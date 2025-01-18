package DSA.Problem61;

public class Solution {
    public static void main(String[] args) {
        Node joint = new Node(1);
        Node head = joint;
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        Node last = new Node(8);
        head.next.next.next.next.next.next.next = last;
        last.next = joint;

        // Print the linked list to verify
        printLinkedList(head);
        printLinkedList(removeLoop(head));
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        int count = 0;
        while (current != null && count != 10) {
            System.out.print(current.data + " ");
            current = current.next;
            count++;
        }
        System.out.println();
    }

    public static Node removeLoop(Node head){
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node slow = dummyHead;
        Node fast = dummyHead;

        do{
            slow = slow.next;
            fast = fast.next.next;
        } while(slow!=fast && slow!=null && fast!=null && fast.next!=null);

        if(slow==fast) {
            // loop exist
            slow = dummyHead;
            Node fastPrev = null;
            do {
                slow = slow.next;
                fastPrev = fast;
                fast = fast.next;
            } while (slow!=fast);
            fastPrev.next = null;
        }
        return dummyHead.next;
    }
}