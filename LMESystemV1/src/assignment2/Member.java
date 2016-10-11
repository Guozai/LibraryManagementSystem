package assignment2;

public abstract class Member extends CommonObject implements CommonInterface, MemberInterface {
	private double credit;
	private int numHolding;
	private Holding[] holdings = new Holding[20];
	private static final double MAX_CREDIT_STANDARD_MEMBER = 30;
	private final double MAX_CREDIT_PREMIUM_MEMBER = 45;
	private char prefixId;
	
	public Member(String memberId, String fullName, int credit) {
		this.setObjectId(memberId);
		this.setTitle(fullName);
		
		if(getPrefixId(memberId) == 's') {
			if(credit == MAX_CREDIT_STANDARD_MEMBER) {
				this.credit = credit;
			}
			else {
				System.out.println("Re-enter the credit amount, must be 30.");
			}
		}
		else if(getPrefixId(memberId) == 'p') {
			if(credit == MAX_CREDIT_PREMIUM_MEMBER) {
				this.credit = credit;
			}
			else {
				System.out.println("Re-enter the credit amount, must be 45.");
			}
		}
		
	}
	
	////////////////////////////////////////////////////////////////////////
	// getters and setters
	//
	public boolean setObjectId(String memberId) {
		if (memberId.length() == 7) {
			prefixId = this.getPrefixId(memberId);

			if (this.prefixId == 's' || this.prefixId == 'p') {
				super.setObjectId(memberId);
				return true;
			} else {
				System.out.println("Error: object is not a member.");
				return false;
			}
		}
		else {
			System.out.println("Invalid memeber ID");
			return false;
		}
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	public double getCredit() {
		return this.credit;
	}
	
	//public void setHolding(String holdingId) {
	//	
	//}
	//public Holding getHolding() {
	//	
	//}
	
	/**public void getHoldingIdBorrowed() {
		if (holdings.length > 0) {
			holdingIdTemp += holdings[0].getHoldingId();
			for (int i = 1; i < holdings.length; i++) {
				holdingIdTemp += ":" + holdings[i].getHoldingId();
			}
		}
		return holdingIdTemp;
	}*/
	////////////////////////////////////////////////////////////////////////
	
	public boolean borrowHolding(Holding holding) {
		if (getIsActive() == true || credit > holding.getLoanFee()) {
			credit -= holding.getLoanFee();
			holdings[holdings.length-1] = holding;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**public boolean returnHolding(Holding holding, DateTime returnDate) {
		if(getPrefixId(memberId) == 's') {
			credit -= holding.calculateLateFee(returnDate);
			if(credit < 0) {
				removeHoldingFromArray(holding);
				credit += MAX_CREDIT_STANDARD_MEMBER;
			}
			return true;
		}
		else if(getPrefixId(memberId) == 'p') {
			credit -= holding.calculateLateFee(returnDate);
			if(credit < 0) {
				return isActive = false;
			}
			else {
				return isActive = true;
			}
		}
		else {
			System.out.println("Unknown error!");
			return false;
		}
	}*/
	
	private int arrayIndex = 0;
	public void removeHoldingFromArray(Holding holding) {
		numHolding = getNumId(holding.getObjectId());
		while(getNumId(holdings[arrayIndex].getObjectId()) != numHolding) {
			arrayIndex++;
		}
		for(int h = arrayIndex; h < holdings.length - 1; h++) {
			holdings[h] = holdings[h + 1];
		}
		holdings[holdings.length - 1].setObjectId("");
		holdings[holdings.length - 1].setTitle("");
		holdings[holdings.length - 1].deactivate();
	}
	
	public abstract boolean resetCredit();
	
	public boolean activate() {
		setIsActive(true);
		return true;
	}
	public boolean deactivate() {
		setIsActive(false);
		return false;
	}
	
	public String toString() {
		return getObjectId() + ":" + getTitle() + ":" + credit;
	}
	
	public String print() {
		if (getIsActive() == true) {
			if (numHolding == 0) {
				return "ID:                  " + getObjectId() + "\nName:              " + getTitle()
						+ "\nRemaining Credit:   " + credit;
			} else if (numHolding >= 1) {
				return "Two or more items on loan:\nID:                  " + getObjectId() + "\nName:              "
						+ getTitle() + "\nRemaining Credit:   " + credit + "\nCurrent holdings on loan:\n"
						+ displayHoldingId(numHolding);
			} else {
				return "Error: number of holdings is < 0.";
			}
		}
		else {
			return "Error: member not active.";
		}
	}
	
	private String holdingIdTemp;
	
	public String displayHoldingId(int numHolding) {
		if(numHolding >= 1) {
			holdingIdTemp += holdings[0].getObjectId();
			for(int i = 1; i < numHolding; i++) {
				holdingIdTemp += ":" + holdings[i].getObjectId();
			}
		}
		return holdingIdTemp;
	}
}
