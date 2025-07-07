package DSA.Problem97;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public static String NULL_MARKER = "-1";
    public static String SPACE = " " ;
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
        List<Integer> result = getInOrderTraversal(node1);
        System.out.print(result);


    }

    public static List<Integer> getInOrderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null) {
            if(curr.left == null) {
                result.add(curr.data);
                curr = curr.right;
            } else {
                TreeNode rightMost = curr.left;
                while(rightMost.right!=null && rightMost.right != curr) {
                    rightMost = rightMost.right;
                }
                if(rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                } else {
                    rightMost.right = null;
                    result.add(curr.data);
                    curr = curr.right;
                }

            }
        }
        return result;
    }

}