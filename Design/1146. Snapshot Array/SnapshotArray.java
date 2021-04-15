class SnapshotArray {
    TreeMap<Integer, Integer>[] A;
    int snap_id = 0;
    public SnapshotArray(int length) {
        A = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            A[i] = new TreeMap<Integer, Integer>();
            A[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        A[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        return A[index].floorEntry(snap_id).getValue();
    }
}
//idea: design
// Time O(logS)
// Space O(S)
// where S is the number of set called.
// SnapshotArray(int length) is O(N) time
// set(int index, int val) is O(1) in Python and O(logSnap) in Java
// snap() is O(1)
// get(int index, int snap_id) is O(logSnap)
// floorEntry(K key) 方法用来返回与最大键小于或等于给定的键，或者如果不存在这样的键，null关联的键 - 值映射。
