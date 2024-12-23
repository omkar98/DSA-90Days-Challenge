package DSA.Problem06;

public class solution {
    public static void main(String[] args) {
        String input = "Welcome to Coding Ninjas";
        System.out.println(reverseStringWordWise(input));
    }

    public static String reverseStringWordWise(String input) {
//        String[] inputStringList = input.split(" ");
//        int size = inputStringList.length;
//        StringBuilder sb = new StringBuilder();
//        for(int i=size-1; i>=0;i--) {
//            sb.append(inputStringList[i]);
//            sb.append(" ");
//        }
//        return sb.toString();


        String[] inputStringList = input.split(" ");
        int size = inputStringList.length;
        for(int i=0;i<inputStringList.length/2;i++) {
            swap(inputStringList, i, size-1-i);
        }
        return String.join(" ", inputStringList);

//        // Ready-made function:
//        List<String> inputStringList = Arrays.asList(input.split(" "));
//        Collections.reverse(inputStringList);
//        return String.join(" ", inputStringList);


    }

    public static void swap(String[] input, int index1, int index2) {
        String temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
}

