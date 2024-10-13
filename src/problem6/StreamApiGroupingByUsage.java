package problem6;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiGroupingByUsage {

    public static void main(String[] args) {
        Sale sale;

        List<Sale> sales = Arrays.asList(
                new Sale("Alice", 150, "Electronics"),
                new Sale("Bob", 200, "Clothing"),
                new Sale("Alice", 400, "Home Appliances"),
                new Sale("Charlie", 120, "Electronics"),
                new Sale("Bob", 350, "Clothing")
        );

//Here are the possible types and configurations you can use with `groupingBy()` in Java:

//    1. **Default `Map<K, List<T>>`:**
//    By default, `groupingBy()` returns a `Map` where the key is the grouping criterion, and the value is a `List` of elements that match the key.
        Map<String, List<Sale>> groupedSales = sales.stream()
                .collect(Collectors.groupingBy(Sale::getName));

//    2. **`Map<K, Set<T>>`:**
//    You can collect the grouped values into a `Set` instead of a `List` using `Collectors.toSet()` as a downstream collector.
        Map<String, Set<Sale>> groupedSalesSet = sales.stream()
                .collect(Collectors.groupingBy(Sale::getName, Collectors.toSet()));

//    3. **`Map<K, Double>` (Sum of Values):**
//    You can use `Collectors.summingDouble()` to compute the sum of values for each group. This is useful when you want to sum up certain properties of the objects.
        Map<String, Double> totalAmountByCustomer = sales.stream()
                .collect(Collectors.groupingBy(Sale::getName, Collectors.summingDouble(Sale::getSpentAmount)));

//    4. **`Map<K, Long>` (Count the number of elements):**
//    You can use `Collectors.counting()` to count how many elements are in each group.
        Map<String, Long> countByCustomer = sales.stream()
                .collect(Collectors.groupingBy(Sale::getName, Collectors.counting()));

//    5. **`Map<K, Optional<T>>` (Find the maximum or minimum element):**
//    You can use `Collectors.maxBy()` or `Collectors.minBy()` to find the maximum or minimum element in each group based on some property.
//            - Example of finding the maximum amount spent by each customer:

        Map<String, Optional<Sale>> maxSaleByCustomer = sales.stream()
                .collect(Collectors.groupingBy(Sale::getName, Collectors.maxBy(Comparator.comparing(Sale::getSpentAmount))));

//    6. **`Map<K, String>` (Join elements into a string):**
//    You can use `Collectors.mapping()` with `Collectors.joining()` to concatenate values into a string for each group.
        Map<String, String> customerPurchases = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getName,
                        Collectors.mapping(Sale::getProductCategory, Collectors.joining(", "))
                ));

//    7. **Nested `Map<K1, Map<K2, List<T>>>` (Multi-level grouping):**
//    You can use `groupingBy()` multiple times to achieve nested groupings. For example, group by customer and then by product category.
        Map<String, Map<String, List<Sale>>> groupedByCustomerAndCategory = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getName,
                        Collectors.groupingBy(Sale::getProductCategory)
                ));

//    8. **Custom Collection Types:**
//    If you want to customize the type of `Map` that `groupingBy()` returns (e.g., `TreeMap`), you can pass a custom `Supplier` to the collector.
        Map<String, List<Sale>> sortedGroupedSales = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getName,
                        TreeMap::new,  // Use TreeMap for sorted keys
                        Collectors.toList()
                ));

//    9. **`Map<K, List<R>>` (Custom mapping of elements):**
//    You can use `Collectors.mapping()` to apply a transformation to the grouped elements before collecting them. This is useful when you only want to collect certain properties.
        Map<String, List<Double>> amountByCustomer = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getName,
                        Collectors.mapping(Sale::getSpentAmount, Collectors.toList())
                ));
    /*
    Conclusion:
            `groupingBy()` is flexible and can be used with different data types depending on how you configure the downstream collector. While the default behavior produces a `Map<K, List<T>>`, you can customize it to generate:
            - `Map<K, Set<T>>`
            - `Map<K, Double>` (sum, average, etc.)
            - `Map<K, Long>` (count)
            - `Map<K, Optional<T>>` (min/max)
            - `Map<K, String>` (joined strings)
            - Nested `Map<K1, Map<K2, List<T>>>`
            - Custom `Map` types (like `TreeMap` or `LinkedHashMap`)

    You can tailor `groupingBy()` to meet different requirements by combining it with other collectors (`summingDouble()`, `counting()`, `mapping()`, etc.).
     */
    }

}
