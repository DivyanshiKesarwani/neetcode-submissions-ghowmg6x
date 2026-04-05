class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        int res1[]=new int[n];
        res[0]=1;
        //left
        for(int i=1;i<n;i++)
        {
          res[i] = res[i - 1] * nums[i - 1];
        }
        //{1,1,2,8}
        //{48,24,6,1}
        //right
        int result=1;
        // for(int i=n-1;i>=0;i--)
        // {
        //   res[i] = res[i] * result;
        //   result=result*nums[i];
        // }
       
        res1[n-1] = 1;
        for(int i = n-2; i >= 0; i--)
        {
             res1[i] = res1[i + 1] * nums[i + 1];
        }
        for(int i=0;i<n;i++)
        {
            nums[i]=res[i]*res1[i];
        }
        return nums;
    }
}  
