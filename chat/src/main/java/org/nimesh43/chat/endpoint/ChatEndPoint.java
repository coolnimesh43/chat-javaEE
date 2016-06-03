
package org.nimesh43.chat.endpoint;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.logging.log4j.Logger;
import org.nimesh43.chat.pojo.ChatMessage;
import org.nimesh43.chat.pojo.JoinMessage;
import org.nimesh43.chat.pojo.LeaveMessage;
import org.nimesh43.chat.pojo.Message;
import org.nimesh43.chat.pojo.User;
import org.nimesh43.chat.util.ChatMessageEncorder;
import org.nimesh43.chat.util.JoinMessageEncorder;
import org.nimesh43.chat.util.LeaveMessageEncorder;
import org.nimesh43.chat.util.MessageDecorder;

@ServerEndpoint(value = "/zoom/{name}/{userName}", encoders = { JoinMessageEncorder.class, ChatMessageEncorder.class,
    LeaveMessageEncorder.class }, decoders = { MessageDecorder.class })
public class ChatEndPoint {

    @Inject
    private Logger logger;

    private static Map<String, Session> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(
        Session session, EndpointConfig endpointConfig, @PathParam("name") String name, @PathParam("userName") String userName) {
        logger.debug("Inside ChatEndPoint#onOpen method. name is: {} userName is: {}", name, userName);
        User user = new User(name, userName);
        session.getUserProperties().put(userName, user);
        sessions.put(userName, session);
        JoinMessage joinMessage = new JoinMessage(user);
        joinMessage.setType("join");
        sendAll(session, joinMessage);
    }

    @OnMessage
    public void onMessage(Session session, ChatMessage message) {
        logger.debug("Inside ChatEndPoint#onMessage method. Received Message : {}", message);
        if (message instanceof ChatMessage) {
            User user = (User) session.getUserProperties().get(message.getUser().getUserName());
            if (user != null) {
                Session targetSession = sessions.get(message.getTarget().getUserName());
                if (targetSession != null) {
                    try {
                        message.setType("chat");
                        targetSession.getBasicRemote().sendObject(message);
                    }
                    catch (IOException | EncodeException e) {
                        logger.error("Exception while sending chat message. Exception is: {}", e);
                    }
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("userName") String userName) {
        logger.debug("Inside ChatEndPoint#onClose method. Session closed by : {}", userName);
        sessions.remove(userName);
        User user = (User) session.getUserProperties().get(userName);
        try {
            sendAll(session, new LeaveMessage(user, "leave"));
            session.close();
        }
        catch (IOException e) {
            logger.error("Exception while closing the session. Exception is: {}", e);
        }
    }

    private void sendAll(Session session, Message message) {
        logger.debug("Sending message. message {}", message);
        try {
            for (Session s : session.getOpenSessions()) {
                if (s.isOpen()) {
                    s.getBasicRemote().sendObject(message);
                }
            }
        }
        catch (IOException e) {
            logger.error("IOException while sending message. Exception is : {}", e);
        }
        catch (EncodeException e) {
            logger.error("EncodeException while encoding message. Exception is: {}", e);
        }
    }
}
