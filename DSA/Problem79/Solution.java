package DSA.Problem79;


import java.util.*;
import java.util.stream.Stream;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {
    static int maxComputed = 0;
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);
        System.out.print(zigZagTraversal(root));
    }
    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> output = new ArrayList<>(); // 1
        if(root==null) return output;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>(); //  2 3
        queue.add(root); // 1
        boolean flag = true;
        while(!queue.isEmpty()) {
            List<BinaryTreeNode<Integer>> tempList = new ArrayList<>();
            while(!queue.isEmpty()) {
                tempList.add(queue.remove());
            }
            List<Integer> currInteger = new ArrayList<>();
            while(!tempList.isEmpty()) {
                BinaryTreeNode<Integer> node = tempList.iterator().next();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                currInteger.add(node.data);
                tempList.remove(node);
            }
            if(flag) {
                output.addAll(currInteger);
            } else {
                Collections.reverse(currInteger);
                output.addAll(currInteger);
            }
            flag = !flag;
        }
        return output;
    }
}