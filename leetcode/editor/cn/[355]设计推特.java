//设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个
//功能： 
//
// 
// postTweet(userId, tweetId): 创建一条新的推文 
// getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
// 
// follow(followerId, followeeId): 关注一个用户 
// unfollow(followerId, followeeId): 取消关注一个用户 
// 
//
// 示例: 
//
// 
//Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//twitter.getNewsFeed(1);
// 
// Related Topics 堆 设计 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Twitter {

    class TwitterNode{
        int userId;
        int twitterId;
        TwitterNode(int userId,int twitterId){
            this.userId = userId;
            this.twitterId = twitterId;
        }
    }
    List<TwitterNode> twitterNodeList;
    Map<Integer,Set> userMapper;

    /** Initialize your data structure here. */
    public Twitter() {
        twitterNodeList = new LinkedList<TwitterNode>();
        userMapper = new HashMap<Integer,Set>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMapper.containsKey(userId)){
            Set<Integer> tmp = new HashSet<>();
            tmp.add(userId);
            userMapper.put(userId,tmp);
        }
        TwitterNode node = new TwitterNode(userId,tweetId);
        twitterNodeList.add(0,node);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (userMapper.containsKey(userId)){
            Set<Integer> follows = userMapper.get(userId);
            int count = 0;
            for (TwitterNode node:twitterNodeList){
                if (count==10){
                    break;
                }
                if (follows.contains(node.userId)){

                    res.add(node.twitterId);
                }
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> focusSet;
        if (!userMapper.containsKey(followeeId)){
            focusSet = new HashSet<>();
            focusSet.add(followeeId);
            userMapper.put(followeeId,focusSet);
        }
        if (!userMapper.containsKey(followerId)){
            focusSet = new HashSet<>();
            focusSet.add(followerId);
            userMapper.put(followerId,focusSet);
        }
        userMapper.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId!=followeeId&&userMapper.containsKey(followerId)){
            if (userMapper.containsKey(followeeId)){
                userMapper.get(followerId).remove(followeeId);
            }
        }
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
//leetcode submit region end(Prohibit modification and deletion)
