package ru.elite.model;

public class Profile {
    private String name;
    private long messageCount;
    private long[] photo;
    private long[] video;
    private long[] audio;
    private long[] sticker;
    private long[] audioMessage;
    private long block;

    public Profile(){
        name = "";
        messageCount = 0;
        photo = new long[2];
        video = new long[2];
        audio = new long[2];
        sticker = new long[2];
        audioMessage = new long[2];
    }



    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getMessageCount() { return messageCount; }
    public void setMessageCount(long value) { this.messageCount = value; }

    public long[] getPhoto() { return photo; }
    public void setPhoto(long[] value) { this.photo = value; }

    public long[] getVideo() { return video; }
    public void setVideo(long[] value) { this.video = value; }

    public long[] getAudio() { return audio; }
    public void setAudio(long[] value) { this.audio = value; }

    public long[] getSticker() { return sticker; }
    public void setSticker(long[] value) { this.sticker = value; }

    public long[] getAudioMessage() { return audioMessage; }
    public void setAudioMessage(long[] value) { this.audioMessage = value; }

    public long getBlock() { return block; }
    public void setBlock(long value) { this.block = value; }
}
