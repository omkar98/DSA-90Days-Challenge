package DSA.Problem52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  solution {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4,6,2,5,7,9,1,3));
        System.out.println(quickSort(arr));
    }

    public static List<Integer> quickSort(List<Integer> arr){
        int low = 0;
        int high = arr.size()-1;
        divideAndConquer(arr,low,high);
        return arr;
    }

    public static void divideAndConquer(List<Integer> arr, int low, int high) {
        if(low<high) {
            int pivotIdx = findPivot(arr, low, high);
            divideAndConquer(arr, low, pivotIdx-1);
            divideAndConquer(arr, pivotIdx+1, high);
        }
    }

    public static int findPivot(List<Integer> arr, int low, int high) {
        int i=low;
        int j=high;
        int pivot = arr.get(low);
        while(i<j) {
            while(arr.get(i)<=pivot && i<=high-1) {
                i++;
            }
            while(arr.get(j)>pivot && j>=low+1) {
                j--;
            }
            if(i<j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

}





