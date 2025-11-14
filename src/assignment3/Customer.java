public class Customer {
    private String firstName;
    private String lastName;
    private double totalAmount;

    public Customer(String firstName, String lastName, double totalAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalAmount = totalAmount;
    }

    public void addPurchase(double amount) {
        this.totalAmount += amount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " owes $" + totalAmount;
    }
}
