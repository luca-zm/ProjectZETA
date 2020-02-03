package logic;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import logic.model.AbstractUser;

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
	
	
	
	
	public void checkWarn(ActionEvent event, String id, String style, String label, String path, AbstractUser user) throws IOException {
		
        String eventClicked = event.getSource().toString();

		Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
		if(eventClicked.contentEquals("Button[id="+ id +", styleClass="+ style +"]'"+ label +"'")){
			if(user != null) {
				a.openWin(path);
			}else {
				a.openWarning(oldWin);
				return;
			}
			return;
		}
	}
	
}
