package DSA.Problem103;

import java.util.ArrayList;
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
        TreeNode node1 = new TreeNode(5);
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(7);

        node1.left.left = new TreeNode(1);
        node1.left.right = new TreeNode(4);

//        node1.left.left.left = new TreeNode(1);
        node1.left.left.right = new TreeNode(2);
//        node1.left.left.right.right = new TreeNode(4);

//        node1.left.right.left = new TreeNode(6);
//        node1.left.right.right = new TreeNode(8);

        node1.right.left = new TreeNode(6);
        node1.right.right = new TreeNode(8);


        int kthSmallElement = kthSmallest(node1, 3);
        System.out.print(kthSmallElement);


    }

    //can also be solved using morris traversal

    public static int kthSmallest(TreeNode root, int k) {
        // iterative inorder traversal
        int count = 0;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        TreeNode node = root;
        while(!stk.isEmpty()) {
            if(node!=null) {
                stk.push(node);
                node = node.left;
            }
            else {
                node = stk.pop();
                count++;
                if(count==k) return node.data;
//                list.add(node.data);
                node = node.right;
            }
        }
        return -1;
    }
}