// Design a HashSet without using any built-in hash table libraries.

// To be specific, your design should include these functions:

// 1- add(value): Insert a value into the HashSet. 
// 2- contains(value) : Return whether the value exists in the HashSet or not.
// 3- remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

class MyHashSet {
    int set[];
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new int[1000001];
        Arrays.fill(set, -1);   
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = -1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key] != -1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
