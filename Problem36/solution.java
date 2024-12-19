package Problem36;

public class  solution {
    public static void main(String[] args) {
        String s = "dajidas988ksajlkdn908";
//        String s="ab5n3";
        System.out.println(kThCharaterOfDecryptedString(s,9000L));
    }

    public static char kThCharaterOfDecryptedString(String s, Long k) {
        long n = s.length();
        long idxOfPrevDigit = -1;
        long extendedSum = 1; // because it is starting from 1-based indexing
        int i=0;
        char finalCh = '\0';
        while(i<n) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int start=i;
                while(i<n && Character.isDigit(s.charAt(i))) i++;
                int end = i;
                Long freq = Long.valueOf(s.substring(start, end));
                long chars = (start) - (idxOfPrevDigit) - 1;
                long totalCharSum = chars*freq;
                long prevSum = extendedSum;
                extendedSum+=totalCharSum;
                long oldPrevDigit = idxOfPrevDigit;
                idxOfPrevDigit = end-1;

                if(extendedSum>=k) {
                    long diff = k-prevSum;
                    finalCh = s.substring((int)oldPrevDigit+1, start).charAt((int) (diff%chars));
                    return finalCh;
                }
            }
            i++;
        }
        return finalCh;
    }
}





