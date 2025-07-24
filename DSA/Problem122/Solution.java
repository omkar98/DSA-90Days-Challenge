package DSA.Problem122;



import java.util.Arrays;

public class Solution
{

    public static void main(String[] arr){
        int[] at = new int[]{2105,2299,2012,1939,2353 };
        int[] dt = new int[]{2143,2340,2123,2121,2357};
        int minPlatforms = calculateMinPatforms(at, dt, at.length);
        System.out.print(minPlatforms);
    }

    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int count = 0;
        int maxCount = 0;
        int atPtr = 0;
        int dtPtr = 0;
        while(atPtr<n && dtPtr<n){
            if(at[atPtr]<=dt[dtPtr]){
                count++;
                atPtr++;
                maxCount = Math.max(maxCount, count);
            }  else {
                count--;
                dtPtr++;
            }
        }
        return maxCount;
    }
}