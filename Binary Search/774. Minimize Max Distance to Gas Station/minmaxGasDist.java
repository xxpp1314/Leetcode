class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        int count;
        int N = stations.length;
        double left = 0, right = stations[N - 1] - stations[0];
        double mid;
        while (left + 1e-6 < right) {
            mid = left + (right - left) / 2;
            count = 0;
            for (int i = 0; i < N - 1; ++i)
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            if (count > k) left = mid;
            else right = mid;
        }
        return right;
    }
}
//binary search
