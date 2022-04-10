package cl.uach.info090.semana04;

import java.util.Date;

public class Message {
	private String id;
	private String senderId;
	private String destinationId;
	private Date date;
	private String text;
	private static int msgCount;
	private int state;
	
	static {
		msgCount = 0;
	}
	
	public Message(String senderId, String destinationId, String text){
		this.senderId = senderId;
		this.destinationId = destinationId;
		this.text= text;
		msgCount++;
		id = "msg-"+msgCount;
		date = null;
		state = 0;
	}
	
	public boolean isSent() {
		return state > 0;
	}
	
	public boolean isReceived(){
		return state > 1;
	}
	
	public boolean isRead(){
		return state > 2;
	}

	public void send(){
		if(state==0) {
			state = 1;
			date = new Date();
		}
	}
	
	public void receive() {
		if(isSent() && !isReceived()) {
			state = 2;
		}
	}
	
	public void read() {
		if(isReceived() && isRead()) {
			state = 3;
		}
	}
	public String getText() {
		return text;
	}

	public Date getDate() {
		return date;
	}

	public int getState() {
		return state;
	}
	
	public String getDestinationId() {
		return destinationId;
	}

	public String getSenderId() {
		return senderId;
	}

	public String getId() {
		return id;
	}

	public static int getMsgCount() {
		return msgCount;
	}
	
}