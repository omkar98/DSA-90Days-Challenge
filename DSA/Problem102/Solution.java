package DSA.Problem102;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    BinaryTreeNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }
    BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

public class Solution
{

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        node1.left = new BinaryTreeNode(5);
        node1.right = new BinaryTreeNode(12);

        node1.left.left = new BinaryTreeNode(2);
        node1.left.right = new BinaryTreeNode(7);

        node1.left.left.left = new BinaryTreeNode(1);
        node1.left.left.right = new BinaryTreeNode(3);
        node1.left.left.right.right = new BinaryTreeNode(4);

        node1.left.right.left = new BinaryTreeNode<>(6);
        node1.left.right.right = new BinaryTreeNode(8);

        node1.right.left = new BinaryTreeNode(10);
        node1.right.right = new BinaryTreeNode(13);


        BinaryTreeNode rootNode = deleteNode(node1, 5);
        System.out.print(rootNode);


    }

    public static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to be deleted found
            if (root.left == null && root.right == null) {
                // Case 1: No children
                return null;
            } else if (root.left == null) {
                // Case 2: One child (right)
                return root.right;
            } else if (root.right == null) {
                // Case 2: One child (left)
                return root.left;
            } else {
                // Case 3: Two children
                BinaryTreeNode<Integer> successor = findMin(root.right);
                root.data = successor.data;
                root.right = deleteNode(root.right, successor.data);
            }
        }
        return root;
    }

    private static BinaryTreeNode<Integer> findMin(BinaryTreeNode<Integer> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}