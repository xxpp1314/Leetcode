class Solution {
    private int findReversedPairs(int[] nums,int left,int right){
        int res = 0,mid = left + (right-left)/2;
        int i = left,j = mid+1;
        for(;i <= mid;i++){
            while(j <= right && (long)nums[i] > 2*(long)nums[j]) {
                res += mid - i + 1;
                j++;
            }
        }
        return res;
    }
    
    private int mergeSort(int[] nums,int[] numsSorted,int left,int right){
        if(left == right) return 0;
        int mid = left + (right - left) / 2;
        int res = mergeSort(nums,numsSorted,left,mid) +
                  mergeSort(nums,numsSorted,mid+1,right) +
                  findReversedPairs(nums,left,right);
        int i = left,j = mid+1,k = left;
        
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]) numsSorted[k++] = nums[i++];
            else numsSorted[k++] = nums[j++];
        }
        while(i <= mid) numsSorted[k++] = nums[i++];
        while(j <= right) numsSorted[k++] = nums[j++];
        
        for(int ind = left;ind <= right;ind++) nums[ind] = numsSorted[ind];
    
        return res;
    }
    
    public int reversePairs(int[] nums) {
        if(nums.length == 0) return 0;
        int[] numsSorted = new int[nums.length];
        return mergeSort(nums,numsSorted,0,nums.length-1);
    }
}
//idea: merge sort
//Time complexity: O(nlogn)
// In each step we divide the array into 2 sub-arrays, and hence, the maximum times we need to divide is equal to O(logn)
// Additional O(n) work needs to be done to count the inversions and to merge the 2 sub-arrays after sorting. Hence total time complexity is O(nlogn)
// Space complexity: O(n). Additional space for storing L and R arrays
