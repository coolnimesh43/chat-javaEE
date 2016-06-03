
package org.nimesh43.chat.util;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.nimesh43.chat.pojo.LeaveMessage;

public class LeaveMessageEncorder implements Encoder.Text<LeaveMessage> {

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(LeaveMessage object)
        throws EncodeException {
        return JsonUtil.encodeToJson(object).toString();
    }

}
