package DSA.Problem58;

import DSA.Problem57.Node;

public class  solution {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(7);

        Node headNew = sortLL(head);
        System.out.println(headNew);

    }

    public static Node sortLL(Node head) {
        if(head == null || head.next == null)return head;
        Node middle = findMiddle(head);
        Node middleNextHead = middle.next;
        middle.next = null;
        Node leftHead = sortLL(head);
        Node rightHead = sortLL(middleNextHead);
        Node sortedHead = sort(leftHead, rightHead);
        return sortedHead;
    }

    public static Node sort(Node leftHead, Node rightHead) {
        Node head = new Node(-1);
        Node temp = head;
        while(leftHead!=null && rightHead!=null) {
            if(leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                temp = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                temp = rightHead;
                rightHead = rightHead.next;
            }
        }
        if(leftHead!=null) {
            temp.next = leftHead;
        }
        if(rightHead!=null) {
            temp.next = rightHead;
        }
        return head.next;
    }

    public static Node findMiddle(Node head) {
        Node ptr1 = head;
        Node ptr2 = head;
        while(ptr2!=null && ptr2.next!=null) {
            ptr2 = ptr2.next.next;
            if(ptr2!=null) ptr1 = ptr1.next;
        }
        return ptr1;

    }
}





