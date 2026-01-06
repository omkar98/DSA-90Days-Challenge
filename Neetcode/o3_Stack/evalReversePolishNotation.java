package Neetcode.o3_Stack;

import java.util.*;
import java.util.function.BiFunction;

public class evalReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        final BiFunction<Integer, Integer, Integer> add = (a,b) -> a+b;
        final BiFunction<Integer, Integer, Integer> multiply = (a,b) -> a*b;
        final BiFunction<Integer, Integer, Integer> subtract = (a,b) -> a-b;
        final BiFunction<Integer, Integer, Integer> divide = (a,b) -> a/b;
        Map<String, BiFunction<Integer,Integer,Integer>> mpp = Map.of(
                "+", add,
                "-", subtract,
                "*", multiply,
                "/", divide
        );

        Deque<Integer> stk = new ArrayDeque<>();
        List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        for(String s : tokens) {
            if(!operators.contains(s)) stk.push(Integer.valueOf(s));
            else {
                int op1 = stk.pop();
                int op2 = stk.pop();
                stk.push(mpp.get(s).apply(op2,op1));
            }
        }
        System.out.println(stk.peek());
        return stk.pop();
    }
}
