package ee.taltech.iti0202.socialnetwork;
import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;
import java.util.HashSet;
import java.util.Set;

public class SocialNetwork {
    private Set<Group> socialNetworkList = new HashSet<>();
    private Set<Message> messages;

    public void registerGroup(Group group) {
        socialNetworkList.add(group);
    }

    public Set<Group> getGroups() {
        return socialNetworkList;
    }

    public Feed getFeedForUser(User user) {
        return new Feed(user, messages);
        }
}
