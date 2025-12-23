package Neetcode.o1_ArraysAndHashing;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {
    public static  boolean isAnagram(String s, String t) {
        Map<Integer, Long> mpp1 = s.chars().boxed().collect(Collectors.groupingBy(i->i, Collectors.counting()));
        Map<Integer, Long> mpp2 = t.chars().boxed().collect(Collectors.groupingBy(i->i, Collectors.counting()));
        return(mpp1.equals(mpp2));
        /* Alternative Approach
        Map<Integer, Long> collect = s.chars().boxed().collect(
                Collectors.toMap(
                        i -> i,
                        i -> 1L,
                        (o1, o2) -> o1 + 1
                )
        );
        */
//        return true;
    }
}
