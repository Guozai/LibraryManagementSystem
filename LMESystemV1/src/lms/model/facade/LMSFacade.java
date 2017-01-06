package lms.model.facade;


import lms.model.util.DateTime;
import assignment2.*;

public class LMSFacade 
{
	private LMSMerchant lmsMerchant = new LMSMerchant();
	/* you need to modify the methods below to forward calls to the methods in your library class
	 * and return the correct values to your menu. */
	
	public LMSFacade()
	{
		
	}
	
	private void initialiseEngine() 
	{
		
	}
	
	public boolean addBook(String id, String title, int numPages) 
	{
		return lmsMerchant.addBook(id, title, numPages);
	}

	public boolean addVideo(String id, String title, double loanFee, 
			double runningTime) 
	{
		return lmsMerchant.addVideo(id, title, loanFee, runningTime);
	}
	
	public boolean removeHolding(String holdingId) 
	{
		return lmsMerchant.removeHolding(holdingId);
	}
	
	public boolean addMember(String id, String name) 
	{
		return lmsMerchant.addMember(id, name);		
	}
	
	public boolean removeMember(String memberId)
	{
		return lmsMerchant.removeMember(memberId);
	}
	
	public boolean borrowHolding(String memberId, String holdingId)  
	{
		return lmsMerchant.borrowHolding(memberId, holdingId);
	}
	
	public boolean returnHolding(String memberId, String holdingId, DateTime dateReturned) 
	{
		return lmsMerchant.returnHolding(memberId, holdingId, dateReturned);
	}
	
	public String printAllHoldings()
	{
		return lmsMerchant.printAllHoldings();
	}
	
	public String printAllMembers()
	{
		return lmsMerchant.printAllMembers();
	}
	
	public String printSpecificHolding(String holdingId)
	{
		return lmsMerchant.printSpecificHolding(holdingId);
	}
	
	public String printSpecificMember(String memberId)
	{
		return lmsMerchant.printSpecificMember(memberId);
	}
	
	public boolean resetMembersCredit(String memberId)
	{
		return lmsMerchant.resetMembersCredit(memberId);
	}
	
	public double getLateFee(String memberId)
	{
		return lmsMerchant.getLateFee(memberId);
	}
	
	public double getMembersBalance(String memberId)
	{
		return lmsMerchant.getMembersBalance(memberId);
	}
	
	public boolean activate(String id)
	{
		return lmsMerchant.activate(id);
	}

	public boolean deactivate(String id)
	{
		return lmsMerchant.deactivate(id);
	}
	
	public void fileWriter() {
		lmsMerchant.fileWriter();
	}
	
	public void fileReader() {
		lmsMerchant.fileReader();
	}
	
	public void test() {
		lmsMerchant.test();
	}
}