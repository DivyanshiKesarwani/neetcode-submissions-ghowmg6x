class Solution {
    public int reverse(int n) {
           int result=0;
        int lastDigit=0;
        
        while(n!=0)
        {
            lastDigit=n%10;
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 || 
               (result == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }
            result=result*10+lastDigit;
            n=n/10;
            
        }
        return result;
    }
}
