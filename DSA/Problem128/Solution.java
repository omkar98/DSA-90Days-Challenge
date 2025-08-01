package DSA.Problem128;

import java.util.Arrays;

class Node{
    Node[] links;
    boolean end;
    Node(){
        this.links = new Node[26];
        end = false;
    }
}

class Trie {
    Node root;
    Trie(){
        this.root = new Node();
    }

    public void insert(String str){
        int strLeng = str.length();
        Node currNode = this.root;
        for(int i=0; i<strLeng; i++){
            int letterIndex = str.charAt(i) - 'a';
            if(currNode.links[letterIndex]==null){
                Node newNode = new Node();
                currNode.links[letterIndex] = newNode;
            }
            currNode = currNode.links[letterIndex];
        }
        currNode.end = true;
    }

    public boolean commonPrefix(String str){
        int strLeng = str.length();
        Node currNode = this.root;
        for(int i=0; i<strLeng; i++){
            int letterIndex = str.charAt(i) - 'a';
            currNode = currNode.links[letterIndex];
            if(currNode==null || !currNode.end){
                return false;
            }
        }
        return true;
    }

}

public class Solution
{

    public static String completeString(int n, String[] a) {
        Trie trie = new Trie();
        for(int strNo=0; strNo<n;strNo++){
            String str = a[strNo];
            trie.insert(str);
        }
        String longestPrefixString = "";
        for(int strNo=0; strNo<n;strNo++){
            String str = a[strNo];
            boolean isCommon = trie.commonPrefix(str);
            if(isCommon && longestPrefixString.length()<=str.length()) {
                if(longestPrefixString.length()==str.length() && !longestPrefixString.isBlank()){
                    String[] strArr = new String[2];
                    strArr[0] = longestPrefixString;
                    strArr[1] = str;
                    Arrays.sort(strArr);
                    longestPrefixString = strArr[0];
                } else {
                    longestPrefixString = str;
                }
            }
        }
        return longestPrefixString.isBlank() ? "None" : longestPrefixString;
    }

    public static void main(String[] arr){
        String[] a = new String[]{ "g" ,"l", "lm", "ga", "lmn", "gaz"};
        System.out.print(completeString(a.length, a));
    }
}