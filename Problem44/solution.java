package Problem44;

import java.util.ArrayList;
import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(
//                Arrays.asList(
//                        new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
//                        new ArrayList<>(Arrays.asList(5, 6, 7, 8)),
//                        new ArrayList<>(Arrays.asList(9, 10, 11, 12)),
//                        new ArrayList<>(Arrays.asList(13, 14, 15, 16))
//                )
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(8, 1, 3)),
                        new ArrayList<>(Arrays.asList(2, 9, 3)),
                        new ArrayList<>(Arrays.asList(0, 3, 5))
                )
        );
        System.out.print(sumOfKxKMatrices(list,2));

    }

    public static ArrayList<ArrayList<Integer>> sumOfKxKMatrices(ArrayList<ArrayList<Integer>> arr, int k) {
        int rows = arr.size();
        int cols = arr.get(0).size();
        // this will ensure that the sum of the rows are calculated and stored in their respective positions
        for(int i=0; i<rows;i++) {
            int sum=0;
            int counter = 0;
            int index = 0;
            for(int j=0; j<cols; j++) {
                counter++;
                sum += arr.get(i).get(j);
                if(counter==k) {
                    int oldValue = arr.get(i).get(index);
                    arr.get(i).set(index, sum);
                    sum-=oldValue;
                    counter--;
                    index++;
                }
            }
        }


        /* now lets calculate the column values
        If its a 4*4 matrix and
            k = 2: There will be a 3*3 matrix formed.
            k = 3: There will be a 2*2 matrix formed.
            pattern: if a n*n matrix, the resultant matrix will be of size: n-k+1


         */
        for(int j=0; j<cols-k+1; j++) {
            int sum=0;
            int counter = 0;
            int index = 0;

            for(int i=0; i<rows; i++) {
                counter++;
                sum += arr.get(i).get(j);
                if(counter==k) {
                    int oldValue = arr.get(index).get(j);
                    arr.get(index).set(j, sum);
                    sum-=oldValue;
                    counter--;
                    index++;
                }
            }
        }

        // now put all the elements in a new Arraylist and return it.
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for(int i=0; i<rows-k+1; i++) {
            ArrayList<Integer> list = new ArrayList();
            for(int j=0; j<cols-k+1; j++) {
                list.add(arr.get(i).get(j));
            }
            output.add(list);
        }
        return output;
    }
}





