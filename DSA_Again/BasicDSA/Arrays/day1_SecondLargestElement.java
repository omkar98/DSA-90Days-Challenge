package DSA_Again.BasicDSA.Arrays;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;

public class day1_SecondLargestElement {
    public static int findSecondLargest(int n, int[] arr) {
        Optional<Integer> asInt = IntStream.of(arr).filter(i->i>0).boxed().sorted(Comparator.reverseOrder()).distinct().skip(1).limit(1).findFirst();
        int value = asInt.isPresent() ? asInt.get() : -1;
        System.out.println(value);
        return value;
    }

    public static void main(String[] args) {
        findSecondLargest(5, new int[]{10,25,-12,-6,20,20 });
    }
}
