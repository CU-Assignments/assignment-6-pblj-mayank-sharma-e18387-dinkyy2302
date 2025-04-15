import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1000),
            new Product("Smartphone", "Electronics", 800),
            new Product("Shirt", "Clothing", 50),
            new Product("Jeans", "Clothing", 60),
            new Product("Washing Machine", "Electronics", 500)
        );

        // 1. Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // 2. Find the most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> mostExpensiveProduct = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));

        mostExpensiveProduct.forEach((category, product) -> {
            product.ifPresent(p -> System.out.println(category + ": " + p));
        });

        // 3. Calculate the average price of all products
        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0);

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
