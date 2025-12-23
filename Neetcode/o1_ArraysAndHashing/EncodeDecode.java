package Neetcode.o1_ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EncodeDecode {
    public static String encode(List<String> strs) {
        // Super corner case scenario
        if(strs.size()==0) return "<>EmptyString</>";
        String collect = strs.stream().collect(Collectors.joining("</>"));
//        System.out.println(collect);
        return collect;

    }

    public static List<String> decode(String str) {
        if("<>EmptyString</>".equals(str)) return new ArrayList<>();
        List<String> collect = Arrays.stream(str.split("</>")).collect(Collectors.toList());
        System.out.println(collect);
        return collect.isEmpty() ? new ArrayList<>() : collect;
    }
}
