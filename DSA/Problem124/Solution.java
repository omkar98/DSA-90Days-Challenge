package DSA.Problem124;


public class Solution
{

    public static void main(String[] arr){
        int[] s = new int[]{6,5,4,3,2,1};
        int requiredCandies = requiredCandies(s);
        System.out.print(requiredCandies);
    }

    public static int requiredCandies(int[] students) {
        int n = students.length;
        int sum = 1;
        if(n==1) return 1;
        int i=1;
        int peak = 1;
        int down = 1;
        while(i<n) {
            if(students[i]==students[i-1]) {
                i++;
                sum+=1;
                continue;
            }
            peak = 1;
            while(i<n && students[i]>students[i-1]) {
                peak+=1;
                sum+=peak;
                i++;
            }
            down = 1;
            while(i<n && students[i]<students[i-1]) {
                sum+=down;
                down+=1;
                i++;
            }
            if(down>peak) sum+=down-peak;
        }
        return sum;
    }

}