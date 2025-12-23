package Neetcode.o1_ArraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoko {
    public static boolean isValidSudoku(char[][] board) {
        int sudokoSize = 9;
        // Check all the rows
        for(int row=0; row<sudokoSize; row++){
            Set<Character> hashSet = new HashSet<>();
            for(int col=0; col<sudokoSize; col++){
                if(board[row][col]=='.') continue;
                if(!hashSet.add(board[row][col])) {
                    return false;
                }
            }
        }

        // Check all the columns
        for(int col=0; col<sudokoSize; col++){
            Set<Character> hashSet = new HashSet<>();
            for(int row=0; row<sudokoSize; row++){
                if(board[row][col]=='.') continue;
                if(!hashSet.add(board[row][col])) {
                    return false;
                }
            }
        }

        /*
        I used record instead of creating a new class.
        In class I will need to override equals and hashcode method to ensure
        two new pairs with same values are actually equal.
         */
        record Pair(int rowI, int colI) {}

        // Check all the 3x3 matrix
        Map<Pair, Set<Character>> mpp = new HashMap<>();
        for(int row=0; row<sudokoSize; row++){
            for(int col=0; col<sudokoSize; col++){
                if(board[row][col]=='.') continue;
                Pair pair = new Pair(row/3, col/3);
                Set<Character> hashSet = mpp.getOrDefault(pair, new HashSet<>());
                if(!hashSet.add(board[row][col])) {
                    return false;
                }
                mpp.put(pair, hashSet);
                System.out.println(hashSet);
            }
        }

        System.out.println("Done.");
        return true;
    }
}
