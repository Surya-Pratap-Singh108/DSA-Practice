class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        Arrays.sort(potions);
        int []ans=new int[n];
        for(int i=0;i<n;i++){
            long required = (success + spells[i] - 1) / spells[i];
            
            ans[i]=bSearch(potions,required);
        }
        return ans;
    }
    public int bSearch(int[]potion,long target){
        int left=0;
        int right=potion.length-1;
        int ans=-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            if (potion[mid] >= target) {
            ans = mid;
            right = mid - 1;
         }
            else{
                left=mid+1;
            }
        }
        return ans==-1?0:potion.length-ans;
    }
}