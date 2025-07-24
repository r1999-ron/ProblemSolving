package blind_75;

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