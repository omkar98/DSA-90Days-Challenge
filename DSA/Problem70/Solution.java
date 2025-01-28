package DSA.Problem70;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.top());
//        System.out.println(minStack.pop());
//        System.out.println(minStack.pop());
//        System.out.println(minStack.pop());
//        System.out.println(minStack.pop());
//        System.out.println(minStack.pop());
//        System.out.println(minStack.pop());

    }
}

class MinStack {
    Stack<Integer> stack;
    int min;

    // Constructor
    MinStack() {
        this.stack = new Stack<Integer>();
    }

    // Function to add another element equal to num at the top of stack.
    void push(int num) {
        if(stack.isEmpty()) {
            this.min = num;
            stack.push(num);
        }
        else {
            if(num < getMin()) {
                stack.push(2*num - getMin());
                this.min = num;
            } else {
                stack.push(num);
            }
        }
    }

    // Function to remove the top element of the stack.
    int pop() {
        if(stack.isEmpty()) return -1;
        if(stack.peek()>=getMin()) {
            return stack.pop();
        } else {
            int topElement = top();
            this.min = 2*getMin() - stack.pop();
            return topElement;
        }
    }

    // Function to return the top element of stack if it is present. Otherwise
    // return -1.
    int top() {
        if(stack.peek()>getMin()) return stack.peek();
        else {
            return !stack.isEmpty() ? getMin() : -1;
        }
    }

    // Function to return minimum element of stack if it is present. Otherwise
    // return -1.
    int getMin() {
        return !stack.isEmpty() ? this.min : -1;
    }
}