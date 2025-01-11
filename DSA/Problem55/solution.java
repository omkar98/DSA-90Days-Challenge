package DSA.Problem55;

import java.util.ArrayList;
import java.util.List;

public class  solution {
    public static List<String> finalList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(generateString(4));

    }

    public static List< String > generateString(int N) {
        stringAtLevel(N, "",1,'0');
        stringAtLevel(N, "",1,'1');
        return finalList;
    }

    public static void stringAtLevel(int N, String currentString, int currentLevel, char currentBinary) {
        String finalString = currentString + currentBinary;
        if(currentLevel==N) {
            finalList.add(finalString);
            return;
        }

        if(currentBinary=='1') {
            stringAtLevel(N, finalString,currentLevel+1,'0');
        }
        else {
            stringAtLevel(N, finalString,currentLevel+1,'0');
            stringAtLevel(N, finalString,currentLevel+1,'1');
        }
    }
}





