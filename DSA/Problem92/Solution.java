package DSA.Problem92;


import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class Solution {

    public static Map<BinaryTreeNode,BinaryTreeNode> parentPointersMap = new HashMap<>();
    public static int timeTaken = 0;

    public static void main(String[] args) {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        node1.left = new BinaryTreeNode<>(2);
        node1.right = new BinaryTreeNode<>(3);

        node1.left.left = new BinaryTreeNode<>(4);

        node1.right.left = new BinaryTreeNode<>(5);
        node1.right.right = new BinaryTreeNode<>(6);

        node1.left.left.left = new BinaryTreeNode<>(7);

        System.out.print(timeToBurnTree(node1,2));
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        BinaryTreeNode<Integer> newRoot = mapParentPointers(root, start);
        calculateTimeTaken(newRoot);
        return timeTaken-1;
    }

    public static void calculateTimeTaken(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Map<BinaryTreeNode, Boolean> visited = new HashMap();
        queue.add(root);
        visited.put(root, true);
        while(!queue.isEmpty()) {
            List<BinaryTreeNode> allElements = new ArrayList<>();
            while(!queue.isEmpty()) allElements.add(queue.remove());
            for(int i=0; i<allElements.size(); i++) {
                if(allElements.get(i).left!=null) {
                    if(!visited.getOrDefault(allElements.get(i).left, false)) {
                        queue.add(allElements.get(i).left);
                        visited.put(allElements.get(i).left, true);
                    }
                }
                if(allElements.get(i).right!=null) {
                    if(!visited.getOrDefault(allElements.get(i).right, false)) {
                        queue.add(allElements.get(i).right);
                        visited.put(allElements.get(i).right, true);
                    }
                }
                if(parentPointersMap.get(allElements.get(i))!=null) {
                    if(!visited.getOrDefault(parentPointersMap.get(allElements.get(i)), false)) {
                        queue.add(parentPointersMap.get(allElements.get(i)));
                        visited.put(parentPointersMap.get(allElements.get(i)), true);
                    }
                }
            }
            timeTaken+=1;
        }
    }

    public static BinaryTreeNode<Integer> mapParentPointers(BinaryTreeNode<Integer> root, int start) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode newRoot = root;
        while(!queue.isEmpty()) {
            BinaryTreeNode element = queue.remove();
            if(element.data.equals(start))  newRoot = element;
            if(element.left!=null) {
                parentPointersMap.put(element.left, element);
                queue.add(element.left);
            }
            if(element.right!=null) {
                parentPointersMap.put(element.right, element);
                queue.add(element.right);
            }
        }
        return newRoot;
    }
}