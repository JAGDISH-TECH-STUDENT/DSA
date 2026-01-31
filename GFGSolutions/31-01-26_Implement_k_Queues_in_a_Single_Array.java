class kQueues {
    private int[] arr;       // storage array
    private int[] front;     // front indices of queues
    private int[] rear;      // rear indices of queues
    private int[] next;      // next free slot or next element
    private int free;        // beginning of free list
    private int n, k;

    // Constructor
    kQueues(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        // initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }

        // initialize free list
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        free = 0;
    }

    // enqueue element x into queue number i
    void enqueue(int x, int i) {
        if (free == -1) {
            return; // array is full
        }

        int insertAt = free;       // allocate free slot
        free = next[insertAt];     // update free list

        if (front[i] == -1) {      // empty queue
            front[i] = insertAt;
        } else {
            next[rear[i]] = insertAt;
        }

        next[insertAt] = -1;
        rear[i] = insertAt;
        arr[insertAt] = x;
    }

    // dequeue element from queue number i
    int dequeue(int i) {
        if (front[i] == -1) {
            return -1; // empty queue
        }

        int frontIndex = front[i];
        front[i] = next[frontIndex];

        if (front[i] == -1) {
            rear[i] = -1; // queue became empty
        }

        // add freed slot back to free list
        next[frontIndex] = free;
        free = frontIndex;

        return arr[frontIndex];
    }

    // check if queue i is empty
    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    // check if array is full
    boolean isFull() {
        return free == -1;
    }
}
