import java.util.*;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        int n = nums1.length;

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long total = 0;
        int maxGain = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            total += diff;

            int idx = Arrays.binarySearch(sorted, nums2[i]);

            if (idx < 0) {
                idx = -idx - 1;

                if (idx < n) {
                    maxGain = Math.max(maxGain,
                            diff - Math.abs(sorted[idx] - nums2[i]));
                }

                if (idx > 0) {
                    maxGain = Math.max(maxGain,
                            diff - Math.abs(sorted[idx - 1] - nums2[i]));
                }
            } else {
                maxGain = Math.max(maxGain, diff);
            }
        }

        return (int) ((total - maxGain) % MOD);
    }
}