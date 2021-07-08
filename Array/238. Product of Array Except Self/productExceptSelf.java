class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        //Calculate lefts and store in res
        int left = 1;
        for(int i = 0; i < n; i++){
            if(i > 0){
                left *= nums[i - 1];
            }
            res[i] = left;
        }
        //Calculate rights and store in res
        int right = 1;
        for(int i = n - 1; i >= 0; i--){
            if(i < n - 1){
                right *= nums[i + 1];
            }
            res[i] *= right;
        }
        return res;
    }
}
//idea: array
//time:O(N)
//space:O(1)
//https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
