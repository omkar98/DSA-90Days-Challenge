package DSA.Problem86;

import java.util.Arrays;

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

public class Solution {

    public static void main(String[] args) {
        int[] inorder = {4,5,2,6,7,3,1};
        int[] preorder = {10,20,40,50,30,60};
        int[] postorder = {4,2,5 ,1, 6, 3, 7};
//        TreeNode root = buildBinaryTree(inorder, preorder);
        TreeNode root = buildBinaryTreeNew(inorder, postorder);
        System.out.print(root.data);
        //printTree(root);
    }

    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        return buildBinaryTreeAlgo(root, inorder, preorder);
    }

    public static TreeNode buildBinaryTreeNew(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        return buildBinaryTreeAlgoNew(root, inorder, postorder);
    }

    public static TreeNode buildBinaryTreeAlgo(TreeNode root, int[] inorder, int[] preorder) {
        if(inorder.length==0 && preorder.length==0) {
            return null;
        }
        int rootIndex = findIndex(preorder[0],inorder);
        root = new TreeNode(preorder[0]);
        TreeNode leftNode =  buildBinaryTreeAlgo(root, Arrays.copyOfRange(inorder, 0,rootIndex), Arrays.copyOfRange(preorder, 1,rootIndex+1));
        if(leftNode!=null) root.left = leftNode;
        TreeNode rightNode = buildBinaryTreeAlgo(root, Arrays.copyOfRange(inorder, rootIndex+1,inorder.length), Arrays.copyOfRange(preorder, rootIndex+1,preorder.length));
        if(rightNode!=null) root.right = rightNode;
        return root;
    }

    public static int findIndex (int element, int[] array) {
       for(int i=0; i<array.length; i++) {
           if(element==array[i]) return i;
       }
       return -1;
    }

    public static TreeNode buildBinaryTreeAlgoNew(TreeNode root, int[] inorder, int[] postorder) {
        if(inorder.length==0 && postorder.length==0) {
            return null;
        }
        int rootValue = postorder[postorder.length-1];
        int rootIndex = findIndex(rootValue,inorder);
        root = new TreeNode(rootValue);
        TreeNode leftNode =  buildBinaryTreeAlgoNew(root, Arrays.copyOfRange(inorder, 0,rootIndex), Arrays.copyOfRange(postorder, 0,rootIndex));
        if(leftNode!=null) root.left = leftNode;
        TreeNode rightNode = buildBinaryTreeAlgoNew(root, Arrays.copyOfRange(inorder, rootIndex+1,inorder.length), Arrays.copyOfRange(postorder, rootIndex,postorder.length-1));
        if(rightNode!=null) root.right = rightNode;
        return root;
    }
}