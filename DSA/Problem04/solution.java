package DSA.Problem04;

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(arrayEquilibriumIndex(arr));
    }

    public static int arrayEquilibriumIndex(int[] arr) {
        int size = arr.length;
        if(size==1) return 0;
        if(size==2) return -1;
        int leftSum = 0;
        int totalSum = Arrays.stream(arr).sum();
        for(int i=0; i<size; i++) {
            int rightSum = totalSum-leftSum-arr[i];
            if(leftSum==rightSum) return i;
            leftSum+=arr[i];
        }
        return -1;
    }
}

