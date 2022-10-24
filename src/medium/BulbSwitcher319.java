package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BulbSwitcher319 {

    /**
     * There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
     *
     * On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
     *
     * Return the number of bulbs that are on after n rounds.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: n = 3
     * Output: 1
     * Explanation: At first, the three bulbs are [off, off, off].
     * After the first round, the three bulbs are [on, on, on].
     * After the second round, the three bulbs are [on, off, on].
     * After the third round, the three bulbs are [on, off, off].
     * So you should return 1 because there is only one bulb is on.
     * Example 2:
     *
     * Input: n = 0
     * Output: 0
     * Example 3:
     *
     * Input: n = 1
     * Output: 1
     *
     * @param args
     *
     * Constraints:
     *
     * 0 <= n <= 10^9
     */
    public static void main(String args[]) {
        BulbSwitcher319 obj = new BulbSwitcher319();
//        System.out.println("0 -> " + obj.bulbSwitch(0));
        System.out.println("1 -> " + obj.bulbSwitch(1));
//        System.out.println("2 -> " + obj.bulbSwitch(2));
//        System.out.println("3 -> " + obj.bulbSwitch(3));
//        System.out.println("4 -> " + obj.bulbSwitch(4));
//        System.out.println("999999 -> " + obj.bulbSwitch(999999));
    }

    // Time Limit Exceeded
    public int bulbSwitch1(int n) {
        Map<Integer,Integer> m = new HashMap<>();
        for (int i=1; i<=n; i++) {
            for (int j=i; j<=n; j=j+i) {
                m.put(j, 1+m.getOrDefault(j, 0));
            }
        }
        return (int)m.values().stream().filter(t -> t%2==1).map(t -> 1).count();
    }

    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
