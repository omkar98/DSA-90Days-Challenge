package DSA.Problem62;

public class Solution {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        // Print the linked list to verify
        printLinkedList(head);
        printLinkedList(pairsSwap(head));
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node pairsSwap(Node head) {
        Node ptr1 = head;
        if(ptr1==null) return head;
        Node ptr2 = ptr1.next;
        if(ptr2==null) return head;
        Node temp = ptr2.next;
        Node oldPtr2 = ptr2;
        do {
            ptr2.next = ptr1;
            ptr1.next = temp;
            if(oldPtr2!=ptr2) {
                oldPtr2.next = ptr2;
            } else {
                head = ptr2;
            }
            oldPtr2 = ptr1;
            ptr1 = temp;
            if(temp!=null) {
                ptr2 = temp.next;
                temp = ptr2!=null ? ptr2.next : ptr2;
            }
        } while ((temp!=null || ptr1!=null) && (temp!=null || ptr2!=null));

        return head;
    }
}