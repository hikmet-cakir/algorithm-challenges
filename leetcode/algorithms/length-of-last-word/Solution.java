class Solution {
    public int lengthOfLastWord(String s) {
        String trimString = s.trim();
        char[] trimCharArr = trimString.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = trimCharArr.length - 1; i >= 0; i--) {
            char val = trimCharArr[i];
            if(val == ' ') break;
            result.append(val);
        }
        return result.toString().length();
    }
}