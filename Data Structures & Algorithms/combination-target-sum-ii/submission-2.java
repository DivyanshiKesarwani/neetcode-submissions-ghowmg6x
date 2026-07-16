class Solution {
    HashSet<List<Integer>>hs=new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> curr=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Sum(target,nums,0,curr,ans);
        return ans;
    }
    public void Sum(int target,int[] nums,int idx,List<Integer> curr,
    List<List<Integer>> ans)
    {
        
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0)
        {
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i]==nums[i-1])
            continue;

            if(nums[i]>target)
            break;

            curr.add(nums[i]);
            Sum(target-nums[i],nums,i+1,curr,ans);
            curr.remove(curr.size()-1);
        }
        
    }
}    

