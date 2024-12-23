package DSA.Problem43;

public class  solution {
    public static void main(String[] args) {
//        int[] arr = {2,6,3,4,1,12};
//        int[] arr = {4,1,7,2,6,5};
//        int[] arr = {1,4,6,3,2};
        String a = "123";
        String b = "459";
        System.out.print(multiplyStrings(a,b));

    }

    public static String multiplyStrings(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        if(lengthA == 1 && a.equals("0") || lengthB == 1 && b.equals("0")) return "0";
        if(lengthA == 1 && a.equals("1") ) return b;
        if(lengthB == 1 && b.equals("1") ) return a;
        int arraySize = lengthA+lengthB;
        int[] output = new int[arraySize];

        for(int i=lengthB-1; i>=0; i--) {
            int valueA = (int) b.charAt(i) - '0';
            for(int j=lengthA-1; j>=0; j--) {
                int valueB = (int) a.charAt(j) - '0';
                int charArrayIdx = (i+1) + (j+1) - 1;
                int carryIdx = charArrayIdx - 1;
                int prod = (valueA*valueB)+ output[charArrayIdx];
                int value = prod%10;
                int currentCarry = prod/10;

                output[charArrayIdx] =  (value);
                output[carryIdx] += currentCarry;

            }
        }
        StringBuilder sb = new StringBuilder();
        boolean startingZero = true;
        for(int i=0; i<output.length; i++) {
            if(output[i]!=0 || !startingZero) {
                sb.append(output[i]);
                startingZero=false;
            }
        }
        return sb.toString();
    }
}





