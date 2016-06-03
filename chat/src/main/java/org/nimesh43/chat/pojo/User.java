
package org.nimesh43.chat.pojo;

public class User {

    private String name;
    private String userName;

    public User() {
        super();
    }

    public User(String name, String userName) {
        super();
        this.name = name;
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", userName=" + userName + "]";
    }

}
