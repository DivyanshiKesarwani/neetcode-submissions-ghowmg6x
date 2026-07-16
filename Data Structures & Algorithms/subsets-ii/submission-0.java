class Solution {
    //Time Complexity: O(n × 2ⁿ)
    //Time complexity = (Number of answers) × (Cost to copy one answer).
    HashSet<List<Integer>>hs=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        generateSubsets(nums, 0, curr, ans);

        return ans;
    }

    public void generateSubsets(
            int[] nums,
            int idx,
            List<Integer> curr,
            List<List<Integer>> ans) {          
                    
         ans.add(new ArrayList<>(curr));
                

        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx &&nums[i]==nums[i-1])
            continue;
            curr.add(nums[i]);
            generateSubsets(nums, i + 1, curr, ans);
            curr.remove(curr.size()-1);

        }
    }
}