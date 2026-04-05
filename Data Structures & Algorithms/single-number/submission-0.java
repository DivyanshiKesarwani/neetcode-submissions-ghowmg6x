class Solution {
    public int singleNumber(int[] nums) {
        
        int xor=0;//xor with 0 is same number//1^1=0;0^1=0
        for(int i=0;i<nums.length;i++)
        {
            xor=xor^nums[i];
        }
        return xor;
    }
}
