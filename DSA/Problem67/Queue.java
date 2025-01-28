package DSA.Problem67;

public class Queue {
    private Node front;
    private Node back;

    public Queue() {
        this.front = null;
        this.back = null;
    }

    /*----------------- Public Functions of Queue -----------------*/

    public boolean isEmpty() {
        return this.front == null;
    }

    public void enqueue(int data) {
        Node n = new Node(data);
        if(isEmpty()) {
            this.front = n;
            this.back = n;
        } else {
            this.back.next = n;
            this.back = n;
        }
    }

    public int dequeue() {
        if(isEmpty()) return -1;
        int element = this.front.data;
        this.front = this.front.next;
        return element;
    }

    public int front() {
        if(isEmpty()) return -1;
        return this.front.data;
    }
}

