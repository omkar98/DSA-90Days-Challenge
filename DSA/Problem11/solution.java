package DSA.Problem11;

public class  solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{2,4,5},{3,5,8}};
        System.out.println(isMatrixSymmetric(matrix));
    }

    public static boolean isMatrixSymmetric(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if(rows!=columns) return false;
        for(int i=0;i<rows;i++) {
            for(int j=0; j<columns; j++) {
                if(i!=j && matrix[i][j] != matrix[j][i]) return false;
            }
        }
        return true;
    }
}

