class PrefixTree {
    class Node{
        Node[] children;
        boolean eow;

        public Node() {
        children=new Node[26];
        for(int i=0;i<26;i++)
        {
            children[i]=null;
        } 
        eow=false;
    }
    }

    
    Node root;
    public PrefixTree()
    {
         root=new Node();
    }

    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++)
        {
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null)
            {
                curr.children[idx]=new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];
        }
    }

    public boolean search(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++)
        {
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null)
            {
                return false;
            }
            if(i==word.length()-1 && curr.children[idx].eow==false)
            {
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

    public boolean startsWith(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++)
        {
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null)
            {
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

}
