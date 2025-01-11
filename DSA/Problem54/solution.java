package DSA.Problem54;

public class  solution {
    public static long kthGenCount = 0;
    public static boolean kthGenGender;
    public static void main(String[] args) {
        System.out.println(kthChildNthGeneration(2, 2));

    }

    public static String kthChildNthGeneration(int n, long k) {
        boolean gender = true; // true for male
        while(n>1) {
            if(k%2==0) {
                gender = !gender;
            }
            k = (long) Math.ceil((double) k /2);
            n--;
        }
        return gender ? "Male" : "Female";
    }
}





