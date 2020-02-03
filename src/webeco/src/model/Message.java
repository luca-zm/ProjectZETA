package model;
import enums.MesType;

public class Message {
	
	private int id;
	private String date;
	private String title;
	private String bodymessage;
	private MesType type;
	
	
	
	public Message(int id, String date, String title, String bodymessage, MesType type) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.bodymessage = bodymessage;
		this.type = type;
	}
	

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setBodymessage(String bodymessage) {
		this.bodymessage = bodymessage;
	}


	public void setType(MesType type) {
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
