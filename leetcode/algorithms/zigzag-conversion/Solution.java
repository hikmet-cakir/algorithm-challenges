class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();
        char[] arr = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[length];
        for(int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }


        int count = 0;
        while(count < length) {
            for(int i = 0; i < numRows && count < length; i++) {
               sb[i].append(arr[count++]);
            }

            for(int i = numRows - 2; i > 0 && count < length; i--) {
                sb[i].append(arr[count++]);
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < sb.length; i++) {
            result.append(sb[i]);
        }
        return result.toString();
    }
}