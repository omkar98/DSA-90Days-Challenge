package DSA.Problem87;

import java.util.Arrays;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }
    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        System.out.print(isBalancedBT(root));

    }

    public static boolean isBalancedBT(TreeNode<Integer> root) {
        int value = heightBT(root);
        return value > -1;
    }

    public static int heightBT(TreeNode<Integer> root) {
        if(root==null) return 0;
        int leftHeight = heightBT(root.left);
        if(leftHeight==-1) return -1;
        int rightHeight = heightBT(root.right);
        if(rightHeight==-1) return -1;
        // Balanced BT: !abs(leftHeight - rightHeight) > 1;
        if(Math.abs(leftHeight-rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight)+1;
    }

}