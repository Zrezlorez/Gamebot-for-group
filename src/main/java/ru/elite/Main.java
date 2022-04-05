package ru.elite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;
import ru.elite.model.Data;

import java.io.IOException;
import java.util.List;
import java.util.Random;

class Main{
    private static final Random random = new Random();
    private static final TransportClient transportClient = HttpTransportClient.getInstance();
    public static VkApiClient vk = new VkApiClient(transportClient);

    static String token = "c53619db37f00a8b5dcf331bb8952cfedb607932b44a3d0b8b8c6f9b2f60bafa8c3c512b237a34e004323";
    static int groupId = 205847122;

    public static GroupActor group = new GroupActor(groupId, token);
    public static void main(String[] args) throws ClientException, ApiException, IOException, InterruptedException {

        Gson parser = new GsonBuilder().setPrettyPrinting().create();
        Data data = parser.fromJson(Data.Load(), Data.class);






        Integer ts = vk.messages().getLongPollServer(group).execute().getTs();
        while (true){
            MessagesGetLongPollHistoryQuery historyQuery =  vk.messages().getLongPollHistory(group).ts(ts);
            List<Message> messages = historyQuery.execute().getMessages().getItems();

            if (!messages.isEmpty()){
                messages.forEach(message -> {
                    try {
                        User user = new User(message.getFromId().toString(), message.getPeerId().toString(), data);
                        user.addStats(message.getAttachments());


                        if(message.getText().equals("!profile")){
                            send(user.getProfile(), message.getPeerId());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }

            ts = vk.messages().getLongPollServer(group).execute().getTs();
            Data.Save(parser.toJson(data));
        }
    }


    static void send(String mes, Integer user_id) throws ClientException, ApiException {
        vk.messages().send(group).message(mes).peerId(user_id).randomId(random.nextInt(10000)).execute();
    }
}
