package DSA.Problem106;

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

    static int currPtr = 0;

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(2);
//        node1.left = new TreeNode(1);
//        node1.right = new TreeNode(3);

//        node1.left.left = new TreeNode(2);
//        node1.left.right = new TreeNode(2);

//        node1.left.left.left = new TreeNode(1);
//        node1.left.left.right = new TreeNode(2);
//        node1.left.left.right.right = new TreeNode(4);

//        node1.left.right.left = new TreeNode(6);
//        node1.left.right.right = new TreeNode(8);

//        node1.right.left = new TreeNode(3);
//        node1.right.right = new TreeNode(5);

        int[] preOrder = new int[]{8,5,1,7,10,12};

        TreeNode preOrderTree = preOrderTree(preOrder);
        System.out.print(preOrderTree);


    }

    public static TreeNode preOrderTree(int[] preOrder) {
        return bstFormation(preOrder, Integer.MAX_VALUE);
    }

    public static TreeNode bstFormation(int[] preOrder, int upperBound) {
        if(currPtr==preOrder.length || preOrder[currPtr]> upperBound) return null;
        TreeNode newNode = new TreeNode(preOrder[currPtr++]);
        newNode.left = bstFormation(preOrder, newNode.data);
        newNode.right = bstFormation(preOrder, upperBound);
        return newNode;
    }

}