import java.time.LocalDate;
import java.util.*;

public abstract class Message {
    private User speaker;
    private String content;
    private LocalDate timeStamp;
    private Map<String, String> reactions;

    public Message() {
        this.reactions = new HashMap<>();
    }

    public Message(User speaker, String content, LocalDate timeStamp, Map<String, String> reactions){
        this.speaker = speaker;
        this.content = content;
        this.timeStamp = timeStamp;
        this.reactions = reactions;
    }

    public Map<String, String> getReactions() {
        return reactions;
    }

    public void setReactions(Map<String, String> reactions) {
        this.reactions = reactions;
    }

    public void add(String reactionName, String reactionEmoji){
        reactions.put(reactionName, reactionEmoji);
    }

    public void remove(String reactionName){
        reactions.remove(reactionName);
    }

    public String lookup(String reactionName){
        return reactions.get(reactionName);
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

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

}
