package assignment2;

import lms.model.util.DateTime;

public class PremiumMember extends Member implements CommonInterface, MemberInterface {
	// private String PremiumMemberId;
	// private String premiumMemberName;
	private double credit;
	private static final int MAX_CREDIT_PREMIUM_MEMBER = 45;
	public PremiumMember(String premiumMemberId, String premiumMemberName) {
		super(premiumMemberId, premiumMemberName, MAX_CREDIT_PREMIUM_MEMBER);
	}
	
	public boolean returnHolding(Holding holding, DateTime returnDate) {
		credit -= getCredit() - holding.calculateLateFee(returnDate);
		holding.setIsOnLoan(false);
		holding.setMemberId(null);
		removeHoldingFromList(holding);
		if(credit < 0) {
			setIsActive(false);
		}
		else {
			setIsActive(true);
		}
		return getIsActive();
	}
	
	public boolean resetCredit() {
		setCredit(MAX_CREDIT_PREMIUM_MEMBER);
		return true;
	}
}
