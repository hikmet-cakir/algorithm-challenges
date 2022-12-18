class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> uniqueNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(uniqueNums.contains(nums[i])) {
                uniqueNums.remove(Integer.valueOf(nums[i]));
            } else {
                uniqueNums.add(nums[i]);
            }
        }
        return uniqueNums.get(0);
    }
}