class Solution {
    public int halveArray(int[] nums) {
        
        PriorityQueue<Double> pq=new PriorityQueue<>((a,b)-> Double.compare(b,a));
        
        double sum=0;
        double removedSum=0;
        
        for(int num : nums){
            sum+=num;
            pq.offer((double)num);
        }
        int operation=0;

        while(removedSum<(sum/2.0)){
            double largest= pq.poll();
            double half=largest/2.0;
            removedSum+=half;
            pq.offer(half);
            operation++;
        }
        
        return operation;
        
    }
}