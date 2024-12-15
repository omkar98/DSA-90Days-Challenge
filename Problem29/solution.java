package Problem29;

public class  solution {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 2, 1, 2};
        sort012(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void swap(int start, int end, int[] arr) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void sort012(int[] arr) {
        int n = arr.length;
        int start = 0;
        int mid = 0;
        int end = n - 1;
        // int i=0 <-- no need of another independent ptr. The mid ptr can work as i.
        while (mid <= end) {
            switch (arr[mid]) {
                case 0: {
                    swap(start, mid, arr);
                    start++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swap(end, mid, arr);
                    end--;
                    /* mid++;
                    can't do mid++, because we still don't know what was the element that was swapped.
                    So we need this arr[mid] again to check what was the element and sort it accordingly.
                     */
                    break;
                }
            }
        }
    }
}





