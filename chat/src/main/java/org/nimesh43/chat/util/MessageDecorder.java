
package org.nimesh43.chat.util;

import java.io.IOException;

import javax.inject.Inject;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import org.apache.logging.log4j.Logger;
import org.nimesh43.chat.pojo.ChatMessage;
import org.nimesh43.chat.pojo.Message;

public class MessageDecorder implements Decoder.Text<ChatMessage> {

    @Inject
    private Logger logger;

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public ChatMessage decode(String s) {
        logger.debug("String to be decoded is: {}", s);
        try {
            ChatMessage message = JsonUtil.decodeFromJson(s);
            return message;
        }
        catch (IOException e) {
            logger.error("Exception while decoding message. String is: {} Exception is: {}", s, e);
            return null;
        }

    }

    @Override
    public boolean willDecode(String s) {
        try {
            Message message = JsonUtil.decodeFromJson(s);
            if (message.getType() != null && message.getType().trim().length() != 0) {
                return true;
            }
        }
        catch (IOException e) {
            logger.error("Exception while decoding message. Exception is: {}", e);
        }
        return false;
    }

}
