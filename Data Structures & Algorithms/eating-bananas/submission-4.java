class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int max = Integer.MIN_VALUE;
         int low=1;
         int ans=Integer.MIN_VALUE;
        // find max pile
        for (int p : piles) {
            max = Math.max(max, p);
        }
        int high=max;
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            int hours=Hours(piles,mid);
            if(hours<=h)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;

    }
    public int Hours(int []piles,int k)
    {
        int hours=0;
        for (int p : piles) {
                hours += (int)Math.ceil((double)p/(double)k);//(p + k - 1) / k;   // correct ceil
            }
            return hours;
    }
}
