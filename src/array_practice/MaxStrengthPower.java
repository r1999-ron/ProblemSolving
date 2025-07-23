package array_practice;

import java.util.*;

public class MaxStrengthPower {
    public static int maximizeStrength(int[][] machinePowers) {
        int n = machinePowers.length;
        int m = machinePowers[0].length;

        // Step 1: Sort each machine's power units
        PriorityQueue<Integer> extraUnits = new PriorityQueue<>(Collections.reverseOrder()); // Max heap for extra units
        int[][] sortedMachines = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.sort(machinePowers[i]); // ascending
            for (int j = 1; j < m; j++) {
                extraUnits.offer(machinePowers[i][j]); // pick all except the smallest (which defines strength)
            }
            sortedMachines[i] = machinePowers[i];
        }

        // Step 2: Now each machine can receive stronger units
        for (int i = 0; i < n; i++) {
            int min = sortedMachines[i][0]; // current strength
            // check if we can replace min by any larger value (from the pool)
            if (!extraUnits.isEmpty() && extraUnits.peek() > min) {
                sortedMachines[i][0] = extraUnits.poll(); // replace min
                Arrays.sort(sortedMachines[i]); // re-sort
            }
        }

        // Step 3: Sum the minimum (first element after sort) of each machine
        int sumStrengths = 0;
        for (int i = 0; i < n; i++) {
            sumStrengths += sortedMachines[i][0];
        }

        return sumStrengths;
    }

    public static void main(String[] args) {
        int[][] machinePowers = {
                {1, 5},
                {4, 3},
                {2, 10}
        };

        int result = maximizeStrength(machinePowers);
        System.out.println("Maximum sum of strengths: " + result);
    }
}
