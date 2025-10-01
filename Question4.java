import java.util.*;

// Custom Exception for missing product
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class ProductCatalog {
    private HashMap<String, Double> products = new HashMap<>();

    // Add product
    public void addProduct(String id, double price) {
        products.put(id, price);
    }

    // Apply discount
    public void applyDiscount(String id, double discountPercent) 
            throws ProductNotFoundException, IllegalArgumentException {
        
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Product ID not found!");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100!");
        }

        double oldPrice = products.get(id);
        double newPrice = oldPrice - (oldPrice * discountPercent / 100);
        products.put(id, newPrice); // update price
        System.out.println("New price for " + id + ": $" + newPrice);
    }

    // Display products
    public void displayProducts() {
        System.out.println("Product Catalog: " + products);
    }
}

public class Question4 {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        System.out.println("Adding products: P001=$50.0, P002=$100.0");
        catalog.addProduct("P001", 50.0);
        catalog.addProduct("P002", 100.0);
        catalog.displayProducts();

        // 1. Apply valid discount
        try {
            System.out.println("Applying 20% discount to P001...");
            catalog.applyDiscount("P001", 20);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 2. Apply invalid discount (greater than 100)
        try {
            System.out.println("Applying 150% discount to P002...");
            catalog.applyDiscount("P002", 150);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 3. Apply discount to non-existent product
        try {
            System.out.println("Applying discount to P999...");
            catalog.applyDiscount("P999", 10);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
