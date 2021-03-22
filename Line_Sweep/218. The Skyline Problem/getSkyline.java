class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> height = new ArrayList<>();
        for(int[] b:buildings) {
            // start point has negative height value
            height.add(Arrays.asList(b[0], -b[2]));
            // end point has normal height value
            height.add(Arrays.asList(b[1], b[2])); 
        }

        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(height, (a, b) -> {
                if(!a.get(0).equals(b.get(0))) 
                    return a.get(0) - b.get(0);
                return a.get(1) - b.get(1);
        });

        // Use a maxHeap to store possible heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        Integer prev = 0;

        // visit all points in order
        for(List<Integer> h:height) {
            if(h.get(1) < 0) { // a start point, add height
                pq.offer(-h.get(1));
            } else {  // a end point, remove height
                pq.remove(h.get(1));
            }
            Integer cur = pq.peek(); // current max height;

            // compare current max height with previous max height, update result and 
            // previous max height if necessary
            if(!prev.equals(cur)) {
                result.add(Arrays.asList(h.get(0), cur));
                prev = cur;
            }
        }
        return result;
    }
}
