import java.awt.*;
import java.util.List;
import java.util.Map;

public class Channel extends ChatSpace {
    private String name;
    private List<User> admins;
    private String topic;
    private Map<User, Color> colors ;

    public Channel() {}

    public Channel(String name, List<User> admins, String topic, Map<User, Color> colors) {
        this.name = name;
        this.admins = admins;
        this.topic = topic;
        this.colors = colors;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public List<User> getAdmins() {
        return admins;
    }

    public void setAdmins(List<User> admins) {
        this.admins = admins;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Map<User, Color> getColors() {
        return colors;
    }

    public void setColors(Map<User, Color> colors) {
        this.colors = colors;
    }

    public List<User> members() {
        return null;
    }

    public List<MainMessage> messages() {
        return null;
    }
}
