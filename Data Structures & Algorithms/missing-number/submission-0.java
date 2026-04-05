class Solution {
    public int missingNumber(int[] nums) {
        int sum=0,total=0;
        int n=nums.length;
      for(int i:nums)
      {
        sum=sum+i;
      }  
      for(int i=1;i<=n;i++)
      { 
        total=i+total;
      }
      return total-sum;
    }
}
