package DSA.Problem35;

public class  solution {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatRight(arr,4,4,1);
    }

    public static int[][] rotateMatRight(int[][] mat, int n, int m, int k) {

        for(int i=0; i<n;i++) {
            int[] row = mat[i];
            k = k % m; // Handle cases where k > row.length
            if (k == 0) continue;
            reverseArray(row, 0, m-1);
            reverseArray(row, 0, k-1);
            reverseArray(row, k, m-1);
        }
        return mat;
    }

    public static void reverseArray(int[] row, int start, int end) {
        int range = end+ start;
        for(int i=start; i<=(start+end)/2; i++) {
            swap(row, i, start+end-i);
        }
    }

    public static void swap(int[] row, int pos1, int pos2) {
        int temp = row[pos1];
        row[pos1] = row[pos2];
        row[pos2] = temp;
    }
}





