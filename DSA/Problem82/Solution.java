package DSA.Problem82;


import java.util.*;

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
    TreeNode<Integer> node;
    Integer x;

    public QueueElement(TreeNode<Integer> node, Integer x) {
        this.node = node;
        this.x = x;
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
        System.out.print(getTopView(root));
    }

    public static List<Integer> getTopView(TreeNode<Integer> root)
    {
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<QueueElement> outputElements = new ArrayList<>();
        if(root==null) return output;
        Queue<QueueElement> queue = new LinkedList<>();
        QueueElement element = new QueueElement(root, 0);
        queue.add(element);
        while(!queue.isEmpty()) {
            element = queue.remove();
            outputElements.add(element);
            TreeNode<Integer> left = element.node.left;
            TreeNode<Integer> right = element.node.right;
            if(left!=null) queue.add(new QueueElement(left, element.x-1));
            if(right!=null) queue.add(new QueueElement(right, element.x+1));
        }
        TreeMap<Integer,Integer> mpp = new TreeMap<>();
        for(int i = 0; i<outputElements.size(); i++) {
            Integer key = outputElements.get(i).x;
            Integer value = outputElements.get(i).node.data;
            if(!mpp.containsKey(key)) {
                mpp.put(key, value);
            }
        }
        output.addAll(mpp.values());
        return output;
    }
}