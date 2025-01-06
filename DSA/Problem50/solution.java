package DSA.Problem50;

import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        int[] stalls = {0,3};
        System.out.println(aggressiveCows(stalls, 2));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int size = stalls.length;
        int low = 1;
        int high = stalls[size-1]-stalls[0];

        if(k==1) return stalls[0];
        if(k==2) return high;

        while(low<=high) {
            int mid = (low+high)/2;
            if(canWePlace(stalls, k, mid)) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }

    public static boolean canWePlace(int[] stalls, int k, int mid) {
        int cows = 1;
        int lastCowPosition = 0;
        for(int i=1; i<stalls.length; i++) {
            if(stalls[i]-stalls[lastCowPosition]>=mid) {
                cows++;
                lastCowPosition = i;
            }
            if(cows==k) return true;
        }

        return cows==k ? true : false;
    }


}





