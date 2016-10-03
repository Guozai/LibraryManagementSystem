package assignment2;

import lms.model.util.*;

public interface HoldingInterface {
	public double calculateLateFee(DateTime dateReturned);
	// public int getNumLateDay(DateTime dateBorrowed, DateTime dateReturned) {
	//		return DateTime.diffDays(dateBorrowed, dateReturned);
	// };
}
