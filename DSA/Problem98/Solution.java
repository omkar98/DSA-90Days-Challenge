package DSA.Problem98;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

public class Solution
{
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(5);

//        node1.right.left = new TreeNode(4);
//        node1.right.right = new TreeNode(5);

//        node1.left.left.left = new TreeNode<>(7);
//        node1.left.left.right = new TreeNode<>(8);

//        node1.left.right.left = new TreeNode<>(9);
        node1.left.right.right = new TreeNode(6);
        TreeNode result = flattenBinaryTree(node1);
        System.out.print(result);


    }

    public static TreeNode flattenBinaryTree(TreeNode root) {
        TreeNode curr = root;
        while(curr!=null) {
            if(curr.left!=null) {
                TreeNode rightNode = curr.left;
                while(rightNode.right!=null) {
                    rightNode = rightNode.right;
                }
                rightNode.right = curr.right;
                curr.right = curr.left;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return root;
    }


}