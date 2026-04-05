class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int l = 0;
        int res = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {

            char ch = s.charAt(r);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            // update max frequency
            maxFreq = Math.max(maxFreq, hm.get(ch));

            // shrink window if invalid
            if ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                hm.put(leftChar, hm.get(leftChar) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}