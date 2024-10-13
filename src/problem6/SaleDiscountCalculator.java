package problem6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SaleDiscountCalculator {

    public static void main(String[] args) {
        Sale sale;

        List<Sale> sales = Arrays.asList(
                new Sale("Alice", 150, "Electronics"),
                new Sale("Bob", 200, "Clothing"),
                new Sale("Alice", 400, "Home Appliances"),
                new Sale("Charlie", 120, "Electronics"),
                new Sale("Bob", 350, "Clothing")
        );

        getQualifiedCustomer(sales);
    }

    private static void getQualifiedCustomer(List<Sale> sales) {
        Map<String, Double> totalSpentByCustomer = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getName,
                        Collectors.summingDouble(Sale::getSpentAmount)
                ));

        Predicate<Double> qualifiedCustomerForDiscount = total -> total > 500;

        List<String> customerWithDiscount = totalSpentByCustomer.entrySet().stream()
                .filter(entry -> qualifiedCustomerForDiscount.test(entry.getValue()))
                .map(Map.Entry::getKey)
                .toList();

        if (customerWithDiscount.isEmpty()) {
            System.out.println("No customer qualified for the discount");
        } else {
            System.out.println("Customer who qualified for Discount: " + customerWithDiscount );
        }
    }
}
