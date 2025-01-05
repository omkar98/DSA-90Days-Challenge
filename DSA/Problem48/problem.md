Single Element in a Sorted Array

- Brute: O(n)
  - Iterate through all the elements.
  - If you find the element towards the left and right of the current element different, thats our answer!

- Modified Binary Search: O(logn)
  - Left and Right Ptrs as usual.
  - find the mid.
  - How to decide whether the mid is our element?
    - Check left and right of the mid element, similar to how we checked in the Brute force.
    - If they are different, thats it! return the value.
  - How do we decide whether to move left half of the array or the right half of the array?
    - Check the current index. If the #elements on the left are odd, there lies our element.
    - The side of the array that has odd number of elements is the side we will traverse to.