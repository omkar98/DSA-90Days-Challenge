package DSA.Problem72;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4,2,3,3,7));
        ArrayList<Integer> output = findSpans(arr);
        for(int i=0; i<arr.size(); i++) {
            System.out.print(output.get(i) + " ");
        }
    }
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        ArrayList<Integer> output = new ArrayList<>();
        Stack<Map<Integer, Integer>> stk = new Stack<Map<Integer, Integer>>();
        for(int i=0; i<price.size(); i++) {
            while(!stk.isEmpty() && stk.peek().entrySet().iterator().next().getKey()<=price.get(i)) {
                stk.pop();
            }
            int index = stk.isEmpty() ? -1 : stk.peek().entrySet().iterator().next().getValue();
            output.add(i-index);
            stk.push(Map.of(price.get(i), i));
        }
        return output;
    }
}