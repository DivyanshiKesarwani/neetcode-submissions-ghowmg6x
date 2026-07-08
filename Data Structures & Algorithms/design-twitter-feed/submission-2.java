class Twitter {

    int time;
    HashMap<Integer, Set<Integer>> followMap;
    HashMap<Integer, List<Tweets>> tweetMap;

    class Tweets {
        int tweetId;
        int time;

        Tweets(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        Tweets tweet = new Tweets(tweetId, time);

        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }

        tweetMap.get(userId).add(tweet);
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweets> pq =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        List<Integer> arr = new ArrayList<>();

        if(tweetMap.containsKey(userId))
        {
            for(Tweets tweet:tweetMap.get(userId))
            {
                pq.add(tweet);
            }
        }
        if(followMap.containsKey(userId))
        {
            for(int followee:followMap.get(userId))
            if (tweetMap.containsKey(followee))
            {
               for(Tweets tweet:tweetMap.get(followee))
            {
                pq.add(tweet);
            } 
            }
        }
        while(!pq.isEmpty() && arr.size()<10)
        {
            Tweets t=pq.poll();
            arr.add(t.tweetId);
        }
        return arr;
        // // User's own tweets
        // if (tweetMap.containsKey(userId)) {
        //     for (Tweets tweet : tweetMap.get(userId)) {
        //         pq.add(tweet);
        //     }
        // }

        // // Followees' tweets
        // if (followMap.containsKey(userId)) {
        //     for (int followee : followMap.get(userId)) {

        //         if (tweetMap.containsKey(followee)) {
        //             for (Tweets tweet : tweetMap.get(followee)) {
        //                 pq.add(tweet);
        //             }
        //         }
        //     }
        // }

        // while (!pq.isEmpty() && ans.size() < 10) {
        //     ans.add(pq.poll().tweetId);
        // }

        // return ans;
    }

    public void follow(int followerId, int followeeId) {

    if (followerId == followeeId) {
        return;
    }

    if (!followMap.containsKey(followerId)) {
        followMap.put(followerId, new HashSet<>());
    }

    followMap.get(followerId).add(followeeId);
}

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}