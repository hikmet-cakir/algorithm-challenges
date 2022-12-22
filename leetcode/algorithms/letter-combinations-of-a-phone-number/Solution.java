class Solution {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> numbersByCharacters = new HashMap<>() {{
            put('2', List.of("a","b","c")); put('3', List.of("d","e","f"));
            put('4', List.of("g","h","i")); put('5', List.of("j","k","l"));
            put('6', List.of("m","n","o")); put('7', List.of("p","q","r", "s"));
            put('8', List.of("t","u","v")); put('9', List.of("w","x","y", "z"));
        }};

        char[] chars = digits.toCharArray();
        List<List<String>> mappings = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            mappings.add(numbersByCharacters.get(chars[i]));
        }
        return calculateCombination(mappings);
    }

    public List<String> calculateCombination(List<List<String>> mappings) {
        int size = mappings.size();
        if(size == 1) {
            return mappings.get(0);
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            result = merge(result, mappings.get(i));
        }
        return result;
    }

    public List<String> merge(List<String> list1, List<String> list2) {
        if(list1.size() == 0) {
            return list2;
        }

        if(list2.size() == 0) {
            return list1;
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for(int j = 0; j < list2.size(); j++) {
                result.add(list1.get(i) + list2.get(j));
            }
        }
        return result;
    }
}