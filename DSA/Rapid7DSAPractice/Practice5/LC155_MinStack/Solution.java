package DSA.Rapid7DSAPractice.Practice5.LC155_MinStack;

import java.util.Stack;

public class Solution
{
    public static void main(String[] arr){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

class MinStack {
    private Stack<int[]> stk;
    public MinStack() {
        this.stk = new Stack<>();
    }

    public void push(int val) {
        if(stk.isEmpty()){
            stk.push(new int[]{val,val});
        } else {
            stk.push(new int[]{val,Math.min(val,this.getMin())});
        }
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        return stk.peek()[0];
    }

    public int getMin() {
        return stk.peek()[1];
    }
}