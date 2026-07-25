class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minheap=new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        HashMap<Integer,Integer>map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
        
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element=entry.getKey();
            int frequency=entry.getValue();
            minheap.offer(new int[]{frequency,element});
            
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i]=minheap.poll()[1];
        }
        
        return ans;
        
	}
}