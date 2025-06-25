package DSA.Problem88;

import java.util.Arrays;
import java.util.List;
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

public class Solution {

    static Stack<TreeNode> stk = new Stack<>();
    static Stack<TreeNode> rightStk = new Stack<>();

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(28);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(42);
        TreeNode n3 = new TreeNode(39);
        TreeNode n4 = new TreeNode(2);
        n2.left = n3;
        n2.right = n4;

        TreeNode n5 = new TreeNode(40);
        TreeNode n6 = new TreeNode(24);
        TreeNode n7 = new TreeNode(17);
        TreeNode n8 = new TreeNode(45);
        TreeNode n9 = new TreeNode(18);
        TreeNode n10 = new TreeNode(23);
        TreeNode n11 = new TreeNode(12);
        TreeNode n12 = new TreeNode(47);
        TreeNode n13 = new TreeNode(7);
        TreeNode n14 = new TreeNode(32);
        n13.right = n14;
        n12.left = n13;
        n11.right = n12;
        n10.left = n11;
        n9.left = n10;
        n7.left = n8;
        n7.right = n9;
        n6.right = n7;

        TreeNode n15 = new TreeNode(41);
        TreeNode n16 = new TreeNode(15);
        TreeNode n17 = new TreeNode(33);
        n16.right = n17;
        TreeNode n18 = new TreeNode(37);
        TreeNode n19 = new TreeNode(43);
        TreeNode n20 = new TreeNode(35);
        TreeNode n21 = new TreeNode(30);
        n20.right = n21;
        n18.left = n19;
        n18.right = n20;
        n15.left = n16;
        n15.right = n18;

        n5.left = n6;
        n5.right = n15;
        n1.left = n2;
        n1.right = n5;
        n0.right = n1;

        TreeNode root = n0;

        System.out.print(traverseBoundary(root));
    }

    public static List<Integer> traverseBoundary(TreeNode root){
        if(root.left!=null)  getLeftNodes(root); else stk.push(root);
        getLeafNodes(root);
        getRightNodes(root);
        int size = rightStk.size();
        TreeNode lastElement = stk.pop();

        /*  check if skew tree: Fo Skew Tree we donot need to again calculate the right nodes!*/
        boolean skew = false;
        if(stk.peek().data == rightStk.peek().data) skew = true;
        stk.push(lastElement);

        if(!skew){
            for(int i=0; i< size-1; i++){
                stk.push(rightStk.pop());
            }
        }

        return stk.stream().map(ele -> Integer.valueOf(ele.data)).toList();
    }

    public static void getLeftNodes(TreeNode root){
        // left nodes without the leaves
        if(root==null || (root.left==null && root.right==null)) return;
        stk.push(root);
        getLeftNodes(root.left!=null ? root.left : root.right);
    }

    public static void getLeafNodes(TreeNode root){
        // leaf nodes only
        if(root==null) return;
        getLeafNodes(root.left);
        if(root.left==null && root.right==null) stk.push(root);
        getLeafNodes(root.right);
    }

    public static void getRightNodes(TreeNode root){
        // right nodes without the leaves
        if(root==null || (root.left==null && root.right==null)) return;
        rightStk.push(root);
        getRightNodes(root.right!=null ? root.right : root.left);
    }


    
}