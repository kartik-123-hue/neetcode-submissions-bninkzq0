class TimeMap {
    private static class Pair<K,V>{
        public final K key;
        public final V value;
        Pair(K key,V value){
            this.key=key;
            this.value=value;
        }

        public K getKey(){
            return this.key;
        }
        public V getValue(){
            return this.value;
        }

    }

    Map<String,List<Pair<Integer,String>>> data;

    public TimeMap() {
        data=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> dataAgainstKey=data.getOrDefault(key,new ArrayList<>());
        int low=0;
        int high=dataAgainstKey.size()-1;
        String result="";
        while(low<=high){
            int mid=(low+high)/2;
            if(dataAgainstKey.get(mid).getKey()<=timestamp){
                result=dataAgainstKey.get(mid).getValue();
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return result;
    }
}
