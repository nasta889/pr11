package PACKAGE_NAME;public class Order {
}
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderId = 1; // Генератор уникальных ID для заказов
    private int orderId;
    private List<Product> products;
    private double totalPrice;

    public Order() {
        this.orderId = nextOrderId++;
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void displayOrderDetails() {
        System.out.println("\n=== Детали заказа #" + orderId + " ===");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Общая стоимость: " + totalPrice + " грн");
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int get
