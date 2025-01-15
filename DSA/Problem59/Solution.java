package DSA.Problem59;

public class Solution {
    public static void main(String[] args) {
        LinkedListNode headA = new LinkedListNode(9);
        headA.next = new LinkedListNode(9);
        headA.next.next = new LinkedListNode(9);
        headA.next.next.next = new LinkedListNode(9);

        LinkedListNode headB = new LinkedListNode(9);
        headB.next = new LinkedListNode(9);
//        headB.next.next = new LinkedListNode(6);

        // Print the linked lists to verify
//        printLinkedList(headA);
//        printLinkedList(headB);
        printLinkedList(addTwoNumbers(headA, headB));
    }

    public static void printLinkedList(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode finalResultHead = new LinkedListNode(0);
        LinkedListNode temp1 = head1;
        LinkedListNode temp2 = head2;
        LinkedListNode finalTemp = finalResultHead;
        int carry = 0;
        while(temp1!=null && temp2!=null) {
            int data = temp1.data + temp2.data + carry;
            int value = data%10;
            finalTemp.next = new LinkedListNode(value);
            carry = data/10;
            finalTemp = finalTemp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1!=null) {
            int data = temp1.data+carry;
            int value = data%10;
            finalTemp.next = new LinkedListNode(value);
            carry = data/10;
            finalTemp = finalTemp.next;
            temp1 = temp1.next;
        }
        while(temp2!=null) {
            int data = temp2.data+carry;
            int value = data%10;
            finalTemp.next = new LinkedListNode(value);
            carry = data/10;
            finalTemp = finalTemp.next;
            temp2 = temp2.next;
        }

        if(carry>0) {
            finalTemp.next = new LinkedListNode(carry);
        }

        return finalResultHead.next;
    }
}





