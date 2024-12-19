package Problem37;

import java.util.ArrayList;
import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,0,4,1,3,0,28));
        pushZerosAtEnd(arr);
        System.out.println(arr);
    }

    public static void pushZerosAtEnd(ArrayList<Integer> arr) {
        int rightPtr = 0;
        for(int i=0; i< arr.size(); i++) {
            if(arr.get(i)!=0) {
                swap(arr,rightPtr, i);
                rightPtr++;
            }
        }
    }

    public static void swap(ArrayList<Integer> arr, int ptr1, int ptr2) {
        int temp = arr.get(ptr1);
        arr.set(ptr1, arr.get(ptr2));
        arr.set(ptr2, temp);
    }
}





