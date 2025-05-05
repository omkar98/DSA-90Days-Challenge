package DSA.Problem85;


import java.util.ArrayList;
import java.util.List;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        System.out.print(pathInATree(root, 7));
    }

    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean pathExists = pathInATreeAlgo(root, x, arr);
        return arr;
    }

    public static boolean pathInATreeAlgo(TreeNode root, int x, List<Integer> arr) {
        if(root==null) {
            return false;
        }
        arr.add((int) root.data);
        if((int) root.data == x) {
            return true;
        }
        /* if it exists in the left, then no need of going to the right.
        If it doesnt exist in the left, then go to the right.

         */
        boolean exists = pathInATreeAlgo(root.left, x, arr);
        if(!exists) {
            exists = pathInATreeAlgo(root.right, x, arr);
            if(!exists) {
                arr.remove(arr.size()-1);
            }
        }
        return exists;
    }
}