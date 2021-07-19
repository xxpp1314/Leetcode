class Solution {
    Map<Integer, Integer> cntMap = new HashMap<>();
    Map<Integer, Set<Integer>> squareMap = new HashMap<>();
    int cnt = 0;
    public int numSquarefulPerms(int[] nums) {
        for (int num : nums) {
            if (!cntMap.containsKey(num)) {
                cntMap.put(num, 1);
                squareMap.put(num, new HashSet<>());
            } else {
                cntMap.put(num, cntMap.get(num) + 1);
            }
        }
        for (int num1 : cntMap.keySet()) {
            for (int num2 : cntMap.keySet()) {
                double c = Math.sqrt(num1 + num2);
                if (c == Math.floor(c)) {
                    squareMap.get(num1).add(num2);
                    squareMap.get(num2).add(num1);
                }
            }
        }
        for (int num: cntMap.keySet()) {
            countPerm(num, nums.length - 1);
        }
        return cnt;
    }
    
    private void countPerm(int num, int left) {
        cntMap.put(num, cntMap.get(num) - 1);
        if (left == 0) { cnt++; }
        else {
            for (int next : squareMap.get(num)) {
                if (cntMap.get(next) != 0) {
                    countPerm(next, left - 1);
                }
            }
        }
        cntMap.put(num, cntMap.get(num) + 1);
    }
}
//https://leetcode.com/problems/number-of-squareful-arrays/discuss/238562/C%2B%2BPython-Backtracking
