public class solution {
    public static void main(String[] args) {
        int[] arr = {-2147483648, -2147483647};
//        int arr[] = {1,1,1,2};
        int n = arr.length;
        int num = findSecondLargestElement(arr, n);
        System.out.println(num);
    }

    public static int findSecondLargestElement(int[] arr, int n) {
        int secondLargest = Integer.MIN_VALUE;
        int largest = arr[0];
        for(int i=1;i<n;i++) {
            if(arr[i]>largest) {
                int currentLargest = largest;
                largest = arr[i];
                secondLargest = currentLargest;
            }
            if (arr[i]>secondLargest && secondLargest!=largest && largest!=arr[i]) secondLargest=arr[i];
        }
        return secondLargest == largest || secondLargest==Integer.MIN_VALUE ? -1 : secondLargest;
    }
}