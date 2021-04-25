class Solution {
    int[] arr;
    public int createSortedArray(int[] instructions) {
        int res = 0, n = instructions.length, mod = (int)1e9 + 7;
        arr = new int[100001];
        for (int i = 0; i < n; ++i) {
            res = (res + Math.min(get(instructions[i] - 1), i - get(instructions[i]))) % mod;
            update(instructions[i]);
        }
        return res;
    }

    public void update(int x) {
        while (x < 100001) {
            arr[x]++;
            x += x & -x;
        }
    }

    public int get(int x) {
        int res = 0;
        while (x > 0) {
            res += arr[x];
            x -= x & -x;
        }
        return res;
    }
}
//idea:Binary Indexed Tree
// Time O(NlogM),
// Space O(M)
// where M is the range of instructions[i].
