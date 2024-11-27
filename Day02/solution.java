package Day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class solution {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(rotateArray(list, 2));
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        int size = arr.size();
        reverseArray(arr);
        reverseArray(arr.subList(0,size-k));
        reverseArray(arr.subList(size-k,size));
        return arr;

        // Direct collection
//        Collections.reverse(arr);
//        Collections.reverse(arr.subList(0,size-k));
//        Collections.reverse(arr.subList(size-k, size));
//        return arr;
    }

    private static void reverseArray(List<Integer> arr) {
        int size = arr.size();
        for(int i=0; i<(size/2); i++) {
            Integer temp = arr.get(i);
            arr.set(i,arr.get(size-i-1));
            arr.set(size-i-1, temp);
        }
    }
}