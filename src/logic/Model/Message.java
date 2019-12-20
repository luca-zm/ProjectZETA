package logic.Model;

public class Message {
	
	private int id;
	private String title;
	private String bodymessage;
	private int type;
	
	
	
	public Message(int id, String title, String bodymessage, int type) {
		this.id = id;
		this.title = title;
		this.bodymessage = bodymessage;
		this.type = type;
	}
	
}
