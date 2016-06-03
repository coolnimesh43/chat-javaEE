
package org.nimesh43.chat.pojo;

import javax.validation.constraints.NotNull;

public class ChatMessage extends Message {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String message;

    @NotNull
    private User target;

    @NotNull
    private User user;

    public ChatMessage(String message, User target, User user) {
        super();
        this.message = message;
        this.target = target;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ChatMessage [message=" + message + ", target=" + target + ", user=" + user + ", type=" + type + "]";
    }

}
