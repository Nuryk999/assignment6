package facade_pattern;

public class LibrarySystemFacade implements LibraryFacade {
    private final BookInventorySystem bookInventorySystem;
    private final UserManagementSystem userManagementSystem;

    public LibrarySystemFacade() {
        this.bookInventorySystem = new BookInventorySystem();
        this.userManagementSystem = new UserManagementSystem();
    }

    @Override
    public void borrowBook(String bookTitle, String userName) {
        if (bookInventorySystem.isBookAvailable(bookTitle)) {
            bookInventorySystem.borrowBook(bookTitle);
            userManagementSystem.addBorrowedBook(userName, bookTitle);
            System.out.println(userName + " borrowed " + bookTitle);
        } else {
            System.out.println("Sorry, " + bookTitle + " is not available for borrowing.");
        }
    }

    @Override
    public void returnBook(String bookTitle) {
        bookInventorySystem.returnBook(bookTitle);
        System.out.println(bookTitle + " returned successfully.");
    }

    @Override
    public void searchBooksByTitle(String title) {
        bookInventorySystem.searchByTitle(title);
    }

    @Override
    public void searchBooksByAuthor(String author) {
        bookInventorySystem.searchByAuthor(author);
    }

    @Override
    public void checkBookAvailability(String bookTitle) {
        if (bookInventorySystem.isBookAvailable(bookTitle)) {
            System.out.println(bookTitle + " is available.");
        } else {
            System.out.println(bookTitle + " is not available.");
        }
    }

    @Override
    public void reserveBook(String bookTitle, String userName) {
        if (bookInventorySystem.isBookAvailable(bookTitle)) {
            bookInventorySystem.reserveBook(bookTitle);
            userManagementSystem.addReservedBook(userName, bookTitle);
            System.out.println(userName + " reserved " + bookTitle);
        } else {
            System.out.println("Sorry, " + bookTitle + " is not available for reservation.");
        }
    }

    @Override
    public void viewBorrowerHistory(String bookTitle) {
        bookInventorySystem.viewBorrowerHistory(bookTitle);
    }
}
