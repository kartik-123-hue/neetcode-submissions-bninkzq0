class Twitter {
    int count=0;
    HashMap<Integer,HashSet<Integer>> followers;
    HashMap<Integer,List<int[]>> tweetMap;

    public Twitter() {
        this.count=0;
        this.followers=new HashMap<>();
        this.tweetMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId,k->new ArrayList<>()).add(new int[]{count--,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparing(a->a[0]));
        followers.computeIfAbsent(userId,k->new HashSet<>()).add(userId);
        for(int followerId:followers.get(userId)){
            if(tweetMap.containsKey(followerId)){
                List<int[]> tweets=tweetMap.get(followerId);
                int lastIndex=tweets.size()-1;
                int[] tweet=tweets.get(lastIndex);
                minHeap.offer(new int[]{tweet[0],tweet[1],followerId,lastIndex});
            }
        }
        while(!minHeap.isEmpty() && res.size()<10){
            int[] tweetData=minHeap.poll();
            res.add(tweetData[1]);
            int lastIndex=tweetData[3];
            if(lastIndex>0){
                int[] tweet=tweetMap.get(tweetData[2]).get(lastIndex-1);
                minHeap.offer(new int[]{
                    tweet[0],tweet[1],tweetData[2],lastIndex-1
                });
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.computeIfPresent(followerId,(k,v)->{
            v.remove(followeeId);
            return v;
        });
    }
}
