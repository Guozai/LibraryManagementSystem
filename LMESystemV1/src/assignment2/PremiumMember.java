package assignment2;

public class PremiumMember extends Member {
	private String PremiumMemberId;
	private String premiumMemberName;
	private static final int MAX_CREDIT_PREMIUM_MEMBER = 45;
	public PremiumMember(String premiumMemberId, String premiumMemberName) {
		super(premiumMemberId, premiumMemberName, MAX_CREDIT_PREMIUM_MEMBER);
	}
}
