
package org.nimesh43.chat.pojo;

public class LeaveMessage extends Message {

    private User user;

    public LeaveMessage(User user, String type) {
        super(type);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LeaveMessage [user=" + user + ", type=" + type + "]";
    }

}
