package DSA.Rapid7DSAPractice.Practice3.LC56_MergeIntervals;


import java.sql.Array;
import java.util.*;

public class Solution
{
    public static void main(String[] arr){
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        Solution s = new Solution();
        int[][] mergedList = s.merge(intervals);
        System.out.print(mergedList);
    }

    // https://leetcode.com/problems/merge-intervals/
    public int[][] merge(int[][] intervals) {
        //make sure they are sorted
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedList = new ArrayList<>();
        int left = 0;
        int len = intervals.length;
        if(len==1) return intervals;
        for(int right=1; right<len;right++){
            if(intervals[left][1] >= intervals[right][0]) {
                // Merge intervals by updating the end
                intervals[left][1] = Math.max(intervals[left][1], intervals[right][1]);
            }
            else {
                // keep adding the left and not the right, as you did earlier.
                mergedList.add(intervals[left]);
                left = right;
            }
        }
        mergedList.add(intervals[left]);
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}