package ee.taltech.iti0202.socialnetwork.group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private String name;
    private User owner;
    private Set<User> groupList = new HashSet<>();
    private List<Message> messages = new ArrayList<>();


    public Group(String name, User owner) {
        this.name = name;
        this.owner = owner;
        groupList.add(owner);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        if (groupList.contains(owner)) {
            return owner;
        } else {
            return null;
        }
    }

    public void addUser(User user) {
        groupList.add(user);
    }

    public Set<User> getParticipants() {
        return groupList;
    }

    public void publishMessage(Message message) {
        if (!groupList.isEmpty()) messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }
}
