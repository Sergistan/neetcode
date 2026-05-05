package com.utochkin.Heap_Priority_Queue;

import java.util.*;

public class Twitter {

    private int count;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--, tweetId});  //count = “время” и count-- т.к. чем меньше число → тем новее твит
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;  // берем последний элемент = самый свежий
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!minHeap.isEmpty() && result.size() < 10) {
            int[] curr = minHeap.poll();
            result.add(curr[1]);
            int index = curr[3];
            if (index > 0) {
                int[] tweet = tweetMap.get(curr[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 10); // User 1 posts a new tweet with id = 10.
        twitter.postTweet(2, 20); // User 2 posts a new tweet with id = 20.
        System.out.println(twitter.getNewsFeed(1));// User 1's news feed should only contain their own tweets -> [10].
        System.out.println(twitter.getNewsFeed(2));// User 2's news feed should only contain their own tweets -> [20].
        twitter.follow(1, 2);     // User 1 follows user 2.
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should contain both tweets from user 1 and user 2 -> [20, 10].
        System.out.println(twitter.getNewsFeed(2));  // User 2's news feed should still only contain their own tweets -> [20].
        twitter.unfollow(1, 2);   // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should only contain their own tweets -> [10].
    }
}
