
package org.nimesh43.chat.util;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.nimesh43.chat.pojo.JoinMessage;

public class JoinMessageEncorder implements Encoder.Text<JoinMessage> {

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(JoinMessage object)
        throws EncodeException {
        return JsonUtil.encodeToJson(object).toString();
    }

}
