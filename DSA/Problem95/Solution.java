package DSA.Problem95;


import java.util.LinkedList;
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

//        node1.left.left = new TreeNode<>(4);
//        node1.left.right = new TreeNode<>(4);

        node1.right.left = new TreeNode(4);
        node1.right.right = new TreeNode(5);

//        node1.left.left.left = new TreeNode<>(7);
//        node1.left.left.right = new TreeNode<>(8);

//        node1.left.right.left = new TreeNode<>(9);
//        node1.left.right.right = new TreeNode<>(10);

        String serialisedString = serializeTree(node1);
        System.out.println(serialisedString);
        TreeNode root = deserializeTree(serialisedString);
        System.out.println(serializeTree(root));
    }

    public static String serializeTree(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode element = queue.remove();
            if(element!=null) str.append(element.data).append(SPACE); else str.append(NULL_MARKER).append(SPACE);
            if(element!=null) queue.add(element.left);
            if(element!=null) queue.add(element.right);
        }
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    public static TreeNode deserializeTree(String serialized) {
        String[] newString = serialized.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(newString[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        for(int i=1; i<newString.length; i++) {
            TreeNode currentNode = queue.remove();
            if(!newString[i].equals(NULL_MARKER)) {
                TreeNode node = new TreeNode(Integer.valueOf(newString[i]));
                queue.add(node);
                currentNode.left = node;
            }
            i++;
            if(!newString[i].equals(NULL_MARKER)) {
                TreeNode node = new TreeNode(Integer.valueOf(newString[i]));
                queue.add(node);
                currentNode.right = node;
            }
        }
        return root;
    }
}