package problem6;

public class Sale {

    final private String name;
    final private double spentAmount;
    final private String productCategory;

    public Sale(String name, double spentAmount, String productCategory) {
        this.name = name;
        this.spentAmount = spentAmount;
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public double getSpentAmount() {
        return spentAmount;
    }

    public String getProductCategory() {
        return productCategory;
    }
}
