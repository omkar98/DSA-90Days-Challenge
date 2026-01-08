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
        DailyTemperatures.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(CarFleet.carFleet(10, new int[]{6,8}, new int[]{3,2}));
        HistogramLargestRectangle.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
