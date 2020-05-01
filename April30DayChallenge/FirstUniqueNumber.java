class FirstUnique {
    Node head, tail;
    HashMap<Integer, Pair> unique;

    class Node {
        int val = -1;
        Node prev;
        Node next;
    }

    class Pair {
        Node node;
        boolean isUnique;

        public Pair(Node node, boolean isUnique) {
            this.node = node;
            this.isUnique = isUnique;
        }
    }

    public FirstUnique(int[] nums) {
        unique = new HashMap<Integer, Pair>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;  // point the dummy head to tail
        tail.prev = head;  // poin the dummy tail to head
        for (int i : nums) add(i);  // add all the numbers to the HashMap and LinkedList maintaining the state
    }

    public int showFirstUnique() {
        return tail.prev.val; // return the value of the last element in the linked list, it is the first unique element
    }

    public void add(int value) {
        if (unique.containsKey(value)) { // check if this is a totally new element
            if (unique.get(value).isUnique) { // check if that element is unique, if not let it go
                Node removeNode = unique.get(value).node; // newNode
                removeNode.next.prev = removeNode.prev;  //  head <- tail
                removeNode.prev.next = removeNode.next;  // head <-> tail
                unique.replace(value, new Pair(null, false)); // Update the value to not unique and set the linked list reference as null, because that is not required now
            }
        } else {
            Node newNode = new Node();
            newNode.val = value; // set node value
            Node firstNode = head.next; //tail
            head.next = newNode;  // head -> newnode
            newNode.prev = head;  // head <-> newNode
            newNode.next = firstNode; // head <-> newNode -> tail
            firstNode.prev = newNode; // head <-> newNode <-> tail
            unique.put(value, new Pair(newNode, true));  // add new element in the HashMap
        }
    }
}



// Method:

// Maintian a Doubly Linked list with only the unique numbers in latest first fashion (oldest element at the tail)
// Maintain a HashMap where the number entered in add() function call is the key and the value is a Pair object which contains the reference to it's node in the linked list and whether this number is unique or not

// On add() function call check in O(1) whether the number has already been seen -

// if yes then update it as isUnique = false and also remove it fromt he linked list because it is not unique any more. We have
// A doubly linked - save reference to head and tail  -> Worse case O(N)
// A hash map - <Integer, Pair> where Pair<Node, boolean> -> O(N) (Store the complete list)

// Algorithm:
// add() -> When a number is being .

