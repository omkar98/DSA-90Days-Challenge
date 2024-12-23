package DSA.Problem32;

import java.util.ArrayList;
import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        ArrayList a1 = new ArrayList<>(Arrays.asList(1,2,2,2,3,4));
        ArrayList a2 = new ArrayList<>(Arrays.asList(2,2,3,3));
        System.out.println(findArrayIntersection(a1,a1.size(),a2, a2.size()));
    }

    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
       int ptr1 = 0;
       int ptr2 = 0;
       ArrayList<Integer> output = new ArrayList<>();

       while(ptr1<n && ptr2 < m) {
           int val1 = arr1.get(ptr1);
           int val2 = arr2.get(ptr2);
           if(val1==val2) {
               output.add(val1);
               ptr1++;ptr2++;
           }
           if(val1>val2) ptr2++;
           if(val1<val2) ptr1++;
       }
       return output;
    }
}





