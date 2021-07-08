class Solution {
    public int maxSubArray(int[] nums) {
        //conner case
        if(nums.length <= 1){
            return nums.length == 0 ? 0 : nums[0];
        }
        int sum = 0;
        //防止第一位是负数的情况，nums = {-1}，因此应该让res = nums[0], 而不是直接让res = 0;
        int res = nums[0];
        for(int num : nums){
            if(sum > 0){
                sum += num;
            }
            else{
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}







//idea:dynamic programming;leetcode 152
//time:O(n)
//space:O(1)
// 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
// 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
// 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
// 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
// 时间复杂度：O(n)
//这个就是动态规划，只不过每个状态只与前一个状态有关，所以为了降低空间复杂度只用一个变量来保
