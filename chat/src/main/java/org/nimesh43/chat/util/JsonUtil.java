
package org.nimesh43.chat.util;

import java.io.IOException;

import org.json.JSONObject;
import org.nimesh43.chat.pojo.ChatMessage;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static JSONObject encodeToJson(Object object) {
        return new JSONObject(object);
    }

    public static ChatMessage decodeFromJson(String json)
        throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, ChatMessage.class);
    }

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
