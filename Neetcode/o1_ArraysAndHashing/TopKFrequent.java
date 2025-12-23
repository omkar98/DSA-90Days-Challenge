package Neetcode.o1_ArraysAndHashing;


import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(i->i, Collectors.counting()));
        System.out.println(collect);
        int[] list = collect.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(k).map(values -> values.getKey()).peek(i-> System.out.println(i)).mapToInt(i -> i.intValue()).toArray();
        System.out.println(list);
        return list;
    }
}
