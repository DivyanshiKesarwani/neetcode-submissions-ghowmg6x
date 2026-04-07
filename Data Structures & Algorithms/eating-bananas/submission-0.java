class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // find max
        for (int p : piles) {
            right = Math.max(right, p);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int hours = 0;

            for (int p : piles) {
                hours += (p + mid - 1) / mid;  // ceil
            }

            if (hours <= h) {
                right = mid - 1;  // try smaller speed
            } else {
                left = mid + 1;   // need more speed
            }
        }

        return left;
    }
}