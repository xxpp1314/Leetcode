class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums1.length > 6 * nums2.length) {
            return -1;
        }
        int sum1 = IntStream.of(nums1).sum(); 
        int sum2 = IntStream.of(nums2).sum();
        if (sum1 > sum2) {
            return minOperations(nums2, nums1); // make sure the sum of 1st array <= sum of 2nd one.
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = nums2.length - 1, operations = 0;
        while (sum2 > sum1) {
            // increase the number in nums1 or decrease the number in nums2? 
            if (j < 0 || i < nums1.length && 6 - nums1[i] > nums2[j] - 1) {
                sum1 += 6 - nums1[i++]; // increase to 6 the number in nums1.
            }else {
                sum2 -= nums2[j--] - 1; // decrease to 1 the number in nums2.
            }
            ++operations;
        }
        return operations;
    }
}
//https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/discuss/1085786/JavaPython-3-2-Greedy-codes%3A-sort-and-count-w-brief-explanation-and-analysis.
