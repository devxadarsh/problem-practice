package problem1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookSuggestion {

    public List<Book> suggestBooks(User user, List<Book> availableBooks) {

        // Getting the list of the purchased book along with frequency
        Map<String, Long> purchasedBookCategoryFrequency = user.getPurchasedBooks.stream()
                .flatMap(book -> book.getCategories().stream()) // getting all the categories from purchased books
                .collect(Collectors.groupingBy(categories -> categories, Collectors.counting())); // grouping the book categories and counting the category frequency

        // Filtering the books user has not purchased yet
        Set<String> purchasedBookTitle = user.getPurchasedBooks.stream()
                .map(Book::getTitle)
//                .map(book -> book.getTitle())
                .collect(Collectors.toSet());

        List<Book> unPurchasedBook = availableBooks.stream()
                .filter(book -> !purchasedBookTitle.contains(book.getTitle()))
                .toList();

        // Prioritize the book based on the user's most frequently purchased categories
        List<Book> prioritizedBooks = unPurchasedBook.stream()
                .sorted((book1, book2) -> {
                    long book1CategoryPriority = book1.getCategories().stream()
                            .mapToLong(category -> purchasedBookCategoryFrequency.getOrDefault(category, 0L)).sum();
                    long book2CategoryPriority = book2.getCategories().stream()
                            .mapToLong(category -> purchasedBookCategoryFrequency.getOrDefault(category, 0L)).sum();

                    return Long.compare(book1CategoryPriority, book2CategoryPriority);
                }).toList();

        List<Book> sortedByPopularity = prioritizedBooks.stream()
                .sorted(Comparator.comparingInt(Book::getTotalPurchases).reversed())
//                .toList();
                .collect(Collectors.toList());
        return sortedByPopularity;
    }
 }
