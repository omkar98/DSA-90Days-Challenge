package StreamsAPI;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
//        level1Questions();
//        level2Questions();
//        level3Questions();
//        level4Questions();
        level5Questions();
        level6Questions();
        level7Questions();
        level8Questions();
    }

    private static void level4Questions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("TX1", 100.0, "CREDIT"),
                new Transaction("TX2", -50.0, "DEBIT"),
                new Transaction("TX3", 200.0, "CREDIT"),
                new Transaction("TX4", -30.0, "DEBIT"),
                new Transaction("TX5", 50.0, "CREDIT")
        );
        Transaction.totalSumOfAllTxnAmt(transactions);
        Transaction.totalSumOfAllTxnAmtUsingReduce(transactions);
        Transaction.combineAllTransactionIDsIntoOneString(transactions);
        Transaction.listOfIntegers(14,15);
        Transaction.allStats(transactions);
        Transaction.splitTxnInTwoLists(transactions);
        Transaction.groupByType(transactions);
        Transaction.stringListToStringArrayIDs(transactions);
        Transaction.sortTxnByAmtThenSkipByAndTakeNextOf(transactions,1,2);
    }
    
    private static void level5Questions() {
        List<Student> students = Arrays.asList(
                new Student("Alice", 85, "Math", "New York"),
                new Student("Bob", 40, "Math", "New York"),
                new Student("Charlie", 90, "Science", "London"),
                new Student("David", 35, "Science", "London"),
                new Student("Eve", 95, "Math", "Tokyo")
        );
        Student.getUniqueCities(students);
        Student.getStudentNames(students);
        Student.studentsPassOrFail(students);
        Student.countStudentsPassAndFail(students);
        Student.topStudentScorerInEachSubject(students);
        Student.topStudentNameScorerInEachSubject(students);
        Student.allStudentNames(students);
    }

    
    private static void level6Questions() {
        List<Book> books = Arrays.asList(
                new Book("Java in Action", Arrays.asList("Raoul", "Mario", "Alan"), 40.0),
                new Book("Spring Boot", Arrays.asList("Raoul", "Josh"), 50.0),
                new Book("Clean Code", Arrays.asList("Robert"), 30.0),
                new Book("Design Patterns", Arrays.asList("Erich", "Richard", "Ralph", "John"), 60.0)
        );
    }

    
    private static void level7Questions() {
        List<StockData> marketData = Arrays.asList(
                new StockData("AAPL", 150.0, "2023-01-01"),
                new StockData("GOOG", 200.0, "2023-01-01"),
                new StockData("AAPL", 155.0, "2023-01-02"),
                new StockData("GOOG", 198.0, "2023-01-02"),
                new StockData("AAPL", 148.0, "2023-01-03"),
                new StockData("AMZN", 100.0, "2023-01-01")
        );
    }

    
    private static void level8Questions() {
        // Just a raw list of sentences (like lines in a file)
        List<String> lines = Arrays.asList(
                "Java Streams are cool",
                "Java is powerful",
                "Streams provide a clean way to process data",
                "Functional programming in Java"
        );
    }



    private static void level3Questions(){
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
    }

    private static void level2Questions(){
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
    }

    private static void level1Questions(){
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
    }
    
}
