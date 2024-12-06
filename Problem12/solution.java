package Problem12;

public class  solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        inplaceRotate(matrix, matrix.length);
        printMatrix(matrix);
    }

    public static void inplaceRotate(int[][] matrix, int n) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Transpose of the matrix
        findTranspose(matrix, rows, cols);
        swapRows(matrix, rows, cols);
    }

    public static void findTranspose(int[][] matrix, int rows, int cols) {
        for(int i=0; i<rows-1; i++) {
            for(int j=0; j<cols; j++) {
                if(j>i) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
//        printMatrix(matrix);
    }

    public static void swapRows(int[][] matrix, int rows, int cols) {
        for(int i=0; i<rows/2; i++) {
            for(int j=0; j<cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[rows-1-i][j];
                matrix[rows-1-i][j] = temp;
            }
        }
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

