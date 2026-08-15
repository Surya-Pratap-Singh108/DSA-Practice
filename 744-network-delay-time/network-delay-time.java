class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);

        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] curr : times) {

            int u = curr[0]-1;
            int v = curr[1]-1;
            int wt = curr[2];

            list.get(u).add(new int[]{v, wt});
        }

        PriorityQueue<int[]> heap =
            new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        heap.add(new int[]{0, k-1});

        time[k-1]=0;

        while (!heap.isEmpty()) {

            int[] curr = heap.poll();
        
            int currDistance = curr[0];
            int node = curr[1];
        
            if (currDistance > time[node]) {
                continue;
            }
        
            for (int[] neighbor : list.get(node)) {
        
                int nextNode = neighbor[0];
                int weight = neighbor[1];
        
                if (currDistance + weight < time[nextNode]) {
        
                    time[nextNode] = currDistance + weight;
        
                    heap.add(new int[]{time[nextNode], nextNode});
                }
            }
        }

        int ans=0;

        for(int i=0;i<n;i++){

            if(time[i]==Integer.MAX_VALUE){
                return -1;
            }

            ans=Math.max(ans,time[i]);
        }
        
        return ans;
    }
}