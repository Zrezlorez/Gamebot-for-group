package ru.elite.model;

import java.util.HashMap;
import java.util.Map;

public class Conversation {
    private boolean disableTop;
    private long conversationMessageCount;
    private long conversationPhoto;
    private long conversationVideo;
    private long conversationAudio;
    private long conversationSticker;
    private long conversationAudioMessage;
    private Map<String, Profile> profiles;

    public Conversation(){
        profiles = new HashMap<>();
    }

    public boolean getDisableTop() { return disableTop; }
    public void setDisableTop(boolean value) { this.disableTop = value; }

    public long getConversationMessageCount() { return conversationMessageCount; }
    public void setConversationMessageCount(long value) { this.conversationMessageCount = value; }

    public long getConversationPhoto() { return conversationPhoto; }
    public void setConversationPhoto(long value) { this.conversationPhoto = value; }

    public long getConversationVideo() { return conversationVideo; }
    public void setConversationVideo(long value) { this.conversationVideo = value; }

    public long getConversationAudio() { return conversationAudio; }
    public void setConversationAudio(long value) { this.conversationAudio = value; }

    public long getConversationSticker() { return conversationSticker; }
    public void setConversationSticker(long value) { this.conversationSticker = value; }

    public long getConversationAudioMessage() { return conversationAudioMessage; }
    public void setConversationAudioMessage(long value) { this.conversationAudioMessage = value; }

    public Map<String, Profile> getProfiles() { return profiles; }
    public void setProfiles(Map<String, Profile> value) { this.profiles = value; }
}
