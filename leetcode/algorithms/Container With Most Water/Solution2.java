class Solution2 {

    public static void main(String[] args) {
        System.out.println("request=[1,8,6,2,5,4,8,3,7], result=" + maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("request=[1,1], result=" + maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        int maxAmountOfWater = 0;
        int i = 0, j = 0, length = height.length;
        while(i < length) {
            int minHeight = Math.min(height[i], height[j]);
            int calculatedAmountOfWater = minHeight * (j - i);
            if(calculatedAmountOfWater > maxAmountOfWater) {
                maxAmountOfWater = calculatedAmountOfWater;
            } else {
                j++;
            }

            if(j == length) {
                j = i;
                i++;
            }
        }
        return maxAmountOfWater;
    }
}