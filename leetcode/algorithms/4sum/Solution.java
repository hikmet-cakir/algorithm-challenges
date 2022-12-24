class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        long max = nums[len - 1];
        long min = nums[0];

        if(max * 4 < target || min * 4 > target) {
            return new ArrayList<>();
        }

        Set<String> threePartsOfQuadruplets = new HashSet<>();
        Set<String> result = new HashSet<>();
        for(int i = 0; i < len; i++) {
            int sumOfFirst = nums[i];
            int diffOfFirst = target - sumOfFirst;
            if(diffOfFirst > (max + max + max) || diffOfFirst < (min + min + min)) {
                continue;
            }
            for(int j = i + 1; j < len; j++) {
                int sumOfSecond = nums[i] + nums[j];
                int diffOfSecond = target - sumOfSecond;
                if(diffOfSecond > (max + max) || diffOfSecond < (min + min)) {
                    continue;
                }
                for(int k = j + 1; k < len; k++) {
                    if(threePartsOfQuadruplets.contains(nums[i] + "," + nums[j] + "," + nums[k])) {
                        continue;
                    }
                    int sumOfThird = nums[i] + nums[j] + nums[k];
                    int diff = target - sumOfThird;
                    if(diff > max || diff < min) {
                        continue;
                    }
                    for(int l = k + 1; l < len; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if(sum == target) {
                            threePartsOfQuadruplets.add(nums[i] + "," + nums[j] + "," + nums[k]);
                            result.add(nums[i] + "," + nums[j] + "," + nums[k] + "," + nums[l]);
                        }
                    }
                }
            }
        }

        return result.stream().map(val -> val.split(","))
                .map(val -> Arrays.stream(val)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}