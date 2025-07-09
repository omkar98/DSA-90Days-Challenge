package DSA.Problem101;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
};

public class Solution
{

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(7);

        node1.left.left = new TreeNode(1);
        node1.left.right = new TreeNode(3);

//        node1.right.left = new TreeNode(11);
//        node1.right.right = new TreeNode(14);

//        node1.left.left.left = new TreeNode(2);
//        node1.left.left.right = new TreeNode(4);

//        node1.left.right.left = new TreeNode<>(9);
//        node1.left.right.right = new TreeNode(9);

        TreeNode rootNode = insertionInBST(node1, 5);
        System.out.print(rootNode);


    }

    public static TreeNode insertionInBST(TreeNode root, int val) {
        TreeNode origRoot = root;
        while(root!=null) {
            if(root.val<=val) {
                if(root.right==null) {
                    root.right = new TreeNode(val);
                    break;
                }
                root = root.right;
            } else {
                if(root.left==null) {
                    root.left = new TreeNode(val);
                    break;
                }
                root = root.left;
            }
        }
        return origRoot;
    }


}