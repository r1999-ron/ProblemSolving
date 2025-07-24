package blind_75;
/*
* ### Problem Description
This problem aims to find two vertical lines and the x-axis that forms a container that can hold the maximum amount of water. The input array represents the height of vertical lines, where the index represents the x-coordinate.
### How it Works
1. Uses two-pointer technique:
    - starts from the beginning `left`
    - starts from the end `right`

2. For each iteration:
    - Calculates area using: `min(height[left], height[right]) * (right - left)`
    - Updates if current area is larger `maxArea`
    - Moves the pointer with smaller height inward

3. For the example `{5,2,4,2,6,3}`:
```
   Initial: [5,2,4,2,6,3]
   left=0, right=5: area = min(5,3) * 5 = 15
   left=0, right=4: area = min(5,6) * 4 = 20
   left=1, right=4: area = min(2,6) * 3 = 6
   ...and so on
```
### Time and Space Complexity
- Time Complexity: O(n) where n is the length of the array
- Space Complexity: O(1) as it uses only a constant amount of extra space

### Key Points
- Uses two-pointer technique for efficient solution
- Area is limited by the smaller height between two points
- Distance between points (width) is right-left
- Moves the pointer with smaller height as moving the larger one can't increase area
*/
public class ContainerWithMaximumWater {
    public static void main(String[] args) {
        int[] nums = {5,2,4,2,6,3};
        System.out.println(maxArea(nums));
    }

    private static int maxArea(int[] height){
        int left=0, right = height.length-1;
        int maxArea = 0;
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
