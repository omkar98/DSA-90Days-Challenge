package StreamsAPI;

import java.util.Arrays;
import java.util.List;

public class Transaction {
    String id;
    double amount; // Positive = Credit, Negative = Debit
    String type;   // "CREDIT" or "DEBIT"

    public Transaction(String id, double amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }
    // Getters...
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public String getId() { return id; }
}
