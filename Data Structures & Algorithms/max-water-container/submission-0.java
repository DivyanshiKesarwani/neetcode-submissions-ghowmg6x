class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;//7
        int area=0;
        int max=0;
        while(left<right)
        {
            int width=right-left;//7
            area = Math.min(height[left], height[right]) * width;//7
            max=Math.max(area,max);
            if(height[left] < height[right])
            {
                left++;
            }
            else
            {right--;}
        }
        return max;
    }
}
