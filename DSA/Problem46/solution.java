package DSA.Problem46;

public class  solution {
    public static void main(String[] args) {
        System.out.println(sqrtN(49));

    }

    public static int sqrtN(long N) {
        long left = 0;
        long right = N;
        boolean sqrtFound = false;
        int ans = 0;
        if(N==0) return 0;
        if(N==1 || N==2) return 1;
        while(left<right) {
            long mid = (long) Math.floor((left+right)/2);
            if (mid*mid == N) {
                return (int) mid;
            }
            if (mid == left) {
                return (int) left;
            }
            else if(mid*mid <= N) {
                left = mid;
                sqrtFound = true;
            } else if(mid*mid > N) {
                right = mid;
                if(sqrtFound) ans = (int) left;
            }
        }
        return ans;
    }
}





