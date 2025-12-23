package Neetcode.o1_ArraysAndHashing;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Approach - 1: Using the toMap function
        Map<Map<Integer, Long>, String> collect = Arrays.stream(strs).collect(Collectors.toMap(
                str -> str.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting())),
                str -> str,
                (s1, s2) -> String.join(",", s1,s2)
        ));
//        System.out.println(collect);

        // Approach - 2: Directly using GroupingBy function
        Map<Map<Integer, Long>, List<String>> collect1 = Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            return str.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        }));
//        System.out.println(collect1);

        // Approach - 3: Grouping the elements. The key is sorting each string chars.
        Map<String, List<String>> collect2 = Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));
//        System.out.println(collect2);
        List<List<String>> output = new ArrayList<>();
        collect2.forEach((key,value) -> {
            output.add(value);
        });
        System.out.println(output);
        return output;
    }
}
