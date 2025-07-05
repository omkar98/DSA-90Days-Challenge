package DSA.Problem93;


import java.util.List;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

class ParentBinaryTreeNode<T> {
    T data;
    ParentBinaryTreeNode<T> left;
    ParentBinaryTreeNode<T> right;
    ParentBinaryTreeNode<T> parent;

    public ParentBinaryTreeNode(T data) {
        this.data = data;
    }
    public ParentBinaryTreeNode(T data, ParentBinaryTreeNode<T> left, ParentBinaryTreeNode<T> right, ParentBinaryTreeNode<T> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

public class Solution {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(3);
        node1.left = new BinaryTreeNode<>(5);
        node1.right = new BinaryTreeNode<>(1);

        node1.left.left = new BinaryTreeNode<>(6);
        node1.left.right = new BinaryTreeNode<>(2);

        node1.right.left = new BinaryTreeNode<>(0);
        node1.right.right = new BinaryTreeNode<>(8);

        node1.left.right.left = new BinaryTreeNode<>(7);
        node1.left.right.right = new BinaryTreeNode<>(4);

        System.out.print(printNodesAtDistanceK(node1,node1.left,2));
    }

    public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int K) {
        ParentBinaryTreeNode newRoot = recreateUsingParentNodes(root);
        return null;
    }

    public static ParentBinaryTreeNode recreateUsingParentNodes(BinaryTreeNode<Integer> root) {
        return convert(root, null);
    }
    public static ParentBinaryTreeNode convert(BinaryTreeNode<Integer> oldRoot, ParentBinaryTreeNode<Integer> parent) {
        if(oldRoot == null) return null;
        ParentBinaryTreeNode<Integer> newNode = new ParentBinaryTreeNode<>(oldRoot.data);
        newNode.parent = parent;                         // set back‑pointer
        newNode.left  = convert(oldRoot.left,  newNode); // recurse left
        newNode.right = convert(oldRoot.right, newNode); // recurse right
        return newNode;
    }


}