Search In Rotated Sorted Array

Brute:
1. O(n) <-- Directly search for the element in the array.
2. O(n) <-- 
   3. The array is anyways sorted.
   4. Find the pivot point. Then apply binary search.

Finding the pivot point:
1. O(n)
2. O(logn) <-- look for the pivot point using a modified binary search algo

1. When nums[midpoint] > nums[right]:
 - This means the smallest element (pivot) is to the right of midpoint.
 - Why? Because if the midpoint is greater than the rightmost value, it indicates that we are in the rotated part of the array.
 - Action: Move left to midpoint + 1.
    - When nums[midpoint] <= nums[right]:
    - This means the smallest element (pivot) could be at midpoint or to the left of it.
    - Why? Because if the midpoint is less than or equal to the rightmost value, it indicates that the portion from midpoint to right is sorted, and the smallest element lies in the left portion (including midpoint).
    - Action: Move right to midpoint.
 - Termination 
   - The loop continues until left == right. At this point, left (or right) points to the pivot, which is the smallest element in the rotated array.