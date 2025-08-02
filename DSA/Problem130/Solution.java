package DSA.Problem130;
class Node {
    Node[] links;
    Node(){
        this.links = new Node[26];
    }
}

class Trie {
    Node root;
    int distinctNodes = 0;
    Trie(){
        this.root = new Node();
    }
    public Node insert(Node node, char letter) {
        int index = letter - 'a';
        if(node.links==null || node.links[index]==null){
            Node newNode = new Node();
            this.distinctNodes++;
            node.links[index] = newNode;
        }
        return  node.links[index];
    }
}

public class Solution
{
    public static void main(String[] arr){
        System.out.print(distinctSubstring("abc"));
    }
    public static int distinctSubstring(String word) {
        Trie trie = new Trie();
        Node currNode = trie.root;
        int wordLen = word.length();

        for(int i=0; i<wordLen; i++){
            currNode = trie.root;
            for(int j=i; j<wordLen; j++){
                currNode = trie.insert(currNode, word.charAt(j));
            }
        }
        return trie.distinctNodes;
    }
}