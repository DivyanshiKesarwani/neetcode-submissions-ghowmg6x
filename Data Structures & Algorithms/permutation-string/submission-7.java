class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();

        if(n1>n2)return false;
        int ans1[]=new int[26];
        int ans2[]=new int[26];

        for(int i=0;i<n1;i++)
        {
            ans1[s1.charAt(i)-'a']++;
            ans2[s2.charAt(i)-'a']++;
        }
        int matches=0;
        int low=0;
        for(int i=0;i<26;i++)
        {
            if(ans1[i]==ans2[i])matches++;
        }

        for(int i=n1;i<n2;i++)
        {
            if(matches==26)return true;

            //add new
            int idx=s2.charAt(i)-'a';
            ans2[idx]++;
            if(ans2[idx]==ans1[idx])matches++;
            else if(ans2[idx]==ans1[idx]+1)matches--;

            //remove old
            idx=s2.charAt(low)-'a';
            ans2[idx]--;
            if(ans2[idx]==ans1[idx])matches++;
            else if(ans2[idx]==ans1[idx]-1)matches--;
            low++;
        }
        return matches==26;
    }
}
