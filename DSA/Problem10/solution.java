package DSA.Problem10;

import java.util.ArrayList;
import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1)),
                        new ArrayList<>(Arrays.asList(1)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(1))
                )
        );
        System.out.println(coverageOfMatrix(mat));
    }

    public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {
        int rows = mat.size();
        int cols = mat.get(0).size();
        int counter = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(mat.get(i).get(j)==0) {
                    //top
                    if(i-1>=0 && mat.get(i-1).get(j)==1) counter+=1;
                    //right
                    if(j+1<cols && mat.get(i).get(j+1)==1) counter+=1;
                    //bottom
                    if(i+1<rows && mat.get(i+1).get(j)==1) counter+=1;
                    //left
                    if( j-1>=0 && mat.get(i).get(j-1)==1) counter+=1;
                }

            }
        }
        return counter;
    }
}

