package logic;

import java.io.IOException;

public class ManagerClick {

	WinNext a = new WinNext();
	
	public void goToPath(String event, String id, String style, String label, String path) {
		
		if(event.contentEquals("Button[id="+ id +", styleClass="+ style +"]'"+ label +"'")){
			try {
				a.openWin(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public Boolean check(String event, String id, String style, String label) {
		
		return event.contentEquals("Button[id="+ id +", styleClass="+ style +"]'"+ label +"'");
	}	
}
