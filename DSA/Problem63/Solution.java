package DSA.Problem63;

public class Solution {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(5);
        Node<Integer> current = head;
        int[] elements = {4,3,7,9};
        for (int element : elements) {
            current.next = new Node<>(element);
            current = current.next;
        }

        // Print the linked list to verify
        printLinkedList(head);
        printLinkedList(addNodes(head, 4, 3));
    }

    public static void printLinkedList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node<Integer> addNodes(Node<Integer> head, int n, int m) {
        Node<Integer> ptr = head;
        int count = 0;
        while(ptr!=null) {
            count++;
            if(count==m) {
                Node<Integer>  nPtr = ptr.next;
                Node<Integer>  nPrevPtr = null;
                int countN = 0;
                int sum = 0;
                while(countN<n && nPtr!=null) {
                    sum+=nPtr.data;
                    countN++;
                    nPrevPtr = nPtr;
                    nPtr = nPtr.next;
                }
                Node<Integer> newNode = new Node<>(sum);
                newNode.next = nPtr;
                nPrevPtr.next = newNode;
                count = 0;
                ptr = newNode;
            }
            ptr = ptr!=null ? ptr.next : ptr;
        }
        return head;
    }
}