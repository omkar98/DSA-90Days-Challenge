package DSA.Problem116;


import java.util.Arrays;

public class Solution
{

    public static void main(String[] arr){
        int [] jump = new int[]{2,1,3,2,4};
        System.out.print(minimumJumps(jump, 5));
    }

    public static int minimumJumps(int[] arr, int N) {
        int leftPtr = 0;
        int rightPtr = 0;
        int minJumps = 0;
        while(rightPtr<N-1){
            int newRightPtr = rightPtr;
            for(int i=leftPtr; i<=rightPtr; i++){
                int currIndex = arr[i]+i;
                if (currIndex>rightPtr) newRightPtr = currIndex;
                if (newRightPtr >= N - 1) {
                    return minJumps + 1;
                }
            }
            if (newRightPtr == rightPtr) {
                return -1; // If no progress is made, return -1
            }
            leftPtr = rightPtr+1;
            rightPtr= newRightPtr;
            minJumps+=1;
        }
        return minJumps;
    }
}