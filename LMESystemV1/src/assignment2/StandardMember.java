package assignment2;

import lms.model.util.*;

public class StandardMember extends Member implements CommonInterface, MemberInterface {
	// private String standardMemberId;
	// private String standardMemberName;
	private double creditTemp;
	private static final int MAX_CREDIT_STANDARD_MEMBER = 30;
	
	public StandardMember(String standardMemberId, String standardMemberName) {
		super(standardMemberId, standardMemberName, MAX_CREDIT_STANDARD_MEMBER);
	}
	
	public boolean returnHolding(Holding holding, DateTime returnDate) {
		creditTemp -= getCredit() - holding.calculateLateFee(returnDate);
		if(creditTemp < 0) {
			removeHoldingFromArray(holding);
			resetCredit();
		}
		return true;
	}
	
	public boolean resetCredit() {
		setCredit(MAX_CREDIT_STANDARD_MEMBER);
		return true;
	}
}
