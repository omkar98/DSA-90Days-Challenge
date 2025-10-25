package DSA.Recursion.N_Queens;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution
{
    private static ArrayList<Integer> flattenMatrix(int[][] mat){
        ArrayList<Integer> flattenedMatrix = new ArrayList<>();
        for (int[] row : mat) {
            for (int cell : row) {
                flattenedMatrix.add(cell);
            }
            System.out.println(); //sout tab
            System.out.println();
        }
        return flattenedMatrix;
    }
    private static boolean isSafe(int[][] mat, int row, int col, int n) {
        // Check column upwards
        for (int i = 0; i < row; i++) {
            if (mat[i][col] == 1) return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 1) return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (mat[i][j] == 1) return false;
        }

        return true;
    }

    private static void solveNQueensRecursion(int n, int row, ArrayList<ArrayList<Integer>> finalResult, int[][] mat) {
        // Base case: all queens placed
        if (row == n) {
            finalResult.add(flattenMatrix(mat));
            return;
        }

        // Try placing queen in each column of current row
        for (int col = 0; col < n; col++) {
            if (isSafe(mat, row, col, n)) {
                mat[row][col] = 1; // place queen
                solveNQueensRecursion(n, row + 1, finalResult, mat);
                mat[row][col] = 0; // backtrack
            }
        }
    }


    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        int[][] mat = new int[n][n];
        solveNQueensRecursion(n, 0, finalResult, mat);
        return finalResult;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = solveNQueens(4);
        for (ArrayList<Integer> board : res) {
            System.out.println(board);
        }
        System.out.println("Total solutions: " + res.size());

        Stream.iterate(1, a -> a+1);
    }
}