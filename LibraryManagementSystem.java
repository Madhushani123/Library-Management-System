mport java.util.ArrayList;
import java.util.Scanner;

enum BookCategory {
    FictionBook, NonFictionBook, ScienceBook,HistoricalFictionBook,PoetryBook,CookBook,KidsStoryBook
}

class Book {
    String title;
    String author;
    String ISBN;
    boolean isAvailable;
    int quantity;
    BookCategory category;

    public Book(String title, String author, String ISBN, int quantity, BookCategory category) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
        this.quantity = quantity;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Quantity: " + quantity);
        System.out.println("Category: " + category);
        System.out.println("........................");
    }
}

class FictionBook extends Book {
    public FictionBook(String title, String author, String ISBN, int quantity) {
        super(title, author, ISBN, quantity, BookCategory.FictionBook);
    }
}

class NonFictionBook extends Book {
    public NonFictionBook(String title, String author, String ISBN, int quantity) {
        super(title, author, ISBN, quantity, BookCategory.NonFictionBook);
    }
}

class ScienceBook extends Book {
    public ScienceBook(String title, String author, String ISBN, int quantity) {
        super(title, author, ISBN, quantity, BookCategory.ScienceBook);
    }
}

class HistoricalFictionBook extends Book {
    public HistoricalFictionBook(String title, String author, String ISBN, int quantity) {
        super(title, author, ISBN, quantity, BookCategory.HistoricalFictionBook);
    }
}

class PoetryBook extends Book {
    public PoetryBook(String title, String author, String ISBN, int quantity) {
        super(title, author, ISBN, quantity, BookCategory.PoetryBook);
    }
}
class CookBook extends Book {
    public CookBook(String title, String author, String ISBN, int quantity) {
        super(title, author, ISBN, quantity, BookCategory.CookBook);
    }
}
class KidsStoryBook extends Book {
    public KidsStoryBook(String title, String author, String ISBN, int quantity) {
        super(title, author, ISBN, quantity, BookCategory.KidsStoryBook);
    }
}

class Library {
    private ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("Book added to the library.");
    }

    public void displayAvailableBookListByCategory(BookCategory category) {
        System.out.println("List of available Books in category: " + category);
        for (Book book : bookList) {
            if (book.isAvailable() && (category == null || book.category == category)) {
                book.displayBookDetails();
            }
        }
    }

    public void borrowBook(String ISBN) {
        for (Book book : bookList) {
            if (book.getISBN().equals(ISBN) && book.isAvailable()) {
                if (book.getQuantity() > 0) {
                    book.setAvailable(false);
                    book.quantity--;
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("No more copies available for borrowing.");
                }
                return;
            }
        }
        System.out.println("Book not available at library.");
    }

    public void returnBook(String ISBN) {
        for (Book book : bookList) {
            if (book.getISBN().equals(ISBN) && !book.isAvailable()) {
                book.setAvailable(true);
                book.quantity++;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid ISBN or the book is already available in the library.");
    }
}

class User {
    private static int userCount = 0;
    private int userId;
    private ArrayList<String> borrowedBooks = new ArrayList<>();

    public User() {
        userCount++;
        this.userId = userCount;
    }

    public int getUserId() {
        return userId;
    }

    public void borrowBook(String ISBN) {
        borrowedBooks.add(ISBN);
    }

    public void returnBook(String ISBN) {
        borrowedBooks.remove(ISBN);
    }

    public void displayUserDetails() {
        System.out.println("User Id: " + userId);
        System.out.println("Borrowed books: " + borrowedBooks);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new FictionBook("The lord of the Rings Trilogy", "J.R.R.Tolkien", "12345", 5));
        library.addBook(new FictionBook("Frankenstein", "Mary Shelly", "123457", 3));
        library.addBook(new FictionBook("To Kill a Mockingbird","Harper Lee","12347",2));
        library.addBook(new FictionBook("1984"," George Orwell","123484",6));
        library.addBook(new FictionBook("The Great Gatsby", "F. Scott Fitzgerald", "12349",8));

        library.addBook(new NonFictionBook("In the Dream House", "Carmen Maria Machado", "12346", 4));
        library.addBook(new NonFictionBook("Sapiens: A Brief History of Humankind","Yuval Noah Harari","12350",5));
        library.addBook(new NonFictionBook("The Immortal Life of Henrietta Lacks","Rebecca Skloot","12351",7));
        library.addBook(new NonFictionBook("Educated","Tara Westover","12353",0));

        library.addBook(new ScienceBook("Cosmos","Carl Sagan","123602",3));
        library.addBook(new ScienceBook("A Brief History of Time", "Stephen Hawking","123611",2));
        library.addBook(new ScienceBook("The Double Helix","James D. Watson","12362",12));

        library.addBook(new HistoricalFictionBook("The Book Thief", "Markus Zusak","12370",3));
        library.addBook(new HistoricalFictionBook("All the Light We Cannot See", "Anthony Doerr","12371",2));
        library.addBook(new HistoricalFictionBook("The Pillars of the Earth","Ken Follett","12372",3));

        library.addBook(new PoetryBook("Milk and Honey","Rupi Kaur","12380",3));
        library.addBook(new PoetryBook("The Sun and Her Flowers","Rupi Kaur","12381",2));
        library.addBook(new PoetryBook("Leaves of Grass","Walt Whitman","12382",4));

        library.addBook(new  CookBook("The Joy of Cooking","Irma S. Rombauer","12390",3));
        library.addBook(new CookBook("Mastering the Art of French Cooking","Julia Child","12391",4));
        library.addBook(new CookBook("Salt, Fat, Acid, Heat"," Samin Nosrat","12392",4));

        library.addBook(new KidsStoryBook("The Very Hungry Caterpillar",  "Eric Carle", "12302", 0));
        library.addBook(new KidsStoryBook("Goodnight Moon","Margaret Wise Brown","12301",2));
        library.addBook(new KidsStoryBook("Winnie-the-Pooh"," A.A. Milne","12302",3));

        User user = new User();

        int choice;

        do {
            

            System.out.println("\n ..........Library Management System...............\n");
            System.out.println("***************WELCOME TO OUR LIBRARY****************\n");
            System.out.println("///////////SELECT FROM THE FOLLOWING OPTIONS////////////\n");
            System.out.println("1.Display Available Books.");
            System.out.println("2.Borrow a Book.");
            System.out.println("3.Return a Book.");
            System.out.println("4.Display user details.");
            System.out.println("5.Display Available Books by Category.");
            System.out.println("6.Exit\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    library.displayAvailableBookListByCategory(null);
                    break;

                case 2:
                    System.out.print("Enter the ISBN of the book you choose: ");
                    String borrowISBN = sc.nextLine();
                    user.borrowBook(borrowISBN);
                    library.borrowBook(borrowISBN);
                    break;

                case 3:
                    System.out.print("Enter the ISBN of the book you want to return: ");
                    String returnISBN = sc.nextLine();
                    user.returnBook(returnISBN);
                    library.returnBook(returnISBN);
                    break;

                case 4:
                    user.displayUserDetails();
                    break;

                case 5:
                    System.out.print("\nFictionBook\nNonFictionBook\nScienceBook\nHistoricalFictionBook\nPoetryBook\nCookBook\nKidsStoryBook\n\n Enter the category: ");
                    String categoryInput = sc.nextLine();
                    BookCategory selectedCategory = BookCategory.valueOf(categoryInput);
                    library.displayAvailableBookListByCategory(selectedCategory);
                    break;

                case 6:
                    System.out.println("Exiting the Library Management System");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid choice");
            }
        } while (choice != 6);
        sc.close();
    }
}
