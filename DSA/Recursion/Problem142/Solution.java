package DSA.Recursion.Problem142;

/* 1. Find sum using Parameterised
   2. Find sum using Functional
* */


public class Solution
{

    public static void parameterisedSum(int i, int sum){
        if(i<1) {
            System.out.print(sum);
            return;
        }
        parameterisedSum(i-1, sum+i);
    }

    public static int functionalSum(int n){
        if(n==0) return 0;
        int sum = n + functionalSum(n-1);
        return sum;
    }
    public static void main(String[] arr){
//        parameterisedSum(3,0);
        System.out.print(functionalSum(3));
    }




}