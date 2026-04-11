class Solution {
    //if using right>=left -->always keep a track of ans
    //if using right>left then after loop ends left==right
    //Never use <= with right = mid → infinite loop
    public int findMin(int[] nums) {
        //mid left is greater go right 
        int left=0;
        int right=nums.length-1;
        while(right>left)
        {
            int mid=(left+right)/2;
      
            if (nums[mid] > nums[right]) {
                // minimum is in right half
                left = mid + 1;
            } else {
                // minimum is in left half (including mid)
                right = mid;
            }
        }
        return nums[right];
    }
}
