package Neetcode.o3_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class HistogramLargestRectangle {
    // I had initially thought this might be 2-ptr problem, but not. Make sure to remember this and practice again.
    // Just saw the solution vividly. Was able to code it correctly in the first attempt, no compiler/logic issues.
    public static int largestRectangleArea(int[] heights) {
        int totalHeights = heights.length;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[]{0, heights[0]});
        int maxArea = 0;

        for(int i=1; i<totalHeights; i++){
            int[] top = stk.peek();
            int newIdx = i;
            while(top!=null && top[1]>=heights[i]) {
                maxArea = Math.max(maxArea, (i-top[0])*top[1]);
                newIdx = stk.pop()[0];
                top = stk.peek();
            }
            stk.push(new int[]{newIdx,heights[i]});
        }

        while(!stk.isEmpty()){
            int[] top = stk.pop();
            maxArea = Math.max(maxArea, (totalHeights-top[0])*top[1]);
        }
        return maxArea;
    }
}
