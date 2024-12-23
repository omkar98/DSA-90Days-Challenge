package DSA.Problem34;

import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        int[] arr = {-2,1,2,-1,0};
        sort(arr.length, arr);
        for(int i=0; i<arr.length;i++) System.out.print(arr[i] + " ");
    }

    public static int[] sort(int n, int arr[]) {
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int range = max-min+1;
        int[] freqArr = new int[range];

        // create a frequency array
        for(int i=0; i<n; i++) {
            freqArr[arr[i]-min]++;
        }

        // convert this freq array to prefix Array
        for(int i=1; i<range;i++){
            freqArr[i]+=freqArr[i-1];
        }

        // create an ans array and store sorted elements in it.
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--) {
            int ele = arr[i];
            int freqIdx = ele - min;
            ans[freqArr[freqIdx]-1] = ele;
            freqArr[freqIdx]--;
        }

        // now put all ans array ele into original array
        for(int i=0; i<n; i++) arr[i] = ans[i];

        return arr;
    }
}





