class Solution {
    public int missingNumber(int[] nums) {
        int xor=0;
        int n=nums.length;
        int total=n*(n+1)/2;
      for(int i:nums)
      {
        xor=xor^i;
      }  
       for(int i=1;i<=n;i++)
      { 
       xor=xor^i;
      }
      return xor;
    }
}
