package DSA.Problem127;

class Node {
    Node[] links;
    int endsWith;
    int prefixWith;

    Node(Node[] links, int endsWith, int prefixWith){
        this.links = links;
        this.endsWith = endsWith;
        this.prefixWith = prefixWith;
    }

    Node(int endsWith, int prefixWith){
        this.links = new Node[26];
        this.endsWith = endsWith;
        this.prefixWith = prefixWith;
    }

    public boolean containsNode(int index){
        return this.links[index]!=null;
    }

    public Node addNode(int index){
        Node newNode = new Node(0, 1);
        this.links[index] = newNode;
        return newNode;
    }

    public Node getNode(int index){
        return this.links[index];
    }
}

class Trie {
    private Node root;
    public Trie() {
         this.root = new Node( 0, 0);
    }

    public Node getRoot(){
        return this.root;
    }

    public void insert(String word) {
        int wordLen = word.length();
        Node currNode = getRoot();

        for(int i=0; i<wordLen; i++){
            currNode = insertNode(currNode, word.charAt(i));
        }
        currNode.endsWith++;
    }

    public Node insertNode(Node currNode, char letter){
        int index = letter-'a';
        if(!currNode.containsNode(index)) {
            currNode = currNode.addNode(index);
        } else {
            currNode = currNode.getNode(index);
            currNode.prefixWith++;
        }
        return currNode;
    }

    public int countWordsEqualTo(String word) {
        int wordLen = word.length();
        Node currNode = getRoot();
        for(int i=0;i<wordLen; i++){
            int index = word.charAt(i)-'a';
            currNode = currNode.getNode(index);
            if(currNode==null) return 0;
        }
        return currNode.endsWith;
    }

    public int countWordsStartingWith(String word) {
        int wordLen = word.length();
        Node currNode = getRoot();
        for(int i=0;i<wordLen; i++){
            int index = word.charAt(i)-'a';
            currNode = currNode.getNode(index);
            if(currNode==null) return 0;
        }
        return currNode.prefixWith;
    }

    public void erase(String word) {
        int wordLen = word.length();
        Node currNode = getRoot();
        for(int i=0; i<wordLen; i++){
            deleteWordLetter(currNode, word.charAt(i));
            currNode = currNode.getNode(word.charAt(i)-'a');
            if(currNode==null) return;
        }
        if(currNode.endsWith>0) currNode.endsWith--;
    }

    public void deleteWordLetter(Node currNode, char letter) {
        int index = letter-'a';
        if(currNode.containsNode(index)) {
            currNode.prefixWith--;
            if (currNode.prefixWith == 0 && currNode.getNode(index).endsWith == 0) {
                currNode.links[index] = null;
            }
        }
    }

}


public class Solution
{
    public static void main(String[] arr){
        Trie trie = new Trie();
        trie.insert("apps");
        trie.insert("apps");
        trie.insert("apps");
        System.out.println(trie.countWordsEqualTo("apps"));
        System.out.println(trie.countWordsStartingWith("app"));
        trie.erase("apps");
        System.out.println(trie.countWordsEqualTo("apps"));
        System.out.println(trie.countWordsStartingWith("a"));
    }
}