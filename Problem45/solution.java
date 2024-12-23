package Problem45;

import java.util.ArrayList;
import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,1));
        missingAndRepeating(arr,arr.size());

    }

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        long sumofNNaturalNumbers = ((n*(n+1))/2);
        long sumofSquaresOfNNaturalNumbers = (n * (n + 1) * (2 * n + 1)) / 6;
        long runningSum = 0;
        long runningSquaredSum = 0;
        for(int i=0; i<n;i++) {
            runningSum+=arr.get(i);
            runningSquaredSum +=  ((long) arr.get(i)* (long)arr.get(i));
        }
        long deltaSumDiff = runningSum - sumofNNaturalNumbers;
        long deltaSquaredSum = runningSquaredSum - sumofSquaresOfNNaturalNumbers;
        long deltaSumAddition = deltaSquaredSum/deltaSumDiff;

        long x = (deltaSumDiff + deltaSumAddition)/2;
        long y = x - deltaSumDiff;

        return new int[] {(int)x,(int)y};

    }
}





