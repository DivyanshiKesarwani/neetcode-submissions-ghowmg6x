class Solution {
    //window-most frequent<=k-->update res with window
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>hm=new HashMap<>();
        int l=0;
        int res=0;
        for(int r=0;r<s.length();r++)
        {
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)+1);
            int maxFreq = 0;
            for (int val : hm.values()) {
                maxFreq = Math.max(maxFreq, val);
            }
            if((r-l+1)-maxFreq>k)
            {
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                l=l+1;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}
