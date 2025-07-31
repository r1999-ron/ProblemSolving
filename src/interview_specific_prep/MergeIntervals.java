package interview_specific_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);

        for(int[] interval : result){
            System.out.println(Arrays.toString(interval));
        }
    }

    private static int[][] merge(int[][] intervals){
        if (intervals.length == 0) return new int[0][0];

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Merge intervals
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Merge
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap, push current and update
                merged.add(current);
                current = intervals[i];
            }
        }

        // Add last interval
        merged.add(current);

        // Convert to array
        return merged.toArray(new int[merged.size()][]);
    }
}
