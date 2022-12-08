class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        String val = x + "";
        val = isNegative ? (x + "").replace("-", "") : val;

        char[] chars = val.toCharArray();
        char[] resultArr = new char[chars.length];
        for(int i = 0; i < chars.length; i++) {
            resultArr[i] = chars[chars.length - i - 1];
            resultArr[chars.length - i - 1] = chars[i];
        }

        try {
            String s = new String(resultArr);
            String finalForm = isNegative ? "-" + s : s;
            return Integer.parseInt(finalForm);
        } catch (Exception e) {
            return 0;
        }
    }
}