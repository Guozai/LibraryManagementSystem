package assignment2;

import java.util.ArrayList;

import lms.model.util.*;

public abstract class Member extends CommonObject implements CommonInterface, MemberInterface {
	private double credit;
	//private int numHolding;
	private static final double MAX_CREDIT_STANDARD_MEMBER = 30;
	private final double MAX_CREDIT_PREMIUM_MEMBER = 45;
	private char prefixId;
	private ArrayList<String> holdingIds = new ArrayList<String>();
	
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
		this.setIsActive(true);
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
	
	////////////////////////////////////////////////////////////////////////
	
	public boolean borrowHolding(Holding holding) {
		if (getIsActive() == true || credit > holding.getLoanFee()) {
			credit -= holding.getLoanFee();
			holding.setMemberId(this.getObjectId());
			holding.setIsOnLoan(true);
			holdingIds.add(holding.getObjectId());
			return true;
		}
		else {
			return false;
		}
	}
	
	public abstract boolean returnHolding(Holding holding, DateTime returnDate);
	
	private int indexArrayList;
	public boolean removeHoldingFromList(Holding holding) {
		indexArrayList = 0;
		while(!(holdingIds.get(indexArrayList).equals(holding.getObjectId())) && indexArrayList < holdingIds.size()) {
			indexArrayList++;
		}
		if(holdingIds.get(indexArrayList).equals(holding.getObjectId())) {
		    holdingIds.remove(indexArrayList);
		    return true;
		} else {
			return false;
		}
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
			if (holdingIds.size() == 0) {
				return "ID:                  " + getObjectId() + "\nName:              " + getTitle()
						+ "\nRemaining Credit:   " + credit;
			} else if (holdingIds.size() == 1) {
				return "One Item on Loan:\nID:                 " + getObjectId() + "\nName:               "
						+ getTitle() + "\nRemaining Credit:   " + credit + "\nCurrent holdings on loan:\n"
						+ holdingIds.get(0);
			} else if (holdingIds.size() > 1) {
				return "Two or more items on loan:\nID:                 " + getObjectId() + "\nName:               "
						+ getTitle() + "\nRemaining Credit:   " + credit + "\nCurrent holdings on loan:\n"
						+ displayHoldingId(holdingIds);
			} else {
				return "Error: number of holdings is < 0.";
			}
		}
		else {
			return "Error: member not active.";
		}
	}
	
	private String holdingIdTemp;
	
	public String displayHoldingId(ArrayList<String> holdingIds) {
		for (int indexArrayList = 0; indexArrayList < holdingIds.size(); indexArrayList++) {
			holdingIdTemp += holdingIds.get(indexArrayList) + ":";
		}
		return holdingIdTemp;
	}
}
