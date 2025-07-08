package DSA.Problem100;

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
        TreeNode node1 = new TreeNode(10);
        node1.left = new TreeNode(5);
        node1.right = new TreeNode(13);

        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(6);

        node1.right.left = new TreeNode(11);
        node1.right.right = new TreeNode(14);

        node1.left.left.left = new TreeNode<>(2);
        node1.left.left.right = new TreeNode<>(4);

//        node1.left.right.left = new TreeNode<>(9);
        node1.left.right.right = new TreeNode(9);

        int result = findCeil(node1, 8);
        System.out.print(result);


    }

    public  static int findCeil(TreeNode<Integer> node, int x) {
        int ceil = -1;
        while(node!=null) {
            if(node.data==x) return x;
            if(x>node.data) node = node.right;
            else {
                ceil = node.data;
                node = node.left;
            }
        }
        return ceil;
    }


}