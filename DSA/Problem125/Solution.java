package DSA.Problem125;


import java.util.Arrays;
import java.util.Comparator;

class Pair
{
    int value;
    int weight;
    Pair(int weight, int value)
    {
        this.weight = weight;
        this.value = value;
    }

}
public class Solution
{
    public static void main(String[] arr){
        Pair[] pairs = new Pair[6];
        pairs[0] = new Pair(50, 40);
        pairs[1] = new Pair(40, 50);
        pairs[2] = new Pair(90, 25);
        pairs[3] = new Pair(120, 100);
        pairs[4] = new Pair(10, 30);
        pairs[5] = new Pair(200, 45);

        double value = maximumValue(pairs, pairs.length, 200);
        System.out.print(value);
    }

    public static double maximumValue(Pair[] items, int n, int w) {
        double totalValue = 0;
        double totalWeight = 0;
        // If you donot change it to double, the comparator would otherwise find the valuePerWeight in int (floor value) and give you incorrect results.
        // example: (25/90) = 0.27. But you get 0.
        Arrays.sort(items, (item1, item2) -> {
            return Double.compare((double)item2.value / item2.weight, (double)item1.value / item1.weight);
        });
        for(int i=0; i<n;i++){
            if(totalWeight<=w) {
                if(totalWeight+items[i].weight>w) {
                    double perWeightValue = ((double) items[i].value / items[i].weight);
                    double pendingWeight = (w-totalWeight);
                    totalValue+=pendingWeight*perWeightValue;
                    totalWeight+=pendingWeight;
                    break;
                } else {
                    totalWeight+=items[i].weight;
                    totalValue+=items[i].value;
                }
            }
        }
        return totalValue;
    }

}