package interview_specific_prep;
/*### How it Works
1. The method uses three variables:
    - : Keeps track of the product from the start of the array `prefix`
    - : Keeps track of the product from the end of the array `suffix`
    - : Stores the maximum product found so far `max`

2. The algorithm:
    - Traverses the array once, processing both ends simultaneously
    - Resets products to 1 if they become 0
    - Updates both prefix (forward) and suffix (backward) products
    - Updates max with the larger of prefix or suffix at each step

### Example
For input array `[2,3,-2,4]`:
```
i=0: prefix=2, suffix=4, max=4
i=1: prefix=6, suffix=-2, max=6
i=2: prefix=-12, suffix=3, max=6
i=3: prefix=-48, suffix=2, max=6
```
### Time and Space Complexity
- Time Complexity: O(n) where n is the length of the array
- Space Complexity: O(1) as it uses only three variables

### Key Features
1. Handles negative numbers by tracking both prefix and suffix products
2. Handles zero values by resetting products to 1
3. Returns the maximum product found during the traversal

For the example input `[2,3,-2,4]`, the output will be `6` (from subarray `[2,3]`).
*/
public class MaximumProductSubArray {
    public static void main(String[] args) {
      int[] nums = {2,3,-2,4};
      System.out.println(maxProduct(nums));
    }
    
    private static int maxProduct(int[] nums){
        int prefix=1, suffix=1, max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));

        }
        return max;
    }

}
