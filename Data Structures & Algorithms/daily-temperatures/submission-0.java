class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int res[]=new int[temp.length];
        Stack<Integer>s=new Stack<>();
        s.push(0);
        for(int i=1;i<temp.length;i++)
        {
            while (!s.isEmpty() && temp[i] > temp[s.peek()])
            {
               res[s.peek()] = i - s.peek();
                s.pop();
            }
                s.push(i);
            
        }
        return res;
    }
}
