import java.util.*;

public class CustomerLogic {

    public static void updateCustomerMap(Map<Integer, Customer> customers, String line) {
        try {
            String[] parts = line.split("\\s+");
            int customerId = Integer.parseInt(parts[0]);
            String firstName = parts[1];
            String lastName = parts[2];
            double price = Double.parseDouble(parts[5]);
            int items = Integer.parseInt(parts[6]);

            double purchaseTotal = price * items;

            if (customers.containsKey(customerId)) {
                customers.get(customerId).addPurchase(purchaseTotal);
            } else {
                customers.put(customerId, new Customer(firstName, lastName, purchaseTotal));
            }
        } catch (Exception e) {
            System.out.println("Error processing line: " + line);
        }
    }

    public static void main(String[] args) {
        Map<Integer, Customer> customers = new HashMap<>();

        String[] salesData = {
            "1005 Abigail Adams 5020 blouse 45 2",
            "1005 Abigail Adams 5010 skirt 30 1",
            "1006 James Brown 5020 blouse 45 1"
        };

        for (String line : salesData) {
            updateCustomerMap(customers, line);
        }

        System.out.println("Customer Bills:");
        for (Map.Entry<Integer, Customer> entry : customers.entrySet()) {
            System.out.println("CustomerID " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
