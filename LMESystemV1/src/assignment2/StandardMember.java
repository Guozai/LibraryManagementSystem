package assignment2;

public class StandardMember extends Member {
	private String standardMemberID;
	private String standardMemberName;
	private static final int MAX_CREDIT_STANDARD_MEMBER = 30;
	public StandardMember(String standardMemberId, String standardMemberName) {
		super(standardMemberId, standardMemberName, MAX_CREDIT_STANDARD_MEMBER);
	}
}
