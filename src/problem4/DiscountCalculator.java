package problem4;

import java.util.List;
import java.util.function.Predicate;

public class DiscountCalculator {

    public static void main(String[] args) {

        // generating the sample customer and order for the testing
        Customer customer = new Customer("Ram", true,
                List.of(
                        new Order(100),
                        new Order(200)
                ));
        List<Order> orders = List.of(
                new Order(300),
                new Order(250)
        );

        double discount = calculateDiscount(customer, orders);
        System.out.println("Your total discount is: " + discount + "%");
    }

    private static double calculateDiscount(Customer customer, List<Order> orders) {
        double baseDiscount = calculateBaseDiscount(orders);
        double frequentCustomerDiscount = calculateFrequentCustomerDiscount(customer);
        double loyaltyProgramDiscount = calculateLoyaltyProgramDiscount(customer);

        return baseDiscount + frequentCustomerDiscount + loyaltyProgramDiscount;

    }

    private static double calculateBaseDiscount(List<Order> orders) {
        double totalOrderAmount = orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();

        Predicate<Double> isEligibleForDiscount = amount -> amount > 500;
        return isEligibleForDiscount.test(totalOrderAmount) ? 10.0 : 0.0;
    }

    private static double calculateFrequentCustomerDiscount(Customer customer) {
        return customer.getPastOrders().size() > 10 ? 5.0 : 0.0;
    }

    private static double calculateLoyaltyProgramDiscount(Customer customer) {
        return customer.isLoyalMember() ? 2.0 : 0.0;
    }

}
