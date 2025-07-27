package interview_specific_prep;
/*
* ### How it Works
1. **Initialize Pointers**:
    - : Points to the start of the array `low`
    - : Points to the end of the array `high`

2. **Binary Search Loop**:
    - Continues while `low < high`
    - Calculates middle point using `mid = low + (high-low)/2`

3. **Decision Making**:
    - If :
        - Minimum must be in right half
        - Move to `low``mid + 1`

`nums[mid] > nums[high]`
    - Otherwise:
        - Minimum must be in left half (including mid)
        - Move to `high``mid`

### Example
For input array `[8, 1, 3, 4, 5]`:
```
Initial: low=0, high=4
Step 1: mid=2, nums[mid]=3, nums[high]=5
        3 < 5, so high = mid (2)
Step 2: mid=1, nums[mid]=1, nums[high]=3
        1 < 3, so high = mid (1)
Step 3: low=0, high=1
        mid=0, nums[mid]=8, nums[high]=1
        8 > 1, so low = mid + 1 (1)
Final: low=high=1, return nums[1] = 1
```
### Time & Space Complexity
- Time Complexity: O(log n)
- Space Complexity: O(1)

The algorithm efficiently finds the minimum element by leveraging the properties of a rotated sorted array and using binary search principles.
*/
public class FindMinRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {8, 1, 3, 4, 5};
        System.out.println(findMin(nums));
    }
    private static int findMin(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid]> nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}
/*
* 🔍 Problem:
You’re given a sorted array that has been rotated at some unknown pivot.
Your task is to find the smallest element in O(log n) time.

For example:
Sorted → [1, 2, 3, 4, 5]
Rotated → [4, 5, 1, 2, 3]

🧠 Intuition Behind the Binary Search Approach:
✅ Step 1: Know the properties
The array is sorted but rotated.

So it consists of two sorted subarrays:

One from the rotation point to the end (e.g., [1, 2, 3])

One from start to rotation point (e.g., [4, 5])

The minimum element is the only element where:

It is smaller than its previous element (if any).

OR it is the only dip in the increasing pattern.

✅ Step 2: Apply Binary Search Smartly
We don’t do traditional binary search (looking for a specific number),
Instead, we compare nums[mid] and nums[right] to decide where the minimum is:

🔁 Two Possible Cases:
Case 1: nums[mid] > nums[right]
👉 That means the min is in the right half, because:

The current mid value is greater than something to its right.

So we move left = mid + 1.

📌 Example: [4, 5, 6, 1, 2, 3]
If mid = 2, nums[mid] = 6, nums[right] = 3 → min must be on the right.

Case 2: nums[mid] <= nums[right]
👉 That means the min is in the left half (including mid), because:

The current mid value is less than or equal to the right.

So we move right = mid.

📌 Example: [4, 5, 1, 2, 3]
If mid = 2, nums[mid] = 1, nums[right] = 3 → min could be at mid or left.

🚨 Why not compare with nums[left]?
Because rotation can happen such that nums[left] > nums[right], so comparing with right is more helpful in narrowing down the search space safely.

✅ Loop stops when:
left == right → That’s the index of the minimum element.

💡 Summary (Mental Model):
Visualize the array like a mountain with a drop.

You are looking for the lowest point in a rotated increasing slope.

Use binary search and always narrow the search to where the dip (rotation) might be.
* */