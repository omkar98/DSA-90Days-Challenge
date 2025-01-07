package DSA.Problem51;

public class  solution {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,1,5,2,6,9};
        mergeSort(arr, arr.length);
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int[] arr, int n) {
        // divide & merge
        int low = 0;
        int high = n-1;
        divide(arr,low,high);
    }

    public static void divide(int[] arr, int low, int high) {
        if(high==low) return;
        int mid = (low+high)/2;
        divide(arr,low,mid);
        divide(arr,mid+1,high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        // [1,1,2,3,3] [1,2,3,4,5,6,7]
        int leftPtr = low;
        int rightPtr = mid+1;
        int[] temp = new int[high-low+1];
        int tempIdx = 0;
        while(leftPtr<=mid && rightPtr<=high) {
            if(arr[leftPtr]<=arr[rightPtr]) {
                temp[tempIdx] = arr[leftPtr];
                tempIdx++;leftPtr++;
            }
            else if(arr[leftPtr]>=arr[rightPtr]) {
                temp[tempIdx] = arr[rightPtr];
                tempIdx++;rightPtr++;
            }
        }
        if(leftPtr>mid) {
            while(rightPtr<=high) {
                temp[tempIdx] = arr[rightPtr];
                rightPtr++;tempIdx++;
            }
        }
        if(rightPtr>high) {
            while(leftPtr<=mid) {
                temp[tempIdx] = arr[leftPtr];
                leftPtr++;tempIdx++;
            }
        }
        for(int i=0; i<temp.length; i++) {
            arr[low+i] = temp[i];
        }
    }
}





