package Neetcode.o1_ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // Easy
        ContainsDuplicate.hasDuplicate(new int[]{1,2,3,3});
        Anagrams.isAnagram("Omkar", "Omkar");
        TwoSum.twoSum(new int[]{3,4,5,6}, 7);

        //Medium
        GroupAnagrams.groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"});
        TopKFrequent.topKFrequent(new int[]{7,7}, 2);
        EncodeDecode.decode(EncodeDecode.encode(new ArrayList<>(Arrays.asList("neet","code","love","you")))); // Super corner case: if the array is null, we end up resulting in empty string in encode.
//        ProductOfArraysExceptSelf.productExceptSelf(new int[]{1,2,3,4});
//        char[][] board = {{'1','2','.','.','3','.','.','.','.'},
//                {'1','.','.','5','.','.','.','.','.'},
//                {'.','9','8','.','.','.','.','.','3'},
//                {'5','.','.','.','6','.','.','.','4'},
//                {'.','.','.','8','.','3','.','.','5'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','.','.','.','.','.','2','.','.'},
//                {'.','.','.','4','1','9','.','.','8'},
//                {'.','.','.','.','8','.','.','7','9'}};
//        System.out.println(ValidSudoko.isValidSudoku(board));
        LongestConsecutive.longestConsecutive(new int[]{100,4,200,1,3,2,99,98,97,96,95});
    }
}
