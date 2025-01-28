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

    // Function to add another element equal to num at the top of this.stack.
    void push(int num) {
        if(this.stack.isEmpty()) {
            this.min = num;
            this.stack.push(num);
        }
        else {
            if(num < getMin()) {
                this.stack.push(2*num - getMin());
                this.min = num;
            } else {
                this.stack.push(num);
            }
        }
    }

    // Function to remove the top element of the this.stack.
    int pop() {
        if(this.stack.isEmpty()) return -1;
        if(this.stack.peek()>=getMin()) {
            return this.stack.pop();
        } else {
            int topElement = top();
            this.min = 2*getMin() - this.stack.pop();
            return topElement;
        }
    }

    // Function to return the top element of this.stack if it is present. Otherwise
    // return -1.
    int top() {
        if(this.stack.isEmpty()) return -1;
        if(this.stack.peek()>getMin()) return this.stack.peek();
        else {
            return getMin();
        }
    }

    // Function to return minimum element of this.stack if it is present. Otherwise
    // return -1.
    int getMin() {
        return !this.stack.isEmpty() ? this.min : -1;
    }
}