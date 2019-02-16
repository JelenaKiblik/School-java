package ee.taltech.iti0202.socialnetwork;
import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.HashSet;
import java.util.Set;

public class SocialNetwork {
    Set<Group> socialNetwork = new HashSet<>();

    public void registerGroup(Group group) {
        socialNetwork.add(group);
    }

    public Set<Group> getGroups() {
        return socialNetwork;
    }

    public Feed getFeedForUser(User user) {
//        return new Feed(null, null);
        return null;
    }

}
