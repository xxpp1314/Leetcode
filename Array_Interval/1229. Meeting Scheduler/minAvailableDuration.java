class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        
        int i = 0;
        int j = 0;
        int n1 = slots1.length;
        int n2 = slots2.length;
        while(i < n1 && j < n2){
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            
            if(start + duration <= end){
                return Arrays.asList(start, start + duration);
            }
            else if(slots1[i][1] < slots2[j][1]){
                i++;
            }
            else{
                j++;
            }
        }
        return new ArrayList<>();
    }
}
//idea: interval array(two pointers)
//Time: O(NlogN) for Sorting, Two pointer only take O(M+N)
//Space: O(1)
