package DSA.Problem115;


import java.util.Arrays;

public class Solution
{

    public static void main(String[] arr){
        int [] burstTime = new int[]{4,3,7,1,2};
        System.out.print(sjf(5, burstTime));
    }

    public static float sjf(int n, int []burstTime)
    {
        Arrays.sort(burstTime);
        float waitingTime = 0;
        float startTime = 0;
        float endTime = burstTime[0];


        for(int i=1; i<n; i++){
            waitingTime+=endTime;
            startTime=endTime;
            endTime=startTime+burstTime[i];
        }

        return waitingTime/n;
    }



}