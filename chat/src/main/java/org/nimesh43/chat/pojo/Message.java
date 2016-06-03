
package org.nimesh43.chat.pojo;

import java.io.Serializable;

public abstract class Message implements Serializable {

    public String type;

    public Message() {
        super();
    }

    public Message(String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
