class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int currDigitSum=digitSum(nums[i]);
            if(i==currDigitSum)return i;
        }
        return -1;
    }
    private int digitSum(int n){
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        return sum;
    }
}