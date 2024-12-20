package Problem38;

import java.util.ArrayList;
import java.util.HashSet;

public class  solution {
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10,5,5,6,2));
        int[] arr = {1,2,3,1,2,3};
        System.out.println(findTriplets(arr, arr.length));
    }

    public static ArrayList<Integer> findTriplets(int[] nums, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if(n<2)  return result;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                // Calculate the required third value to form a triplet
                int sum = nums[i] + nums[j]; // x + y = sum
                int x = nums[i] - nums[j]; // sum - y = x
                int y = nums[j] - nums[i]; // sum - x = y


                // Check if any of these values exist in the set
                if (seen.contains(sum) || seen.contains(x) || seen.contains(y)) {
                    result.add(nums[i]);
                    result.add(nums[j]);
                    if(seen.contains(sum)) result.add(sum);
                    else if(seen.contains(x)) result.add(x);
                    else if(seen.contains(y)) result.add(y);
                    return result;
                }

                // Add current element nums[j] to the set
                seen.add(nums[j]);
            }
        }
        return result;
    }
}





