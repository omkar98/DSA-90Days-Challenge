package DSA.Problem105;

import java.util.Stack;

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
        TreeNode node1 = new TreeNode(2);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(3);

//        node1.left.left = new TreeNode(2);
//        node1.left.right = new TreeNode(2);

//        node1.left.left.left = new TreeNode(1);
//        node1.left.left.right = new TreeNode(2);
//        node1.left.left.right.right = new TreeNode(4);

//        node1.left.right.left = new TreeNode(6);
//        node1.left.right.right = new TreeNode(8);

//        node1.right.left = new TreeNode(3);
        node1.right.right = new TreeNode(5);


        TreeNode LCAinaBST = LCAinaBST(node1, node1.right, node1.right.right);
        System.out.print(LCAinaBST);


    }

    public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null) {
            // here is the pt where the nodes split.
//            if((root.data>=p.data && root.data<=q.data) || (root.data<=p.data && root.data>=q.data)) return root;

            if(root.data>p.data && root.data>q.data) {
                root = root.left;
            } else if (root.data<p.data && root.data<q.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }



}