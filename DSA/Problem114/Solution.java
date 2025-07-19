package DSA.Problem114;

import java.util.Stack;


public class Solution
{

    public static void main(String[] arr){
        int [] bill = new int[]{5,5,5,10,10,20};
        System.out.print(lemonadeChange(bill));
    }

    public static boolean lemonadeChange(int []bill) {
        int totalBills = bill.length;
        int fives = 0;
        int tens = 0;
        for(int i=0; i<totalBills; i++) {
           switch(bill[i]){
               case 5:
                   fives++;
                   break;
               case 10:
                   if(fives>0) {
                       fives--;
                       tens++;
                   }
                   else return false;
                   break;
               case 20:
                   if(fives>0 && tens>0) {
                       fives--;
                       tens--;
                   } else if(fives>2) {
                       fives-=3;
                   }
                   else return false;
                   break;
               default:
                   return false;
           }
        }
        return true;
    }



}