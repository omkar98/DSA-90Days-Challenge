package DSA.Problem57;

import java.util.ArrayList;
import java.util.List;

public class FindMiddle {
    public static List<String> finalList = new ArrayList<>();
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println(findMiddle(head).data);
    }

    public static Node findMiddle(Node head) {
        // empty and 1 element
        if(head == null || head.next==null) return head;
        // 2 elements
        if(head.next.next == null) return head.next;
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr.next!=null) {
            // even numbers
            if(fastPtr.next.next==null) {
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }
            else{
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
            }
        }
        return slowPtr;
    }
}





