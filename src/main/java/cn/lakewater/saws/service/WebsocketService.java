package cn.lakewater.saws.service;

import cn.lakewater.saws.session.WebsocketSessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Service
@Slf4j
public class WebsocketService {

    /**
     * 发送消息
     *
     * @param session
     * @param text
     * @return
     * @throws IOException
     */
    public void sendMsg(WebSocketSession session, String text) throws IOException {
        session.sendMessage(new TextMessage(text));
    }



    /**
     * 广播消息
     *
     * @param text
     * @return
     * @throws IOException
     */
    public void broadcastMsg(String text) throws IOException {
        for (WebSocketSession session : WebsocketSessionManager.SESSION_POOL.values()) {
            session.sendMessage(new TextMessage(text));
        }
    }

}