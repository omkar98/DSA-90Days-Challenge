package DSA.Problem121;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution
{

    public static void main(String[] arr){
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
        ArrayList<Integer> interval1 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> interval2 = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> interval3 = new ArrayList<>(Arrays.asList(5, 7));
        ArrayList<Integer> interval4 = new ArrayList<>(Arrays.asList(8, 10));
        ArrayList<Integer> interval5 = new ArrayList<>(Arrays.asList(12, 16));
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval5);
        ArrayList<Integer> newInterval = new ArrayList<>(Arrays.asList(6,8));
        insertInterval(intervals, newInterval);
    }

    public static ArrayList<ArrayList<Integer>> insertInterval(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newInterval) {
        int size = intervals.size();
        ArrayList<ArrayList<Integer>> newList = new ArrayList<>();
        int intervalStart = Integer.MAX_VALUE;
        int intervalEnd = -1;
        int rightPtr = -1;
        for(int i=0; i<size; i++){
            // look for the right part
            if(intervals.get(i).get(1)<newInterval.get(0)){
                newList.add(intervals.get(i));
            }
            // within the interval
            else if(intervals.get(i).get(0)<=newInterval.get(0)){
                intervalStart = intervals.get(i).get(0);
            } else if((intervalEnd==-1 || intervalEnd>=intervals.get(i).get(0)) && intervals.get(i).get(1)>=newInterval.get(1) && intervals.get(i).get(0)>=newInterval.get(1)) {
                intervalEnd = intervals.get(i).get(1);
            }
            // final right portion
            else if(intervals.get(i).get(0)>=newInterval.get(0) && intervals.get(i).get(1)>=newInterval.get(1)){
                rightPtr = i;
                break;
            }
        }
        ArrayList<Integer> newInt = new ArrayList<>(Arrays.asList(intervalStart, intervalEnd));
        newList.add(newInt);
        newList.addAll(intervals.subList(rightPtr, intervals.size()));
        return newList;
    }
}