package Neetcode.o3_Stack;

import java.util.*;
import java.util.function.BiFunction;

public class evalReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();
        List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        for(String s : tokens) {
            if(!operators.contains(s)) stk.push(Integer.valueOf(s));
            else {
                int op1 = stk.pop();
                int op2 = stk.pop();
                int value = 0;
                switch(s) {
                    case "*": { value = op2 * op1; break; }
                    case "-": { value = op2 - op1; break; }
                    case "+": { value = op2 + op1; break; }
                    case "/": { value = op2 / op1; break; }
                    default :
                        System.out.println("incorrect");
                }
                stk.push(value);
            }
        }
        System.out.println(stk.peek());
        return stk.pop();
    }
}
