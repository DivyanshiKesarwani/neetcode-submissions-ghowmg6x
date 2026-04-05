// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         int n=nums.length-1;
//         ArrayList<List<Integer>>arr=new ArrayList<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             if(i>0 && nums[i-1]==nums[i])continue;
//             int left=i+1;
//             int right=n;
//             while(left<right){
//             int sum=nums[left]+nums[right]+nums[i];
//             if(sum==0)
//             {
//                 arr.add(Arrays.asList(nums[left],nums[right],nums[i]));
//                 while (left < right && nums[left] == nums[left + 1]) left++;
//                 while (left < right && nums[right] == nums[right - 1]) right--;
//                 left++;
//                 right--;

//             }
//             else if(sum>0)
//             {
//                 right--;
//             }
//             else{
//                 left++;
//             }
//         }
//         }
//         return arr;
//     }
// }
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>>hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                   int sum=nums[i]+nums[left]+nums[right];
            if(sum==0)
            {
                hs.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
            }
            else if(sum<0)
            {
                left++;
            }
            else
            {
                right--;
            }
            }
         
        }
        return new ArrayList<>(hs);
    }
}