package logic.model;

import java.util.List;

public class NoticeBoard {

	private List<Message> list;

	public NoticeBoard(List<Message> list) {

		this.list = list;
	}


	public void setList(List<Message> list) {
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
	
	public List<Message> getList() {return list;}

	@Override
	public String toString() {
		return "NoticeBoard: " + list;
	}


	
	

}
