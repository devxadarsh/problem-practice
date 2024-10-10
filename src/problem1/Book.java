package problem1;

import java.util.List;

public class Book {
    String title;
    List<String> categories;
    int totalPurchases;

    public Book(String title, List<String> categories, int totalPurchases) {
        this.title = title;
        this.categories = categories;
        this.totalPurchases = totalPurchases;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getTotalPurchases() {
        return totalPurchases;
    }

    public void setTotalPurchases(int totalPurchases) {
        this.totalPurchases = totalPurchases;
    }

//    public List<Book> Book() {
//
//    }
}
