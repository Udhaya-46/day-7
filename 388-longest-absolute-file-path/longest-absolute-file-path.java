import java.util.*;

class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Length before the root
        int maxLen = 0;

        String[] paths = input.split("\n");

        for (String path : paths) {
            int level = 0;

            // Count the number of '\t'
            while (path.startsWith("\t")) {
                level++;
                path = path.substring(1);
            }

            // Move back to the correct parent directory
            while (stack.size() > level + 1) {
                stack.pop();
            }

            int currLen = stack.peek() + path.length();

            if (path.contains(".")) {
                // It's a file
                maxLen = Math.max(maxLen, currLen);
            } else {
                // It's a directory (+1 for '/')
                stack.push(currLen + 1);
            }
        }

        return maxLen;
    }
}