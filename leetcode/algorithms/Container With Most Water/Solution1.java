class Solution {
    public int maxArea(int[] height) {
        int maxAmountOfWater = 0;
        int verticalsLength = height.length;
        for(int i = 0; i < verticalsLength; i++) {
            for(int j = i + 1; j < verticalsLength; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int calculatedAmountOfWater = minHeight * (j - i);
                if(maxAmountOfWater < calculatedAmountOfWater) {
                    maxAmountOfWater = calculatedAmountOfWater;
                }
            }
        }
        return maxAmountOfWater;
    }
}