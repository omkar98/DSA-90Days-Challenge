package DSA.Rapid7DSAPractice.Practice7.ReverseLL;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    private static ListNode newHeadLL = null;
    public static  void main (String args[]) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, null);
        ListNode newHead = reverseListRecursive(node1);
        System.out.print(newHead);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode curr = head;
        ListNode prev = null;
//        boolean start = true;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
//            if(start) {  // unnecessary loop. You can directly start with prev = null.
//                prev.next =null;
//                start = false;
//            }
            prev = curr;
            curr = nextNode;
        }
        head = prev;
        return head;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if(head==null || head.next==null) {
            newHeadLL = head;
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        newHead.next = head;
        head.next = null;
        return head;
    }
}


