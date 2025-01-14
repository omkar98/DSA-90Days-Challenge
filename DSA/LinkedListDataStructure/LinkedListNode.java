package DSA.LinkedListDataStructure;

public class LinkedListNode<T>
{
    T data;
    public LinkedListNode<T> next;
    public LinkedListNode(T data)
    {
        this.data = data;
    }

    public static void travelLinkedList(LinkedListNode head) {
        // traverse the linked list if head is given
        LinkedListNode<Integer> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}





