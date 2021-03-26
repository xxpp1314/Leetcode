class Solution {
    public int balancedString(String s) {
        int[] count = new int[128];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        int baseline = s.length() / 4;
        int left = 0;
        int right = 0;
        int res = s.length();
        while(left < s.length() && right < s.length()){
            count[s.charAt(right)]--;
            while(count['Q'] <= baseline && count['W'] <= baseline && count['E'] <= baseline && count['R'] <= baseline){
                res = Math.min(res, right - left + 1);
                count[s.charAt(left)]++;
                left++;
            }
            right++;
        }
        return res;
    }
}
//idea: sliding window
// Time O(N), one pass for counting, one pass for sliding window
// Space O(1)
