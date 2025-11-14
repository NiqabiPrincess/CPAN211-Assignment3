package assignment3;

import java.util.HashMap;

public class ProductMap {
    private HashMap<Integer, Integer> products;

    public ProductMap() {
        products = new HashMap<>();
    }

    public void updateProduct(int productId, int itemsPurchased) {
        int currentCount = products.getOrDefault(productId, 0);
        products.put(productId, currentCount + itemsPurchased);
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public void printProducts() {
        System.out.println("\n=== Products Summary ===");
        for (Integer id : products.keySet()) {
            System.out.println("Product ID: " + id + " | Total Purchased: " + products.get(id));
        }
    }
}

