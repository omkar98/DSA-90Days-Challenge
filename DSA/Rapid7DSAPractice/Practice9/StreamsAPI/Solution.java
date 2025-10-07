package DSA.Rapid7DSAPractice.Practice9.StreamsAPI;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String args[]){


        squaresOFAllEvenNumbers();
        numberOfEmptyStrings();
        employeesWithSalaryGreaterThan50K();
        employeesWithSalaryGreaterThan50K_2ndLargest();
        flattenAListOfLists();
        occuranceOfEachCharInAString();
        duplicateElementsInAList();
        partitionListOfNumbersIntoEvenAndOdd();
        groupEmpByDept();
        sumUsingReduce();
        prolemEmployee();


    }

    public static void prolemEmployee(){

        Employee e1 = new Employee(1, "a", 10000, "A", 20, LocalDate.parse("2020-01-01"));
        Employee e2 = new Employee(2, "b", 70000, "A",30, LocalDate.parse("2019-01-01"));
        Employee e3 = new Employee(3, "c", 80000, "B",40, LocalDate.parse("2021-01-01"));
        Employee e4 = new Employee(4, "d", 70000, "B",50, LocalDate.parse("2022-01-01"));
        Employee e5 = new Employee(5, "e", 20000, "C",60, LocalDate.parse("2020-02-01"));

        List<Employee> list = Arrays.asList(e1,e2,e3,e4,e5);

        // Filter employees who are above 25 years old
        List<Employee> empList1 = list.stream().filter(e -> e.getAge()>25).collect(Collectors.toList());

        // Filter employees who joined after January 1, 2020
        List<Employee> empList2 = list.stream().filter(e -> e.getJoiningDate().isAfter(LocalDate.parse("2020-01-01"))).collect(Collectors.toList());

        // Group employees by department
        Map<String, List<Employee>> empList3 = list.stream().collect(Collectors.groupingBy(Employee::getDept));

        // For each department, calculate average salary of only the top 3 highest-paid employees
        // For each department, calculate average salary of all the employees in that department
        Map<String, Double> empList4 = list.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));

        // For each department, find the top 3 highest paid employees
        Map<String, List<Employee>> empList5 = list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.collectingAndThen(
                                Collectors.toList(), l ->
                                        l.stream()
                                                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                                                .limit(3)
                                                .toList()
                        )));
        // For each department, find the top 3 highest paid employees
        Map<String, List<Employee>> empList6 = list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.collectingAndThen(
                                Collectors.toList(), l ->
                                        l.stream()
                                                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                                                .limit(3)
                                                .toList()
                        )));

        // For each department, find the top 3 highest paid employees
        Map<String, Double> empList7 = list.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDept,
                            Collectors.collectingAndThen(
                                    Collectors.toList(), l ->   {
                                        if(l.size()<3) return 0.0;

                                        return l.stream()
                                                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                                                .limit(3)
                                                .mapToInt(Employee::getSalary)
                                                .average()
                                                .orElse(0.0);

                                    }
                            )
                    )
                );

        empList7.entrySet().removeIf(e->e.getValue() == 0.0);

        LocalDate cutoff = LocalDate.of(2020, 1, 1);

        List<Employee> filtered = list.stream()
                .filter(e -> e.getAge() > 25)
                .filter(e -> e.getJoiningDate().isAfter(cutoff))
                .toList();

        Map<String, List<Employee>> grouped = filtered.stream()
                .collect(Collectors.groupingBy(Employee::getDept));


        Map<String, Double> avgTop3ByDept = new HashMap<>();
        List<String> excluded = new ArrayList<>();

        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            String dept = entry.getKey();
            List<Employee> emps = entry.getValue();

            if (emps.size() < 2) {
                excluded.add(dept); // exclude if fewer than 2
                continue;
            }

            double avg = emps.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                    .limit(3)
                    .mapToInt(Employee::getSalary)
                    .average()
                    .orElse(0.0);

            avgTop3ByDept.put(dept, avg);
        }


        System.out.print(empList7);
    }

    /*
     * Find the sum of all integers in a list using reduce.
     * */
    public static void sumUsingReduce(){
        int arr[] = {};
        int sum1 = Arrays.stream(arr).reduce((a,b)->a+b).orElse(0); // Type-1
        int sum = Arrays.stream(arr).reduce(0, (a,b)->a+b); // Type-2

        System.out.print(sum1);
        System.out.print(sum);



    }

    /*
     * Group employees by department.
     * */
    public static void groupEmpByDept(){

        Employee e1 = new Employee("a", 10000, "A");
        Employee e2 = new Employee("b", 70000, "A");
        Employee e3 = new Employee("c", 80000, "B");
        Employee e4 = new Employee("d", 70000, "B");
        Employee e5 = new Employee("e", 20000, "C");

        List<Employee> empList = new ArrayList<>(List.of(e1,e2,e3,e4,e5));

        // Using legacy Java code
        Map<String, Integer> empList1 = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDept))
                .entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue().size()
                        ));

        // Using Streams Counting -- Con: Will return Long and not Integer. For Integer, use the legacy code
        Map<String, Long> empList2 = empList.stream()
                        .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

        System.out.println(empList1);
    }

    /*
     * Partition a list of numbers into even and odd numbers.
     * */
    public static void partitionListOfNumbersIntoEvenAndOdd(){
        int[] a = {1,2,3,4,5,6,7,8,9};
        Map<Boolean, List<Integer>> finalList = Arrays.stream(a).boxed().collect(Collectors.partitioningBy(ele->ele%2==0));

        System.out.println(finalList);
    }

    /*
     * Find all duplicate elements in a list of integers.
     * */
    public static void duplicateElementsInAList(){
        int[] a = {1,2,2,3,3,4,5,6};
        List<Integer> finalList = Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(ele -> ele, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue()>1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(finalList);
    }

    /*
     * Given a list of integers, return a list of squares of all even numbers.
     * */
    public static void occuranceOfEachCharInAString(){
        String s = "This is Delta Airline. Departing to Altanta in the USA";
        s = s.toLowerCase().replace(" ", "");
        // This return a Long
        Map<Character, Long> mpp = s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
        // To return an Integer
        Map<Character, Integer> mpp1 = s.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.collectingAndThen(Collectors.counting(), count -> count.intValue())));

        // retunr with the chars sorted.
        Map<Character, Integer> naturalSorting = s.chars()
                .mapToObj(c->(char)c)
                .sorted()
                .collect(Collectors.groupingBy(c->c, Collectors.collectingAndThen(Collectors.counting(), count -> count.intValue())));

        // return with the freq sorted.
        Map<Character, Long> naturalSorting1 = s.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()))
                        .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

