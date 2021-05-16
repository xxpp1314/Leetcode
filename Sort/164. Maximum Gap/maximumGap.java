class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        int res = 0;
        if(n < 2){
            return 0;
        }
        Arrays.sort(nums);
        for(int i = 1; i < n; i++){
            int cur = nums[i] - nums[i - 1];
            res = Math.max(cur, res);
        }
        return res;
    }
}
//idea:sort+array
//time:O(nlogn)
//space:O(1)
