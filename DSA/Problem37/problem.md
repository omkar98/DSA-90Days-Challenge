This is a new problem
```
<h1> Move Zeroes To End</h1>
```
Approach1:
1. Iterate through the arrayList and count the number of zeroes.
2. Iterate through the arrayList again and this time remove the 0's. Easier if arrayList and not in arrays.
3. Simply push all the 0's at the end.

O(n) + O(n) + O(n)
Step1 + Step2 + Step3(incase there are n-1 zeroes)

Approach 2:
1. Apply bubble sort and bubble out the zero at the end.
2. Do this for every zero.
O(n^2)

Approach 3:
Partitioning method: Rephrase the question: Move all the non zero elements at the right.
1. 2 ptrs. L and R.
2. L will keep all the non-zero elements. R will be iterating. The moment it finds some non-zero, it will simply swap.
3. 