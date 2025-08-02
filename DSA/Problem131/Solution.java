package DSA.Problem131;

class Node{
    Node[] bit;
    Node(){
        this.bit = new Node[2];
    }

    public boolean contains(int bit){
        return this.bit[bit]!=null;
    }
}

class Trie{
    Node root;
    Trie(){
        this.root = new Node();
    }

    public void insert(int num){
        Node currNode = this.root;
        for(int i = Solution.NO_OF_BITS; i>=0; i--){
            int bit = (num>>i)&1;
            if(!currNode.contains(bit)){
                Node newNode = new Node();
                currNode.bit[bit] = newNode;
            }
            currNode = currNode.bit[bit];
        }
    }

    public int XOR(int num){
        Node currNode = this.root;
        int maxNum = 0;
        for(int i = Solution.NO_OF_BITS; i>=0; i--){
            int bit = (num>>i)&1;
            int oppBit = bit==1 ? 0 : 1;
            if(currNode.contains(oppBit)){
                maxNum =  maxNum | (1<<i) ; // setting that bit to 1
                currNode = currNode.bit[oppBit];
            } else{
                currNode=currNode.bit[bit];
            }
        }
        return maxNum;
    }
}


public class Solution
{
    public static int NO_OF_BITS = 4;
    public static void main(String[] arr){
        int[] A = new int[]{9,8,7,5,4};
        System.out.print(maximumXor(A));
    }
    public static int maximumXor(int []A) {
        Trie trie = new Trie();
        for(int i=0;i<A.length;i++){
            trie.insert(A[i]);
        }
        int maxXOR=0;
        for(int i=0;i<A.length;i++){
            maxXOR = Math.max(maxXOR,trie.XOR(A[i]));
        }
        return maxXOR;
    }
}