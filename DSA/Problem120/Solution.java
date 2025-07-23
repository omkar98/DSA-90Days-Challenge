package DSA.Problem120;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval{
    int startTime;
    int endTime;
    int position;

    Interval(int startTime, int endTime, int position){
        this.startTime = startTime;
        this.endTime = endTime;
        this.position = position;
    }
}
public class Solution
{

    public static void main(String[] arr){
        int[] start = new int[]{0,3,1,5,5,8};
        int[] end = new int[]{5,4,2,9,7,9};
        int maxMeetings = maximumMeetings(start, end);
        System.out.print(maxMeetings);
    }

    public static int maximumMeetings(int []start, int []end) {
        int noOfMeetings = start.length;
        List<Interval> intervals = new ArrayList<>();
        for(int i=0; i<noOfMeetings; i++){
            intervals.add(new Interval(start[i], end[i], i+1));
        }
        intervals.sort(Comparator.comparingInt(interval -> interval.endTime));
        int freeTime = 0;
        int count = 0;
        List<Integer> meetings = new ArrayList<>();
        for(int i=0; i<noOfMeetings; i++){
            Interval currentMeeting = intervals.get(i);
            if(currentMeeting.startTime>freeTime) {
                freeTime = currentMeeting.endTime;
                count++;
                meetings.add(currentMeeting.position);
            }
        }

        return count;
    }
}