class Solution {
    public int subtractProductAndSum(int n) {
        int m=n;
        int pro=1;
        int sum=0;
        while(m>0){
            int rem=m%10;
            pro=pro*rem;
            sum=sum+rem;
            m=m/10;
        }
        return pro-sum;
    }
}