class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for(int[] i : intervals){
            if(i[1] <= toBeRemoved[0] || i[0] >= toBeRemoved[1]){
                res.add(Arrays.asList(i[0], i[1]));
            }
            else{
                //there exist order pproblem, you need notice that
                if(i[0] < toBeRemoved[0]){
                    res.add(Arrays.asList(i[0], toBeRemoved[0]));
                }
                if(i[1] > toBeRemoved[1]){
                    res.add(Arrays.asList(toBeRemoved[1], i[1]));
                }
            }
        }
        return res;
    }
}
//idea:array interval
//time:O(N)
//space:O(1), excluding return list, where n = intervals.length.
