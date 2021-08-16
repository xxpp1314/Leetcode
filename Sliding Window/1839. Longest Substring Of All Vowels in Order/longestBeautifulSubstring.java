class Solution {
    public int longestBeautifulSubstring(String word) {
        int longest = 0;
        Set<Character> seen = new HashSet<>();
        for (int lo = -1, hi = 0; hi < word.length(); ++hi) {
            if (hi > 0 && word.charAt(hi - 1) > word.charAt(hi)) {
                seen = new HashSet<>();
                lo = hi - 1;
            }
            seen.add(word.charAt(hi));
            if (seen.size() == 5) {
                longest = Math.max(longest, hi - lo);
            }
        }
        return longest;
    }
}
//https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/discuss/1175134/JavaPython-3-Sliding-window-codes-w-brief-explanation-and-analysis.
