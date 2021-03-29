class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;
        long sum1 = 0, sum2 = 0, mod = (long)1e9 + 7;
        while (i < n || j < m) {
            if (i < n && (j == m || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else if (j < m && (i == n || nums1[i] > nums2[j])) {
                sum2 += nums2[j++];
            } else {
                sum1 = sum2 = Math.max(sum1, sum2) + nums1[i];
                i++; 
                j++;
            }
        }
        return (int)(Math.max(sum1, sum2) % mod);
    }
}
//idea: two pointers
//time:O(N)
//space:O(1)
