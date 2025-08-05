package DSA.TwoPointerSlidingWindow.Problem133;


import java.util.Arrays;

public class Solution
{
    public static void main(String[] arr){
        int[] A = new int[]{9,7,5,3,2,1,8};
        System.out.print(maxPoints(A, 4));
    }
    public static int maxPoints(int []arr , int K){
        int n = arr.length;
        if(K==1 || n==1) return Math.max(arr[0], arr[n - 1]);
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;
        leftSum= Arrays.stream(arr).limit(K).sum();
        maxSum = leftSum;


        for(int i=K-1, rightIndex=n-1; i>=0; i--, rightIndex--){
            leftSum -= arr[i];
            rightSum += arr[rightIndex];
            maxSum = Math.max(leftSum+rightSum, maxSum);
        }
        return maxSum;

    }
}