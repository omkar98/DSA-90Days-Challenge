package DSA.Problem90;


class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class Solution {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        node1.left = new BinaryTreeNode<>(2);
        node1.right = new BinaryTreeNode<>(2);

        node1.left.left = new BinaryTreeNode<>(3);
        node1.left.right = new BinaryTreeNode<>(4);

        node1.right.left = new BinaryTreeNode<>(4);
        node1.right.right = new BinaryTreeNode<>(4);

        System.out.print(isSymmetric(node1));
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        boolean result = (root!=null) ? areNodesEqual(root.left, root.right) : true;
        return result;
    }

    public static boolean areNodesEqual(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
        if((left!=null && right==null) || (right!=null && left==null)) return false;
        if(left!=null && right!=null && !left.data.equals(right.data)) return false;
        if(left==null && right==null) return true;
        boolean result = areNodesEqual(left.left, right.right);
        if(result) result = areNodesEqual(left.right, right.left);
        return result;
    }
}