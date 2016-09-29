package assignment2;

import lms.model.util.*;

public interface MemberInterface {
	public boolean borrowHolding(Holding holding);
	public boolean returnHolding(Holding holding, DateTime returnDate);
	public boolean resetCredit();
}
