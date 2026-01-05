package Neetcode.o3_Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MinStack {
    // IMP: Dont use a Map<Integer, Integer>, it will become super difficult to iterate over.
    Deque<int[]> minStack;

    public MinStack() {
        this.minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        int currMin = val;
        if(!minStack.isEmpty()) currMin = Math.min(minStack.peek()[1], val);
        minStack.push(new int[]{val, currMin});
    }

    public void pop() {
        minStack.pop();
    }

    public int top() {
        return !minStack.isEmpty() ? minStack.peek()[0] : -1;
    }

    public int getMin() {
        return !minStack.isEmpty() ? minStack.peek()[1] : -1;
    }
}
