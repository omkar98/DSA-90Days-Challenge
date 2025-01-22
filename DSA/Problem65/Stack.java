package DSA.Problem65;

public class Stack {
    private int[] stack;
    private int capacity;
    private int top = -1;

    Stack(int capacity) {
        this.stack = new int[capacity];
        this.capacity = capacity;
    }

    public void push(int num) {
        if(isFull()!=1) {
            top++;
            this.stack[top] = num;
        }
    }

    public int pop() {
        if(isEmpty()!=1) {
            int element = this.stack[top];
            top--;
            return element;
        }
        return -1;
    }

    public int top() {
        return top!=-1 ? this.stack[top] : -1;
    }

    public int isEmpty() {
        if(top<0) return 1;
        else return 0;
    }
    public int isFull() {
        if(top>=capacity-1) return 1;
        else return 0;
    }
}

