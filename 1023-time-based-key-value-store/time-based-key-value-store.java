
class TimeMap {
    class Pair{
        int time;
        String val;
        Pair(int _time,String _val){
            time=_time;
            val=_val;
        }
    }
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> l=new ArrayList<>();
        if(map.containsKey(key)){
            l=map.get(key);
        }
        Pair curr=new Pair(timestamp,value);
        l.add(curr);
        map.put(key,l);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        else return bsearch(map.get(key),timestamp);
        
    }
    public String bsearch(List<Pair> l,int timestamp){
        String ans = "";
        int low = 0;
        int high = l.size() - 1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(l.get(mid).time>timestamp){
                high=mid-1;
            }
            else{
                ans=l.get(mid).val;
                low=mid+1;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */