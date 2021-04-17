class LFUCache {
    Map<Integer, ListNode> cacheData;
    Map<Integer, LinkedList<ListNode>> visitData;
    private Integer capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        // data map init
        cacheData = new HashMap(capacity);
        // visit map init
        visitData = new HashMap<>();
        // 初始化访问次数为0的List
        visitData.put(0, new LinkedList<>());
    }

    public int get(int key) {
        ListNode node = cacheData.get(key);
        if (node == null) {
            return -1;
        }

        int visit = node.visit;
        visitData.get(visit).remove(node);
        node.visit = visit + 1;

        LinkedList<ListNode> nodes = visitData.get(node.visit);
        if (nodes == null) {
            nodes = new LinkedList<>();
            nodes.addFirst(node);
            visitData.put(node.visit, nodes);
        } else {
            nodes.addFirst(node);
        }

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        // 判断容量
        if (cacheData.size() == capacity && !cacheData.containsKey(key)) {
            // 获取最少访问次数
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, LinkedList<ListNode>> entry : visitData.entrySet()) {
                if (entry.getKey() < min && entry.getValue().size() > 0) {
                    min = entry.getKey();
                }
            }
            // 移除最少访问次数的，最后访问的元素
            LinkedList<ListNode> nodes = visitData.get(min);
            ListNode node = nodes.getLast();
            cacheData.remove(node.key);
            nodes.removeLast();
        }

        // 清空之前的访问记录
        if (cacheData.containsKey(key)) {
            ListNode node = cacheData.get(key);

            int visit = node.visit;
            visitData.get(visit).remove(node);
            node.visit = visit + 1;

            LinkedList<ListNode> nodes = visitData.get(node.visit);
            if (nodes == null) {
                nodes = new LinkedList<>();
                nodes.addFirst(node);
                visitData.put(node.visit, nodes);
            } else {
                nodes.addFirst(node);
            }

            // 添加值
            node.value = value;
            cacheData.put(key, node);
        } else {
            // 初始化访问记录为0
            ListNode node = new ListNode(key, value, 0);
            visitData.get(0).addFirst(node);
            // 添加值
            cacheData.put(key, node);
        }
    }

    class ListNode {
        Integer key;
        Integer value;
        Integer visit;

        public ListNode(Integer key, Integer value, Integer visit) {
            this.key = key;
            this.value = value;
            this.visit = visit;
        }
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
