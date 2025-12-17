package StreamsAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transaction {
    String id;
    double amount; // Positive = Credit, Negative = Debit
    String type;   // "CREDIT" or "DEBIT"

    public Transaction(String id, double amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }
    // Getters...
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public String getId() { return id; }

    @Override
    public String toString(){
        return "("+this.getId()+"|"+this.getType()+"|"+this.getAmount()+")";
    }

//    Calculate the total sum of all transaction amounts.
    public static void totalSumOfAllTxnAmt(List<Transaction> transactions) {
        double sum = transactions.stream().mapToDouble(Transaction::getAmount).sum();
        System.out.println(sum);
    }

//    Crucial: Calculate total sum using reduce(Start with identity 0.0).
    public static void totalSumOfAllTxnAmtUsingReduce(List<Transaction> transactions) {
        Double reduce = transactions.stream().map(Transaction::getAmount).reduce(0.0, Double::sum);
        System.out.println(reduce);
    }
    //    Combine all Transaction IDs into one string: "TX1, TX2, TX3..." using reduce.
    public static void combineAllTransactionIDsIntoOneString(List<Transaction> transactions) {
        String reduce = transactions.stream().map(Transaction::getId).reduce("",(acc,next)-> {
            return acc.isEmpty() ? next : acc + "," + next;
        });
        String collect = transactions.stream().map(Transaction::getId).collect(Collectors.joining(","));
        System.out.println(reduce);
    }
    //    Create a List<Integer> of numbers from 1 to 10.
    public static List<Integer> listOfIntegers(int start, int end){
        List<Integer> collect = Stream.iterate(start, (a) -> {
            return (a+1) > end ? a : a + 1;
        }).limit(end-start+1).collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }

    //    Get the Count, Sum, Min, Max, and Average of amounts in ONE go.
    public static void allStats(List<Transaction> transactions) {
        DoubleSummaryStatistics collect = transactions.stream().map(Transaction::getAmount).collect(Collectors.summarizingDouble(a -> a));
        System.out.println(String.format("Count: %s, Sum: %s, Min: %s, Max: %s, Avg: %s", collect.getCount(), collect.getSum(), collect.getMin(), collect.getMax(), collect.getAverage()));
    }

    //    Split transactions into two lists: Credits (True) and Debits (False).
    public static void splitTxnInTwoLists(List<Transaction> transactions) {
        Map<Boolean, List<String>> collect = transactions.stream().collect(Collectors.partitioningBy(txn -> "CREDIT".equals(txn.getType()), Collectors.mapping(Transaction::getId, Collectors.toList())));
        System.out.println(collect);
    }

    //    Group by Type, but I want a List of Amounts, not Transactions.
    public static Map<String, List<Double>> groupByType(List<Transaction> transactions) {
        Map<String, List<Double>> collect = transactions.stream().collect(Collectors.groupingBy(Transaction::getType, Collectors.mapping(Transaction::getAmount, Collectors.toList())));
        System.out.println(collect);
        return collect;
    }
    //    Convert the list of IDs into a String[] array.
    public static String[] stringListToStringArrayIDs(List<Transaction> transactions) {
        String[] array = transactions.stream().map(Transaction::getId).collect(Collectors.toList()).toArray(new String[0]);
        Arrays.stream(array).forEach((s)-> System.out.print(s));
        return array;
    }
    //    Sort by amount (desc), skip the highest one, and take the next 2.
    public static List<Transaction> sortTxnByAmtThenSkipByAndTakeNextOf(List<Transaction> transactions, int skip, int nextOf){
        List<String> collect = transactions.stream().sorted(Comparator.comparingDouble(Transaction::getAmount)).skip(skip).limit(nextOf).collect(Collectors.mapping(Transaction::getId, Collectors.toList()));
        List<Transaction> collect1 = transactions.stream().sorted(Comparator.comparingDouble(Transaction::getAmount)).skip(skip).limit(nextOf).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect1);
        return collect1;
    }

}
