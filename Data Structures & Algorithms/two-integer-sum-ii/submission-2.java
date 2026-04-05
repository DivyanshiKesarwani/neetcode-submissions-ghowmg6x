class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int n=nums.length;
        int right=n-1;
        int arr[]=new int[2];
        while(left<right)
        {
            int sum=nums[left]+nums[right];
            if(sum==target)
            {
                   return new int[] {left+1,right+1};
            }
            else if(sum<target)
            {
                    left++;
            }
            else{
                right--;
            }
        }
        return arr;
    }
}
