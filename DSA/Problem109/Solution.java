package DSA.Problem109;

public class Solution
{
    public static void main(String[] arr){
        System.out.println(reverseString(""));
    }
    public static String reverseString(String str)
    {
        String[] strArray = str.split(" ");
        StringBuilder strbuilder = new StringBuilder();
        int strLength = strArray.length;
        for(int i=0; i<strLength; i++) {
            strbuilder.append(strArray[strLength-i-1]);
            if(i<strLength-1)strbuilder.append(" ");
        }
        return strbuilder.toString();
    }

}