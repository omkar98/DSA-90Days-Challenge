package StreamsAPI;

import java.util.*;

public class StreamPractice {
    public static void main(String[] args) {
        // Level - 1
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Phone", "Electronics", 800.0),
                new Product("TV", "Electronics", 1500.0),
                new Product("Sofa", "Furniture", 700.0),
                new Product("Table", "Furniture", 300.0),
                new Product("Lamp", "Furniture", 150.0),
                new Product("Shirt", "Clothing", 50.0),
                new Product("Jeans", "Clothing", 80.0),
                new Product("Dress", "Clothing", 120.0)
        );

        Product.printAllProductsToTheConsole(products);
        Product.productsWithPriceGreaterThan(products, 500);
        Product.productsBelongingToCategory(products, "Electronics");
        Product.productsCheaperThanPrice(products, 50);
        System.out.println(Product.checkIfAllProductsAreExpensiveThanPrice(products, 10));
        Product.countHowManyCategoryItemsExist(products, "Furniture");
        Product.printProductsInAscSortedByPrice(products);
        Product.getListOfUniqueCategories(products);


        // Level - 2
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 75000, 25),
                new Employee("Bob", "IT", 60000, 28),
                new Employee("Charlie", "HR", 50000, 30),
                new Employee("David", "HR", 55000, 35),
                new Employee("Eve", "Sales", 40000, 22),
                new Employee("Frank", "Sales", 90000, 40)
        );
        Employee.getListOfNamesOfAllEmployees(employees);
        Employee.calculateTotalSalary(employees);
        Employee.employeeWithHighestSalary(employees);
        Employee.youngestEmployeeInTheDepartment(employees, "IT");
        Employee.groupEmpByDept(employees);
        Employee.countEmpInAllDept(employees);
        Employee.findAvgSalaryOfEveryDept(employees);
        Employee.sortByDeptThenSalary(employees);

        // Level - 3
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", Arrays.asList("Leo", "Tom", "Ellen"), 9.0),
                new Movie("Titanic", Arrays.asList("Leo", "Kate", "Billy"), 8.5),
                new Movie("Dark Knight", Arrays.asList("Christian", "Heath", "Gary"), 9.5),
                new Movie("Shutter Island", Arrays.asList("Leo", "Mark"), 8.2)
        );

        Movie.getListOfAllUniqueActors(movies);
        Movie.countMoviesActorActedIn(movies, "Ellen");
        Movie.mapOfActorMovieList(movies);
        Movie.totalNoOfActors(movies);
        Movie.movieWithHighestRating(movies);
        Movie.mapMovieWithRating(movies);
        Movie.getAllMovieTitles(movies);

        // level - 4:
        List<Transaction> transactions = Arrays.asList(
                new Transaction("TX1", 100.0, "CREDIT"),
                new Transaction("TX2", -50.0, "DEBIT"),
                new Transaction("TX3", 200.0, "CREDIT"),
                new Transaction("TX4", -30.0, "DEBIT"),
                new Transaction("TX5", 50.0, "CREDIT")
        );


    }
}
