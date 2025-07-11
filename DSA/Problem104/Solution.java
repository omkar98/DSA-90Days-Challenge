package DSA.Problem104;

import java.util.Stack;

class BinaryTreeNode<Integer> {
    int data;
    BinaryTreeNode<Integer> left;
    BinaryTreeNode<Integer> right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

public class Solution
{

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(3);
        node1.left = new BinaryTreeNode(1);
        node1.right = new BinaryTreeNode(5);

//        node1.left.left = new BinaryTreeNode(2);
        node1.left.right = new BinaryTreeNode(2);

//        node1.left.left.left = new BinaryTreeNode(1);
//        node1.left.left.right = new BinaryTreeNode(2);
//        node1.left.left.right.right = new BinaryTreeNode(4);

//        node1.left.right.left = new BinaryTreeNode(6);
//        node1.left.right.right = new BinaryTreeNode(8);

//        node1.right.left = new BinaryTreeNode(4);
//        node1.right.right = new BinaryTreeNode(8);


        boolean validateBST = validateBST(node1);
        System.out.print(validateBST);


    }

    //can also be solved using morris traversal

    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        if(root==null) return true;
        BinaryTreeNode<Integer> node = root;
        Stack<BinaryTreeNode> stk = new Stack();
        Integer recentLargeElement = null;
//        stk.push(node);
        while(!stk.isEmpty() || node!=null) {
            if(node!=null){
                stk.push(node);
                node=node.left;
            } else {
                BinaryTreeNode newNode = stk.pop();
                if(recentLargeElement==null || newNode.data>=recentLargeElement) recentLargeElement = newNode.data;
                else return false;
                node = newNode.right;
            }
        }
        return true;
    }
}