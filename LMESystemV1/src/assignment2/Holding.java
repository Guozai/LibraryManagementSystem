package assignment2;

import lms.model.util.*;

public abstract class Holding extends CommonObject implements CommonInterface, HoldingInterface {
	private double loanFee;
	private int maxLoanDay;
	private DateTime dateBorrowed;
	private double latePenaltyFee;
	private int numLateDay;
	private boolean isOnLoan;
	private static final int LENGTH_OF_PREFIX = 1;
	private static final int LENGTH_OF_PREDEFINED_ID_LENGTH = 6;
	private char prefixIdTemp;
	private String memberId;
	
	public Holding(String holdingId, String title) {
		this.setObjectId(holdingId);
		this.setTitle(title);
		activate();
	}
	
	public boolean activate() {
		// This may have problem, need to CHANGE later DEFINITELY.
		setIsActive(true);
		return getIsActive();
	}
	
	public boolean deactivate() {
		// Check if the holding is having an invalid ID
		prefixIdTemp = getPrefixId(this.getObjectId());
		if(prefixIdTemp != 'b' || prefixIdTemp != 'v' || 
				getObjectId().length() - LENGTH_OF_PREFIX > LENGTH_OF_PREDEFINED_ID_LENGTH) {
			setIsActive(false);
			return true;
		}
		// Check if the holding is having an invalid title
		if(this.getTitle().length() < 1) {
			setIsActive(false);
			return true;
		}
		// Check if the holding is damaged
		/**
		 * Need to add code later
		 */
		// Check if the holding on loan - not needed - no status change
		if(this.isOnLoan) {
			return false;
		}
		return  false;
	}
	
	public abstract double calculateLateFee(DateTime dateReturned);
	
	public abstract String print();
	
	////////////////////////////////////////////////////////////////////////
	// getters and setters
	//
	public boolean setObjectId(String holdingId) {
		if(holdingId.length() == 7) {
			super.setObjectId(holdingId);
			return true;
		}
		else {
			System.out.println("Invalid Book or Video ID");
			return false;
		}
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
	
	public void setDateBorrowed(DateTime dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}
	public DateTime getDateBorrowed() {
		return this.dateBorrowed;
	}
	
	public void setLatePenaltyFee(double latePenaltyFee) {
		this.latePenaltyFee = latePenaltyFee;
	}
	public double getLatePenaltyFee() {
		return this.latePenaltyFee;
	}
	
	public void setNumLateDay(int numLateDay) {
		this.numLateDay = numLateDay;
	}
	public int getNumLateDay() {
		return this.numLateDay;
	}
	
	public void setIsOnLoan(boolean isOnLoan) {
		this.isOnLoan = isOnLoan; 
	}
	public boolean getIsOnLoan() {
		return this.isOnLoan;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberId() {
		return this.memberId;
	}
	////////////////////////////////////////////////////////////////////////
	
	public abstract String toString();
}
