class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mod = (int)1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for(int i = 1; i < n; i++){
            pows[i] = pows[i - 1] * 2 % mod;
        }
        while(left <= right){
            if(nums[left] + nums[right] > target){
                right--;
            }
            else{
                res = (res + pows[right - left]) % mod;
                left++;
            }
        }
        return res;
    }
}
//idea: two pointers
//time:O(nlogn)
//space:O(n)
