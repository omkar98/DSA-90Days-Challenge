package DSA.Problem126;




class Trie {

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public Node[] getLinks(){
            return this.links;
        }

        public boolean containsKey(char key){
            int index = key-'a';
            if(links[index]!=null){
                return true;
            }
            return false;
        }

        public Node keyNode(Node node, char key){
            if(node.containsKey(key)){
                int index  = getIndex(key);
                return node.links[index];
            }
            return null;
        }

        public int getIndex(char key){
            return key-'a';
        }
    }

    private static Node root;
    //Initialize your data structure here
    Trie() {
        root = new Node();
    }

    public static Node[] getLinks(Node root){
        return root.getLinks();
    }

    public static void createNewNode(Node node, char letter){
        int index = node.getIndex(letter);
        Node[] links = node.getLinks();
        Node newNode = new Node();
        links[index] = newNode;
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        Node node = root;
        int wordLength = word.length();
        for(int i=0; i<wordLength; i++){
            char letter = word.charAt(i);
            if(node.containsKey(letter)){
                node = node.keyNode(node, letter);
            } else {
                createNewNode(node, letter);
                node.flag = false;
                node = node.keyNode(node, letter);
            }
        }
        node.flag = true;
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        Node node = root;
        int wordLength = word.length();
        for(int i=0; i<wordLength; i++){
            char letter = word.charAt(i);
            if(!node.containsKey(letter)){
                return false;
            }
            node = node.keyNode(node, letter);
        }
        return node.flag;
    }


    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String prefix) {
        Node node = root;
        int wordLength = prefix.length();
        for(int i=0; i<wordLength; i++){
            char letter = prefix.charAt(i);
            if(!node.containsKey(letter)){
                return false;
            }
            node = node.keyNode(node, letter);
        }
        return true;
    }
}


public class Solution
{
    public static void main(String[] arr){
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("applek");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("applek"));
    }



}