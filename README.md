# Library Management System

## Description
This Java program represents a simple Library Management System. It allows users to interact with a library that contains various categories of books. Users can view available books, borrow, and return books. The system tracks user details and book availability.

## Features
- Add books to the library with details such as title, author, ISBN, quantity, and category.
- Display available books.
- Borrow a book (decrease quantity and mark as unavailable).
- Return a book (increase quantity and mark as available).
- Display user details.

## Book Categories
- FictionBook
- NonFictionBook
- ScienceBook
- HistoricalFictionBook
- PoetryBook
- CookBook
- KidsStoryBook

## Classes
- `Book`: Represents a generic book with common attributes and methods.
- Specific book classes like `FictionBook`, `NonFictionBook`, etc., that inherit from `Book`.
- `Library`: Manages the book inventory and user interactions.
- `User`: Represents a library user.

## Usage
1. Compile and run the `LibraryManagementSystem` class.
2. Follow the on-screen menu to interact with the system.
3. Select options to display available books, borrow/return books, display user details, etc.

## Instructions
- When prompted for a book's ISBN, enter the unique ISBN associated with each book.
- Users can borrow books until the quantity is zero.
- Users can return books they have borrowed.

## Sample Data
- The system is preloaded with sample books in different categories.
- A sample user is also created.

## Dependencies
- This program is written in Java and does not have external dependencies.

## Contribution
Contributions are welcome! If you have improvements or new features to suggest, please create a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
