package interview_specific_prep;
/*
* - Uses a HashMap where:
    - Key: sorted version of the string
    - Value: list of original strings that share the same sorted form

- For each string:
    - Converts to char array
    - Sorts the characters (making "eat" and "tea" both become "aet")
    * - If sorted string isn't in map, creates new list
- Adds original string to appropriate list
* - Returns all grouped anagrams as a list of lists

* ### Example
For input `["eat", "tea", "tan", "ate", "nat", "bat"]`:
- "eat", "tea", "ate" → sorted as "aet" → grouped together
- "tan", "nat" → sorted as "ant" → grouped together
- "bat" → sorted as "abt" → in its own group

### Complexity
- Time: O(n * k * log k), where n is number of strings and k is max length of any string
- Space: O(n * k) for storing all strings in the HashMap



*/
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
