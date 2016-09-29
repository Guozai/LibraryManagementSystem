package assignment2.test;

import assignment2.*;

public class Runner {
	private static final double LOAN_FEE_VIDEO_OPTION_1 = 4;
	private static final double LOAN_FEE_VIDEO_OPTION_2 = 6.5;
	
	public static void main(String[] args) {
		// Book book1 = new Book("b010001", "Lion King", 323);
		// book1.testBook();
		
		// Loan fee is either $4 or $6.5
		Video video1 = new Video("v000011", "Simba", LOAN_FEE_VIDEO_OPTION_2, 1.37);
		video1.testVideo();
	}
}
