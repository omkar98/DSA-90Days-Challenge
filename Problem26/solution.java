package Problem26;

public class  solution {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        int[] arr = {-1,-2,-3}; // corner case. May not work if all the elements are -ve. Revisit the problem and fix it.
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    public static long maxSubarraySum(int[] arr, int n) {
        int max = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum+=arr[i];
            if(sum>max) max = sum;
            else if(sum<0) sum=0;
        }
        return max;
    }
}



