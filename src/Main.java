import problem1.Book;
import problem1.BookRecommendation;
import problem1.BookSuggestion;
import problem1.User;

import java.util.Arrays;
import java.util.List;

public static void main(String[] args) {
    // Books
    Book book1 = new Book("Book 1", Arrays.asList("Fiction", "Mystery"), 50);
    Book book2 = new Book("Book 2", Arrays.asList("Science", "Technology"), 20);
    Book book3 = new Book("Book 3", Arrays.asList("History"), 70);
    Book book4 = new Book("Book 4", Arrays.asList("Fiction", "Adventure"), 30);
    Book book5 = new Book("Book 5", Arrays.asList("Science"), 40);

    // User's purchased books
    User user = new User("John", Arrays.asList(book1, book2));

    // All available books in the store
    List<Book> availableBooks = Arrays.asList(book1, book2, book3, book4, book5);

    // Get recommendations
    BookRecommendation recommendationSystem = new BookRecommendation();
    List<Book> recommendations = recommendationSystem.recommendBooks(user, availableBooks);

    BookSuggestion suggestion = new BookSuggestion();
    List<Book> suggestions = suggestion.suggestBooks(user, availableBooks);

    // Output recommended books
    recommendations.forEach(book -> System.out.println(book.getTitle()));
}
