package DSA.Problem112;

import java.util.Arrays;
import java.util.Stack;

public class Solution
{

    public static void main(String[] arr){

        int[] greed = new int[]{3,5,6,4};
        int[] size = new int[]{10,10};
        System.out.print(assignCookie(greed, size));

    }

    public static int assignCookie(int []child, int []cookie) {
        Arrays.sort(child);
        Arrays.sort(cookie);
        int cookiePtr = 0;
        int childPtr = 0;
        int noOfChildren = child.length;
        int noOfCookies = cookie.length;
        while(cookiePtr<noOfCookies && childPtr<noOfChildren){
            if(cookie[cookiePtr]>=child[childPtr]) {
                cookiePtr++;
                childPtr++;
            } else {
                cookiePtr++;
            }
        }
        return childPtr;
    }

}