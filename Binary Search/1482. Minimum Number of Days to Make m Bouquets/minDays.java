class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int left = 1, right = (int)1e9;
        if (m * k > n) return -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int flow = 0, bouq = 0;
            for (int j = 0; j < n; ++j) {
                if (bloomDay[j] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
//idea: binary search
//Time O(Nlog(max(bloomDay))
//Space O(1)
