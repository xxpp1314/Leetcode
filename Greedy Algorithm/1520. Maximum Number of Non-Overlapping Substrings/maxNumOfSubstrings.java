class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int l[] = new int[26], r[] = new int[26];
        Arrays.fill(l, s.length());
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < s.length(); ++i) {
            int ch = s.charAt(i) - 'a';
            l[ch] = Math.min(l[ch], i);
            r[ch] = i;
        }
        int right = -1;
        for (int i = 0; i < s.length(); ++i)
            if (i == l[s.charAt(i) - 'a']) {
                int new_right = checkSubstr(s, i, l, r);
                if (new_right != -1) {
                    if (i > right)
                        res.add("");                     
                    right = new_right;
                    res.set(res.size() - 1, s.substring(i, right + 1));
                }
            }
        return res;
    }
    
    public int checkSubstr(String s, int i, int l[], int r[]) {
        int right = r[s.charAt(i) - 'a'];
        for (int j = i; j <= right; ++j) {
            if (l[s.charAt(j) - 'a'] < i)
                return -1;
            right = Math.max(right, r[s.charAt(j) - 'a']);
        }
        return right;
    }    
}
//idea:greedy algorthm
//Time: O(n). In the worst case, we search for substring 26 times, and each search is O(n)
// Memory: O(1). We store left and right positions for 26 characters.
// For the complexity analysis purposes, we ignore memory required by inputs and outputs.
