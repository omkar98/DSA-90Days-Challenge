# Solution for Sum of KxK Sub-Matrices in a Matrix

## Problem Overview

You are given a square matrix of integers `ARR` of size `N x N`, and a value `K`. The task is to compute the sum of all `K x K` sub-squares in the matrix where `K <= N`. The output should be a new matrix that holds the sum of the elements of all sub-squares of size `K x K`.

## Steps and Approach

### 1. Initial Setup
You are provided with a matrix `ARR` of size `N x N` as an `ArrayList<ArrayList<Integer>>`.  
A sub-matrix of size `K x K` is formed from every contiguous block of size `K` in the matrix. For each block, we need to calculate the sum of its elements.

### 2. Row-Wise Sum Calculation
To calculate the sum of the elements in each row for a given sub-matrix:

- Iterate through each row of the matrix.
- Maintain a running sum for each block of `K` contiguous elements.
- When the size `K` is reached, store the sum and move the window one element to the right.

#### Steps:
- Start by iterating over each row.
- Keep a running sum for `K` consecutive elements.
- Once the `K` elements are added, store the sum and adjust the sum by subtracting the element that has just been excluded from the window and adding the new element.

### 3. Column-Wise Sum Calculation
After row-wise sums are computed, we proceed to calculate column-wise sums:

- For each column, calculate the sum of elements for each `K x K` sub-matrix by summing up the elements in the columns of the sub-matrix.
- Again, maintain a running sum and adjust it as the window moves down.

#### Steps:
- Iterate over each column, maintaining a running sum for each column segment of length `K`.
- Adjust the sum after reaching `K` elements and move the window down.

### 4. Construct the Output Matrix
After performing the above row-wise and column-wise summations, you will have the sums for all possible `K x K` sub-matrices stored in the original matrix. The final step is to copy the relevant sums into a new matrix (of size `(N-K+1) x (N-K+1)`).

### 5. Return the Result
Return the matrix that holds the sums of all `K x K` sub-matrices.

## Code Implementation

```java
package Problem44;

import java.util.ArrayList;
import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(8, 1, 3)),
                        new ArrayList<>(Arrays.asList(2, 9, 3)),
                        new ArrayList<>(Arrays.asList(0, 3, 5))
                )
        );
        System.out.print(sumOfKxKMatrices(list, 2));
    }

    public static ArrayList<ArrayList<Integer>> sumOfKxKMatrices(ArrayList<ArrayList<Integer>> arr, int k) {
        int rows = arr.size();
        int cols = arr.get(0).size();
        
        // Step 1: Calculate row-wise sums for each k-length window
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            int counter = 0;
            int index = 0;
            for (int j = 0; j < cols; j++) {
                counter++;
                sum += arr.get(i).get(j);
                if (counter == k) {
                    int oldValue = arr.get(i).get(index);
                    arr.get(i).set(index, sum);
                    sum -= oldValue;
                    counter--;
                    index++;
                }
            }
        }

        // Step 2: Calculate column-wise sums for each k-length window
        for (int j = 0; j < cols - k + 1; j++) {
            int sum = 0;
            int counter = 0;
            int index = 0;
            for (int i = 0; i < rows; i++) {
                counter++;
                sum += arr.get(i).get(j);
                if (counter == k) {
                    int oldValue = arr.get(index).get(j);
                    arr.get(index).set(j, sum);
                    sum -= oldValue;
                    counter--;
                    index++;
                }
            }
        }

        // Step 3: Construct the final output matrix
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < rows - k + 1; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < cols - k + 1; j++) {
                list.add(arr.get(i).get(j));
            }
            output.add(list);
        }

        return output;  // Return the matrix with summed values
    }
}


Time Complexity:

Time Complexity: The time complexity is O(N^2) because we are iterating over all elements of the matrix multiple times, first for row-wise summation, then for column-wise summation.
Space Complexity: The space complexity is O(N^2) due to the space needed to store the matrix and the output.