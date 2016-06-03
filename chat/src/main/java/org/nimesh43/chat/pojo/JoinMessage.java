
package org.nimesh43.chat.pojo;

public class JoinMessage extends Message {

    private static final long serialVersionUID = 1L;

    private User joinedUser;

    public JoinMessage(User joinedUser) {
        super();
        this.joinedUser = joinedUser;
    }

    public User getJoinedUser() {
        return joinedUser;
    }

    public void setJoinedUser(User joinedUser) {
        this.joinedUser = joinedUser;
    }

    @Override
    public String toString() {
        return "JoinMessage [joinedUser=" + joinedUser + ", type=" + type + "]";
    }

}
