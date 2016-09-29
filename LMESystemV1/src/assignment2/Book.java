package assignment2;

import lms.model.util.*;

public class Book extends Holding implements CommonInterface, HoldingInterface {
	private static final int LOAN_FEE_BOOK = 10;
	private static final int MAX_LOAN_DAYS = 28;
	private static final double FIXED_DAILY_LATE_FEE_RATE = 2.0;
	private int numPage;
	public Book(String bookId, String title, int numPage) {
		super(bookId, title);
		if (numPage > 0) {
			this.numPage = numPage;
		}
		else {
			System.out.println("Error: invalid page number.");
		}
		// Books have a fixed standard loan fee of $10
		this.setLoanFee(LOAN_FEE_BOOK);
		// Books have a fixed maximum loan period of 28 days
		this.setMaxLoanDay(MAX_LOAN_DAYS);
	}
	
	public double calculateLateFee(int numLateDay) {
		return FIXED_DAILY_LATE_FEE_RATE * numLateDay;
	}
	
	public boolean isBook() {
		if (getPrefixId(getHoldingId()) == 'b') {
			return true;
		}
		else {
			return false;
		}
	}
	
	////////////////////////////////////////////////////////////////////////
	// getters and setters
	//
	//public void setNumPage(int numPage) {
	//	this.numPage = numPage;
	//}
	public int getNumPage() {
		return this.numPage;
	}
	////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return this.getHoldingId() + ":" + this.getTitle() + ":" + numPage + ":" + this.getLoanDate() + ":"
				+ LOAN_FEE_BOOK + ":" + MAX_LOAN_DAYS + ":" + translateTrueToActive(this.getIsActive());
	}
	
	public String translateTrueToActive(boolean isActive) {
		if (isActive == true) {
			return "Active";
		}
		else {
			return "Inactive";
		}
	}
	
	public String print() {
		if (this.getIsActive() == true) {
			if (this.getIsOnLoan() == false) {
				return "Not on loan:\nID:                " + this.getHoldingId() + "\nTitle:             " + this.getTitle()
						+ "\nNumber of Pages:   " + numPage + "\nLoan Fee:          " + LOAN_FEE_BOOK
						+ "\nMax Loan Period:   " + MAX_LOAN_DAYS
						+ "\nOn Loan:           No\nSystem Status:     Active";
			} else {
				return "On loan:\nID:                " + this.getHoldingId() + "\nTitle:             " + this.getTitle() + "\nNumber of Pages:   "
						+ numPage + "\nLoan Fee:          " + LOAN_FEE_BOOK + "\nMax Loan Period:   " + MAX_LOAN_DAYS
						+ "\nOn Loan:           Yes\nDate of Loan:      " + this.getLoanDate() + "\nSystem Status:     Active";
			}
		} else {
			return "Error: Book is inactive.";
		}
	}
	
	public void testBook() {
		System.out.println("Running the test for Book class...");
		this.activate();
		this.setIsOnLoan();
		this.setLoanDate(new DateTime());
		System.out.print(this.print());
		System.out.print("\n\n");
		System.out.println(this.toString());
		
		System.out.print("\n");
		
		this.activate();
		this.setIsNotOnLoan();
		System.out.print(this.print());
	}
}
