package DSA.Problem59;

public class Solution {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Print the linked list to verify
        printLinkedList(head);
        printLinkedList(insertionSortLL(head));
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node insertionSortLL(Node head) {
        Node finalHead = new Node(0);
        finalHead.next = head;

        Node temp = head.next;
        while(temp!=null) {
            Node i = finalHead;
            Node iPrev = finalHead;
            while(i.data<temp.data) {
                iPrev = i;
                i=i.next;
            }
            iPrev.next = temp;
            Node tempNext = temp.next;
            temp.next = i;

            while(i.next!=temp) {
                i=i.next;
            }
            i.next=tempNext;
            temp = tempNext;
        }
        return finalHead.next;
    }
}