import java.util.*;

public abstract class Message {
    private User speaker;
    private String content;
    private Date timeStamp;
    private Map<String, List<String>> reactions;

    public Message() {
    }

    public Message(User speaker, String content, Date timeStamp, Map<String, List<String>> reactions){
        this.speaker = speaker;
        this.content = content;
        this.timeStamp = timeStamp;
        this.reactions = reactions;
    }

    public Map<String, List<String>> getReactions() {
        return reactions;
    }

    public void setReactions(Map<String, List<String>> reactions) {
        this.reactions = reactions;
    }

    public void add(String reactionName, String reactionEmoji){
        List<String> emoji = new ArrayList<>();
        emoji.add(reactionEmoji);
        reactions.put(reactionName, emoji);
    }

    public void remove(String reactionName){
        reactions.remove(reactionName);
    }

    public List<String> lookup(String reactionName){
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}
