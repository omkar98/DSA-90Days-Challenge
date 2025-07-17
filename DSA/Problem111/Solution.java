package DSA.Problem111;

import java.util.Stack;

class TreeNode<T>
{
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Solution
{
    static Stack<TreeNode> stk = new Stack();
    public static void main(String[] arr){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode<>(3);
        root.right = new TreeNode<>(10);
        root.right.left = new TreeNode<>(9);
        root.right.left.left = new TreeNode<>(8);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.left.right.left.left= new TreeNode(4);
        root.left.left.left = new TreeNode<>(1);
        BSTIterator iterator = new BSTIterator(root);
        while(iterator.hasNext())
        {
            System.out.println(iterator.next()+" ");
        }

    }

    static class BSTIterator{

        BSTIterator(TreeNode<Integer> root){
            if(root!=null){
                stk.push(root);
                while(root.left!=null) {
                    stk.push(root.left);
                    root = root.left;
                }
            }
        }

        int next(){
            TreeNode element = null;
            if(hasNext()){
                element = stk.pop();
                if(element.right!=null){
                    new BSTIterator(element.right);
                }
                return (int)element.data;
            } else {
                return -1;
            }
        }

        boolean hasNext(){
            return !stk.isEmpty();
        }
    }


}