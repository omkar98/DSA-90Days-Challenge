package DSA.Problem15;

import java.util.*;
        import java.util.concurrent.atomic.AtomicInteger;

public class  solution {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,2,2,2,2));
        System.out.println(minElementsToRemove(list));
        System.out.println(minElementsToRemoveAlternative(list));

    }
    public static int minElementsToRemove(ArrayList<Integer> arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        AtomicInteger counter = new AtomicInteger();
        for(Integer i : arr) {
            hashMap.computeIfPresent(i, (key, value) -> value+1);
            hashMap.computeIfAbsent(i, value -> 0);
        }
        hashMap.forEach((key, value) -> {
            if(value>0) counter.addAndGet(value);
        });
        return counter.get();
    }

    // Alternate super simple approach in Java
    public static int minElementsToRemoveAlternative(ArrayList<Integer> arr) {
        Set<Integer> intSet = new HashSet<>(arr);
        return arr.size()- intSet.size();
    }
}



