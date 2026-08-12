class WordDictionary {
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
    public WordDictionary()
    {
         root=new Node();
    }
    
    public void addWord(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++)
        {
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null)
            {
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public boolean dfs(String word,int idx,Node curr)
    {
        if (idx == word.length()) {
            return curr.eow;
        }
        char ch=word.charAt(idx);
        if(ch!='.')
        {
            int childIdx = ch - 'a';
            if(curr.children[childIdx]==null)
            {
                return false;
            }
            return dfs(word,idx+1,curr.children[childIdx]);
        }
        for(int i=0;i<26;i++)
        {
            if(curr.children[i]!=null)
            {
                if (dfs(word, idx + 1, curr.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(String word) {
      return dfs(word,0,root);
    }
}