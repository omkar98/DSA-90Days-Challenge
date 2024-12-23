package DSA.Problem14;

public class  solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,0},{1,0,1,1},{1,1,0,1},{1,1,1,1}};
        setZeros(matrix);

//        printMatrix(matrix);
    }

    public static void setZeros(int[][] matrix) {
        int col0 = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        col0 = iterateAllElements(matrix, rows, cols, col0);
        solveUsingOuterRow(matrix, rows, cols, col0);
        solveUsingOuterCol(matrix, rows, cols, col0);
        solveFirstRow(matrix, rows, cols, col0);
        solveFirstCol(matrix, rows, cols, col0);
        printMatrix(matrix);
    }

    public  static void solveUsingOuterRow(int[][] matrix, int rows, int cols, int col0) {
        for(int j=cols-1; j>0; j--) {
            if(matrix[0][j]==0) {
                for(int i=1; i<rows; i++){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public  static void solveUsingOuterCol(int[][] matrix, int rows, int cols, int col0) {
        for(int i=rows-1; i>=0; i--) {
            if(matrix[i][0]==0) {
                for(int j=1; j<cols; j++){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public  static void solveFirstRow(int[][] matrix, int rows, int cols, int col0) {
        if(matrix[0][0]==0) {
            for(int j=1; j<cols; j++) matrix[0][j] = 0;
        }
    }

    public  static void solveFirstCol(int[][] matrix, int rows, int cols, int col0) {
        if(col0==0) {
            for(int i=0; i<rows; i++) matrix[i][0] = 0;
        }
    }

    public  static int iterateAllElements(int[][] matrix, int rows, int cols, int col0) {
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0]=0;
                    if(matrix[i][j]==0 && j==0) {
                        col0 = 0;
                    }
                    else matrix[0][j]=0;
                }
            }
        }
        return col0;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

