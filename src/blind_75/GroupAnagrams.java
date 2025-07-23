package blind_75;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(solution.groupAnagrams(new String[]{""}));
        // Output: [[""]]
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
        // Output: [["a"]]
    }

    public List<List<String>> groupAnagrams(String[] strs){
        if(strs==null || strs.length==0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
