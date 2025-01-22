package DSA.Problem64;

public class Solution {
    public static void main(String[] args) {
        int[] elements = {1};
        Node head = new Node(elements[0]);
        Node current = head;
        for (int i = 1; i < elements.length; i++) {
            current.next = new Node(elements[i]);
            current = current.next;
        }

        // Print the linked list to verify
        printLinkedList(head);
        printLinkedList(segregateOddEven(head));
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node segregateOddEven(Node head) {
        Node odd = null;
        Node even = null;
        Node currOdd = odd;
        Node currEven = even;
        Node temp = head;

        while(temp!=null) {
            if(temp.data%2==0) {
                Node currNode = new Node(temp.data);
                if(even==null) {
                    even = currNode;
                    currEven = currNode;
                }
                else {
                    currEven.next = currNode;
                    currEven = currNode;
                }
            } else {
                Node currNode = new Node(temp.data);
                if(odd==null) {
                    odd = currNode;
                    currOdd = currNode;
                }
                else {
                    currOdd.next = currNode;
                    currOdd = currNode;
                }
            }
            temp = temp.next;
        }

        if(currOdd!=null) currOdd.next = even;
        return odd!=null ? odd : even;
    }

}