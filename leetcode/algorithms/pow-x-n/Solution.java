class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1.0 / x;
            n = n * -1;
        }

        double pow = 1;

        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            }

            x *= x;
            n >>>= 1;

        }

        return pow;
    }
 
}