package DSA.Recursion.Problem141;

/* 1. Print 1 -> n
*  2. Print n -> 1
* */


public class Solution
{
    public static void main(String[] arr){
//        print1ToN(1,5);
//        printNTo1(5);
//        print1ToNBackTracking(5);
        printNTo1BackTracking(1,5);
    }

    // 1. Print 1 to N using recursion. Time: O(n) | Space: O(n)
    public static void print1ToN(int count, int n) {
        if(count>n) return;
        System.out.println(count);
        print1ToN(count+1, n);
    }

    // 2. Print N to 1 using recursion. Time: O(n) | Space: O(n)
    public static void printNTo1(int n) {
        if(n<=0) return;
        System.out.println(n);
        printNTo1(n-1);
    }

    // 3. Print 1 to N using backtracking. Time: O(n) | Space: O(n)
    public static void print1ToNBackTracking(int n) {
        if(n<=0) return;
        print1ToNBackTracking(n-1);
        System.out.println(n);
    }

    // 4. Print N to 1 using backtracking. Time: O(n) | Space: O(n)
    public static void printNTo1BackTracking(int count, int n) {
        if(count>n) return;
        printNTo1BackTracking(count+1, n);
        System.out.println(count);
    }



}