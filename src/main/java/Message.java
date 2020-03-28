import java.util.Date;
import java.util.Map;

public abstract class Message {
    private User speaker;
    private String content;
    private Date timeStamp;
    private Map<String, Integer> reactions;

    public Message() {
    }

    public Message(User speaker, String content, Date timeStamp, Map<String, Integer> reactions){
        this.speaker = speaker;
        this.content = content;
        this.timeStamp = timeStamp;
        this.reactions = reactions;
    }

    public User getSpeaker() {
        return speaker;
    }

    public void setSpeaker(User speaker) {
        this.speaker = speaker;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Map<String, Integer> getReactions() {
        return reactions;
    }

    public void setReactions(Map<String, Integer> reactions) {
        this.reactions = reactions;
    }
}
