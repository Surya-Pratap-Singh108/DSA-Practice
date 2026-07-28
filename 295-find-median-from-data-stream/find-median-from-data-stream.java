class MedianFinder {

    PriorityQueue<Integer> left;   // Max Heap
    PriorityQueue<Integer> right;  // Min Heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to max heap
        left.offer(num);

        // Step 2: Move largest of left to right
        right.offer(left.poll());

        // Step 3: Balance heaps
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */