class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int i1 = 0, i2 = 0;
        int f1 = 0, f2 = 0;
        int p = 0;
        int len1 = encoded1.length, len2 = encoded2.length;
        List<int[]> lst = new ArrayList<>();
        while (i1 < len1 && i2 < len2) {
            f1 = encoded1[i1][1];
            f2 = encoded2[i2][1];
            p = encoded1[i1][0] * encoded2[i2][0];
            if (f1 == f2) {
                lst.add(new int[]{p, f1});
                i1++;
                i2++;
            } else if (f1 < f2) {
                lst.add(new int[]{p, f1});
                encoded2[i2][1] = f2 - f1;
                i1++;
            } else {
                lst.add(new int[]{p, f2});
                encoded1[i1][1] = f1 - f2;
                i2++;
            }
        }
        //for (int[] arr : lst) System.out.println(Arrays.toString(arr));
        List<List<Integer>> res = new ArrayList<>();
        
        int[] cur = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i)[0] != cur[0]) { 
                res.add(Arrays.asList(new Integer[]{cur[0], cur[1]})); // if diff from prev, add to result.
                cur = lst.get(i);
            } else {
                cur[1] += lst.get(i)[1]; // if same as prev, then add freq.
            }
        }
        res.add(Arrays.asList(new Integer[]{cur[0], cur[1]})); // last one
        return res;
        
    }
}
//https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/discuss/1231200/Java-two-pointer
