package DSA.Problem48;

import java.util.ArrayList;
import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-1,-1,-2));
        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int size = arr.size();
        int left = 0;
        int right = size-1;
        if(size==1) return arr.get(0);

        while(left<=right) {
            int mid = left + ((right-left)/2);
            int midLeftIdx = (mid-1+size)%size; // ArrayOutOfBoundException
            int midRightIdx = (mid+1+size)%size; // ArrayOutOfBoundException
            if(arr.get(mid)!=arr.get(midLeftIdx) && arr.get(mid)!=arr.get(midRightIdx)) return arr.get(mid);
            // check if the duplicate element lies in the left or the right
            else if(arr.get(mid)==arr.get(midRightIdx)) {
                boolean even = (right - midRightIdx)%2 == 0;
                if(even) right = mid-1;
                else left = mid+2;
            } else if(arr.get(mid)==arr.get(midLeftIdx)) {
                boolean even = (left - midLeftIdx)%2 == 0;
                if(even) left = mid+1;
                else right = mid-2;
            }
        }
        return -1;
    }
}





