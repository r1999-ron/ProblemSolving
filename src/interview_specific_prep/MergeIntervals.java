package interview_specific_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        List<int[]> result = merge(intervals);

        for(int[] interval : result){
            System.out.println(interval[0]+" "+interval[1]);
        }
    }

    private static List<int[]> merge(int[][] intervals){
        if(intervals.length==0) return new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }else{
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});
        return result;
    }
}
