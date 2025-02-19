package DSA.Problem77;


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
        System.out.println(maxPathSum(root));
    }
    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        helperMethod(root);
        return maxComputed;
    }

    public static int helperMethod(BinaryTreeNode<Integer> root) {
        if(root==null) return 0;
        int leftValue = helperMethod(root.left);
        int rightValue = helperMethod(root.right);
        int maxValue = Math.max(leftValue, rightValue);
        int currMaxValue = root.val + Math.max(maxValue, leftValue+rightValue);
        if(maxComputed<currMaxValue) maxComputed = currMaxValue;
        return root.val + maxValue;
    }
}