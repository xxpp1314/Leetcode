class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin = Math.max(cmin - 1, 0);
            } else {
                cmax++;
                cmin = Math.max(cmin - 1, 0);
            }
            if (cmax < 0) return false;
        }
        return cmin == 0;
    }
}
//idea:greedy algorithm
//time:O(n)
//space:O(1)
// Explanation:
// We count the number of ')' we are waiting for,
// and it's equal to the number of open parenthesis.
// This number will be in a range and we count it as [cmin, cmax]

// cmax counts the maximum open parenthesis,
// which means the maximum number of unbalanced '(' that COULD be paired.
// cmin counts the minimum open parenthesis,
// which means the number of unbalanced '(' that MUST be paired.

// Example:
// It's quite straight forward actually.
// When you met "(", you know you need one only one ")", cmin = 1 and cmax = 1.
// When you met "(*(", you know you need one/two/three ")", cmin = 1 and cmax = 3.

// The string is valid for 2 condition:

// cmax will never be negative.
// cmin is 0 at the end.
