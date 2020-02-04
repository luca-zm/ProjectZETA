package laptopeco.logic;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import laptopeco.logic.model.AbstractUser;

public class ManagerClick {

	WinNext a = new WinNext();
	String first="Button[id=";
	String second=", styleClass=";
	
	public void goToPath(String event, String id, String style, String label, String path) {
		
		if(event.contentEquals(first + id + second + style +"]'"+ label +"'")){
			try {
				a.openWin(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public Boolean check(String event, String id, String style, String label) {
		
		return event.contentEquals(first + id + second + style +"]'"+ label +"'");
	}	
	
	
	
	
	public void checkWarn(ActionEvent event, String id, String style, String label, String path, AbstractUser user) throws IOException {
		
        String eventClicked = event.getSource().toString();

		Stage oldWin = (Stage) ((Node) event.getSource()).getScene().getWindow();
		if(eventClicked.contentEquals(first + id + second + style +"]'"+ label +"'")){
			if(user != null) {
				a.openWin(path);
			}else {
				a.openWarning(oldWin);
			}
		}
	}
	
}
