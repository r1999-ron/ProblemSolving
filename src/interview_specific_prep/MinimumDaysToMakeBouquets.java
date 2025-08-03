package interview_specific_prep;

public class MinimumDaysToMakeBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        // Not enough flowers at all
        if ((long) m * k > bloomDay.length) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find min and max bloom days
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeBouquets(bloomDay, mid, m, k)) {
                answer = mid;      // Store valid day
                high = mid - 1;    // Try to find smaller day
            } else {
                low = mid + 1;     // Try more days
            }
        }

        return answer;
    }

    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;  // reset after forming one bouquet
                }
            } else {
                flowers = 0;  // reset since flowers must be adjacent
            }
        }

        return bouquets >= m;
    }

    // Sample usage
    public static void main(String[] args) {
        MinimumDaysToMakeBouquets solver = new MinimumDaysToMakeBouquets();
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println("Minimum days: " + solver.minDays(bloomDay, m, k));  // Output: 3
    }
}

/*
[7,7,7,7,11,12,7,7,13] m=2,k=3
min days else -1
*/