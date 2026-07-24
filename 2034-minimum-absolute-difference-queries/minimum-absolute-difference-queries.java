class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;

        // prefix[i][v] = frequency of value v in nums[0...i-1]
        int[][] prefix = new int[n + 1][101];

        for (int i = 0; i < n; i++) {
            System.arraycopy(prefix[i], 0, prefix[i + 1], 0, 101);
            prefix[i + 1][nums[i]]++;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int prev = -1;
            int minDiff = Integer.MAX_VALUE;

            for (int v = 1; v <= 100; v++) {
                if (prefix[r + 1][v] - prefix[l][v] > 0) {
                    if (prev != -1) {
                        minDiff = Math.min(minDiff, v - prev);
                    }
                    prev = v;
                }
            }

            ans[i] = (minDiff == Integer.MAX_VALUE) ? -1 : minDiff;
        }

        return ans;
    }
}