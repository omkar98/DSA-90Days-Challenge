package DSA.TwoPointerSlidingWindow.Problem132;

public class Solution
{
    public static void main(String []args) {
        int[] a = {1,2,3,1,1,1,1};
        System.out.print(longestSubarrayWithSumK(a, 3));
    }
    // Sliding Window - Optimal Solution's more optimal approach O(n)
    public static int longestSubarrayWithSumK(int []a, long k) {
        int left = 0;
        int right = 0;
        int arrLen = a.length;
        int maxLen = 0;
        int sum = 0;
        while(right<arrLen){
            sum+=a[right];
            if(sum>k){
                sum = sum - a[left];
                left++;
            }
            if(sum==k){
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;
    }
}