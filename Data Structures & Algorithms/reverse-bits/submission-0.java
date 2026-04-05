class Solution {
    public int reverseBits(int n) {
        int lastbit=0;
        int result=0;
        for(int i=0;i<32;i++)
        {
            lastbit=n&1;
            result=result<<1;
            result=result|lastbit;
            n=n>>>1;
        }
        return result;
        
    }
}
