package DSA.Problem84;


import java.util.ArrayList;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        System.out.print(lowestCommonAncestor(root, 4,5));
    }

    public static int lowestCommonAncestor(TreeNode root, int x, int y) {
        TreeNode lcaNode = findLCA(root, x, y);
        return (lcaNode != null) ? (int) lcaNode.data : -1;
    }

    private static TreeNode findLCA(TreeNode root, int x, int y) {
        if (root == null) return null;
        if ((int) root.data == x || (int) root.data == y) return root;

        TreeNode left = findLCA(root.left, x, y);
        TreeNode right = findLCA(root.right, x, y);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}