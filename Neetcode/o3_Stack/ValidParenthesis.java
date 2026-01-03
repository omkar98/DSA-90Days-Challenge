package Neetcode.o3_Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {
    public static Character OPEN_SQUARE = '[';
    public static Character OPEN_CURLY = '{';
    public static Character OPEN_CIRCLE = '(';
    public static Character CLOSED_SQUARE = ']';
    public static Character CLOSED_CIRCLE = ')';
    public static Character CLOSED_CURLY = '}';

    public static boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        int sSize = s.length();
        for(int i=0; i<sSize; i++){
            char currentChar = s.charAt(i);
            if(currentChar==OPEN_SQUARE || currentChar==OPEN_CURLY || currentChar==OPEN_CIRCLE) {
                stk.push(currentChar);
            } else {
                if(!stk.isEmpty() && (currentChar==CLOSED_SQUARE && stk.peek()==OPEN_SQUARE)) stk.pop();
                else if(!stk.isEmpty() && (currentChar==CLOSED_CURLY && stk.peek()==OPEN_CURLY)) stk.pop();
                else if(!stk.isEmpty() && (currentChar==CLOSED_CIRCLE && stk.peek()==OPEN_CIRCLE)) stk.pop();
                else return false;
            }
        }
        return stk.isEmpty();
    }
}
