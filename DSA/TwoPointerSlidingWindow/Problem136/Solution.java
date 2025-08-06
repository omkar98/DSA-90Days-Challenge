package DSA.TwoPointerSlidingWindow.Problem136;


import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] arr){
        int[] a = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.print(findMaxFruits(a, a.length));
    }
    public static int findMaxFruits(int []arr, int n) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        int maxLen = 0;
        while(right<n){
            if(mpp.size()<=2) {
                int value = mpp.getOrDefault(arr[right], 0);
                mpp.put(arr[right], value+1);
                if(mpp.size()<=2) maxLen = Math.max(maxLen, right-left+1);
                right++;
            } else {
                while(mpp.size()>2){
                    mpp.compute(arr[left], (k, value) -> value - 1);
                    if(mpp.get(arr[left])<=0) mpp.remove(arr[left]);
                    left++;
                }
            }
        }
        return maxLen;
    }
}