class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int n:nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        List<Integer>[] buckets=new List[nums.length+1];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new ArrayList<>();
        }

        for(int n:freq.keySet()){
            buckets[freq.get(n)].add(n);
        }

        /*
        nums = [1,2,2,3,3,3], k = 2
        freq={
        1,1
        2,2
        3,3
        }

        bucket
        0,[0]
        1,1
        2,2
        3,3

        from last 
        3
        2
        */
        int index=0;
        int[] res=new int[k];
        for(int i=buckets.length-1;i>=0 && index<k;i--){
            for(int n:buckets[i]){
                res[index++]=n;
            }
        }

        return res;

    }
}
