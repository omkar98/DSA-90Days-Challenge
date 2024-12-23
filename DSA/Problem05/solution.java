package DSA.Problem05;

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        int[] arr = {39, -31, 45, -34, 25, -1, 30, -15, -49, 41, 43, -45, -6, -22, -21, -24, -47, -32, -2, 48, 4, 16, -23, 37, -18, -44, -38, 44, 0, -41, -3, -33, 1, 27, 8, 38, -48, -14, 32, -16, -50, 6, 22, 28, -25, 9, -4, 31, -30, 14, 35, -46, 49, -35, 11, 19, -8, -7, 12, 23, 29, 52, -28, 40, 33, -36, 21, 20, -26, -10, -11, 2, -27, -12, 10, -42, 46, -40, 13, 34, -37, 50, 47, 7, -39, 51, -9, -29, 42, -13, 17, 24, -5, 26, 18, -19, -43, 5, -20, 36};
        int n = arr.length;
        System.out.println(firstMissing(arr, n));
    }

    public static int firstMissing(int[] arr, int n) {
        arr = Arrays.stream(arr).map(i -> {if(i<0) return 0; else return i;}).toArray();
         for(int i=0; i<n; i++){
         	int index = Math.abs(arr[i]) - 1;
         	if(index<0 || index>=n || arr[index]<0) continue;
         	else if(arr[index]==0) arr[index] = -(n+1);
         	else if(arr[index]>0) arr[index] = -(arr[index]);
         }
         for(int i=0; i<n;i++) {
         	if(arr[i]>=0){
         		return i+1;
         	}
         }
         return n+1;
    }
}

