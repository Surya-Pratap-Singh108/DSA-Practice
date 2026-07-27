class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->{
                return b-a;//max Heap
            }
            );
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            pq.add(value);
        }
        
        Queue<int[]> q = new LinkedList<>();

        int time = 0;
        
        while((!pq.isEmpty())||(!q.isEmpty())){
            time++;
            
            if(!pq.isEmpty()){
                int curr=pq.poll();
                curr--;
                if(curr>0) q.add(new int[]{curr,time+n});
            }
            
            // if(!q.isEmpty()&&q.peek()[1]==time){
            //     pq.add(q.poll()[0]);
            // }
             // release all ready tasks
            while (!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}