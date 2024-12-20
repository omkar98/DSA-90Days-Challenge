This is a new problem
```
<h1> Kadane's Algorithm on a circular array</h1>
```
Best resource: https://www.youtube.com/watch?v=Q1TYVUEr-wY
Approach 1:
1. Apply Kadane's algo for every index.
2. Use %N operator.
3. Time: O(n^2)

Approach 2: 
1. Double the array, i.e copy paste the same array at the end.
2. Apply Kadane's Algo ensuring that the max window size will be the size of the original array.
3. O(n) time an O(n) space

Approach 3:
1. Iterate the same array twice. Apply same logic as Approach 2.
2. O(n) time
3. O(n) space

Simpler Approach:
1. Min subarray sum using kadane's algo.
2. Total array sum.
3. Max(totalArraySum - minSubArraySum, maxSubArraySum)

Corner case: if all elements are -ve, then simply return the gloablMax element.
