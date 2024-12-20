This is a new problem

<h1>  Longest Consecutive Sequence
</h1>

Best resource: https://www.youtube.com/watch?v=P6RZZMu_maU
Approach-1:
1. Sort the elements. O(nlogn)
2. Then iterate through the whole arr to look for the longest subsequence. O(n)
3. use a variable to keep tracking of a longSubSequence O(1)

Approach 2: 
1. look for the max and min elements in the array. O(n)
2. Create a new array size of (max-min+1). Initialise to 0. <--- space: O(max of arr). 
3. Iterate through the arr and whenever there is an occurance mark the auxi array with 1.
3. Iterate the aux array and look for longest subsequence of 1's. O(max ele in array);

Approach 3:
1. Convert to a hashset. Space: O(n)
2. Logic:
   3. Every longest subseq has a starting pt and ending pt.
      4. The starting pt has no prev number.  
      5. The ending pt has no next number.
example [9,5,4,10,6]
6. Take the first element. eg 9.
7. Look if there exists any prev for this number, i.e 8 in hashset.
   8. YES: ignore. move to next.
   9. NO: update longSub = 1, and search for the next number, i.e 10 in hashset.
   10. Keep doing this, until you reach a point where there is no next number.
11. Repeat again for every number.

Time: O(n) + searching in the Hashset is O(1)
Space: O(n) <-- size of hashset
   