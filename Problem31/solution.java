package Problem31;

import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        System.out.println(areAnagram(s1, s2));
    }

    public static boolean areAnagram(String str1, String str2){
        char[] s1 = str1.toCharArray();
        Arrays.sort(s1);
        char[] s2 = str2.toCharArray();
        Arrays.sort(s2);
        return Arrays.toString(s1).equals(Arrays.toString(s2));

    }
}





