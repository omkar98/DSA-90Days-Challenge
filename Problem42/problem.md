The problem statement provided is incorrect. It was told that there are not duplicates, but the examples contain duplicates.

Actual Problem statement is - 
# Problem Statement

You are given an array `ARR` of `N` integers. Your task is to identify the product `P` with the highest frequency of unique pairs `(p, q)` such that \( p \cdot q = P \), where \( p \) and \( q \) are elements of the array located at different indexes.

Additionally, determine the total count `C` of all such quadruples, considering only unique pairs for each product.

## Notes
1. A pair `(p, q)` is considered unique if:
   - \( p \) and \( q \) come from different indexes.
   - The pair `(p, q)` is treated the same as `(q, p)`.
2. If two or more products \( P_1, P_2, \dots \) have the same highest frequency `C`, choose the smallest product `P`.
3. If no such product `P` exists, return \( P = 0 \).

---

## Input
- An integer \( N \) (\( 4 \leq N \leq 100 \)) — the size of the array.
- An array `ARR` of size \( N \) (\( 1 \leq ARR[i] \leq 10^9 \)).

---

## Output
Two integers:
1. `P` — the product with the highest frequency of unique pairs.
2. `C` — the total count of all quadruples for the product `P`.

If no valid product exists, return \( P = 0 \).

---

## Example
### Input:
6 2 6 3 4 1 12

### Output:

12 3

---

## Explanation
- The unique pairs that produce the product `12` are:
   - \( (2, 6) \)
   - \( (3, 4) \)
   - \( (1, 12) \)
- The frequency of the product `12` is `3`.
- The number of quadruples formed is:
  \[
  C = \binom{3}{2} = \frac{3 \times 2}{2} = 3
  \]


----
SOLUTION:
# Problem Context

The problem involves finding the product `P` that can be formed by multiple pairs `(i, j)`, such that:

\[
P = arr[i] \times arr[j]
\]

The goal is to find all possible quadruples `(p, q, r, s)` such that:

\[
arr[p] \times arr[q] = arr[r] \times arr[s]
\]

Quadruples are formed from combinations of pairs of indices that yield the same product `P`.

---

## Why Use the Formula

### Understanding the Frequency and Quadruples Relationship

Suppose `P` is a product with a frequency `f` (i.e., it appears `f` times in the array of pair products). Each pair that produces `P` can combine with another pair to form a quadruple.

### Example:

Consider \( P = 12 \) and pairs:
- \( (2, 6) \)
- \( (3, 4) \)
- \( (1, 12) \)

There are 3 pairs. Quadruples can be formed by choosing 2 pairs out of these 3 pairs:

\[
\binom{f}{2} = \frac{f \times (f - 1)}{2}
\]

Thus, the formula:

\[
\frac{f \times (f - 1)}{2}
\]

is used to count the quadruples for a product `P`.

---

## Intuition Behind the Formula

### Frequency `f`:
Represents the number of pairs producing the product `P`.

### Combinations of Pairs:
For `f` pairs, any two pairs can form a valid quadruple. This is a combinatorial problem where you choose 2 items from `f`, calculated as:

\[
\binom{f}{2} = \frac{f \times (f - 1)}{2}
\]

### Example Calculations:
1. \( f = 3 \):
   \[
   \text{Quadruples} = \frac{3 \times 2}{2} = 3
   \]
2. \( f = 4 \):
   \[
   \text{Quadruples} = \frac{4 \times 3}{2} = 6
   \]

---

## Step-by-Step Example

### Input Array:
\[
arr = \{2, 6, 3, 4, 1, 12\}
\]

### Calculate Pair Products:
- Pair products: \( 12, 18, 24, \dots \)

### Frequency of Product `12`:
- \( f = 3 \)

### Count Quadruples:
With \( f = 3 \), the number of quadruples is:

\[
\binom{3}{2} = \frac{3 \times 2}{2} = 3
\]

### Result:
- Product: \( P = 12 \)
- Quadruples: \( 3 \)

---

## Key Takeaway

The formula:

\[
\frac{f \times (f - 1)}{2}
\]

efficiently counts how many unique quadruples can be formed when `f` pairs share the same product `P`. This is a direct application of combinatorics, avoiding the need to explicitly enumerate all possible quadruples, which would be computationally expensive.
