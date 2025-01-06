package DSA.Problem49;

import java.util.ArrayList;
import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        arr.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        arr.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        arr.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        arr.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2)));
        System.out.println(getMedian(arr));
    }

    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int low = findLowAndHigh(matrix,true);
        int high = findLowAndHigh(matrix,false);
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int reqNum = (rows*cols)/2;
        while(low<=high) {
            int mid = (low+high)/2;
            int freq = blackBox(matrix, mid, rows, cols);
//            if(freq==reqNum) return mid;
            if(freq<=reqNum) low = mid+1;
            else if(freq>reqNum) high = mid-1;
        }
        return low; // Low can be trusted that high, because low will stop at the right point.
    }

    public static int blackBox(ArrayList<ArrayList<Integer>> matrix, int mid, int rows, int cols) {
        int count = 0;
        for(int i=0; i<rows; i++){
            count+=binarySearchCount(matrix.get(i), mid, cols);
        }
        return count;
    }

    public static int binarySearchCount(ArrayList<Integer> arr, int required, int cols) {
        int low = 0;
        int high = cols-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr.get(mid)<=required) low = mid+1; // This is where I was stuck
            if(arr.get(mid)>required) high = mid-1;
        }
        return low; // Low can be trusted that high, because low will stop at the right point.
    }

    public static int findLowAndHigh(ArrayList<ArrayList<Integer>> matrix, boolean findLow) {
        if(findLow) {
            int low = matrix.get(0).get(0);
            for(int i=0; i<matrix.size(); i++) {
                if(low>matrix.get(i).get(0)) low = matrix.get(i).get(0);
            }
            return low;
        } else {
            int high = matrix.get(0).get(matrix.get(0).size() - 1);
            for (int i = 0; i < matrix.size(); i++) {
                if (high < matrix.get(i).get(matrix.get(i).size() - 1)) high = matrix.get(i).get(matrix.get(i).size() - 1);
            }

            return high;


        }
    }


}





