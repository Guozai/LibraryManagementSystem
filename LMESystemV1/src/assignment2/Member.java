package assignment2;

import lms.model.util.*;

public abstract class Member implements CommonInterface, MemberInterface {
	private char prefixId;
	private int numId;
	private String memberId;
	private String fullName;
	private double credit;
	private boolean isActive;
	private int numHolding;
	
	//Holding[] holdings = new Holding[20];
	
	public Member(String memberId, String fullName) {
		this.setMemberId(memberId);
		this.setFullName(fullName);
		this.setInitialCredit(memberId);
	}
	
	////////////////////////////////////////////////////////////////////////
	// getters and setters
	//
	public void setMemberId(String memberId) {
		this.prefixId = this.getPrefixId(memberId); 

		if(this.prefixId == 's' || this.prefixId == 'p') {
			this.memberId = memberId;
		}
		else {
			System.out.println("Error: object is not a member.");
		}
	}
	
	public void setFullName(String fullName) {
		if(fullName.length() > 0) {
			this.fullName = fullName;
		}
		else {
			System.out.println("Error: invalid member name - length is 0");
		}
	}
	
	public void setInitialCredit(String memberId) {
		if(getPrefixId(memberId) == 's') {
			credit = 30;
		}
		else if(getPrefixId(memberId) == 'p') {
			credit = 45;
		}
	}
	////////////////////////////////////////////////////////////////////////
	
	public boolean borrowHolding(Holding holding) {
		if (isActive == true || credit > holding.getLoanFee()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean returnHolding(Holding holding, DateTime returnDate) {
		
	}
	
	public boolean resetCredit() {
		
	}
	
	public boolean deactivate() {
		
	}
	
	public boolean activate() {
		
	}
	
	public String toString() {
		return memberId + ":" + fullName + ":" + credit;
	}
	
	public String print() {
		if ( isActive == true) {
			if ( numHolding == 0) {
		return "ID:                  " + memberId + "\nName:              " + fullName 
				+ "\nRemaining Credit:   " + credit;
			}
			else if(numHolding == 1) {
				return "One Item on Loan:\nID:                  " + memberId 
						+ "\nName:              " + fullName 
						+ "\nRemaining Credit:   " + credit 
						+ "\nCurrent holdings on loan:\n" + holdingId;
			}
			else if(numHolding == 2) {
				return "Two or more items on loan:\nID:                  " + memberId 
						+ "\nName:              " + fullName 
						+ "\nRemaining Credit:   " + credit 
						+ "\nCurrent holdings on loan:\n" + holdingId;
			}
	
		}
	}
}
