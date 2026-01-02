package Neetcode.o2_TwoPointers;

import java.util.*;

public class TrapRainWater {
    public static int trap(int[] height) {
        int heightSize = height.length;
        int[] maxLeft = new int[heightSize];
        int[] maxRight = new int[heightSize];
        int[] minOfHeights = new int[heightSize];
        for(int i=0; i<heightSize; i++) {
            if(i==0) maxLeft[i] = 0;
            else {
                maxLeft[i] = Math.max(height[i-1], maxLeft[i-1]);
            }
        }
        for(int i=heightSize-1; i>=0; i--) {
            if(i==heightSize-1) maxRight[i] = 0;
            else {
                maxRight[i] = Math.max(height[i+1], maxRight[i+1]);
            }
        }
        for(int i=0; i<heightSize; i++) {
            minOfHeights[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        int totalSum = 0;
        for(int i=0; i<heightSize; i++) {
            int trapAtEachHeight = minOfHeights[i] - height[i]; // <-- Actual formula
            totalSum += Math.max(trapAtEachHeight, 0);
        }
        System.out.println(totalSum);
        return totalSum;
    }
}
