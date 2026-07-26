class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return (b[0]-a[0]);
                
            }
            return arr[b[1]]-arr[a[1]];
        });
        
        for(int i=0;i<arr.length;i++){
            int distance=Math.abs(arr[i]-x);
            
            pq.offer(new int[]{distance,i});
            
            if(pq.size()>k){
                pq.poll();
            }
            
        }
        
        while(pq.size()>0){
            int index=pq.poll()[1];
            ans.add(arr[index]);
        }
        Collections.sort(ans);

        return ans;
        
    }
}