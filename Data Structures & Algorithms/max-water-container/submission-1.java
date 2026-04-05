class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;//7
        int area=0;
        int max=0;
        while(left<right)
        {
            int width=right-left;//7 6
            area = Math.min(height[left], height[right]) * width;//7 36 15 28
            max=Math.max(area,max);//7 36
            if(height[left] > height[right])
            {
                right--;
            }
            else
            {left++;}
        }
        return max;
    }
}
