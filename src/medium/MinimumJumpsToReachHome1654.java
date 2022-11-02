package medium;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumJumpsToReachHome1654 {

    /**
     * A certain bug's home is on the x-axis at position x. Help them get there from position 0.
     *
     * The bug jumps according to the following rules:
     *
     * It can jump exactly a positions forward (to the right).
     * It can jump exactly b positions backward (to the left).
     * It cannot jump backward twice in a row.
     * It cannot jump to any forbidden positions.
     * The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
     *
     * Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
     * Output: 3
     * Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
     * Example 2:
     *
     * Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
     * Output: -1
     * Example 3:
     *
     * Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
     * Output: 2
     * Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.
     *
     *
     * Constraints:
     *
     * 1 <= forbidden.length <= 1000
     * 1 <= a, b, forbidden[i] <= 2000
     * 0 <= x <= 2000
     * All the elements in forbidden are distinct.
     * Position x is not forbidden.
     */

    public static void main(String args[]) {
        MinimumJumpsToReachHome1654 obj = new MinimumJumpsToReachHome1654();
        int forbidden[] = {14,4,18,1,15};
//        System.out.println(obj.minimumJumps(forbidden, 3, 5, 9));
        int forbidden1[] = {8,3,16,6,12,20};
//        System.out.println(obj.minimumJumps(forbidden1, 15, 13, 11));
        int forbidden2[] = {1,6,2,14,5,17,4};
//        System.out.println(obj.minimumJumps(forbidden2, 16, 9, 7));
        int forbidden3[] = {18,13,3,9,8,14};
//        System.out.println(obj.minimumJumps(forbidden3, 3, 8, 6));
        int forbidden4[] = {162,118,178,152,167,100,40,74,199,186,
                             26,73,200,127,30,124,193,84,184,36,
                            103,149,153,9,54,154,133,95,45,198,
                             79,157,64,122,59,71,48,177,82,35,
                             14,176,16,108,111,6,168,31,134,164,
                            136,72,98};
        System.out.println(obj.minimumJumps(forbidden4, 29, 98, 80));
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Integer> q = new LinkedList<>();
        if (x==0) {
            return 0;
        }
        int l=1;
 //       Set<Integer> f = new HashSet(Arrays.asList(forbidden));
        Set<Integer> f = new HashSet<>();
        for (int i=0; i<forbidden.length; i++) {
            f.add(forbidden[i]);
        }
        if (f.contains(x)) {
            return -1;
        }

        q.add(0);
        q.add(null);
        while(!q.isEmpty()) {
            Integer e = q.poll();
            if (e == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    q.forEach(s -> System.out.print(s + " "));
                    System.out.println("");
                    l++;
                }
                else {
                    return -1;
                }
            }
            else {
                // previous was forward jump
                if (e > 0) {
                    if (x == e+a || x == e-b) {
                        return l;
                    }
                    if (e+a-b <= x) {
                        if (!f.contains(e+a)) {
                            q.add(e+a);
                            f.add(e+a);
                        }
                        if (!f.contains(e-b) && (e-b) > 0) {
                            q.add(-1*(e-b));
                            f.add(-1*(e-b));
                        }
                    }
                }
                else {
                    // previous was backward jump
                    e *= -1;
                    if (x == e+a) {
                        return l;
                    }
                    if (e-b+a <= x) {
                        if (!f.contains(e+a)) {
                            q.add(e+a);
                            f.add(e+a);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
