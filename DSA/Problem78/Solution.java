package DSA.Problem78;


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
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(1);
        root1.left = new BinaryTreeNode<>(9);
        root1.right = new BinaryTreeNode<>(3);
        root1.left.left = new BinaryTreeNode<>(4);
        root1.left.right = new BinaryTreeNode<>(5);
        root1.right.left = new BinaryTreeNode<>(6);
        root1.right.right = new BinaryTreeNode<>(7);
        System.out.println(identicalTrees(root, root1));
    }
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        // PreOrder Traversal -> Root|Left|Right
        if(root1==null || root2==null) return root1==root2;
        boolean left =  identicalTrees(root1.left, root2.left);
        boolean right = identicalTrees(root1.right, root2.right);
        return (root1.val==root2.val) && left && right;
    }
}