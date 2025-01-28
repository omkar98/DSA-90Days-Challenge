package DSA.Problem69;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(17);
        s.push(23);
        s.push(11);
        System.out.println(s.pop());
    }
}

class Stack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public Stack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /*----------------- Public Functions of Stack -----------------*/
    public int getSize() {
        if(isEmpty()) return 0;
        return this.q1.isEmpty() ? this.q2.size() : this.q1.size();
    }

    public boolean isEmpty() {
        if(this.q1.isEmpty() && this.q2.isEmpty()) return true;
        return false;
    }

    public void push(int element) {
        if(isEmpty()) {
            this.q1.add(element);
        } else if (this.q1.isEmpty()) {
            this.q1.add(element);
            while(!this.q2.isEmpty()) {
                this.q1.add(this.q2.remove());
            }
        } else if (this.q2.isEmpty()) {
            this.q2.add(element);
            while(!this.q1.isEmpty()) {
                this.q2.add(this.q1.remove());
            }
        }
    }

    public int pop() {
        if(isEmpty()) return -1;
        if(this.q1.isEmpty()) return this.q2.remove();
        else return this.q1.remove();
    }

    public int top() {
        if(isEmpty()) return -1;
        if(this.q1.isEmpty()) return this.q2.element();
        else return this.q1.element();
    }
}