class Solution {
    private int [] allMonths={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveA=calDays(arriveAlice);
        int leaveA=calDays(leaveAlice);
        int arriveB=calDays(arriveBob);
        int leaveB=calDays(leaveBob);
        int intersactions= Math.min(leaveA,leaveB)- Math.max(arriveA,arriveB)+1;
        return intersactions<0?0:intersactions;
        
    }
    public int calDays(String str){
        
        int months = Integer.parseInt(str.substring(0, 2)); 
        int days=Integer.parseInt(str.substring(3,5));
        int totalDays=0;
        for(int i=0;i<months-1;i++){
            totalDays+=allMonths[i];
        }
        totalDays=totalDays+days;
        return totalDays;
    }
}