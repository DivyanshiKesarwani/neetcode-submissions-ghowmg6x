class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] ans1 = new int[26];
        int[] ans2 = new int[26];

        // freq of s1
        for (int i = 0; i < n1; i++) {
            ans1[s1.charAt(i) - 'a']++;
            ans2[s2.charAt(i) - 'a']++; // first window
        }

        // 🔥 NEW: matches variable
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (ans1[i] == ans2[i]) matches++;
        }
        if(matches==26)return true;

        int low = 0;
        int high = n1 - 1;

        while (high < n2 - 1) {

            if (matches == 26) return true;

            low++;
            high++;

            // 👉 ADD new char
            int index = s2.charAt(high) - 'a';
            ans2[index]++;
            if (ans2[index] == ans1[index]) matches++;
            else if (ans2[index] == ans1[index] + 1) matches--;

            // 👉 REMOVE old char
            index = s2.charAt(low - 1) - 'a';
            ans2[index]--;
            if (ans2[index] == ans1[index]) matches++;
            else if (ans2[index] == ans1[index] - 1) matches--;
        }

        return matches == 26;
    }
}