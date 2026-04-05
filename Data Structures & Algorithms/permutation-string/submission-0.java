class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] ans1 = new int[26];
        int[] ans2 = new int[26];

        // frequency of s1
        for (int i = 0; i < n1; i++) {
            ans1[s1.charAt(i) - 'a']++;
        }

        // first window of s2
        for (int i = 0; i < n1; i++) {
            ans2[s2.charAt(i) - 'a']++;
        }

        // check initial window
        if (matches(ans1, ans2)) return true;

        int low = 0;
        int high = n1 - 1;

        // slide window high < n2 - 1 ensures high++ stays inside string
        while (high < n2 - 1) {
            low++;
            high++;

            // add new char
            ans2[s2.charAt(high) - 'a']++;

            // remove old char
            ans2[s2.charAt(low - 1) - 'a']--;

            if (matches(ans1, ans2)) return true;
        }

        return false;
    }

    // helper function to compare arrays
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}