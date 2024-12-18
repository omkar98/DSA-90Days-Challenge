package Problem33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class  solution {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList<>(Arrays.asList(6,6,6,7));
        System.out.println(majorityElementII(arr));
    }

    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        int ctr1 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ctr2 = 0;
        int ele2 = Integer.MIN_VALUE;
        int size = arr.size();
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (ctr1 == 0) {
                ele1 = arr.get(i);
                ctr1++;
            } else if (ele1 == arr.get(i)) ctr1++;
            else if (ctr2 == 0) {
                ele2 = arr.get(i);
                ctr2++;
            }
            else if (ele2 == arr.get(i)) ctr2++;
            else {
                ctr1--;
                ctr2--;
            }
        }
        if(ele1!=Integer.MIN_VALUE && validateMajority(ele1, arr)) output.add(ele1);
        if(ele2!=Integer.MIN_VALUE && validateMajority(ele2, arr)) output.add(ele2);
        return output;
    }

    public static boolean validateMajority(int ele, ArrayList<Integer> arr) {
        return Collections.frequency(arr, ele) > arr.size()/3;
    }
}





