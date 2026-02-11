class Twitter {
    Map<Integer, Set<Integer>> follows;
    Map<Integer, List<int[]>> tweets;
    int timestamp;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();      
        timestamp = 0;  
    }
    
    public void postTweet(int userId, int tweetId) {
        Set<Integer> listOfUsers = follows.getOrDefault(userId, new HashSet<>());
        listOfUsers.add(userId);
        follows.put(userId, listOfUsers);

        List<int[]> tweet = tweets.getOrDefault(userId, new ArrayList<>());
        tweet.add(new int[]{timestamp++, tweetId});
        tweets.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> listOfUsers = follows.getOrDefault(userId, new HashSet<>());
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        
        for (int user : listOfUsers) {
            List<int[]> tweet = tweets.getOrDefault(user, new ArrayList<>());
            pQueue.addAll(tweet);
        }

        List<Integer> feeds = new ArrayList<>();

        while (!pQueue.isEmpty() && feeds.size() != 10) {
            feeds.add(pQueue.poll()[1]);
        }

        return feeds;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> listOfUsers = follows.getOrDefault(followerId, new HashSet<>());
        listOfUsers.add(followeeId);
        follows.put(followerId, listOfUsers);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> listOfUsers = follows.getOrDefault(followerId, new HashSet<>());
        listOfUsers.remove(followeeId);
        follows.put(followerId, listOfUsers);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */