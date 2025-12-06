package StreamsAPI;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters and toString()
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() { return name + " (" + category + ") - $" + price; }


    public static void printAllProductsToTheConsole(List<Product> products){
//        products.stream().forEach(x-> System.out.print(x.getName()));
        System.out.println("1. ------------------");
        System.out.println("All products: " + products.stream().map(Product::getName).collect(Collectors.joining(",")));
        System.out.println("------------------");
    }

    public static void productsWithPriceGreaterThan(List<Product> products, int price){
        System.out.println("2. ------------------");
        System.out.println("Products greater than "+price + ":\n" + products.stream().filter(x->x.getPrice()>price).map(Product::toString).collect(Collectors.joining(",\n")));
        System.out.println("------------------");
    }

    public static List<Product> productsBelongingToCategory(List<Product> products, String category){
        System.out.println("3. ------------------");
        List<Product> collect = products.stream()
                .filter(product -> category.equals(product.getCategory()))
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("------------------");
        return collect;
    }

    public static List<Product> productsCheaperThanPrice(List<Product> products, int price){
        System.out.println("4. ------------------");
        List<Product> collect = products.stream()
                .filter(p -> p.getPrice() <= price) // anyMatch also
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("------------------");
        return collect;
    }

    public static boolean checkIfAllProductsAreExpensiveThanPrice(List<Product> products, int price){
        System.out.println("5. ------------------");
        boolean b = products.stream().allMatch(p -> p.getPrice() > price);
        System.out.println("------------------");
        return b;
    }

    public static Long countHowManyCategoryItemsExist(List<Product> products, String category){
        System.out.println("5. ------------------");
        Long collect = products.stream().filter(p -> category.equals(p.getCategory())).collect(Collectors.counting()); // .count()
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }

    public static void printProductsInAscSortedByPrice(List<Product> products){
        System.out.println("5. ------------------");
        String collect = products.stream()
//                .sorted(((o1, o2) -> (int) (o1.getPrice() - o2.getPrice())))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .map(Product::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect);
        System.out.println("------------------");
    }

    public static List<String> getListOfUniqueCategories(List<Product> products){
        System.out.println("5. ------------------");
        List<String> collect = products.stream().map(Product::getCategory).distinct().collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("------------------");
        return collect;
    }
}
