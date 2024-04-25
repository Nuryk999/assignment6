package facade_pattern;

import java.util.HashMap;
import java.util.Map;

public class BookInventorySystem {
    private final Map<String, Boolean> books = new HashMap<>();
    private final Map<String, String> borrowedBooks = new HashMap<>();

    public BookInventorySystem() {
        books.put("Harry Potter", true);
        books.put("Java Programming", true);
        books.put("Data Structures and Algorithms", false);
    }

    void borrowBook(String bookTitle) {
        books.put(bookTitle, false);
    }

    void returnBook(String bookTitle) {
        books.put(bookTitle, true);
        borrowedBooks.remove(bookTitle);
    }

    void searchByTitle(String title) {
        for (String book : books.keySet()) {
            if (book.toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Book found: " + book);
            }
        }
    }

    void searchByAuthor(String author) {
        System.out.println("Searching books by author: " + author);
    }

    boolean isBookAvailable(String bookTitle) {
        return books.getOrDefault(bookTitle, false);
    }

    void reserveBook(String bookTitle) {
        books.put(bookTitle, false);
    }

    void viewBorrowerHistory(String bookTitle) {
        String borrower = borrowedBooks.get(bookTitle);
        if (borrower != null) {
            System.out.println("Borrower history for " + bookTitle + ": " + borrower);
        } else {
            System.out.println("No borrower history found for " + bookTitle);
        }
    }
}