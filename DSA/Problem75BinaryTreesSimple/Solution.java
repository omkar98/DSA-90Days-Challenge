package DSA.Problem75BinaryTreesSimple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    Node(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}


public class Solution {
     public static void main(String[] args) {
         Node<Integer> root = new Node<>(1);
         root.left = new Node<>(2);
         root.right = new Node<>(3);
         root.left.left = new Node<>(4);
         root.left.right = new Node<>(5);
         root.right.left = new Node<>(6);
         root.right.right = new Node<>(7);

         preOrder(root); System.out.println();
         inOrder(root); System.out.println();
         postOrder(root);System.out.println();
         System.out.println(levelOrder(root));
    }
    /* Tree Traversals -->
    1. DFS(DepthFirstSearch) -> 3 types:
        Inorder(LRRi), [Point your finger like ^ for whole tree]
        PreOrder(RLRi), [Point your finger like -> for whole tree]
        PostOrder (LRiR) [Point your finger like <- for whole tree]
    2. BFS (BreadthFirstSearch) [easier] [Also called Level Order Traversal]
    */

    // DFS Type-1
    public static void preOrder(Node<Integer> root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // DFS Type-2
    public static void inOrder(Node<Integer> root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // DFS Type-3
    public static void postOrder(Node<Integer> root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //BFS: Level-Order Traversal
    public static List<Integer> levelOrder(Node<Integer> root) {
        List<Integer> finalList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root==null) {
            finalList.add(root.data);
            return finalList;
        };
        queue.add(root);
        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            finalList.add((int) currentNode.data);
            if(currentNode.left!=null) queue.add(currentNode.left);
            if(currentNode.right!=null) queue.add(currentNode.right);
        }
        return finalList;
    }
}