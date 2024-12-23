package DSA.Problem17;

import java.util.*;

public class  solution {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,-1,2,-2));
        System.out.println(LongestSubsetWithZeroSum(arr));

    }

    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        // you dont have to create a separate sumList. Infact you can directly input in the hasmap as you parallelly calculate the sum.
//        List<Integer> sumList = new ArrayList<>();
//        sumList.add(arr.get(0));
//
//        for(int i=1; i<n; i++){
//            sumList.add(sumList.get(i-1)+ arr.get(i));
//        }
        int n = arr.size();
        Map<Integer, Integer> hashMap = new HashMap<>();
        int maxLength = 0;
        int sum=0;
        for(int i=0; i<n; i++) {
            sum+=arr.get(i);
            int index = i;
            // corner case when sum==0.
            if(sum==0) {
                maxLength=index+1;
            }
            if(hashMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i-hashMap.get(sum));
            }
            hashMap.computeIfAbsent(sum, value -> index);
        }
        return maxLength;
    }
}



