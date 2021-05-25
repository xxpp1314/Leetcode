class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int psum = 0, res = 0, count[] = new int[nums.length + 1];
        count[0] = 1;
        for (int i : nums) {
            psum += i;
            if (psum >= goal)
                res += count[psum - goal];
            count[psum]++;
        }
        return res;
    }
}
//idea:sliding window
//time:O(N)
//space:O(1)
//https://leetcode.com/problems/binary-subarrays-with-sum/discuss/186683/C%2B%2BJavaPython-Sliding-Window-O(1)-Space
