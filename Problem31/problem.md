This is a new problem
```
<h1>Moore's Voting Algorithm</h1>
```
1. O(n^2) + O(n) 
   2. Take every element from list1. Search in list2.
   3. Then delete that element from List2
   4. O(n) becasue in that case n strings will be created
5. O(n^2) + O(1)
   6. Same process as above. Use StringBuilder instead of String.
7. O(nlogn) + O(n)
   8. Sort then compare
9. [O(n) + O(n) + O(n) - time] + [O(2n) - space]
   10. map list1.
   11. map list2
   12. then compare these maps