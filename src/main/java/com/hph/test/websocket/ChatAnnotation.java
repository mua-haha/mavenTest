package com.hph.test.websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ServerEndpoint(value = "/server", configurator = GetHttpSessionConfigurator.class)
public class ChatAnnotation {

    private static final Log log = LogFactory.getLog(ChatAnnotation.class);

    private static final Set<ChatAnnotation> connections =
            new CopyOnWriteArraySet<>();
    private Session session;

    public ChatAnnotation() {
        
    }


    @OnOpen
    public void start(Session session, EndpointConfig config) {
        this.session = session;
        /*HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        httpSession.setAttribute("webSession", session);*/
        connections.add(this);
        System.out.println("onOpen");
        String message = "初始化";
        broadcast(message);
    }


    @OnClose
    public void end() {
        connections.remove(this);
        String message = "抽奖结束";
        broadcast(message);
    }


    @OnMessage
    public void incoming(String message) {
        // Never trust the client
        broadcast(message);
    }




    @OnError
    public void onError(Throwable t) throws Throwable {
        log.error("系统出现错误: " + t.toString(), t);
    }


    public static void broadcast(String msg) {
        for (ChatAnnotation client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                log.debug("Chat Error: Failed to send message to client", e);
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
            }
        }
    }
}