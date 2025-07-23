package blind_75;

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
