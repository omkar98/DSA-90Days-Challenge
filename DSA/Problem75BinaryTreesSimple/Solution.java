package DSA.Problem75BinaryTreesSimple;

import java.util.*;

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

         System.out.print("PreOrder: Recursive: ");preOrder(root);
         System.out.print("\nPreOrder: Iterative: ");preOrderIterative(root);
         System.out.print("\nInOrder: Recursive: ");inOrder(root);
         System.out.print("\nInOrder: Iterative: ");inOrderIterative(root);
         System.out.print("\nPostOrder: Recursive: ");postOrder(root);
         System.out.print("\nPostOrder: Iterative: ");postOrderIterative(root);
         System.out.print("\nLevelOrder: Recursive: ");System.out.println(levelOrder(root));
         System.out.print("\nDepth of Tree ");System.out.println(findMaxDepth(root));


    }
    /* Tree Traversals -->
    1. DFS(DepthFirstSearch) -> 3 types:
        Inorder(LRRi), [Point your finger like ^ for whole tree]
        PreOrder(RLRi), [Point your finger like -> for whole tree]
        PostOrder (LRiR) [Point your finger like <- for whole tree]
    2. BFS (BreadthFirstSearch) [easier] [Also called Level Order Traversal]
    */

    // DFS Type-1 (recursion)
    public static void preOrder(Node<Integer> root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // DFS Type-1 (iterative single stack)
    public static void preOrderIterative(Node<Integer> root) {
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            Node currentElement = stack.pop();
            System.out.print(currentElement.data + " ");
            if(currentElement.right!=null) stack.add(currentElement.right);
            if(currentElement.left!=null) stack.add(currentElement.left);
        }
    }

    // DFS Type-2
    public static void inOrder(Node<Integer> root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    // DFS Type-2 (Iterative single stack)
    public static void inOrderIterative(Node<Integer> root) {
        Stack<Node> stk = new Stack<>();
        if(root==null) return;
        stk.push(root);
        Node currNode = root;
        while(!stk.isEmpty()) {
            if(currNode==null) {
                currNode = stk.pop();
                System.out.print(currNode.data + " ");
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
            if(currNode!=null) stk.push(currNode);
        }
    }

    // DFS Type-3
    public static void postOrder(Node<Integer> root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // DFS Type-3 (Iterative)
    // Best: https://www.youtube.com/watch?v=QhszUQhGGlA
    public static void postOrderIterative(Node<Integer> root) {
        Stack<Node> stack = new Stack<>();
        Stack<Boolean> visit = new Stack<>();
        if(root==null) return;
        stack.push(root);
        visit.push(false);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            Boolean visited = visit.pop();
            if(visited) {
                System.out.print(curr.data + " ");
            } else {
                if(curr!=null) {
                    stack.push(curr);
                    visit.push(true);
                    stack.push(curr.right);
                    visit.push(false);
                    stack.push(curr.left);
                    visit.push(false);
                }
            }
        }
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

    //Depth/Height: find the total "number of nodes" encountered while moving from the root node to the farthest leaf node, along the longest path of the binary tree.
    // 2 ways:
    //    1.  Level Order (O(n))
    //    2.   Recursive Traversal (O(heightOfTree))
    public static int findMaxDepth(Node<Integer> root)
    {
        if(root==null) return 0;
        int leftDepth = findMaxDepth(root.left);
        int rightDepth = findMaxDepth(root.right);
        return 1+Math.max(leftDepth, rightDepth);
    }
}