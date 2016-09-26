package assignment2;

public abstract class Holding implements CommonInterface, HoldingInterface {
	private char prefixCode;
	private int numCode;
	private String holdingId;
	private String title;
	private double loanFee;
	private int maxLoanDay;
	private double latePenaltyFee;
	private boolean isInactive = false;
	
	public Holding(String holdingId, String title) {
		this.holdingId = holdingId;
		this.title = title;
	}
	
	public void setLoanFee(double loanFee) {
		this.loanFee = loanFee;
	}
	public double getLoanFee() {
		return this.loanFee;
	}
	
	public void setMaxLoanDay(int maxLoanDay) {
		this.maxLoanDay = maxLoanDay;
	}
	public int getMaxLoanDay() {
		return this.maxLoanDay;
	}
	
	@Override
	public String toString() {
		
	}
	
	@Override
	public char getPrefixId(String holdingId) {
		return holdingId.charAt(0);
	}
	
	@Override
	public int getNumId(String holdingId) {
		try {
			Integer.parseInt(holdingId.substring(1, 6));
 		}
 		catch(NumberFormatException e) {
			System.out.println("Format Error: " + e.toString());
 		}
		return Integer.parseInt(holdingId.substring(1, 6));
	}
}
