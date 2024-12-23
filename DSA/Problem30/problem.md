This is a new problem
```
<h1>Moore's Voting Algorithm</h1>
```
1. O(n^2)
2. O(n) + O(n):
    a. Iterate through the whole array and store the count in.a hashmap. Then Iterate through the hashmap and check which has >n/2 element.
3. O(nlogn) + O(n)
    a. Sort the array.
    b. Then iterate through the array to check which is >n/2. 
4. O(nlogn) + O(1) + O(n)
    a. After sorting the array, the majority element will definetly be present in the center.
    b. Check if the element returned is really n/2 times.
    c. Greedy approach
5. Moore's voting algorithm