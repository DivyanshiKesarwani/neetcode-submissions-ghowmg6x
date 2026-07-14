class Solution {
    //O(n × n!)time
    //O(n)space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Permutations(nums,0,ans);
        return ans;
    }
    public void Permutations(int[] nums, int idx,List<List<Integer>> ans)
    {

        if(idx==nums.length){
        List<Integer> temp = new ArrayList<>();

            for (int num : nums) {
                temp.add(num);
            }

            ans.add(temp);
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            swap(nums, idx, i);
            Permutations(nums,idx+1,ans);
            swap(nums, idx, i);
        }
    }
    public void swap(int nums[],int idx,int i)
    {
        int temp=nums[idx];
        nums[idx]=nums[i];
        nums[i]=temp;
    }
}
