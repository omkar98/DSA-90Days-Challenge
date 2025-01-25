package DSA.Problem66;

public class Stack {
    private Node head;
    private int size;
    private int top = -1;

    Stack() {
        this.head = null;
        this.size = 0;
    }

    public int getSize()
    {
        return this.size;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public boolean isEmpty()
    {
        if(this.head==null) return true;
        return false;
    }

    void pop() {
        if(!isEmpty()) {
            this.head=this.head.next;
            this.size--;
        }
    }

    int getTop()
    {
        if(isEmpty()) return -1;
        return head.data;
    }
}

