class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maximum(piles);
        int ans = high;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(isSatisfy(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
	}
	public boolean isSatisfy(int[] piles,int k, int h){
	    for(int pile:piles){
	        if(pile%k==0)h-=pile/k;
	        else h-=pile/k+1;
	    }
	    if(h>=0)return true;
	    return false;
	}
    public int maximum(int[] piles){ 
        int max=Integer.MIN_VALUE;
        for(int num:piles){ max=Math.max(num,max); } 
        return max; 
        }
}