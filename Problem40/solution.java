package Problem40;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class  solution {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(lengthOfLongestConsecutiveSequence(arr, arr.length));
    }

    public static int lengthOfLongestConsecutiveSequence(int[] arr, int n) {
        HashSet<Integer> hashSet = Arrays.stream(arr).boxed().collect(Collectors.toCollection(HashSet::new));
        int globalLongSub = 0;
        for (Integer i : hashSet) {
            if(!hashSet.contains(i-1)) {
                int num = i;
                int subSeq = 1;
                while(hashSet.contains(num+1)) {
                    num++;subSeq++;
                }
                if(globalLongSub<subSeq) globalLongSub = subSeq;
            }
        }
        return globalLongSub;
    }
}





