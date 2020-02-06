package laptopeco.test.model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.Test;

import laptopeco.ExceptionEco.AddressNotFoundException;
import laptopeco.bean.CollectionPointBean;
import laptopeco.controller.ControllerManageCollPoint;
import laptopeco.logic.model.CollectionPoint;
import laptopeco.logic.persistence.CollectionPointDAO;

//Davide Verardo Test ControllerManageCollPoint


public class testInsertCollPoint {

	ControllerManageCollPoint c = new ControllerManageCollPoint();
	CollectionPointBean coltest = new CollectionPointBean(2, "CollectionPointTest" , "Via del Quadraro 72", 10, 20);
	double testlat = 41.8555535; //Confirmed by Google API
	double testlon = 12.5525593; //Confirmed by Google API
	CollectionPoint coltest2 = new CollectionPoint(12, "Colosseo Quadrato", 12.4653328, 41.8366849, "Colosseo Quadrato Roma", 10, 19); 
		
	
	@Test
	public void testInsert() throws SQLException, IOException, AddressNotFoundException { //Confirms the insertion of a collection point on the map
		
		assertEquals(c.insert(coltest),true); 
		
		
	}
	
	@Test
	public void testCollPointInsertCorrectness() throws SQLException { //Confirms the correct entry of the coordinates of the Collection Point 
																		//by comparing it with the right coordinate
		double test = 0;
		for ( CollectionPoint p : CollectionPointDAO.select()) { 
			if ( p.getLatitude() == testlat) {
				test = p.getLongitude();
			}
		}
		
		assertEquals(test, testlon,0);
			
		}
	
	@Test
	public void testdelete() throws SQLException, IOException { //Confirms the insertion of a collection point on the map
		
		c.delete(coltest2);
		boolean var = false;
		for ( CollectionPoint p : CollectionPointDAO.select()) { 
			if ( p.getLatitude() == coltest2.getLatitude() && p.getLongitude() == coltest2.getLatitude()) {
				var = true;
			}
		}
		assertEquals(false, var);
		
		
	}
	
		
		
	
}