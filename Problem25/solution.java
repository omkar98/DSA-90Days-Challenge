package Problem25;

public class  solution {
    public static void main(String[] args) {
        // consider 0 as +ve.
        int[] arr = {6,5,4,3,2,1};
        insertionSort(arr.length, arr);
        for (int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
    }

    public static void insertionSort(int n , int[] arr) {
        if(n>1) {
            for(int i=1; i<n; i++) {
                int element = arr[i];
                int j=i;
                while(j>0 && arr[j-1]>element) {
                    arr[j]=arr[j-1];
                    arr[j-1]=element;
                    j--;
                }
            }
        }
    }

    public static void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}



