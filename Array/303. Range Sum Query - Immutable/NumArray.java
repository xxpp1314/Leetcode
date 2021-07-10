public class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return nums[j];

        return nums[j] - nums[i - 1];
    }
}
//https://leetcode.com/problems/range-sum-query-immutable/discuss/75192/Java-simple-O(n)-init-and-O(1)-query-solution


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
