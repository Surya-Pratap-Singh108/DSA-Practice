class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans=new LinkedList<>();
        boolean[] isUsed=new boolean[nums.length];
        if(nums.length==0)return ans;
        temp(new LinkedList<>(),ans,nums,0,isUsed);
        return ans;
	}
	public void temp(List<Integer> curr,List<List<Integer>> ans,int[] nums,int idx, boolean[] isUsed){
	    
	    
	    if(curr.size()==nums.length){
	        ans.add(new LinkedList<>(curr));
	        return;
	    }
	    
	    for(int i=0;i<nums.length;i++){
	        
	        if(isUsed[i]==true){
	            continue;
	        }
	        curr.add(nums[i]);
	        isUsed[i]=true;
	        
	        temp(curr,ans,nums,idx+1,isUsed);
	        
	        curr.remove(curr.size() - 1);
	        isUsed[i]=false;
	        
	    }
	}
}