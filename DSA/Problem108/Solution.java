package DSA.Problem108;

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
    static int[] array;
    static int counter = 0;

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

        int[] totalArray = printNos(5);
        System.out.print(totalArray);


    }

    public static int[] printNos(int x) {
        if (x <= 0) {
            return new int[0];
        }
        int[] a = printNos(x - 1);
        int[] result = new int[a.length + 1];
        System.arraycopy(a, 0, result, 0, a.length);
        result[a.length] = x;
        return result;
    }

}