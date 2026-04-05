class Solution {
    public int[] countBits(int n) {
        int arr[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]=hammingWeight(i);
        }
        return arr;
    }
    public int hammingWeight(int n) {
        int count=0;
        for(int i=0;i<32;i++){
        int a=n&1;
        if(a==1)
        {
            count++;
        }
        n=n>>>1;
        }
        return count;
    }
}
