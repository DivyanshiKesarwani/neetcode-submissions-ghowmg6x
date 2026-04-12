class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;//2
        int n=nums2.length;//1
        int nums[]=new int[n+m];
        for(int i=0;i<m;i++)
        {
            nums[i]=nums1[i];
        }
        for(int i=m;i<n+m;i++)
        {
            nums[i]=nums2[i-m];
        }
        Arrays.sort(nums);
        if((m+n)%2==1)//1 2 3 4-->4
        {
            return nums[(m+n)/2];
        }
        return (double)(nums[((m+n)-1)/2]+nums[(m+n)/2])/2;
    }
}
