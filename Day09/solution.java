package Day09;

public class    solution {
    public static void main(String[] args) {
        String input = "1221";
        System.out.println(nextLargestPalindrome(input, input.length()));
    }

    // Brute of Brute Force approach -> O(n*10^n) time complexity!
    public static String nextLargestPalindrome(String number, int length) {
        Long num = Long.valueOf(number);
        Long nextPalindrome = num+1;
        while(!checkPalindrome(nextPalindrome.toString(), nextPalindrome.toString().length())) {
            nextPalindrome++;
        }
        return nextPalindrome.toString();
    }

    public static boolean checkPalindrome(String number, int length) {
        int left = 0;
        int right = length-1;
        boolean palindrome = false;
        while(left<right) {
            if(number.charAt(left)!=number.charAt(right)) return false;
            left++;right--;
        }
        return true;
    }
}

