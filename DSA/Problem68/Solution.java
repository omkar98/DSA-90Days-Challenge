package DSA.Problem68;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(2);
    }
}

class Queue {
    // Stacks to be used in the operations.
    Stack<Integer> stk1, stk2;

    public Queue() {
        this.stk1 = new Stack<>();
        this.stk2 = new Stack<>();
    }

    // Enqueues 'X' into the queue. Returns true after enqueuing.
    public boolean enqueue(int x) {
        this.stk1.push(x);
        return true;
    }
    /*
       Dequeues top element from queue. Returns -1 if the queue is empty,
       otherwise returns the popped element.
    */
    public int dequeue() {
        if(!this.stk2.isEmpty()) {
            return this.stk2.pop();
        } else {
            while(!this.stk1.isEmpty()){
                this.stk2.push(this.stk1.pop());
            }
            return this.stk2.isEmpty() ? -1 : this.stk2.pop();
        }
    }
};