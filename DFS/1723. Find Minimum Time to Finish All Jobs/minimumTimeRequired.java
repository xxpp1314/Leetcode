class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int n = jobs.length;
        int left = jobs[n - 1];
        int right = jobs[n - 1] * n;
        while (left < right) {
            int[] cap = new int[k];
            int mid = left + (right - left) / 2;
            Arrays.fill(cap, mid);
            if (dfs(jobs, cap, n - 1, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean dfs(int[] jobs, int[] cap, int i, int k, int x) {
        if (i == -1) {
            return true;
        }
        for (int j = 0; j < k; j++) {
            if (cap[j] >= jobs[i]) {
                cap[j] -= jobs[i];
                if (dfs(jobs, cap, i - 1, k, x)) {
                    return true;
                }
                cap[j] += jobs[i];
            }
            if (cap[j] == x) {
                break;
            }
        }
        return false;
    }
}
//https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/discuss/1010057/JavaPython-Binary-Search-100
