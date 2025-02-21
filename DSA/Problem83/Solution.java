package DSA.Problem83;


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
        System.out.print(getRightView(root));
    }

    public static ArrayList<Integer> getRightView(TreeNode<Integer> root) {
        ArrayList<Integer> output = new ArrayList<>();
        if(root==null) return output;
        getLevelWiseRightNodes(root,0, output);
        return output;
    }

    public static void getLevelWiseRightNodes(TreeNode<Integer> root, int level, ArrayList<Integer> output) {
        if(root==null) return;
        if(output.size()==level) output.add(root.data);
        getLevelWiseRightNodes(root.right, level+1, output);
        getLevelWiseRightNodes(root.left, level+1, output);
    }
}