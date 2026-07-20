class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        ArrayList<String>curr=new ArrayList<>();
        backtrack(s,0,curr,ans);
        return ans;
    }
    public void backtrack(String s,int idx,ArrayList<String>curr,List<List<String>>ans)
    {
        if(idx==s.length())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            if(isPalindrome(s, idx, i))
            {
                curr.add(s.substring(idx, i + 1));

                backtrack(s, i + 1, curr, ans);

                curr.remove(curr.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right) {

    if (left >= right)
        return true;

    if (s.charAt(left) != s.charAt(right))
        return false;

    return isPalindrome(s, left + 1, right - 1);
}
}
