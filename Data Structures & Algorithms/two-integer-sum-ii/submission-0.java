class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int arr[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int more=target-nums[i];
            if(hm.containsKey(more))
            {
                arr[0]=hm.get(more)+1;
                arr[1]=i+1;
            }
            else{
                hm.put(nums[i],i);
            }
        }
        return arr;
    }
}
