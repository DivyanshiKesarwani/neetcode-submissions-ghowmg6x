class KthLargest {
//Time Complexity: 
//Constructor:
// O(n log k)
// (You insert all elements and keep only k.)

// add(val):
// O(log k)

// because:

// add() → O(log k)
// poll() → O(log k)
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
       for(int num : nums) {
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
}

    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k)
        {
            pq.poll();
        }
        return pq.peek();
    }
}
