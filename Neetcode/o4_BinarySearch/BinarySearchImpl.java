package Neetcode.o4_BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchImpl {
    public static int search(int[] nums, int target) {
        List<Integer> ints = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int index = Collections.binarySearch(ints, target);
        return index>=0 ? index : -1;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        int checkRow = 0;
        for(int i=0; i<matrixRows; i++) {
            int largestValue = matrix[i][matrixColumns-1];
            if(target<=largestValue) {
                checkRow = i; break;
            }
        }
        List<Integer> actualRow = Arrays.stream(matrix[checkRow]).boxed().collect(Collectors.toList());
        return Collections.binarySearch(actualRow, target)>=0 ;
    }
}
