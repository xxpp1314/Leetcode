class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return helper(nums1, nums2) + helper(nums2, nums1);
    }
    
    private int helper(int[] nums1, int[] nums2){
        int res = 0;
        if(nums1.length <= 1){
            return res;
        }
        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length - 1; i++){
            for(int j = i + 1; j < nums1.length; j++){
                long tmp = (long)nums1[i] * (long)nums1[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
        for(int i = 0; i < nums2.length; i++){
            long tmp = (long)nums2[i] * (long)nums2[i];
            if(map.containsKey(tmp)){
                res += map.get(tmp);
            }
        }
        return res;
    }
}
//idea: hashmap
//time:O(nums1.length * nums2.length)
//space:O(max(nums1.length, nums2.length))
