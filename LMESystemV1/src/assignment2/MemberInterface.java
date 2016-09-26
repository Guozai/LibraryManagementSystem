package assignment2;

public interface MemberInterface {
	public boolean borrowHolding(Holding holding);
	public boolean returnHolding(Holding holding, DateTime returnDate);
	public boolean resetCredit();
}
