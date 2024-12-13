package Problem24;

public class  solution {
    public static void main(String[] args) {
        // consider 0 as +ve.
        int[] arr = {6,5,4,3,2,1};
        insertionSort(arr.length, arr);
        for (int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
    }

    public static void insertionSort(int n , int[] arr) {
        for(int i=0; i<n-1; i++) {
            int smallest = arr[i];
            int indexSmallest = i;
            for(int j=i; j<n;j++) {
                if(arr[j]<smallest) {
                    smallest = arr[j];
                    indexSmallest = j;
                }
            }
            swap(i,indexSmallest,arr);
        }
    }

    public static void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}



