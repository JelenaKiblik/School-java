package ee.taltech.iti0202.socialnetwork;
import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SocialNetwork {
    private Set<Group> socialNetworkList = new HashSet<>();
    private List<Message> userMessages = new ArrayList<>();

    public void registerGroup(Group group) {
        socialNetworkList.add(group);
    }

    public Set<Group> getGroups() {
        return socialNetworkList;
    }

    public Feed getFeedForUser(User user) {
        if (user != null) {
            return new Feed(user, null);
        } else {
            return null;
        }
    }
}
