class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        int max=0;
        for(int i:nums)
        {
            hs.add(i);
        }
        for(int i : hs)
        {
            // Check if it's a starting point
            if(!hs.contains(i - 1))
            {
                int length = 1;       // reset for each sequence
                int current = i;

                // Expand sequence
                while(hs.contains(current + 1))
                {
                    current++;
                    length++;
                }

                max = Math.max(max, length);
            }
        }
       return max;
    }
}
