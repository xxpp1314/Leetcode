class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length, i = 0;
        while (i < n && target > arr[i] * (n - i)) {
            target -= arr[i++];
        }
        if (i == n) return arr[n - 1];
        int res = target / (n - i);
        if (target - res * (n - i) > (res + 1) * (n - i) - target)
            res++;
        return res;
    }
}
