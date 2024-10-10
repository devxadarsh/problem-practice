package problem1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookRecommendation {

    public List<Book> recommendBooks(User user, List<Book> availableBooks) {
        // Step 1: Find all categories the user has purchased from, along with the frequency
        Map<String, Long> categoryFrequency = user.getPurchasedBooks().stream()
                .flatMap(book -> book.getCategories().stream())  // Get all categories from purchased books
                .collect(Collectors.groupingBy(category -> category, Collectors.counting()));

        // Step 2: Filter books the user hasn’t purchased yet
        Set<String> purchasedBookTitles = user.getPurchasedBooks().stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());  // Collect titles of purchased books

        List<Book> unPurchasedBooks = availableBooks.stream()
                .filter(book -> !purchasedBookTitles.contains(book.getTitle()))  // Filter books user hasn’t bought
//                .collect(Collectors.toList());
                .toList();

        // Step 3: Prioritize books based on the user’s most frequently purchased categories
        List<Book> prioritizedBooks = unPurchasedBooks.stream()
                .sorted((book1, book2) -> {
                    // Get the category frequency for book1 and book2
                    long book1CategoryPriority = book1.getCategories().stream()
                            .mapToLong(cat -> categoryFrequency.getOrDefault(cat, 0L)).sum();

                    long book2CategoryPriority = book2.getCategories().stream()
                            .mapToLong(cat -> categoryFrequency.getOrDefault(cat, 0L)).sum();

                    return Long.compare(book2CategoryPriority, book1CategoryPriority);  // Sort descending by category priority
                })
                .toList();
//                .collect(Collectors.toList());

//        // Step 4: Sort the prioritized books by total purchases (popularity)
//
//        return prioritizedBooks.stream()
//                .sorted(Comparator.comparingInt(Book::getTotalPurchases).reversed())  // Sort by total purchases, descending
//                .collect(Collectors.toList());

        // Step 4: Sort the prioritized books by total purchases (popularity)
        List<Book> sortedByPopularity = prioritizedBooks.stream()
                .sorted(Comparator.comparingInt(Book::getTotalPurchases).reversed())  // Sort by total purchases, descending
                .collect(Collectors.toList());

        return sortedByPopularity;
    }
}

