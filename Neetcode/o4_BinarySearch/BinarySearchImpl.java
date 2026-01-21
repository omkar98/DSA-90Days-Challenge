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

    public static int binarySearchImpl(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        int right = size-1;
        while(left<=right){
            /* Super Important: https://youtu.be/s4DPM8ct1pI?si=jdVdkf5XxCU6SDl0&t=501
            * For mid, adding (right+left) increases the value, esp. if they lie at the INT_MAX.
            * Better option: subtraction and then adding the left: i.e left+(right-left), this way we are reducing the value.
            * */
            int mid = left+((right-left)/2);
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return -1;
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

    public static int findMin(int[] nums) {
        int arrSize = nums.length;
        int left = 0; int right = arrSize-1;
        int mid = left+((right-left)/2);
        int small = nums[0];
        while(left<=right) {
            mid = left+((right-left)/2);
            small = Math.min(nums[left], Math.min(nums[mid],small));
            if(nums[mid]>=nums[left]) {
                left=mid+1;
            } else {
                right = mid-1;
            }
        }
        return small;

        /* ALTERNATIVE SOLUTION: Check with Gemini's help:
        int arrSize = nums.length;
        int left = 0; int right = arrSize-1;
        while(left<right) {
            int mid = left+((right-left)/2);
            if(nums[mid]>=nums[right]) {
                left=mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];*/
    }

    public static int searchRotatedSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Step 1: Check if the Left Side is sorted
            if (nums[left] <= nums[mid]) {
                // Step 2: Check if target is in this sorted left range
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is here, discard right
                } else {
                    left = mid + 1;  // Target is not here, go right
                }
            }
            // Step 3: Otherwise, the Right Side MUST be sorted
            else {
                // Step 4: Check if target is in this sorted right range
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Target is here, discard left
                } else {
                    right = mid - 1; // Target is not here, go left
                }
            }
        }
        return -1;
    }
}
