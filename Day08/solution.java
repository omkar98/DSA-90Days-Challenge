package Day08;

import java.util.Stack;

public class solution {
    public static void main(String[] args) {
        String input = "1001";
        System.out.println(makeBeautiful(input));
    }

    public static int makeBeautiful(String str) {
        // We need to find the changes that can occur for two strings.
        int size = str.length();
        int startsWithZero = 0;
        int startsWithOne = 0;
        for(int i=0; i<size; i++) {
            // if starts with 0.
            // The char at that position should match with  (i%2) for Zero-start string or (i+1%2) for One-start string
            if(str.charAt(i)%2!=i%2){
                startsWithZero++;
            }
            // if starts with 1
            if(str.charAt(i)%2!=(i+1)%2) {
                startsWithOne++;
            }
        }
        return Math.min(startsWithZero,startsWithOne);
    }
}

