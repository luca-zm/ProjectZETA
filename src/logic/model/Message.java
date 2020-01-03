package logic.Model;

public class Message {
	
	private int id;
	private String title;
	private String bodymessage;
	private MesType type;
	
	
	
	public Message(int id, String title, String bodymessage, MesType type) {
		this.id = id;
		this.title = title;
		this.bodymessage = bodymessage;
		this.type = type;
	}

	public int getId() {return id;}

	public String getTitle() {return title;}

	public String getBodymessage() {return bodymessage;}
	
	public MesType getType() {return type;}

	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", bodymessage=" + bodymessage + ", type=" + type + "]";
	}
	
	
}
