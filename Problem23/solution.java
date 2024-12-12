package Problem23;

public class  solution {
    public static void main(String[] args) {
        // consider 0 as +ve.
        String str1 = "BAE";
        String str2 = "ABADE";
        System.out.println(isSubsequence(str1, str2));

    }

    public static String isSubsequence(String str1, String str2) {
        int str1Ptr = 0;
        int str2Ptr = 0;
        while(str1Ptr<str1.length() && str2Ptr<str2.length()) {
            if(str1.charAt(str1Ptr) == str2.charAt(str2Ptr)) {
                str1Ptr++;
                str2Ptr++;
            }
            else str2Ptr++;
        }
        return str1Ptr==str1.length() ? "True" : "False";
    }
}



