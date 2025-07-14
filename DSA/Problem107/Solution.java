package DSA.Problem107;

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
    static List<Integer> inorderList = new ArrayList<>();
    static TreeNode predecessor = null;
    static TreeNode successor = null;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6521171);
        node1.left = new TreeNode(5650934);
        node1.right = new TreeNode(9278816);

        node1.left.left = new TreeNode(899375);
//        node1.left.right = new TreeNode(12);

//        node1.left.left.left = new TreeNode(1);
//        node1.left.left.right = new TreeNode(2);
//        node1.left.left.right.right = new TreeNode(4);

//        node1.left.right.left = new TreeNode(6);
//        node1.left.right.right = new TreeNode(8);

        node1.right.left = new TreeNode(8989449);
//        node1.right.right = new TreeNode(25);

//        int[] preOrder = new int[]{8,5,1,7,10,12};

        List<Integer> preOrderTree = predecessorSuccessor(node1,9615950);
        System.out.print(preOrderTree);


    }

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        predecessor = null;
        successor = null;
        TreeNode current = root;
        List<Integer> output = new ArrayList<>();

        while (current != null) {
            if (current.data == key) {
                // Find predecessor (max in left subtree)
                if (current.left != null) {
                    TreeNode temp = current.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp;
                }

                // Find successor (min in right subtree)
                if (current.right != null) {
                    TreeNode temp = current.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp;
                }
                break;
            } else if (key < current.data) {
                successor = current;
                current = current.left;
            } else {
                predecessor = current;
                current = current.right;
            }
        }
        output.add(predecessor!=null ? predecessor.data: -1);
        output.add(successor!=null ? successor.data: -1);
        return output;

    }
}