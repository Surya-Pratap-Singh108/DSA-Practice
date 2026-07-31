class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(new ArrayList<>(),0,ans,target,candidates,0);
        return ans;
    }
	public void helper(List<Integer> curr,int currSum,List<List<Integer>>ans,int target,int[] arr,int low){
	    if(currSum>target) return;
	    if(currSum==target){
	        ans.add(new ArrayList<>(curr));
	        return;
	    }
	    for(int i=0;i<arr.length;i++){
	        if(i<low)continue;
	        curr.add(arr[i]);
	        currSum+=arr[i];
	        
	        helper(curr,currSum,ans,target,arr,low);
	        
	        curr.remove(curr.size()-1);
	        currSum-=arr[i];
	        low++;
	    }
	}
}