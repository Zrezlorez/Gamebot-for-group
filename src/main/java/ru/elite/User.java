package ru.elite;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.MessageAttachment;
import ru.elite.model.Conversation;
import ru.elite.model.Data;
import ru.elite.model.Profile;

import java.util.*;

public class User {
    String user_id, peer_id;
    Conversation conversation;
    Profile profile;
    User(String user_id, String peer_id, Data data) throws ClientException, ApiException {
        this.user_id = user_id;
        this.peer_id = peer_id;

        if(!data.getConversations().containsKey(peer_id))
            data.getConversations().put(peer_id, new Conversation());

        conversation = data.getConversations().get(peer_id);

        if(!conversation.getProfiles().containsKey(user_id)){
            conversation.getProfiles().put(user_id, new Profile());
            var name = Main.vk.users().get(Main.group).
                    userIds(user_id).execute().get(0);
            conversation.getProfiles().get(user_id).setName(name.getFirstName() + name.getLastName());

        }

        profile = conversation.getProfiles().get(user_id);
    }

    public void addStats(List<MessageAttachment> attachmentList) {
        profile.setMessageCount(profile.getMessageCount()+1);
        if(!attachmentList.isEmpty()){
            for (var attachment : attachmentList) {
                switch (attachment.getType().toString()) {
                    case "photo":
                        profile.setPhoto(arrayPlus(profile.getPhoto(), 0));
                        break;
                    case "audio":
                        profile.setAudio(arrayPlus(profile.getAudio(), 0));
                        break;
                    case "video":
                        profile.setVideo(arrayPlus(profile.getVideo(), 0));
                        break;
                    case "audio_message":
                        profile.setAudioMessage(arrayPlus(profile.getAudioMessage(), 0));
                        break;
                    case "sticker":
                        profile.setSticker(arrayPlus(profile.getSticker(), 0));
                        break;
                }
            }
        }
    }
    public String getProfile(){
        return String.format("%s\nФото - %d\nАудио - %d\nВидео - %d\nГс - %d\nСтикеры - %d\n",
                profile.getName(), profile.getPhoto()[0], profile.getAudio()[0], profile.getVideo()[0],
                profile.getAudioMessage()[0], profile.getSticker()[0]);
    }
    private long[] arrayPlus(long[] get, Integer index){
        get[index] += 1;
        return get;
    }
}
