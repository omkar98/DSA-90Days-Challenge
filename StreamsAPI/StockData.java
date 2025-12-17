package StreamsAPI;

import java.time.LocalDate;

public class StockData {
    String symbol;
    double price;
    LocalDate date;

    public StockData(String symbol, double price, String dateStr) {
        this.symbol = symbol;
        this.price = price;
        this.date = LocalDate.parse(dateStr); // Format YYYY-MM-DD
    }
    // Getters
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public LocalDate getDate() { return date; }
    @Override public String toString() { return symbol + ": " + price + " on " + date; }
}

