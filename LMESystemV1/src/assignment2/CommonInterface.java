package assignment2;

// import java.util.StringTokenizer;

public interface CommonInterface {
	public char getPrefixId(String objectId);
	public int getNumId(String objectId);
	
	public boolean activate();
	public boolean deactivate();
	
	public String print();
}
