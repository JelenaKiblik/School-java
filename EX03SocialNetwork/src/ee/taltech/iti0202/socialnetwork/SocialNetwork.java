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
    private Message message;
    private Group group;
    private Set<Message> userMessages;

    public void registerGroup(Group group) {
        socialNetworkList.add(group);
    }

    public Set<Group> getGroups() {
        return socialNetworkList;
    }

    public Feed getFeedForUser(User user) {
        for (Group group : socialNetworkList)
            if (group.getParticipants().contains(user)
                    && group.getMessages().contains(message)
                    && user == message.getAuthor()) {
                 userMessages.add(message);
            }
        return new Feed(user, userMessages);
    }
}
