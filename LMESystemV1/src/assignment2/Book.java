package assignment2;

public class Book extends Holding {
	private static final int LOAN_FEE_BOOK = 10;
	private static final int MAX_LOAN_DAYS = 28;
	private int numPage;
	public Book(String holdingId, String title, int numPage) {
		super(holdingId, title);
		// Books have a fixed standard loan fee of $10
		this.setLoanFee(LOAN_FEE_BOOK);
		// Books have a fixed maximum loan period of 28 days
		this.setMaxLoanDay(MAX_LOAN_DAYS);
	}
}
