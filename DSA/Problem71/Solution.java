package DSA.Problem71;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {3,9,2,7,7};
        int[] output = nextGreater(arr, arr.length);
        for(int i=0; i<arr.length; i++) {
            System.out.print(output[i] + " ");
        }

    }

    public static int[] nextGreater(int[] arr, int n) {
        ArrayList<Integer> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=n-1; i>=0; i--) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
                output.add(-1);
            }
            else {
               if(arr[i]<stack.peek()) {
                   output.add(stack.peek());
                   stack.push(arr[i]);
               } else {
                   while(!stack.isEmpty() && arr[i]>=stack.peek()) {
                       stack.pop();
                   }
                   if(stack.isEmpty()) {
                       stack.push(arr[i]);
                       output.add(-1);
                   } else {
                       output.add(stack.peek());
                       stack.push(arr[i]);
                   }
               }
            }
        }
        Collections.reverse(output);
        return  output.stream().mapToInt(i-> i).toArray();
    }
}