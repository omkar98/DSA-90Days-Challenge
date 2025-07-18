package DSA.Problem112;

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
    static Stack<TreeNode> stkAsc = new Stack();
    static Stack<TreeNode> stkDesc = new Stack();
    public static void main(String[] arr){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode<>(3);
        root.right = new TreeNode<>(6);
//        root.right.left = new TreeNode<>(2);
//        root.right.left.left = new TreeNode<>(8);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
//        root.left.right.left = new TreeNode(5);
//        root.left.right.left.left= new TreeNode(4);
//        root.left.left.left = new TreeNode<>(1);
//        BSTIteratorASC iterator = new BSTIteratorASC(root);
//        while(iterator.hasNext())
//        {
//            System.out.println(iterator.next()+" ");
//        }
        System.out.print(pairSumBst(root, 14));

    }

    static class BSTIteratorASC{

        BSTIteratorASC(TreeNode<Integer> root){
            if(root!=null){
                stkAsc.push(root);
                while(root.left!=null) {
                    stkAsc.push(root.left);
                    root = root.left;
                }
            }
        }

        int next(){
            TreeNode element = null;
            if(hasNext()){
                element = stkAsc.pop();
                if(element.right!=null){
                    new BSTIteratorASC(element.right);
                }
                return (int)element.data;
            } else {
                return -1;
            }
        }

        boolean hasNext(){
            return !stkAsc.isEmpty();
        }
    }

    static class BSTIteratorDESC{

        BSTIteratorDESC(TreeNode<Integer> root){
            if(root!=null){
                stkDesc.push(root);
                while(root.right!=null) {
                    stkDesc.push(root.right);
                    root = root.right;
                }
            }
        }

        int before(){
            TreeNode element = null;
            if(hasBefore()){
                element = stkDesc.pop();
                if(element.left!=null){
                    new BSTIteratorDESC(element.left);
                }
                return (int)element.data;
            } else {
                return -1;
            }
        }

        boolean hasBefore(){
            return !stkDesc.isEmpty();
        }
    }

    public static boolean pairSumBst(TreeNode root, int k) {
        BSTIteratorASC p1 = new BSTIteratorASC(root);
        BSTIteratorDESC p2 = new BSTIteratorDESC(root);
        int val = -1;
        int p1Val = p1.next();
        int p2Val = p2.before();
        while(val!=k && p1Val<p2Val) {
            val = p1Val+p2Val;
           if(val>k) {
               p2Val =  p2.before();
           } else {
               p1Val = p1.next();
           }
        }
        return val==k;

    }

}