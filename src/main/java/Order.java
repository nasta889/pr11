package PACKAGE_NAME;public class Order {
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> catalog = new ArrayList<>();
        Cart cart = new Cart();
        List<Order> orders = new ArrayList<>(); // Список всех заказов

        //   Наповнення каталогу продукції
        catalog.add(new Product(1, "Ноутбук", 25000));
        catalog.add(new Product(2, "Смартфон", 15000));
        catalog.add(new Product(3, "Навушники", 2000));
        catalog.add(new Product(4, "Монітор", 8000));

        while (true) {
            System.out.println("\n=== Інтернет-магазин ===");
            System.out.println("1. Переглянути каталог");
            System.out.println("2. Додати товар до кошика");
            System.out.println("3. Переглянути кошик");
            System.out.println("4. Оформити замовлення");
            System.out.println("5. Переглянути історію замовлень");
            System.out.println("6. Вийти");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n=== Каталог товарів ===");
                    for (Product product : catalog) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("\nВведіть ID товару, який бажаєте додати до кошика: ");
                    int productId = scanner.nextInt();
                    Product productToAdd = catalog.stream()
                            .filter(p -> p.getId() == productId)
                            .findFirst()
                            .orElse(null);
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd);
                        System.out.println("Товар додано до кошика: " + productToAdd.getName());
                    } else {
                        System.out.println("Товар з таким ID не знайдено.");
                    }
                    break;
                case 3:
                    System.out.println("\n=== Кошик ===");
                    cart.viewCart();
                    break;
                case 4:
                    System.out.println("\n=== Оформлення замовлення ===");
                    if (cart.isEmpty()) {
                        System.out.println("Кошик порожній. Спочатку додайте товари.");
                    } else {
                        Order order = new Order();
                        for (Product product : cart.products) {
                            order.addProduct(product);
                        }
                        orders.add(order);
                        order.displayOrderDetails();
                        System.out.println("Замовлення успішно оформлено!");
                        cart.clearCart();
                    }
                    break;
                case 5:
                    System.out.println("\n=== Історія замовлень ===");
                    if (orders.isEmpty()) {
                        System.out.println("Історія замовлень порожня.");
                    } else {
                        for (Order order : orders) {
                            order.displayOrderDetails();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Дякуємо за використання нашого інтернет-магазину!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}
