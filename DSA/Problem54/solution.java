package DSA.Problem54;

public class  solution {
    public static long kthGenCount = 0;
    public static boolean kthGenGender;
    public static void main(String[] args) {
        System.out.println(kthChildNthGeneration(3, 4));

    }

    public static String kthChildNthGeneration(int n, long k) {
        // Write your code here
        boolean gen = getGen(true, 1,1, n, k);
        return kthGenGender ? "Male" : "Female";
    }


    public static boolean getGen(boolean gender, int generation, long kGen, int reqGen, long reqKGen) {
        if(generation==reqGen) {
            kthGenCount+=1;
            if(kthGenCount==reqKGen) kthGenGender = gender;
            kthGenCount+=1;
            if(kthGenCount==reqKGen) kthGenGender = !gender;
            return gender;
        }
        // Male
        if(gender) {
            getGen(true, generation+1, kGen, reqGen, reqKGen);
            getGen(false, generation+1, kGen, reqGen, reqKGen);
        }
        // Female
        else {
            getGen(false, generation+1, kGen, reqGen, reqKGen);
            getGen(true, generation+1, kGen, reqGen, reqKGen);
        }
        return true;
    }
}





