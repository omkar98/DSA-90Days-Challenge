package DSA.Problem13;

public class  solution {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{14,15,16,5}, {13,20,17,6}, {12,19,18,7}, {11,10,9,8}};
//        int[][] matrix = {{2,3}};
        int[][] matrix = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};

//        int[][] matrix = {
//                {1, 2, 3, 4, 5},
//                {6, 7, 8, 9, 10},
//                {11, 12, 13, 14, 15},
//                {16, 17, 18, 19, 20},
//                {21, 22, 23, 24, 25}
//        };
//        int[][] matrix = {{1},{2},{3},{4},{5}};
//        int[][] matrix = {{1}};
        spiralPrint(matrix);
    }

    public static void spiralPrint(int matrix[][]){
        int rows = matrix.length;
        if(rows==0) return;
        int cols = matrix[0].length;
        int rowPointer = 0;
        int colPointer = 0;
        boolean flag = false;
        while(rowPointer<(rows+1)/2 && colPointer<(cols+1)/2) {
            // left to right
            for(int j=colPointer;j<cols-1-colPointer;j++) System.out.print(matrix[rowPointer][j] + " ");
            // top to bottom
            for(int i=rowPointer;i<rows-1-rowPointer;i++) System.out.print(matrix[i][cols-colPointer-1]+ " ");
            // right to left
            if(rows>1) for(int j=cols-1-colPointer;j>colPointer;j--) System.out.print(matrix[rows-rowPointer-1][j]+ " ");
            // bottom to top
            if(cols>1) for(int i=rows-1-rowPointer;i>rowPointer;i--) System.out.print(matrix[i][colPointer]+ " ");
            rowPointer++;
            colPointer++;
        }
        // when rows==cols, there is always one element left, i.e at the matrix[rowPointer][colPointer], i.e the center most element.
        if(rows%2==1 && cols%2==1 && rows==cols) System.out.print(matrix[rows/2][cols/2] + " ");
        if(rows==1 && cols!=1) System.out.print(matrix[0][cols-1] + " ");
        if(cols==1 && rows!=1) System.out.print(matrix[rows-1][0] + " ");
    }

}

