class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        if(arr.length <= 1){
            return 0;
        }
        int left = 0;
        while(left + 1 < arr.length && arr[left] <= arr[left + 1]){
            left++;
        }
        if(left == arr.length - 1){
            return 0;
        }
        int right = arr.length - 1;
        while(right > left && arr[right - 1] <= arr[right]){
            right--;
        }
        int res = Math.min(arr.length - left - 1, right);
        
        int i = 0;
        int j = right;
        while(i <= left && j < arr.length){
            if(arr[i] <= arr[j]){
                res = Math.min(res, j - i - 1);
                i++;
            }
            else{
                j++;
            }
        }
        return res;
    }
}
//idea: two pointers(sliding window)
//time:O(N)
//space:O(1)
