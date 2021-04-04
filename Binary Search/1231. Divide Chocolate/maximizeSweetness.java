class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = 1;
        int right = (int)1e9;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int cur = 0;
            int cut = 0;
            for (int sweet : sweetness) {
                cur += sweet;
                if (cur >= mid) {
                    cur = 0;
                    cut++;
                    if (cut > K) break;
                }
            }
            if (cut > K)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
}
//idea: binary search
//Time O(Nlog(10^9))
//Space O(1)
