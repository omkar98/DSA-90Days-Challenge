package DSA.Problem20;

public class  solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int sum = 7;
        System.out.println(pairSum(arr, arr.length, sum));

    }

    public static int pairSum(int arr[], int n, int target) {
        // Binary Search Way: O(nlogn)
        // int count=0;
        // for(int i=0; i<n; i++) {
        //     int first = arr[i];
        //     int second = target-first;
        //     if(Arrays.binarySearch(Arrays.copyOfRange(arr, i+1, n), second)>=0) {
        //         count++;
        //     }
        // }
        // return count==0 ? -1 : count;
        int left = 0;
        int right = n-1;
        int counter = 0;
        while(left<right) {
            int currentSum = arr[left]+arr[right];
            if(currentSum==target) {
                counter++;
                left++;
                right--;
            }
            if(currentSum<target) left++;
            if(currentSum>target) right--;
        }
        return counter==0 ? -1: counter;
    }

}



