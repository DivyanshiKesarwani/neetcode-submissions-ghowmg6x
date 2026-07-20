class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>arr=new ArrayList<>();
        String s="";
        backtrack(s,0,0,arr,n);
        return arr;
    }
    public void backtrack(String s, int open,int close,List<String>arr,int n)
    {
        if(open==n && close==n)
        {
            arr.add(s);
            return;
        }
        if(open<n)
        {
            backtrack(s+"(",open+1,close,arr,n);
        }
        if(close<open)
        {
            backtrack(s+")",open,close+1,arr,n);
        }
    }
}
