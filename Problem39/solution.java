package Problem39;

public class  solution {
    // circular array kadane
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10,5,5,6,2));
//        int[] arr = {3,1,-2,9};
        int[] arr = {-1,-2,-3,-4};
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    public static int maxSubarraySum(int[] arr, int n) {
        int maxSum = 0;
        int runningMaxSum = 0;
        int totalArraySum = 0;
        int minSum = 0;
        int runningMinSum = 0;
        boolean allNegative = true;
        int maxInArray = arr[0];
        for(int i=0; i<n;i++) {
            runningMaxSum+=arr[i];
            runningMinSum+=arr[i];
            if(runningMaxSum<0) runningMaxSum = 0;
            if(runningMinSum>0) runningMinSum = 0;
            if(runningMaxSum>maxSum) maxSum = runningMaxSum;
            if(runningMinSum<minSum) minSum = runningMinSum;
            if(arr[i]>0) allNegative = false;
            if(arr[i]>maxInArray) maxInArray = arr[i];
            totalArraySum+=arr[i];
        }
        return allNegative ? maxInArray : Math.max(maxSum, totalArraySum-minSum);
    }
}





