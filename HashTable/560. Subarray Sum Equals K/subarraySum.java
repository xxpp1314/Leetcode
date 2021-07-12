class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        //set a presum hashmap
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            //find the res that satisfy the condition
            if(preSum.containsKey(sum - k)){
                res += preSum.get(sum - k);
            }
            //save each sum value
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
//idea: hashmap
// Time complexity : O(n). The entire nums array is traversed only once.
// Space complexity : O(n). Hashmap map can contain up to nn distinct entries in the worst case.
//https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
