package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {

    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
     */
    public static void main(String args[]) {
        System.out.println("Hello World!");
        int intervals[][] = {{1,3},{2,6},{2,10},{15,18}};
        MergeIntervals56 obj = new MergeIntervals56();

        int result[][] = obj.merge(intervals);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "," + result[i][1] + " ");
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, (p1, p2) ->  p1[0]-p2[0]);
        List<int[]> aList = new ArrayList<>();
        aList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int lastPoint[] = aList.get(aList.size()-1);
            if (lastPoint[1] < intervals[i][0]) {
                // no overlapping.
                aList.add(intervals[i]);
            }
            else {
                lastPoint[1] = Math.max(lastPoint[1], intervals[i][1]);
            }
        }
        return aList.toArray(int[][]::new);
    }
}
