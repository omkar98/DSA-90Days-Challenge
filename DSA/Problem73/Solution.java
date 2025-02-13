package DSA.Problem73;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        Queue<Integer>  output = reverseQueue(q);
        System.out.print(output);
//        for(int i=0; i<output.size(); i++) {
//        }
    }
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<Integer>();
        while(!q.isEmpty()) {
            s.push(q.poll());
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
        return q;
    }
}