package DSA.Problem75;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeNode<T> {
    T val;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {
     public static void main(String[] args) {
         BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
         root.right = new BinaryTreeNode<>(2);
         root.right.right = new BinaryTreeNode<>(3);
         root.right.right.right = new BinaryTreeNode<>(4);
         root.right.right.right.right = new BinaryTreeNode<>(5);

         System.out.println(getLevelOrder(root));
    }
    public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
        ArrayList<Integer> finalList = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(root==null) {
            return finalList;
        };
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryTreeNode currentNode = queue.remove();
            finalList.add((int) currentNode.val);
            if(currentNode.left!=null) queue.add(currentNode.left);
            if(currentNode.right!=null) queue.add(currentNode.right);
        }
        return finalList;
    }
}