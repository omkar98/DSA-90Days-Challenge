package DSA.Problem07;

public class solution {
    public static void main(String[] args) {
        String input = "aaaabbbccd";
        System.out.println(encode(input));
    }

    public static String encode(String message) {
        int size = message.length();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int i=0; i<size;i++){
            counter++;
            char currentChar = message.charAt(i);
            char nextChar = i!=size-1 ? message.charAt(i+1) : '\0';
            if(nextChar!=currentChar) {
                sb.append(currentChar);
                sb.append(counter);
                counter = 0;
            }
        }
        return sb.toString();
    }
}

