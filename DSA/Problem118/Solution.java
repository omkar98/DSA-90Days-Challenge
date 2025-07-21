package DSA.Problem118;


import java.util.Arrays;

public class Solution
{

    public static void main(String[] arr){
        int [][] jump = new int[][] {{1, 1, 30}, {2, 3, 40}, {3, 2, 10}};
        int[] result = jobScheduling(jump);
        System.out.print(result);
    }

    public static int[] jobScheduling(int [][]jobs) {
        Arrays.sort(jobs, (a,b)->compareJobs(a,b));
        int maxDeadline = maxDeadline(jobs);
        if(maxDeadline==-1) return new int[]{};
        int[] hashMap = new int[maxDeadline];
        Arrays.fill(hashMap,-1);
        int maxProfit = 0;
        int maxJobs = 0;
        for(int i=0; i<jobs.length; i++){
            int deadline = jobs[i][1];
            for(int j=deadline; j>0;j--){
                if(hashMap[j-1]==-1){
                    hashMap[j-1]=deadline;
                    maxJobs++;
                    maxProfit+=jobs[i][2];
                    break;
                }
            }
        }
        return new int[]{maxJobs, maxProfit};
    }

    public static int compareJobs(int[] jobA, int[] jobB){
        return jobB[2]-jobA[2];
    }

    public static int maxDeadline(int[][] jobs){
        int maxDeadline = -1;
        for(int i=0; i<jobs.length; i++){
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }
        return maxDeadline;
    }
}