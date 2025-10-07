package DSA.Rapid7DSAPractice.Practice8.LC141_LLCycle;


class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}


public class Solution {
    private static ListNode newHeadLL = null;
    public static  void main (String args[]) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node4 = new ListNode(4, node2);
        boolean newHead = hasCycle(node1);
        System.out.print(newHead);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head==null || head.next==null) return false;
        do{
            fast = fast.next!=null && fast.next.next!=null ? fast.next.next : null;
            slow = slow.next;
            if(fast==null || slow == null) return false;
        } while(fast!=slow);
        return true;
    }

}


