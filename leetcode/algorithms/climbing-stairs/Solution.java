class Solution {
    public int climbStairs(int n) {
        int[] distinctWaysArr = new int[n + 3];
        distinctWaysArr[0] = 0;
        distinctWaysArr[1] = 1;
        distinctWaysArr[2] = 2;

        for(int i = 2; i < n; i++) {
            distinctWaysArr[i + 1] = distinctWaysArr[i] + distinctWaysArr[i - 1];
        }

        return distinctWaysArr[n];
    }
}