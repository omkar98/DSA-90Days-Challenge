package DSA.Problem94;

class TreeNode<T>
{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
};

public class Solution
{
    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>(0);
        node1.left = new TreeNode<>(1);
        node1.right = new TreeNode<>(2);

        node1.left.left = new TreeNode<>(3);
        node1.left.right = new TreeNode<>(4);

        node1.right.left = new TreeNode<>(5);
        node1.right.right = new TreeNode<>(6);

        node1.left.left.left = new TreeNode<>(7);
        node1.left.left.right = new TreeNode<>(8);

        node1.left.right.left = new TreeNode<>(9);
        node1.left.right.right = new TreeNode<>(10);

        System.out.print(countNodes(node1));
    }
    
    public static int countNodes(TreeNode<Integer> root) {
        if(root==null) return 0;
        int left = heightOfBT(root.left, true);
        int right = heightOfBT(root.right, false);
        if(left==right) {
            int total = 1+((int)Math.pow(2,left)-1)+((int)Math.pow(2,right)-1);
            return total;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int heightOfBT(TreeNode<Integer> root, boolean left) {
        if(root==null) return 0;
        int height = heightOfBT(left?root.left:root.right, left);
        return 1+height;
    }
}