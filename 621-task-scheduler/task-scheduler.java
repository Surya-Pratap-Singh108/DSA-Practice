class Solution {

    class Pair {
        char ch;
        int freq;
        int availableTime;

        Pair(char ch, int freq, int availableTime) {
            this.ch = ch;
            this.freq = freq;
            this.availableTime = availableTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> b.freq - a.freq);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue(), 0));
        }

        Queue<Pair> q = new ArrayDeque<>();

        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {

            time++;
            if (!pq.isEmpty()) {

                Pair curr = pq.poll();

                curr.freq--;
                if (curr.freq > 0) {
                    curr.availableTime = time + n;
                    q.offer(curr);
                }
            }

            if (!q.isEmpty() && q.peek().availableTime == time) {
                pq.offer(q.poll());
            }
        }

        return time;
    }
}