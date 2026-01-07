package Neetcode.o3_Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int tempSize = temperatures.length;
        int[] output = new int[tempSize];
        Deque<int[]> stk = new ArrayDeque<>();

        for(int i=0; i<tempSize; i++){
            int temp = temperatures[i];
            if(!stk.isEmpty()) {
                int[] top = stk.peek();
                while(top!=null && top[0]<temp) {
                    output[top[1]] = (i-top[1]);
                    stk.pop();
                    top = stk.peek();
                }
            }
            stk.push(new int[]{temperatures[i], i});
        }
        while(!stk.isEmpty()) {
            int[] ele = stk.pop();
            output[ele[1]] = 0;
        }
        Arrays.stream(output).peek(value -> System.out.print(value)).boxed().collect(Collectors.toList());
        return output;
    }
}
