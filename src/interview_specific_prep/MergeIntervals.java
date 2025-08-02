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

    private static int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int start = intervals[0][0]; // 1
        int end = intervals[0][1];  // 3
        for(int i=1; i<intervals.length; i++){
            int currStart = intervals[i][0]; // 2
            int currEnd = intervals[i][1]; // 6
            if(currStart <= end){
                end = Math.max(end, currEnd); //6
            }else{
                merged.add(new int[]{start, end}); //[1,6]
                start = currStart;
                end = currEnd;
            }
        }
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);
    }
}
