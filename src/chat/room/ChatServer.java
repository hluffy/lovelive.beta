package chat.room;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

@ServerEndpoint("/websocket")
public class ChatServer {
	
	private static final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	@OnOpen
	public void open(Session session){
		
	}
	
	@OnMessage
	public void getMessage(String message,Session session){
		System.out.println(message);
		System.out.println(session);
		System.out.println(session.hashCode());
		JSONObject jsonObject = JSONObject.fromObject(message);
		jsonObject.put("date", DATA_FORMAT.format(new Date()));
		
		for(Session openSession:session.getOpenSessions()){
			// 添加本条消息是否为当前会话本身发的标志
			jsonObject.put("isSelf", openSession.equals(session));
			// 发送JSON格式的消息
			openSession.getAsyncRemote().sendText(jsonObject.toString());
		}
		System.out.println(jsonObject.toString());
		
	}
	
	@OnClose
	public void close(){
		
	}
	
	@OnError
	public void error(Throwable th){
		
	}

}
