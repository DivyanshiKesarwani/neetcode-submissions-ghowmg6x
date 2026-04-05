class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount=0;
        int prod=1;
        int n=nums.length;
        int arr[]=new int[n];
        for(int i:nums)
        {
            if(i==0)
            {
                zeroCount++;
            }
            else{
                    prod=prod*i;
            }
        }

        for(int i=0;i<n;i++)
        {
            if(zeroCount==1)
            {
                if(nums[i]==0)
                {arr[i]=prod;}
                else
                {
                    arr[i]=0;
                }
            }
            else if(zeroCount>1)
            {
                arr[i]=0;
            }
            else{
                arr[i]=prod/nums[i];
            }
        }
        return arr;
    }
}  
