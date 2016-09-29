package assignment2;

import lms.model.util.DateTime;

public class Video extends Holding implements CommonInterface, HoldingInterface {
	private static final int MAX_LOAN_DAYS = 7;
	private double runningTime;
	public Video(String holdingId, String title, double loanFee, double runningTime) {
		super(holdingId, title);
		super.setLoanFee(loanFee);
		this.setRunningTime(runningTime);
			
		// Videos have a fixed maximum loan period of 7 days
		this.setMaxLoanDay(MAX_LOAN_DAYS);
	}
	
	public boolean isVideo() {
		if (getPrefixId(getHoldingId()) == 'v') {
			return true;
		}
		else {
			return false;
		}
	}
	
	////////////////////////////////////////////////////////////////////////
	// getters and setters
	//
	public void setRunningTime(double runningTime) {
		if (runningTime > 0) {
			this.runningTime = runningTime;
		}
		else {
			System.out.println("Error: invalid running time - couldn't be 0 or <0");
		}
	}
	////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return this.getHoldingId() + ":" + this.getTitle() + ":" + this.runningTime + ":" 
				+ this.getLoanDate() + ":" + this.getLoanFee() + ":" + MAX_LOAN_DAYS + ":" 
				+ translateTrueToActive(this.getIsActive());
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
		if (this.isVideo() == true) {
			if (this.getIsActive() == true) {
				if (this.getIsOnLoan() == false) {
					return "Not on loan:\nID:               " + this.getHoldingId() + "\nTitle:            " + this.getTitle()
							+ "\nRunning Time:     " + runningTime + "\nLoan Fee:         " + this.getLoanFee()
							+ "\nMax Loan Period:  " + MAX_LOAN_DAYS
							+ "\nOn Loan:          No\nSystem Status:    Active";
				} else {
					return "On loan:\nID:               " + this.getHoldingId() + "\nTitle:            " + this.getTitle()
							+ "\nRunning Time:     " + runningTime + "\nLoan Fee:         " + this.getLoanFee()
							+ "\nMax Loan Period:  " + MAX_LOAN_DAYS + "\nOn Loan:          Yes\nDate of Loan:     "
							+ this.getLoanDate() + "\nSystem Status:    Active";
				}
			} else {
				return "Error: Book is inactive.";
			}
		}
		else {
			return "Error: not a video or invalid ID.";
		}
	}
	
	public void testVideo() {
		System.out.println("Running the unit test for Video class...");
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
