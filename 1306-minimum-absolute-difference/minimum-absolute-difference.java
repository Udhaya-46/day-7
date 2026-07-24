import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        // Find the minimum absolute difference
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        // Collect all pairs with the minimum difference
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}