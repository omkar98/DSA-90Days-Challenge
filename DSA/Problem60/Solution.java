package DSA.Problem60;

public class Solution {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Print the linked list to verify
        printLinkedList(head);
        printLinkedList(removeKthNode(head, 5));
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node removeKthNode(Node head, int K)
    {
        Node left = head;
        Node right = head;
        int count = 0;
        while(count<K) {
            right = right.next;
            count++;
        }

        Node leftPrev = left;
        // remove 1st element
        if(right==null) {
            head = left.next;
            return head;
        }

        while(right!=null) {
            leftPrev = left;
            left = left.next;
            right = right.next;
        }
        leftPrev.next = left.next;
        left.next = null;

        return head;
    }
}