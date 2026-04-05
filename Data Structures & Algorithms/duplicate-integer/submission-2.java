//HashSet.add() returns:
//true → if element added
//false → if element already exists
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hs.add(nums[i])==false)
            {
                return true;
            }
        }
        return false;
    }
}