class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new LinkedList<>();
        temp(n,new StringBuilder(),0,0,ans);
        return ans;
	}
	public void temp(int n,StringBuilder curr,int open,int close,List<String> ans){
	    if(close>open||open>n) return;
	    if(close==n){
	        ans.add(curr.toString());
	    
	        return;
	    }
	    
	    curr.append('(');
	    temp(n,curr,open+1,close,ans);
	    curr.deleteCharAt(curr.length() - 1);
	    curr.append(')');
	    temp(n,curr,open,close+1,ans);
	    curr.deleteCharAt(curr.length() - 1);
	}
}