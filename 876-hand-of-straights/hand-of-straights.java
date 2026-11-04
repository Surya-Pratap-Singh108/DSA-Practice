class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
		if (hand.length % groupSize != 0) {
            return false;
        }
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for(int num:hand){
		    map.put(num,map.getOrDefault(num,0)+1);
		}
		
		while(map.size()>0){
		    int firstKey = map.firstKey();
		    for(int i=0;i<groupSize;i++){
		        int curr = firstKey + i;
		        
		        if(!map.containsKey(curr))return false;
		        
    		    if(map.get(curr)==1){
    		        map.remove(curr);
    		    }
    		    else{
    		        map.put(curr,map.get(curr)-1);
    		    }
		        
		    }
		}
		
		return true;
	}
}