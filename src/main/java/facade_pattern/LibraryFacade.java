package facade_pattern;

public interface LibraryFacade {
    void borrowBook(String bookTitle, String userName);
    void returnBook(String bookTitle);
    void searchBooksByTitle(String title);
    void searchBooksByAuthor(String author);
    void checkBookAvailability(String bookTitle);
    void reserveBook(String bookTitle, String userName);
    void viewBorrowerHistory(String bookTitle);
}
