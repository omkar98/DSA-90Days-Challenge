package DSA.Problem30;

import java.util.stream.IntStream;

public class  solution {
    public static void main(String[] args) {
        int[] arr = {7, 7, 5, 7, 5, 1, 5, 7, 5,5,7, 5,5,5,5};
        System.out.println(findMajority(arr, arr.length));
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }

    public static int findMajority(int[] arr, int n) {
        int maxCount = -1;
        int currentElement = arr[0];
        for(int i=0; i<n; i++) {
            if(maxCount<=0) {
                maxCount=0;
                currentElement = arr[i];
            }
            if(currentElement==arr[i]) maxCount++;
            else maxCount--;
        }
        return verifyElement(currentElement, arr) ? currentElement : -1;
    }

    public static boolean verifyElement(int element, int[] arr) {
        return arr.length / 2 < (IntStream.of(arr).filter(x -> x == element).count());
    }
}





