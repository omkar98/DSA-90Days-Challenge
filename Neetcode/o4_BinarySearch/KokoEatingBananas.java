package Neetcode.o4_BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int size = piles.length;
        Arrays.sort(piles);
        int left = 1;
        int right = piles[size-1];
        int minH = right;

        while(left<=right){
            int mid = (left + ((right-left)/2));
            boolean possible = withinGivenHours(piles,h,mid,size);
            if(possible) {
                minH = Math.min(mid,minH);
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return minH;
    }

    private static boolean withinGivenHours(int[] piles, int h, int currH, int size) {
        long total = 0;
        for(int i=0; i<size; i++){
            total+= ((int) Math.ceil((float)(piles[i]/currH)));
            if(total>=h) return false;
        }
        return true;
    }
}
