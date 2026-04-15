
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
        this.data=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // List<Pair<Integer,String>> newList=new ArrayList<>();
        // newList.add(new Pair<>(timestamp,key)); 
        this.data.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values=(List<Pair<Integer,String>>) this.data.getOrDefault(key,new ArrayList<>());
        int l=0;
        int r=values.size()-1;
        String result="";
        while(l<=r){
            int mid=l+(r-l)/2;
            if(values.get(mid).getKey()<=timestamp){
                result=values.get(mid).getValue();
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return result;
    }
}
