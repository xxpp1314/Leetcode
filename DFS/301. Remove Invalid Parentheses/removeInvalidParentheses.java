class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }

    public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closedParen) numClosedParen++;
            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
                    // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(')
            removeHelper(reversed, output, 0, 0, ')','(');
        else
            output.add(reversed);
    }
}
//idea:dfs
// I would say the best case is O(n) which means no error happens.
// Worst case is O(n!), recursion happens for every iteration, while the length of each loop reduces by 1 each time.
// eg: )))))(((((, total computation time is approximately 10*1*9*1*8*1*7*1...*2*1*1 == 10*9*8*7...*1 == 10!, this factorial happens n times for outer loop of the remove function, so we also need to multiply 10 again, while that doesn't change anything for the time complexity of O(n!).
//https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
