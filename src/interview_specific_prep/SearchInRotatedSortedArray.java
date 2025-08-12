package interview_specific_prep;
/*### Key Features
1. **Binary Search Modification**: Uses binary search but with additional logic to handle rotation
2. **Two-Part Analysis**:
    - First determines which half is sorted
    - Then checks if target lies in the sorted portion

### Example Walk-through
Using array `[4,5,6,7,0,1,2]` with target `0`:



1. Initial state: `left=0, right=6, mid=3`
2. `nums[mid]=7`
3. Left side `[4,5,6,7]` is sorted
4. Target `0` is not in range `[4,7]`, so search right half
5. Next iteration: `left=4, right=6`
6. Eventually finds target at index 4

### Time & Space Complexity
- Time Complexity: O(log n)
- Space Complexity: O(1)

The algorithm maintains the efficient logarithmic time complexity of binary search while handling the added complexity of rotation.
*/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));

    }

    // 4,5,6,7,0,1,2
    // mid = 7 --> nums[3]
    // nums[left] = 4 < = 7
    // target = 0 <= nums[3] but target !>= nums[left]
    // left = mid + 1 = 0 = nums[4]
    private static int search(int[] nums, int target){
        int left=0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[left] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target >= nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
