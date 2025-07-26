package blind_75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
* ### Code Explanation
The code solves the problem of finding the k most frequent elements in an array using a combination of HashMap and MinHeap (PriorityQueue). Here's how it works:
1. **Input Processing**:
``` java
Map<Integer, Integer> map = new HashMap<>();
for(int num : nums){
    map.put(num, map.getOrDefault(num, 0)+1);
}
```
- Creates a HashMap to store each number and its frequency
- Iterates through the input array and counts occurrences of each number

1. **MinHeap Creation**:
``` java
PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
```
- Creates a MinHeap using PriorityQueue
- The comparator orders elements based on their frequencies (stored in the map)

1. **Processing Elements**:
``` java
for(int num : map.keySet()){
    minHeap.add(num);
    if(minHeap.size() > k){
        minHeap.poll();
    }
}
```
- Adds each unique number to the MinHeap
- If heap size exceeds k, removes the element with lowest frequency

1. **Result Generation**:
``` java
int[] output = new int[k];
for(int i=k-1; i>=0; i--){
    output[i] = minHeap.poll();
}
```
- Creates output array of size k
- Polls elements from heap to fill the array in descending order

### Example
For input `nums = [1,1,1,2,2,3]` and : `k = 2`
1. Map becomes: `{1:3, 2:2, 3:1}`
2. MinHeap will maintain 2 elements with highest frequencies
3. Output will be `[1,2]` (as 1 appears three times and 2 appears twice)

### Complexity
- Time Complexity: O(n log k)
- Space Complexity: O(n)
    - where n is the length of input array and k is the input parameter
*/
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
    private static int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int num : map.keySet()){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] output = new int[k];
        for(int i=k-1; i>=0; i--){
            output[i] = minHeap.poll();
        }
        return output;
    }
}
