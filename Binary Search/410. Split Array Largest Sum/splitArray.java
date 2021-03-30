class Solution {
    public int splitArray(int[] nums, int m) {
        long l = nums[0], h = 0;//int类型在这里不合适，因为h可能会超过int类型能表示的最大值
        for (int num : nums)
        {
            h += num;
            l = l > num ? l : num;
        }
        while (l < h)
        {
            long mid = l + (h - l) / 2;
            long temp = 0;
            int cnt = 1;//初始值必须为1
            for(int num : nums)
            {
                temp += num;
                if(temp > mid)
                {
                    temp = num;
                    ++cnt;
                }
            }
            if(cnt > m)
                l = mid + 1;
            else
                h = mid;
        }
        return (int)l;
    }
}
//idea: binary search
// Time complexity : O(n * log(sum of array)). The binary search costs O(log(sum of array)), where sum of array is the sum of elements in nums. For each computation of F(x), the time complexity is O(n) since we only need to go through the whole array.
// Space complexity : O(1) space complexity without taking the output list into account, and O(n) to store the output list.
