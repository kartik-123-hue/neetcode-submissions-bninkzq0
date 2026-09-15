class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int n:nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        List<Integer>[] bucket=new List[nums.length+1];
        for(int i=0;i<=nums.length;i++){
            bucket[i]=new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] res=new int[k];
        int index=0;
        for(int i=bucket.length-1;i>=0  && index<k;i--){
            if(!bucket[i].isEmpty()){
                for(int n:bucket[i]){
                    res[index++]=n;
                }
            }
        }
        return res;
    }
}
