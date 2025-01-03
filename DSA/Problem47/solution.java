package DSA.Problem47;

public class  solution {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        System.out.println(search(arr, 9));

    }

    public static int search(int arr[], int key) {
        int size = arr.length;

        if(size==1) {
            if(arr[0]==key) return 0;
            else return -1;
        }
        // finding the pivot point
        int left = 0;
        int right = size-1;

        while(left<right) {
            int mid = (left+right)/2;
            if(arr[mid]>arr[right]) left=mid+1;
            else right = mid;
        }

        // loop will terminate at left==right, i.e the pivot point.
        int pivotIndex = left;
        right = size-1;
        left = 0;

        // check which part of the array this key lies:
        if(key>=arr[pivotIndex] && key<=arr[right]) {
            // right side of the index
            return binarySearch(arr, pivotIndex, right, key);
        } else {
            // left side of the index
            return binarySearch(arr, left, pivotIndex-1, key);
        }
    }

    public static int binarySearch(int[] arr, int left, int right, int key) {
      while(left<=right) {
          int mid = (left+right)/2;
          if(arr[mid]==key) return mid;
          else if(arr[mid]<key) left = mid+1;
          else right = mid-1;
      }
      return -1;
    }
}





