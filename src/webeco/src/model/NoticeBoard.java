package model;

import java.util.ArrayList;

public class NoticeBoard {

	private ArrayList<Message> list;

	public NoticeBoard(ArrayList<Message> list) {

		this.list = list;
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
		return "NoticeBoard: " + list;
	}


	
	

}
