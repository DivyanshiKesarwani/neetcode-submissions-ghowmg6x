class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] ans=new int[nums.length-k+1];
		int index=0;
		Deque<Integer> q=new LinkedList<>();
		for(int i=0;i<nums.length;i++) {
			if(!q.isEmpty()&&q.peek()==i-k)
				q.poll();
			while(!q.isEmpty()&&nums[q.peekLast()]<nums[i])
				q.pollLast();
			q.add(i);
			if(i>=k-1) ans[index++]=nums[q.peek()];
		}
		return ans;
	}
}
