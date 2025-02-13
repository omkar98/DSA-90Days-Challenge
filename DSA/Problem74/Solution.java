package DSA.Problem74;

import java.util.*;

public class Solution {
    private static final char OPENING_CURLY = '{';
    private static final char OPENING_SQAURE = '[';
    private static final char OPENING_CIRCLE = '(';
    private static final char CLOSING_CURLY = '}';
    private static final char CLOSING_SQAURE = ']';
    private static final char CLOSING_CIRCLE = ')';
    private static final ArrayList<Character> OPENINGS = new ArrayList<>(Arrays.asList(OPENING_CIRCLE, OPENING_CURLY, OPENING_SQAURE)) ;
    private static final ArrayList<Character> CLOSINGS = new ArrayList<>(Arrays.asList(CLOSING_CIRCLE, CLOSING_CURLY, CLOSING_SQAURE)) ;
    public static void main(String[] args) {
    String s = "}]]";
    boolean  output = isValidParenthesis(s);
    System.out.print(output);
//        for(int i=0; i<output.size(); i++) {
//        }
    }
    public static boolean isValidParenthesis(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            if(OPENINGS.contains(s.charAt(i))) {
                stk.push(s.charAt(i));
            }
            else {
                if(!stk.isEmpty() && CLOSINGS.indexOf(s.charAt(i)) == OPENINGS.indexOf(stk.peek())) {
                    stk.pop();
                } else return false;
            }
        }
        return stk.isEmpty();
    }
}