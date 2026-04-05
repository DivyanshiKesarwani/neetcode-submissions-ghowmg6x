//>> → keeps sign → bad for negatives-->shifts right and add 0 in left
//for positive and 1 for negative 
//>>> → ALWAYS 0 on left
//>>  → COPY sign bit (0 for +, 1 for -)
//>>> → fills 0 → safe

//<< → wrong direction
class Solution {
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
