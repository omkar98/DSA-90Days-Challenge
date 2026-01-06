package Neetcode.o3_Stack;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(ValidParenthesis.isValid("[(])"));
//        MinStack minStack = new MinStack();
//        minStack.push(1);
//        minStack.push(2);
//        minStack.push(0);
//        System.out.println(minStack.getMin()); // return 0
//        minStack.pop();
//        System.out.println(minStack.top());    // return 2
//        System.out.println(minStack.getMin()); // return 1

        evalReversePolishNotation.evalRPN(new String[]{"1","2","+","3","*","4","-"});
    }
}
