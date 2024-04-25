package facade_pattern;

public class Main {
    public static void main(String[] args) {
        LibraryFacade libraryFacade = new LibrarySystemFacade();

        // Test borrow book
        libraryFacade.borrowBook("Harry Potter", "John");

        // Test return book
        libraryFacade.returnBook("Harry Potter");

        // Test search books
        libraryFacade.searchBooksByTitle("Java Programming");
        libraryFacade.searchBooksByAuthor("John Doe");

        // Test check book availability
        libraryFacade.checkBookAvailability("Harry Potter");

        // Test reserve book
        libraryFacade.reserveBook("Data Structures and Algorithms", "Alice");

        // Test view borrower history
        libraryFacade.viewBorrowerHistory("Java Programming");
    }
}

/*
Interface (LibraryFacade):
This interface defines the methods that clients can use to interact with the library management system.
These methods include borrowing books, returning books, searching books by title or author, checking book availability,
reserving books, and viewing borrower history.

Facade Implementation (LibrarySystemFacade):
This class implements the LibraryFacade interface and acts as a simplified interface to the library management system.
It encapsulates the complexity of the underlying subsystems (BookInventorySystem and UserManagementSystem).
Methods in this class delegate the requests to the appropriate subsystems and provide a unified interface for
clients to interact with the system.

Subsystem Classes (BookInventorySystem and UserManagementSystem):
These classes represent the subsystems of the library management system.
BookInventorySystem manages the inventory of books, including operations such as borrowing, returning,
searching by title or author, checking availability, reserving books, and viewing borrower history.
UserManagementSystem manages user-related operations, such as adding borrowed books and reserved books to user records.

Test Class (Main):
The Main class serves as the entry point for testing the library management system.
It creates an instance of the LibrarySystemFacade and tests various functionalities by invoking methods on the facade.
Test scenarios include borrowing and returning books, searching for books, checking book availability, reserving books, and viewing borrower history.
 */