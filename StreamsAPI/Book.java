package StreamsAPI;

import java.util.List;

public class Book {
    String title;
    List<String> authors;
    double price;

    public Book(String title, List<String> authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }
    public List<String> getAuthors() { return authors; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
}


