package logic.model;

import java.util.ArrayList;

public class NoticeBoard {
	private int id;
	private ArrayList<Message> list;

	public NoticeBoard(int id, ArrayList<Message> list) {
		super();
		this.id = id;
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setList(ArrayList<Message> list) {
		this.list = list;
	}

	public Boolean addMessage(Message message) {
		if(message == null) {
			return false;
		}
		list.add(message);
		return true;
	}
	
	public Boolean deleteMessage(Message message) {
		if(list.remove(message)){
			return true;
		}
		else {
			return false;
		}
	}

	public void clear() {
		list.clear();
	}
	
	public ArrayList<Message> getList() {return list;}

	@Override
	public String toString() {
		return "NoticeBoard [id=" + id + ", list=" + list + "]";
	}


	
	

}
