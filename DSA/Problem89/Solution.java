package DSA.Problem89;


class BinaryTreeNode < Integer > {
    int data;
    BinaryTreeNode <Integer> left;
    BinaryTreeNode <Integer> right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

public class Solution {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(2);
        root.left = new BinaryTreeNode(35);
        root.right = new BinaryTreeNode(10);

        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(3);

        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(2);

        changeTree(root);

    }

    public static void changeTree(BinaryTreeNode <Integer> root) {
        childrenSumProperty(root);
    }

    public static void childrenSumProperty(BinaryTreeNode<Integer> root) {
        if(root==null) return;
        Integer max = findMax(root);
        makeAllNodesMax(root, max);
        childrenSumProperty(root.right);
        childrenSumProperty(root.left);
        updateRootNode(root);
    }

    public static Integer findMax(BinaryTreeNode<Integer> root) {
        Integer max = root.data;
        if(root.left!=null) max = Math.max(max,root.left.data);
        if(root.right!=null) max = Math.max(max,root.right.data);
        return max;
    }

    public static void makeAllNodesMax(BinaryTreeNode<Integer> root, Integer max) {
        root.data = max;
        if(root.left!=null) root.left.data = max;
        if(root.right!=null) root.right.data = max;
    }

    public static void updateRootNode(BinaryTreeNode<Integer> root) {
        int value = 0;
        if(root.left!=null) value += root.left.data;
        if(root.right!=null) value += root.right.data;
        root.data = Math.max(root.data, value);
    }


}