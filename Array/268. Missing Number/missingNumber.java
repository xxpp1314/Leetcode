class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for(int i = 0; i < nums.length; i++){
            sum += i - nums[i];
        }
        return sum;
    }
}
//idea: array
//time:O(nums.length())
//space:O(1)
//bit method
//https://leetcode.com/problems/missing-number/discuss/69777/C%2B%2B-solution-using-bit-manipulation
//https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination
