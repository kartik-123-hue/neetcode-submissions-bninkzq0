class Twitter {
    HashMap<Integer,HashSet<Integer>> followers;
    HashMap<Integer ,List<int[]>> tweetMap;
    int count;
    // HashMap<String,HashSet<String>> unfollowers
    // PriorityQueue<

    public Twitter() {
        this.count=0;
        followers=new HashMap<>();
        tweetMap=new HashMap<>(); 
    }       
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId,k->new ArrayList<>()).add(new int[]{count--,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparing(a->a[0]));
        followers.computeIfAbsent(userId,k->new HashSet<>()).add(userId);
        for(int followId:followers.get(userId)){
            if(tweetMap.containsKey(followId)){
                List<int[]> tweets=tweetMap.get(followId);
                int index=tweets.size()-1;
                int[] tweet=tweets.get(index);
                minHeap.offer(new int[]{
                    tweet[0],tweet[1],followId,index
                });
            }
        }

        while(!minHeap.isEmpty() && res.size()<10){
            int[] curr=minHeap.poll();
            res.add(curr[1]);
            int index=curr[3];
            if(index>0){
                int[] tweet=tweetMap.get(curr[2]).get(index-1);
                minHeap.offer(new int[]{tweet[0],tweet[1],curr[2],index-1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}
