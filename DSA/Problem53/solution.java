package DSA.Problem53;

import java.util.ArrayList;
import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1,4,7,10));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2,5,6));
        System.out.println(findKthElement(arr1, arr2, 4));
    }

    public static int findKthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int k) {
        int ptr1 = 0;
        int ptr2 = 0;
        int size1 = arr1.size();
        int size2 = arr2.size();
        int currentElement = arr1.get(ptr1)<=arr1.get(ptr2) ? arr1.get(ptr1) : arr2.get(ptr2);

        while(ptr1<size1 && ptr2<size2) {
            if(arr1.get(ptr1)<=arr2.get(ptr2)) {
                currentElement = arr1.get(ptr1);
                if(ptr1+ptr2==k-1) return currentElement;
                ptr1++;
            } else {
                currentElement = arr2.get(ptr2);
                if(ptr1+ptr2==k-1) return currentElement;
                ptr2++;
            }
        }

        while(ptr1<size1) {
            currentElement = arr1.get(ptr1);
            if(ptr1+ptr2==k-1) return currentElement;
            ptr1++;
        }
        while(ptr2<size2) {
            currentElement = arr2.get(ptr2);
            if(ptr1+ptr2==k-1) return currentElement;
            ptr2++;
        }

        return currentElement;

    }
}





