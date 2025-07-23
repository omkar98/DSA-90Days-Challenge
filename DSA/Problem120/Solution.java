package DSA.Problem120;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution
{

    public static void main(String[] arr){
        int[][] intervals = new int[][]{{0,5}, {3,4}, {1,2}, {5,9}, {5,7}, {7,9}};
        int maxMeetings = minimumReschedules(intervals.length,intervals);
        System.out.print(maxMeetings);
    }

    public static int minimumReschedules(int N, int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int endTime = -1;
        int count = 0;
        for(int i=0; i<N; i++){
            if(intervals[i][0]>=endTime) {
                count++;
                endTime = intervals[i][1];
            }
        }
        return N-count;
    }
}