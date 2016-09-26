package assignment2;

public class Video extends Holding {
	private static final int MAX_LOAN_DAYS = 7;
	private double runningTime;
	public Video(String holdingId, String title, double loanFee, double runningTime) {
		super(holdingId, title);
		
		// Videos have a fixed maximum loan period of 7 days
		this.setMaxLoanDay(MAX_LOAN_DAYS);
	}
}
