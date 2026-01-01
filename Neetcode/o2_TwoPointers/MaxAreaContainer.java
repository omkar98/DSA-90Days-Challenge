package Neetcode.o2_TwoPointers;

import java.util.*;

public class MaxAreaContainer {
    public static int maxArea(int[] heights) {
        int totalHeights = heights.length;
        int left = 0;
        int right = totalHeights-1;
        int maxArea = 0;
        while(left<right) {
            int area = (right-left)*Math.min(heights[right], heights[left]);
            maxArea = Math.max(maxArea, area);
            if(heights[right]>heights[left]) left++;
            else if (heights[right]<=heights[left]) right--;
        }
        System.out.println(maxArea);
        return maxArea;
    }
}
