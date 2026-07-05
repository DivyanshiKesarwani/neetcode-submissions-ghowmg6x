class Solution {
    //Interview tip: If the interviewer asks more generally (suppose there are M unique task types instead of only 26), then:
//N task executions
//Time: O(N log M)
//Space: O(M) here M=26
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> temp = new ArrayList<>();

            while (cycle > 0 && !pq.isEmpty()) {
                int count = pq.poll();//3
                count--;//2

                if (count > 0) {
                    temp.add(count);//[2]
                }

                time++;//1
                cycle--;//2
            }

            for (int count : temp) {
                pq.add(count);
            }
        //add idle state
            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}