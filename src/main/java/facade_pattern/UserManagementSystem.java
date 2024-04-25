package facade_pattern;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserManagementSystem {
    private final Map<String, String> borrowedBooks = new HashMap<>();
    private final Map<String, String> reservedBooks = new HashMap<>();

    void addBorrowedBook(String userName, String bookTitle) {
        borrowedBooks.put(bookTitle, userName);
    }

    void addReservedBook(String userName, String bookTitle) {
        reservedBooks.put(bookTitle, userName);
    }

    Map<String, String> getBorrowedBooks() {
        return Collections.unmodifiableMap(borrowedBooks);
    }

    Map<String, String> getReservedBooks() {
        return Collections.unmodifiableMap(reservedBooks);
    }
}
