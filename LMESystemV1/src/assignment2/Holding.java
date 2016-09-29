package assignment2;

import lms.model.util.*;

public abstract class Holding implements CommonInterface, HoldingInterface {
	private char prefixId;
	private int numId;
	private String holdingId;
	private String title;
	private double loanFee;
	private int maxLoanDay;
	private DateTime loanDate;
	private double latePenaltyFee;
	private int numLateDay;
	private boolean isActive = false;
	private boolean isOnLoan;
	private static final int LENGTH_OF_PREFIX = 1;
	private static final int LENGTH_OF_PREDEFINED_ID_LENGTH = 6;
	
	public Holding(String holdingId, String title) {
		this.setHoldingId(holdingId);
		this.setTitle(title);
	}
	
	// Methods from CommonInterface
	// getPrefixId, getNumId, activate, deactivate, calculateLateFee, print
	public char getPrefixId(String holdingId) {
		try {
			this.prefixId = holdingId.charAt(0);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return this.prefixId;
	}
	
	public int getNumId(String holdingId) {
		try {
			Integer.parseInt(holdingId.substring(1, 6));
 		}
 		catch(NumberFormatException e) {
			// System.out.println("Format Error: " + e.toString());
 			this.isActive = false;
 		}
		return Integer.parseInt(holdingId.substring(1, 6));
	}
	
	public boolean activate() {
		// This may have problem, need to CHANGE later DEFINITELY.
		this.isActive = true;
		return isActive;
	}
	
	public boolean deactivate() {
		// Check if the holding is having an invalid ID
		this.prefixId = getPrefixId(holdingId);
		this.numId = getNumId(holdingId);
		if(prefixId != 'b' || prefixId != 'v' || 
				holdingId.length() - LENGTH_OF_PREFIX > LENGTH_OF_PREDEFINED_ID_LENGTH) {
			this.isActive = false;
		}
		// Check if the holding is having an invalid title
		if(title.length() < 1) {
			this.isActive = false;
		}
		// Check if the holding is damaged
		/**
		 * Need to add code later
		 */
		// Check if the holding on loan - not needed - no status change
		return isActive;
	}
	
	public double calculateLateFee(double latePenaltyFee, int numLateDay) {
		return latePenaltyFee * numLateDay;
	}
	
	public abstract String print();
	
	////////////////////////////////////////////////////////////////////////
	// getters and setters
	//
	public void setHoldingId(String holdingId) {
		if (holdingId.length() == 7) {
			this.holdingId = holdingId;
		}
		else {
			System.out.println("Invalid Book or Video ID");
		}
	}
	public String getHoldingId() {
		return this.holdingId;
	}
	
	public void setTitle(String title) {
		if(title.length() > 0) {
			this.title = title;
		}
		else {
			System.out.println("Error: Title cannot be left blank!");
		}
	}
	public String getTitle() {
		return this.title;
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
	
	public void setLoanDate(DateTime loanDate) {
		this.loanDate = loanDate;
	}
	public DateTime getLoanDate() {
		return this.loanDate;
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}
	
	public void setIsOnLoan() {
		this.isOnLoan = true; 
	}
	public boolean getIsOnLoan() {
		return this.isOnLoan;
	}
	
	public void setIsNotOnLoan() {
		this.isOnLoan = false;
	}
	////////////////////////////////////////////////////////////////////////
	
	public abstract String toString();
}
