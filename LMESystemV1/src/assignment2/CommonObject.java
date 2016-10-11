package assignment2;

public abstract class CommonObject implements CommonInterface {
	private char prefixId;
	// private int numId;
	private String objectId;
	private String title;
	private boolean isActive;
	
	////////////////////////////////////////////////////////////////////////
	// getters and setters
	//
	// Methods from CommonInterface
	// getPrefixId, getNumId, activate, deactivate, print

	public char getPrefixId(String objectId) {
		try {
			this.prefixId = objectId.charAt(0);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return this.prefixId;
	}
	
	public int getNumId(String objectId) {
		try {
			Integer.parseInt(objectId.substring(1, 6));
 		}
 		catch(NumberFormatException e) {
			// System.out.println("Format Error: " + e.toString());
 			this.isActive = false;
 		}
		return Integer.parseInt(objectId.substring(1, 6));
	}
	
	public boolean setObjectId(String objectId) {
		this.objectId = objectId;
		return true;
	}
	
	public String getObjectId() {
		return this.objectId;
	}
	
	public boolean setTitle(String title) {
		if(title.length() > 0) {
			this.title = title;
			return true;
		}
		else {
			System.out.println("Error: Title or Memeber full name cannot be left blank!");
			return false;
		}
	}
	
	public String getTitle() {
	 	return this.title;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}
	
	public abstract boolean activate();
	
	public abstract boolean deactivate();
	////////////////////////////////////////////////////////////////////////
	
	public abstract String print();
}
