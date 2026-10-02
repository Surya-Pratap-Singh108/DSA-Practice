class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i]-1;
            if ( nums[i] !=nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
            }
            List<Integer> brr=new ArrayList<>();
        for (int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                brr.add(j+1);
            }
        }
        return brr;
    } 
    public void swap(int []arr,int a,int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}