package DSA.Problem18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class  solution {
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,3,5,4,5,3,4));
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,-6,3,1,2,8,2,1));
        System.out.println(subArrayCount(arr, 7));

    }

    public static int subArrayCount(ArrayList <Integer> arr, int k) {
        int sum = 0;
        int size = arr.size();
        final int[] countSubArrays = {0};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        for(int i=0; i<size; i++) {
            sum+=arr.get(i);
            int remainder = (int) ((sum % k) + k) % k;
            hashMap.computeIfPresent(remainder, (key, value) -> {
                countSubArrays[0] +=value;
                return value+1;
            });
            hashMap.computeIfAbsent(remainder, value -> 1);
        }
        return countSubArrays[0];
    }
}



