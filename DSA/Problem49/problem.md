One thing I learnt here, low can always be trusted when returning from BS.

Brute Force:
```declarative
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		ArrayList<Integer> linear = new ArrayList<>();
		int n = matrix.size();
		int m= matrix.get(0).size();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				linear.add(matrix.get(i).get(j));
			}
		}
		Collections.sort(linear);
		return linear.get((n*m)/2);
	}
}
```
corner case: 
```declarative
5 5
2 2 2 2 2
2 2 2 2 2
2 2 2 2 2
2 2 2 2 2
2 2 2 2 2  
```

