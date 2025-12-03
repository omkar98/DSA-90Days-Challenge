package StreamsAPI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Omkar", "Abcd");
        // Filter
        long o = list.stream().filter(x -> x.startsWith("O")).count();
//        System.out.println(o);
        // Distinct
        long distinct = list.stream().distinct().count();

        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        // find the names which have a length greater than three
        System.out.println(names.stream().filter(x->x.length()>3).collect(Collectors.toList()));

        // Example: Squaring and sorting numbers
        List<Integer> list1 = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(list1.stream().map(x->x*x).sorted().collect(Collectors.toList()));

        // Example: Summing values
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        System.out.println(list2.stream().reduce(Integer::sum).get());


        // Counting occurences of a char in a sentence
        String sentence = "Hello World";
        System.out.println(sentence.chars().filter(x -> x=='l').count());

        // Parallel Streams
//        long startTime = System.currentTimeMillis();
//        List<Integer> integerList = Stream.iterate(1, x -> x + 1).limit(100000).collect(Collectors.toList());
//        List<Long> list3 = integerList.parallelStream().map(Demo::factorial).toList();
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time:" + (endTime-startTime));

        // FlatMap
        List<List<String>> list4 = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D"),
                Arrays.asList("E", "f")
        );
        System.out.println(list4.stream().flatMap(List::stream).map(String::toLowerCase).collect(Collectors.toList()));

        List<String> list5 = Arrays.asList("I am", "Om  kar", "In the US");
        System.out.println(list5.stream().flatMap(x->Arrays.stream(x.split(" ")).filter(y-> !y.isEmpty())).map(x->x.toUpperCase()).peek(System.out::println).collect(Collectors.toList()));

        // Grouping By
        List<String> stringList = Arrays.asList("hello", "world", "java", "streams", "collections");
        System.out.println(stringList.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(","))));

        // Partitioning
        System.out.println(stringList.stream().collect(Collectors.partitioningBy(x->x.length()>5, Collectors.joining(","))));

        // Mapping and Collection
        System.out.println(stringList.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList())));



        // Collecting names by length
        List<String> l1 = Arrays.asList ("Anna", "Bob", "Alexander", "Brian", "Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(x->x.length())));

        // Counting word occurrences
        String sentence1 = "hello world hello java world";
        System.out.println(Arrays.stream(sentence1.split(" ")).collect(Collectors.groupingBy(x->x, Collectors.counting())));

        // Partitioning Even and odd numbers
        List<Integer> l4= Arrays.asList(1, 2,3, 4,5,6);
        System.out.println(l4.stream().collect(Collectors.partitioningBy(x->x%2==0)));

        // Summing values in a map
        Map<String, Integer> items = new HashMap<>() ;
        items.put("Apple", 10);
        items.put ("Banana", 20);
        items.put("Orange", 15);

        System.out.println(items.values().stream().collect(Collectors.summarizingInt(x->x)).getSum());
        System.out.println(items.values().stream().reduce(Integer::sum).get());

        // Example 5: Creating a Map from Stream Elements
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(x->x, x->x.length())));

        // Example 6:
        List<String> words2 = Arrays.asList("apple", "banana", "apple", "orange", "banana" , "apple");
        System.out.println(words2.stream().collect(Collectors.toMap(k->k,v->1, (x,y)->x+1)));




    }

    public static long factorial(int n){
        long result = 1;
        for(int i=2; i<=n ; i++){
            result*=n;
        }
        return result;
    }
}
