class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
//| Operation    | Removes          | Reason             |
//| ------------ | ---------------- | ------------------ |
//| `pollLast()` | smaller elements | useless for future |
//| `poll()`     | old indices      | out of window      |

        int n=nums.length;
		int ans[]=new int[n-k+1];
        ArrayDeque<Integer>q=new ArrayDeque<>();

        int index=0;
        for(int i=0;i<n;i++)
        {
            if(!q.isEmpty()&&q.peek()==i-k)//out of order elements
            {
                q.poll();
            }
            while(!q.isEmpty()&&nums[q.peekLast()]<=nums[i])
            {
                q.pollLast();
            }
            q.add(i);
            if(i>=k-1)
            {
                ans[index++]=nums[q.peek()];
            }
        }
        return ans;
	}
}
