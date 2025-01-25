package DSA.Problem67;

public class Queue {
    private Node front;
    private Node back;

    Queue() {
        this.front = null;
        this.back = null;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        return this.front == null;
    }

    void enqueue(int data) {
        Node n = new Node(data);
        if(isEmpty()) {
            this.front = n;
            this.back = n;
        } else {
            this.back.next = n;
            this.back = n;
        }
    }

    int dequeue() {
        if(isEmpty()) return -1;
        int element = this.front.data;
        this.front = this.front.next;
        return element;
    }

    int front() {
        if(isEmpty()) return -1;
        return this.front.data;
    }
}