//        System.out.print(mpp);
        System.out.println(naturalSorting1);
    }


    /*
    * Given a list of integers, return a list of squares of all even numbers.
    * */
    public static void squaresOFAllEvenNumbers(){
        int[] a = {1,2,2,3,4,5,6};
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> newList = list.stream().filter(ele -> ele%2==0).map(ele->ele*ele).collect(Collectors.toList()); // unordered
        Set<Integer> newList1 = list.stream().filter(ele -> ele%2==0).map(ele->ele*ele).collect(Collectors.toSet()); // unordered
        Set<Integer> newList2 = list.stream().filter(ele -> ele%2==0).map(ele->ele*ele).collect(Collectors.toCollection(TreeSet::new)); // ordered
        System.out.print(newList1);
    }

    /*
     * Count the number of empty strings in a list of strings.
     * */
    public static void numberOfEmptyStrings(){
        String[] a = {"", "abcd", "ab", "a", " ", "   "};
        long emptyStrings = Arrays.stream(a).filter(String::isBlank).count();
        System.out.print(emptyStrings);
        // make it int
        emptyStrings = Arrays.stream(a)
                .mapToInt(str -> str.isBlank() ? 1 : 0)// IntStream
                .sum();
        System.out.print(emptyStrings);
    }

    /*
     * Given a list of employees (name, salary), return names of employees with salary > 50k.
     * */
    public static void employeesWithSalaryGreaterThan50K(){
        Employee e1 = new Employee("a", 10000);
        Employee e2 = new Employee("a", 50000);
        Employee e3 = new Employee("a", 60000);
        Employee e4 = new Employee("a", 70000);
        Employee e5 = new Employee("a", 20000);

        List<Employee> empList = new ArrayList<>(List.of(e1,e2,e3,e4,e5));

        empList = empList.stream().filter(emp -> emp.getSalary()>=50000).collect(Collectors.toList());
        // sorting in the lists in the reverse order
        empList = empList.stream()
                .filter(emp -> emp.getSalary()>=50000)
                .sorted(Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName).reversed())
                .collect(Collectors.toList());
        System.out.print(empList);
    }

    /*
     * Given a list of employees (name, salary), return names of employees with salary > 50k.
     * */
    public static void employeesWithSalaryGreaterThan50K_2ndLargest(){
        Employee e1 = new Employee("a", 10000);
        Employee e2 = new Employee("a", 70000);
        Employee e3 = new Employee("a", 80000);
        Employee e4 = new Employee("a", 70000);
        Employee e5 = new Employee("a", 20000);

        List<Employee> empList = new ArrayList<>(List.of(e1,e2,e3,e4,e5));

        // sorting in the lists
        Set<Employee> empReturned = empList.stream()
                .filter(emp -> emp.getSalary()>=50000)
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .skip(1)
                .collect(Collectors.toSet()); // to set to remove all the duplicates

        System.out.print(empReturned.stream().findFirst());
    }

    /*
     * Flatten a list of lists of integers into a single list.
     * */
    public static void flattenAListOfLists(){
        List<List<Integer>> listOfListOfIntegers = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(6,7,8));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(9,10,11));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(10,11,12,13));
        listOfListOfIntegers.add(list1);
        listOfListOfIntegers.add(list2);
        listOfListOfIntegers.add(list3);
        listOfListOfIntegers.add(list4);

        // distinct will remove all the duplicates
        List<Integer> finaList = listOfListOfIntegers.stream()
                .flatMap(l -> l.stream())//.flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.print(finaList);

    }
}

class Employee {
    private int id;
    private String name;
    private String dept;
    private int salary;
    private int age;
    private LocalDate joiningDate;

    Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
        this.dept = null;
    }

    Employee(String name, int salary, String dept){
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    Employee(int id, String name, int salary, String dept, int age, LocalDate date){
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.age = age;
        this.joiningDate = date;
    }

    public String getName(){return this.name;}
    public int getSalary(){return this.salary;}
    public String getDept(){return this.dept;}
    public int getId(){return this.id;}
    public void setId(int dept){this.id = id;}
    public int getAge(){return this.age;}
    public void setAge(int dept){this.age = age;}

    public LocalDate getJoiningDate(){return this.joiningDate;}
    public void setJoiningDate(String date){this.joiningDate = LocalDate.parse(date);}

    public void setDept(String dept){this.dept = dept;}
    public void setName(String name){this.name = name;}
    public void setSalary(int salary){this.salary = salary;}





}


