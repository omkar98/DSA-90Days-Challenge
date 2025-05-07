package DSA.Problem86;

import java.util.LinkedList;
import java.util.Queue;

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


class QueueElement {
    TreeNode node;
    Integer index;
    Integer width;

    public QueueElement(TreeNode node, Integer index, Integer width) {
        this.node = node;
        this.index = index;
        this.width = width;
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
        System.out.print(getMaxWidth(root));
    }

    public static int getMaxWidth(TreeNode root) {
        Queue<QueueElement> queue = new LinkedList<>();
        if(root==null) return -1;

        queue.add(new QueueElement(root,0, 1));
        int width = 1;

        while(!queue.isEmpty()) {
            QueueElement element = queue.remove();
            // under progress
        }

    }
}