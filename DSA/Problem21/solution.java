package DSA.Problem21;

public class  solution {
    public static void main(String[] args) {
        // consider 0 as +ve.
        int[] arr = {-23, 48, -13, 31, -12, 6, -42, 23, 14, 33, -33, -21, 0, 25, -39, -31};
        System.out.println(separateNegativeAndPositive(arr));

    }

    public static int[] separateNegativeAndPositive(int a[]) {
        // corner case if for zero. So for all the conditions, simply include zero
        int size = a.length;
        int left = 0;
        int right = size-1;
        while(left<right) {
            if(a[left]<=0 && a[right]>=0) {
                left++;
                right--;
            } else if(a[left]<=0 && a[right]<=0) {
                left++;
            } else if(a[left]>=0 && a[right]>=0) {
                right--;
            } else if(a[left]>=0 && a[right]<=0) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        for(int i=0; i<size; i++)
            System.out.print(a[i]+" ");
        return a;
    }
}



