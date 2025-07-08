package DSA.Problem98;



class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

public class Solution
{
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        node1.left = new BinaryTreeNode(5);
        node1.right = new BinaryTreeNode(12);

        node1.left.left = new BinaryTreeNode(4);
        node1.left.right = new BinaryTreeNode(7);

        node1.right.left = new BinaryTreeNode(10);
        node1.right.right = new BinaryTreeNode(14);

//        node1.left.left.left = new BinaryTreeNode<>(7);
//        node1.left.left.right = new BinaryTreeNode<>(8);

//        node1.left.right.left = new BinaryTreeNode<>(9);
//        node1.left.right.right = new BinaryTreeNode(6);

        boolean result = searchInBST(node1, 11);
        System.out.print(result);


    }

    public static boolean searchInBST(BinaryTreeNode root, int x) {
        while(root!=null && root.data!=x) {
            root = root.data<x ? root.right : root.left;
        }
        return root!=null && root.data==x;
    }


}