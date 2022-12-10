class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        String result = "";
        String temp = "";

        boolean isSignNeg = chars.length != 0 && chars[0] == '-';
        boolean isSignPos = chars.length != 0 && chars[0] == '+';
        if(s.length() > 1 && (isSignNeg || isSignPos)) {
            s = s.substring(1);
            chars = s.toCharArray();
        }
        for(int i = 0; i < chars.length; i++) {
            char val = chars[i];
            temp += val;
            String replacedResult = temp.replaceAll("[^0-9]", "");
            boolean equals = Objects.equals(temp, replacedResult);
            if (!equals) {
                break;
            }
            result += val;
            temp = result;
        }

        if(isSignNeg) {
            result = "-" + result;
        }

        if(isSignPos) {
            result = "+" + result;
        }


        char[] resultArr = result.toCharArray();
        boolean isNegative = resultArr.length != 0 && resultArr[0] == '-';

        int j = 0;
        result = isNegative ? result.substring(1) : result;
        resultArr = result.toCharArray();
        int len = resultArr.length;
        for(int i = 0; i < len; i++) {
            if( (isNegative || isSignPos) && i == 0) {
                continue;
            }
            if(resultArr[j] != '0') {
                break;
            }
            result = result.substring(1);
            resultArr = result.toCharArray();
            len = resultArr.length;
            i = 0;
        }

        result = isNegative ? "-" + result : result;
        resultArr = result.toCharArray();


        String maxVal = String.valueOf(Integer.MAX_VALUE);
        String minVal = String.valueOf(Integer.MIN_VALUE);

        boolean hasSignNeg = resultArr.length != 0 && resultArr[0] == '-';
        if(isNegative && minVal.length() <   result.length()) {
            return Integer.MIN_VALUE;
        } else if(isNegative && minVal.length() == result.length()) {
            char[] negativeMaxCharArr = minVal.toCharArray();
            for(int i = hasSignNeg ? 1 : 0; i < resultArr.length; i++) {
                if(resultArr[i] > negativeMaxCharArr[i]) {
                    return Integer.MIN_VALUE;
                } else if (resultArr[i] == negativeMaxCharArr[i]) {
                    continue;
                }else {
                    break;
                }
            }
        }
        boolean hasSign = resultArr.length != 0 &&  resultArr[0] == '+';
        if(!isNegative && maxVal.length() < (hasSign ? result.length() - 1: result.length() )) {
            return Integer.MAX_VALUE;
        } else if(!isNegative && maxVal.length() == result.length()) {
            char[] positiveMaxCharArr = maxVal.toCharArray();

            for(int i = hasSign ? 1 : 0; i < resultArr.length; i++) {
                if(resultArr[i] > positiveMaxCharArr[i]) {
                    return Integer.MAX_VALUE;
                } else if (resultArr[i] == positiveMaxCharArr[i]) {
                    continue;
                } else {
                    break;
                }
            }
        }

        try {
            return Integer.parseInt(result);
        } catch (Exception e) {
            return 0;
        }
    }
}