package array_practice;
/*
* This code finds the first missing positive integer in an array. For example, given the array `[3,4,-1,1]`, it will return `2` because that's the first positive integer missing from the sequence.
Here's how the algorithm works:
1. **First Phase - Cyclic Sort**:
``` java
for(int i=0; i<n; i++){
    while (nums[i] > 0 && nums[i] <=n && nums[nums[i]-1] != nums[i]){
        int temp = nums[nums[i]-1];
        nums[nums[i]-1] = nums[i];
        nums[i] = temp;
    }
}
```
- This phase tries to put each number in its correct position
- For a number `x`, its correct position is `x-1` (e.g., 1 should be at index 0)
- The while loop continues swapping numbers until either:
    - The current number is negative or too large
    - The number is already in its correct position

1. **Second Phase - Find Missing Number**:
``` java
for(int i=0; i<n; i++){
    if(nums[i] != i+1){
        return i+1;
    }
}
```
- After sorting, checks if each position contains the correct number
- If position doesn't contain , then is the first missing positive integer `i``i+1``i+1`

1. **Final Check**:
``` java
return n+1;
```
- If all numbers from 1 to n are present, returns n+1

For the example `[3,4,-1,1]`:
1. After sorting phase: `[1,4,3,-1]`
2. Checking phase finds that index 1 doesn't contain 2
3. Returns 2 as the answer

The algorithm has O(n) time complexity and uses O(1) extra space since it modifies the array in-place.
*/
public class FirstMissingPositive {
    public static void main(String[] args) {

        int [] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            while (nums[i] > 0 && nums[i] <=n && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
