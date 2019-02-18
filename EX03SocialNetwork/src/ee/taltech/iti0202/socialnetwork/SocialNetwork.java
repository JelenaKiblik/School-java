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
//    private Message message;
    private Group group;

    public void registerGroup(Group group) {
        socialNetworkList.add(group);
    }

    public Set<Group> getGroups() {
        return socialNetworkList;
    }

    public Feed getFeedForUser(User user) {
        for (Message message : group.getMessages()) {
            if (user == message.getAuthor()) {
                messages.add(message);
            }
//        if (user == message.getAuthor() && group.getParticipants().contains(message.getAuthor())) {
//            messages.add(message);
//            return new Feed(user, messages);
//        } else {
//            return null;
        }
        return new Feed(user, messages);
    }
}
