class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones)
        {
            pq.add(i);
        }
        while(pq.size()!=1)
        {int first = pq.poll();   
        int second = pq.poll();

        pq.add(first-second);}

        return pq.peek();
    }
}
