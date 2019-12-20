package logic.model;

public class Product {
		
		private String gadgetName;
		private int value;
		
		public Product(String gadgetName, int value) {
			
			this.gadgetName = gadgetName;
			this.value = value;
		}
		
		public void setGadgetName(String gadgetName) {
			
			this.gadgetName = gadgetName;
		}
		
		public void setValue(int value) {
			
			this.value = value;
		}
		
		
		public String getGadgetName() {
			
			return this.gadgetName;
		}
		
		public int getValue() {
			
			return this.value;
		}
}
