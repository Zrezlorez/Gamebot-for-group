package ru.elite.model;

public class Types {
    private Audio audioMessage;
    private Audio video;
    private Audio audio;
    private Audio photo;
    private Audio sticker;

    public Audio getAudioMessage() { return audioMessage; }
    public void setAudioMessage(Audio value) { this.audioMessage = value; }

    public Audio getVideo() { return video; }
    public void setVideo(Audio value) { this.video = value; }

    public Audio getAudio() { return audio; }
    public void setAudio(Audio value) { this.audio = value; }

    public Audio getPhoto() { return photo; }
    public void setPhoto(Audio value) { this.photo = value; }

    public Audio getSticker() { return sticker; }
    public void setSticker(Audio value) { this.sticker = value; }
}
