This is a new problem

<h1>  Maximum Subarray Sum After K Concat
</h1>

Best resource: https://www.youtube.com/watch?v=qnoOu5Usb4o

Approach:
1. There could be 3 major conditions
   1. If K = 1: Simple Kadane's Algo
   2. If SumOfTheArray<0: (need to remember. To know the reason what the video in the resource)
      1. In this case the max sum always lies within the first 2 copies only.
      2. Apply kadane's algo on a circular array(i.e first 2 copies), similar to problem 39.
   3. If SumOfTheArray>0:
      1. The sum definitely lies within the whole concatenated array.
      2. Apply Kadane's algo on first two copies (i.e circular array) + (K-2)*SumOfTheWholeArray

