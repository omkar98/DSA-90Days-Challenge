package DSA.Problem19;

import java.util.*;
import java.util.stream.Collectors;

public class  solution {
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,3,5,4,5,3,4));
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"));
        System.out.println(getGroupedAnagrams(arr, arr.size()));

    }

    public static ArrayList<ArrayList<String>> getGroupedAnagrams(ArrayList<String> inputStr, int n) {
        Map<String, ArrayList<String>> hashMap = new HashMap<>();
        // load the hashMap
        for(int i=0; i<n;i++) {
            String input = inputStr.get(i);

            char[] key = new char[26];
            input.chars().forEach(letter -> key[letter%'a'] +=  1);
            String keyString = new String(key).chars()
                    .mapToObj(ch -> String.valueOf(ch))
                    .collect(Collectors.joining("."));

            if(hashMap.containsKey(keyString)) {
                ArrayList<String> value = hashMap.get(keyString);
                if(value.isEmpty()) value = new ArrayList<>();
                value.add(input);
            } else {
                ArrayList<String> value = new ArrayList<>(List.of(input));
                hashMap.put(keyString, value);
            }
        }
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        hashMap.forEach((key, values) -> {
            output.add(values);
        });
        return output;
    }
}



