package Problem42;

import java.util.HashMap;
import java.util.Map;

public class  solution {
    public static void main(String[] args) {
//        int[] arr = {2,6,3,4,1,12};
//        int[] arr = {4,1,7,2,6,5};
//        int[] arr = {1,4,6,3,2};
        int[] arr = {1};
        long[] values = maxProductCount(arr, arr.length);
        for (int i=0; i<values.length; i++){
            System.out.print(values[i] + " ");
        }

    }

    public static long[] maxProductCount(int arr[], int n) {
        if(n<=1) return new long[]{0};
        HashMap<Long, Integer> hashMap = new HashMap<>();
        int maxFreq = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n;j++) {
                long prod = (long) arr[i] *arr[j];
                int currentFreq = hashMap.getOrDefault(prod, 0)+1;
                if(maxFreq < currentFreq) maxFreq = currentFreq;
                hashMap.put(prod, currentFreq);
            }
        }
        /* find the prod with the max frequency
        Scenario-1: If the freq are same, then choose the prod with lowest value */
        Long lowestProd = Long.MAX_VALUE;
        for(Map.Entry<Long, Integer> entry : hashMap.entrySet()) {
            if(maxFreq==entry.getValue() &&  entry.getKey() < lowestProd) {
                lowestProd = entry.getKey();;
            }
        }

        // Now you have the lowest Product and its frequency. Simply apply nCr operation to get the final output.
        long value = nCr(hashMap.get(lowestProd), 2);

        return value<=0 ? new long[]{0} : new long[]{lowestProd, value};
    }

    public static long nCr(int n, int r) {
        return (n*(n-1))/2;
    }
}





