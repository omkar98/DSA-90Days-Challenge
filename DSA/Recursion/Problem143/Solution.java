package DSA.Recursion.Problem143;

/* 1. Reverse an Array
   2. Check if a String in Palindrome
   3. Fibonnaci (multiple recursion calls)
* */


public class Solution
{
    public static int[] reverseAnArray(int[] arr, int l, int r){
        if(l>=r) {
            return arr;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return reverseAnArray(arr, l+1, r-1);
    }

    public static boolean checkForPalindrome(String str, int l, int r){
        if(l>=r) return true;
        if(str.charAt(l)!=str.charAt(r)) return false;
        return checkForPalindrome(str, l+1, r-1);
    }

    public static int fibonnaci(int n){
        if(n<=1) return n;
        return fibonnaci(n-1)+fibonnaci(n-2);
    }

    public static void main(String[] arr){
//        int[] arr1 = new int[]{1,2,3,4,5};
//        arr1 = reverseAnArray(arr1, 0,arr1.length-1);
//        System.out.print(arr1);

//        String str = "madpm";
//        str = str.toLowerCase();
//        str = str.replaceAll("[^a-z0-9]", "");
//        System.out.print(checkForPalindrome(str, 0, str.length()-1));
        System.out.print(fibonnaci(4));


    }




}