package problem4;

import java.util.Objects;
import java.util.List;

public class Customer {

    private final String name;
    private final boolean isLoyalMember;
    private final List<Order> pastOrders;

    public Customer(String name, boolean isLoyalMember, List<Order> orders) {
        this.name = name;
        this.isLoyalMember = isLoyalMember;
        this.pastOrders = orders;
    }

    public String getName() {
        return name;
    }

    public boolean isLoyalMember() {
        return isLoyalMember;
    }

    public List<Order> getPastOrders() {
        return pastOrders;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return isLoyalMember == customer.isLoyalMember && Objects.equals(name, customer.name) && Objects.equals(pastOrders, customer.pastOrders);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, isLoyalMember, pastOrders);
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "name='" + name + '\'' +
//                ", isLoyalMember=" + isLoyalMember +
//                ", orders=" + pastOrders +
//                '}';
//    }
}
