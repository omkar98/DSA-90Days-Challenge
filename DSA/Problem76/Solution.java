package DSA.Problem76;


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
    static int maxComputed = 0;
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);
        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        int diameter = helperMethod(root);
        return diameter+1;
    }

    public static int helperMethod(BinaryTreeNode<Integer> root) {
        if(root==null) return 0;
        int leftHeight = helperMethod(root.left);
        int rightHeight = helperMethod(root.right);
        maxComputed = Math.max(maxComputed, leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
}