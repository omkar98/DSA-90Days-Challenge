package DSA.Problem09;

import java.math.BigInteger;

public class  solution {
    public static void main(String[] args) {
        String input = "8888888888";
        System.out.println(nextLargestPalindrome(input, input.length()));
    }

    public static String nextLargestPalindrome(String number, int length) {
        if(length==1) return String.valueOf(Integer.parseInt(number)+1);
        if(checkPalindrome(number, length))  {
            number = new BigInteger(number).add(BigInteger.ONE).toString();
            length = number.length();
        }
        String leftNumber = number.substring(0,(length/2));
        String rightNumber = number.substring(length%2==0 ? (length/2) : (length/2)+1, length);
        if(length%2==0) {
            String reversedLeftString = new StringBuilder(leftNumber).reverse().toString();
            int reversedLeft = Integer.parseInt(new StringBuilder(leftNumber).reverse().toString());
            if(reversedLeft > Integer.parseInt(rightNumber)) {
                return leftNumber + reversedLeftString;
            } else {
                leftNumber=String.valueOf(Integer.parseInt(leftNumber)+1);
                rightNumber = new StringBuilder(leftNumber).reverse().toString();
                return leftNumber+rightNumber;
            }
        } else {
            String reversedLeftString = new StringBuilder(leftNumber).reverse().toString();
            int reversedLeft = Integer.parseInt(new StringBuilder(leftNumber).reverse().toString());
            if(reversedLeft > Integer.parseInt(rightNumber)) {
                return leftNumber + number.charAt(length/2) + reversedLeftString;
            } else {
                leftNumber = String.valueOf(Integer.valueOf(Integer.valueOf(leftNumber + number.charAt(length/2))+1));
                reversedLeftString = new StringBuilder(leftNumber.substring(0,leftNumber.length()-1)).reverse().toString();
                return leftNumber+reversedLeftString;
            }
        }
    }

    public static boolean checkPalindrome(String number, int length) {
        int left = 0;
        int right = length-1;
        while(left<right) {
            if(number.charAt(left)!=number.charAt(right)) return false;
            left++;right--;
        }
        return true;
    }



    /*// Brute of Brute Force approach -> O(n*10^n) time complexity!
    public static String nextLargestPalindrome(String number, int length) {
        Long num = Long.valueOf(number);
        Long nextPalindrome = num+1;
        while(!checkPalindrome(nextPalindrome.toString(), nextPalindrome.toString().length())) {
            nextPalindrome++;
        }
        return nextPalindrome.toString();
    }*/
}

