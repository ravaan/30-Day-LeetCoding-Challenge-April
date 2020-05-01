class LRUCache {
    Node first;
    Node last;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int get(int key) {
        Node temp = first;
        while (temp != null) {
            if (temp.dict.key == key) {
                if (first != last && temp != first) {
                    if (temp.next != null) { //check if it is not the last node
                        temp.next.prev = temp.prev;
                        temp.prev.next = temp.next;
                    } else { //last node
                        if (last.prev == first) {
                            Node temp2 = first;
                            first = last;
                            first.next = temp2;
                            first.prev = null;
                            last = temp2;
                            last.prev = first;
                            last.next = null;
                            return temp.dict.value;
                        }
                        last = last.prev;
                        last.next = null;
                    }
                    first.prev = temp;
                    temp.next = first;
                    first = temp;
                }
                return temp.dict.value;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        boolean flag = true;
        Node t = first;
        if (t != null) {
            while (t.next != null) {
                if (t.dict.key == key) {
                    t.dict.value = value;
                    flag = false;

                    boolean flag2 = true;
                    if (first != last && t != first) {
                        if (t.next != null) { //check if it is not the last node
                            t.next.prev = t.prev;
                            t.prev.next = t.next;
                        } else { //last node
                            if (last.prev == first) {
                                Node temp2 = first;
                                first = last;
                                first.next = temp2;
                                first.prev = null;
                                last = temp2;
                                last.prev = first;
                                last.next = null;
                                flag2 = false;
                            }
                            if (flag2) {
                                last = last.prev;
                                last.next = null;
                            }
                        }
                        if (flag2) {
                            first.prev = t;
                            t.next = first;
                            first = t;
                        }
                    }


                    break;
                }
                t = t.next;
            }
        }
        if (flag) {
            Pair p = new Pair(key, value);
            Node temp = new Node(p);
            size++;
            if (first == null) {
                System.out.println("First == null");
                first = temp;
                last = first;
            } else if (first == last) {
                System.out.println("First == Last");
                first = temp;
                first.next = last;
                last.prev = first;
            } else {
                Node temp2 = first;
                first = temp;
                first.next = temp2;
                temp2.prev = first;
            }
            if (size > capacity) {
                last = last.prev;
                last.next = null;
                size--;
            }
        }
    }
}


class Node {
    Pair dict;
    Node prev;
    Node next;

    public Node(Pair p) {
        this.dict = p;
        this.prev = null;
        this.next = null;
    }
}


class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// first = 1
//     first.next = 2
//     first.prev = null
// last = 5
//     last.next = null
//     last.prv = 4

// 1->2->3->4->5->next