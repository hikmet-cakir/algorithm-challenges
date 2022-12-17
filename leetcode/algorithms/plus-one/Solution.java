class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int lastNumber = digits[digits.length - 1] + 1;
        int carry = lastNumber / 10;
        int mod = lastNumber % 10;
        result.add(mod);

        for(int i = digits.length - 2; i >= 0; i--) {
            int temp = digits[i] + carry;
            carry = temp / 10;
            mod = temp % 10;
            result.add(mod);
        }

        if(carry == 1) {
            result.add(1);
        }


        int[] resultArr = new int[result.size()];
        for(int i = result.size() - 1; i >= 0; i--) {
            resultArr[resultArr.length - i - 1] = result.get(i);
        }
        return resultArr;
    }
}