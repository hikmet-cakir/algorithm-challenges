class Solution {
    public int mySqrt(int x) {
        long high = x;
        long low = 1;
        while(high > low) {
            high = (high + low) / 2;
            low = x / high;
        }
        return (int)high;
    }
}