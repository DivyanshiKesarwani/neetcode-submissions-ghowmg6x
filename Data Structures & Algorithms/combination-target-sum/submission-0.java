class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Sum(target,nums,0,curr,ans);
        return ans;
    }
    public void Sum(int target,int[] nums,int idx,List<Integer> curr,
    List<List<Integer>> ans)
    {
        if(idx==nums.length || target<0)
        {
            return;
        }
        if(target==0)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        Sum(target-nums[idx],nums,idx,curr,ans);
        curr.remove(curr.size()-1);
        Sum(target,nums,idx+1,curr,ans);

    }
}
