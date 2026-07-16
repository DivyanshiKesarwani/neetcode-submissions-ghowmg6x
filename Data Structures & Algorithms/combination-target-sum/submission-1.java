class Solution {
//     Time	O(2^(target/min) × (target/min))
// Auxiliary Space	O(target/min)
// Including Output	Exponential
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
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
        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i]==nums[i-1])
            continue;
            if(nums[i]>target)
            break;
            curr.add(nums[i]);
            Sum(target-nums[i],nums,i,curr,ans);
            curr.remove(curr.size()-1);
            //Sum(target,nums,i+1,curr,ans);
        }
    }
}
