package interview_specific_prep;

import java.util.HashSet;
import java.util.Set;
/*
* **How it works:**
1. Creates an empty to store unique numbers `HashSet`
2. Iterates through each number in the input array
3. Tries to add each number to the set using `set.add(num)`
4. If `add()` returns `false`, it means the number is already in the set (duplicate found)
5. Returns `true` if a duplicate is found, `false` otherwise

**Key Points:**
- Uses for O(1) lookup and insertion time `HashSet`
- `HashSet.add()` returns `false` if element already exists in the set
- Time Complexity: O(n) where n is the length of input array
- Space Complexity: O(n) to store elements in the HashSet

For the example array `{1,2,3,1}`:
- First 1 is added to set
- 2 is added to set
- 3 is added to set
- Second 1 fails to add (returns true for duplicate)
*/
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
    private static boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
