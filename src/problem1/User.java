package problem1;

import java.util.List;

public class User {

    String username;
    List<Book> getPurchasedBooks;

    public User(String username, List<Book> getPurchasedBooks) {
        this.username = username;
        this.getPurchasedBooks = getPurchasedBooks;
    }

    public List<Book> getPurchasedBooks() {
        return getPurchasedBooks;
    }

    public void setPurchasedBookList(List<Book> getPurchasedBooks) {
        this.getPurchasedBooks = getPurchasedBooks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
