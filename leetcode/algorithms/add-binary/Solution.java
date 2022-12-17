class Solution {
    public String addBinary(String a, String b) {
                char[] longest;
        char[] smallest;
        if(a.length() > b.length()) {
            longest = a.toCharArray();
            smallest = b.toCharArray();
        } else {
            longest = b.toCharArray();
            smallest = a.toCharArray();
        }

        StringBuilder result = new StringBuilder();
        int sumFirst = (Integer.parseInt(longest[longest.length - 1] + "") + Integer.parseInt(smallest[smallest.length - 1] + ""));
        int carry = sumFirst / 2;
        result.append(sumFirst % 2);
        int smallestIndex = smallest.length - 2;
        for(int i = longest.length - 2; i >= 0; i--) {
            if(smallestIndex >= 0) {
                int sum = Integer.parseInt(longest[i] + "") + Integer.parseInt(smallest[smallestIndex] + "") + carry;
                carry = sum / 2;
                result.append(sum % 2);
                smallestIndex--;
                continue;
            } else {
                int sum = Integer.parseInt(longest[i] + "") + carry;
                carry = sum / 2;
                result.append(sum % 2);
            }
        }

        if(carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}