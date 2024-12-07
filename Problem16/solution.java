package Problem16;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class  solution {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));

    }

    public static int firstUniqChar(String s){
        Map<Character, Integer> hashMap = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++) {
            hashMap.computeIfPresent(s.charAt(i), (key, value) -> value+1);
            hashMap.computeIfAbsent(s.charAt(i), value->0);
        }
        AtomicReference<Character> letter = new AtomicReference<>('\0');
        for(Map.Entry<Character, Integer> pair : hashMap.entrySet()) {
            if(pair.getValue()==0) {
                letter.set(pair.getKey());
                break;
            }
        }
        return letter.get()!='\0' ? s.indexOf(letter.get()) : -1;

    }
}



