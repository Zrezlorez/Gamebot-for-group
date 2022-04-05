package ru.elite.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class Data {
    private Settings settings;
    private Map<String, Conversation> conversations;

    public Settings getSettings() { return settings; }
    public void setSettings(Settings value) { this.settings = value; }

    public Map<String, Conversation> getConversations() { return conversations; }
    public void setConversations(Map<String, Conversation> value) { this.conversations = value; }

    static final Path path = Paths.get("src/main/resources/data.json");

    public static String Load() throws IOException {
        return Files.lines(path).collect(Collectors.joining("\n"));

    }
    public static void Save(String json) throws UnsupportedEncodingException {
        byte[] strToBytes = json.getBytes("UTF-8");
        try{
            Files.write(path, strToBytes);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
