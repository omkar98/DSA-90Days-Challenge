package DSA.Problem56;

import DSA.LinkedListDataStructure.LinkedListNode;

import java.util.ArrayList;
import java.util.List;

public class  solution {
    public static List<String> finalList = new ArrayList<>();
    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(null);
        head.next = new LinkedListNode<>(-1);
//        head.next.next = new LinkedListNode<>(3);
//        head.next.next.next = new LinkedListNode<>(4);

        // traverse the linkedLlist if head is given
        LinkedListNode.travelLinkedList(reverseLinkedList(head));
    }

    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head)
    {
        if(head==null || head.next==null) return head;
        LinkedListNode<Integer> ptr1 = null;
        LinkedListNode<Integer> ptr2 = head;
        while(ptr2.next!=null) {
            LinkedListNode<Integer> temp = ptr2.next;
            ptr2.next = ptr1;
            ptr1=ptr2;
            ptr2 = temp;
        }
        ptr2.next = ptr1;
        return ptr2;
    }
}





