class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0)
            return new int[][]{};
        List<int[]> res = new ArrayList<>();

        int i = 0, j = 0;
        int startMax, endMin;
        while(i < firstList.length && j < secondList.length){
            startMax = Math.max(firstList[i][0], secondList[j][0]);
            endMin = Math.min(firstList[i][1], secondList[j][1]);

            if(endMin >= startMax)
                res.add(new int[]{startMax, endMin});

            if(firstList[i][1] == endMin) i++;
            if(secondList[j][1] == endMin) j++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
//https://leetcode.com/problems/interval-list-intersections/discuss/231122/Java-two-pointers-O(m-%2B-n)
