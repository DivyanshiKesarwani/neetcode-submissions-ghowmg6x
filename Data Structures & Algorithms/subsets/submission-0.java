class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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

        if (idx == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Include nums[idx]
        curr.add(nums[idx]);
        generateSubsets(nums, idx + 1, curr, ans);

        // Backtrack
        curr.remove(curr.size() - 1);

        // Do not include nums[idx]
        generateSubsets(nums, idx + 1, curr, ans);
    }
}