package assignment2;

import java.util.*;
import lms.model.util.*;

public class LMSMerchant {
	//private static final int DEFAULT_MAX_INDEX_ARRAY_HOLDING = 15;
	//private static final int DEFAULT_MAX_INDEX_ARRAY_MEMBER = 15;
	//private int indexHolding = 0;
	//private int indexMember = 0;
	
	private ArrayList<Holding> holdingList = new ArrayList<Holding>();
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private int indexArrayList = 0;
	//private Holding[] holdingArray = new Holding[DEFAULT_MAX_INDEX_ARRAY_HOLDING];
	//private Member[] memberArray = new Member[DEFAULT_MAX_INDEX_ARRAY_MEMBER];
	
	public boolean addBook(String id, String title, int numPages) {
		Holding book = new Book(id, title, numPages);
		holdingList.add(book);
		return true;
	}
	
	public boolean addVideo(String id, String title, double loanFee, 
			double runningTime) {
		Holding video = new Video(id, title, loanFee, runningTime);
		holdingList.add(video);
		return true;
	}
	
	private boolean isFound = false;
	public boolean removeHolding(String holdingId) {
		indexArrayList = 0;
		isFound = false;
		while(indexArrayList < holdingList.size() && !isFound) {
			if(holdingList.get(indexArrayList).getObjectId() == holdingId) {
				holdingList.remove(indexArrayList);
				isFound = true;
			}
			indexArrayList++;
		}
		if(isFound) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addMember(String id, String name) {
		if(id.charAt(0) == 's') {
			Member mb = new StandardMember(id, name);
			memberList.add(mb);
			return true;
		} else if(id.charAt(0) == 'p') {
			Member mb = new PremiumMember(id, name);
			memberList.add(mb);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeMember(String memberId) {
		indexArrayList = 0;
		isFound = false;
		while(indexArrayList < memberList.size() && !isFound) {
			if(memberList.get(indexArrayList).getObjectId() == memberId) {
				memberList.remove(indexArrayList);
				isFound = true;
			}
			indexArrayList++;
		}
		if(isFound) {
			return true;
		} else {
			return false;
		}
	}
	
	private int pointerHolding = 0;
	private int pointerMember = 0;
	public boolean borrowHolding(String memberId, String holdingId) {
		pointerHolding = 0;
		pointerMember = 0;
		while(pointerHolding < holdingList.size() && holdingList.get(pointerHolding).getObjectId() != holdingId) {
			pointerHolding++;
		}
		while(pointerMember < memberList.size() && memberList.get(pointerMember).getObjectId() != memberId) {
			pointerMember++;
		}
		return memberList.get(pointerMember).borrowHolding(holdingList.get(pointerHolding));
	}
	
	public boolean returnHolding(String memberId, String holdingId, DateTime dateReturned) {
		pointerHolding = 0;
		pointerMember = 0;
		while(pointerHolding < holdingList.size() && holdingList.get(pointerHolding).getObjectId() != holdingId) {
			pointerHolding++;
		}
		while(pointerMember < memberList.size() && memberList.get(pointerMember).getObjectId() != memberId) {
			pointerMember++;
		}
		return memberList.get(pointerMember).returnHolding(holdingList.get(pointerHolding), dateReturned);
	}
	
	private String strOutput;
	public String printAllHoldings() {
		for (indexArrayList = 0; indexArrayList < holdingList.size(); indexArrayList++) {
			strOutput += holdingList.get(indexArrayList).print() + "\n";
		}
		return strOutput;
	}
	
	public String printAllMembers() {
		for(indexArrayList = 0; indexArrayList < memberList.size(); indexArrayList++) {
				strOutput += memberList.get(indexArrayList).print() + "\n";
		}
		return strOutput;
	}
	
	public boolean activate(String id) {
		indexArrayList = 0;
		isFound = false;
		while(indexArrayList < holdingList.size() && holdingList.get(indexArrayList).getObjectId() != id) {
			indexArrayList++;
		}
		if(holdingList.get(indexArrayList).getObjectId() == id) {
			isFound = true;
			return holdingList.get(indexArrayList).activate();
		} else {
			indexArrayList = 0;
			while(indexArrayList < memberList.size() && memberList.get(indexArrayList).getObjectId() != id) {
				indexArrayList++;
			}
			if(memberList.get(indexArrayList).getObjectId() == id) {
				isFound = true;
				return memberList.get(indexArrayList).activate();
			} else {
				return isFound;
			}
		}
	}
	
	public boolean deactivate(String id) {
		indexArrayList = 0;
		isFound = false;
		while(indexArrayList < holdingList.size() && holdingList.get(indexArrayList).getObjectId() != id) {
			indexArrayList++;
		}
		if(holdingList.get(indexArrayList).getObjectId() == id) {
			isFound = true;
			return holdingList.get(indexArrayList).deactivate();
		} else {
			indexArrayList = 0;
			while(indexArrayList < memberList.size() && memberList.get(indexArrayList).getObjectId() != id) {
				indexArrayList++;
			}
			if(memberList.get(indexArrayList).getObjectId() == id) {
				isFound = true;
				return memberList.get(indexArrayList).deactivate();
			} else {
				return isFound;
			}
		}
	}

//	public boolean addBook(String id, String title, int numPages) {
//		if (indexHolding < DEFAULT_MAX_INDEX_ARRAY_HOLDING) {
//			holdingArray[indexHolding] = new Book(id, title, numPages);
//			indexHolding++;
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public boolean addVideo(String id, String title, double loanFee, 
//			double runningTime) {
//		if (indexHolding < DEFAULT_MAX_INDEX_ARRAY_HOLDING) {
//			holdingArray[indexHolding] = new Video(id, title, loanFee, runningTime);
//			indexHolding++;
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	private int arrayIndex;
//	public boolean removeHolding(String holdingId) {
//		arrayIndex = 0;
//		while(holdingArray[arrayIndex].getObjectId() != holdingId) {
//			arrayIndex++;
//		}
//		for(int h = arrayIndex; h < holdingArray.length - 1; h++) {
//			holdingArray[h] = holdingArray[h + 1];
//		}
//		return holdingArray[holdingArray.length - 1].setObjectId("")
//			&& holdingArray[holdingArray.length - 1].setTitle("")
//			&& holdingArray[holdingArray.length - 1].deactivate();
//	}
//	
//	public boolean addMember(String id, String name) {
//		indexMember = 0;
//		while(indexMember < DEFAULT_MAX_INDEX_ARRAY_MEMBER && memberArray[indexMember].getObjectId() != "") {
//			indexMember++;
//		}
//		if (memberArray[indexMember].getPrefixId(id) == 's') {
//			memberArray[indexMember] = new StandardMember(id, name);
//			return true;
//		} else if (memberArray[indexMember].getPrefixId(id) == 'p') {
//			memberArray[indexMember] = new PremiumMember(id, name);
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public boolean removeMember(String memberId) {
//		arrayIndex = 0;
//		while(memberArray[arrayIndex].getObjectId() != memberId) {
//			arrayIndex++;
//		}
//		for(int h = arrayIndex; h < memberArray.length - 1; h++) {
//			memberArray[h] = memberArray[h + 1];
//		}
//		return memberArray[memberArray.length - 1].setObjectId("")
//			&& memberArray[memberArray.length - 1].setTitle("")
//			&& memberArray[memberArray.length - 1].deactivate();
//	}
//	
//	private int pointerHolding;
//	private int pointerMember;
//	public boolean borrowHolding(String memberId, String holdingId) {
//		pointerHolding = pointerMember = 0;
//		while(memberArray[pointerMember].getObjectId() != memberId) {
//			pointerMember++;
//		}
//		while(holdingArray[pointerHolding].getObjectId() != holdingId) {
//			pointerHolding++;
//		}
//		return memberArray[pointerMember].borrowHolding(holdingArray[pointerHolding]);
//	}
//	
//	public boolean returnHolding(String memberId, String holdingId, DateTime dateReturned) {
//		pointerHolding = pointerMember = 0;
//		while(memberArray[pointerMember].getObjectId() != memberId) {
//			pointerMember++;
//		}
//		while(holdingArray[pointerHolding].getObjectId() != holdingId) {
//			pointerHolding++;
//		}
//		return memberArray[pointerMember].returnHolding(holdingArray[pointerHolding], dateReturned);
//	}
	
//	private String strOutput;
//	public String printAllHoldings() {
//		arrayIndex = 0;
//		if (holdingArray.length == 0 || holdingArray[0].getObjectId() == "") {
//			return "Error: No holding";
//		} else {
//			for (arrayIndex = 0; arrayIndex < holdingArray.length; arrayIndex++) {
//				if (holdingArray[arrayIndex].getObjectId() != "") {
//					strOutput += holdingArray[arrayIndex].print();
//					strOutput += "\n";
//				}
//			}
//			return strOutput;
//		}
//	}
//	
//	public String printAllMembers() {
//		arrayIndex = 0;
//		if(memberArray.length == 0 || memberArray[0].getObjectId() == "") {
//			return "Error: No member";
//		} else {
//			for(arrayIndex = 0; arrayIndex < holdingArray.length; arrayIndex++) {
//				if (memberArray[arrayIndex].getObjectId() != "") {
//					strOutput += memberArray[arrayIndex].print();
//					strOutput += "\n";
//				}
//			}
//			return strOutput;
//		}
//	}
//	
//	public String printSpecificHolding(String holdingId) {
//		arrayIndex = 0;
//		while(arrayIndex < holdingArray.length && holdingArray[arrayIndex].getObjectId() != holdingId) {
//			arrayIndex++;
//		}
//		if(holdingArray[arrayIndex].getObjectId() == holdingId) {
//			return holdingArray[arrayIndex].print();
//		} else {
//			return "Error: no such holding with specified holdingId";
//		}
//	}
//	
//	public String printSpecificMember(String memberId) {
//		arrayIndex = 0;
//		while(arrayIndex < memberArray.length && memberArray[arrayIndex].getObjectId() != memberId) {
//			arrayIndex++;
//		}
//		if(memberArray[arrayIndex].getObjectId() == memberId) {
//			return memberArray[arrayIndex].print();
//		} else {
//			return "Error: no member with specified memberId available";
//		}
//	}
//	
//	public boolean resetMembersCredit(String memberId) {
//		arrayIndex = 0;
//		while(arrayIndex < memberArray.length && memberArray[arrayIndex].getObjectId() != memberId) {
//			arrayIndex++;
//		}
//		if(memberArray[arrayIndex].getObjectId() == memberId) {
//			return memberArray[arrayIndex].resetCredit();
//		} else {
//			return false;
//		}
//	}
//	
//	public double getLateFee(String memberId) {
//		arrayIndex = 0;
//		while(arrayIndex < memberArray.length && memberArray[arrayIndex].getObjectId() != memberId) {
//			arrayIndex++;
//		}
//		if(memberArray[arrayIndex].getObjectId() == memberId) {
//			// return memberArray[arrayIndex].;
//		}
//		return 0.0;
//	}
//	
//	public double getMembersBalance(String memberId) {
//		arrayIndex = 0;
//		while(arrayIndex < memberArray.length && memberArray[arrayIndex].getObjectId() != memberId) {
//			arrayIndex++;
//		}
//		if(memberArray[arrayIndex].getObjectId() == memberId) {
//			return memberArray[arrayIndex].getCredit();
//		} else {
//			System.out.println("Error: No such member with given memberId");
//			return -1.0;
//		}
//	}
//	
//	//private boolean isFound = false;
//	public boolean activate(String id) {
//		arrayIndex = 0;
//		while(arrayIndex < holdingArray.length && holdingArray[arrayIndex].getObjectId() != id) {
//			arrayIndex++;
//		}
//		if(holdingArray[arrayIndex].getObjectId() == id) {
//			isFound = true;
//			return holdingArray[arrayIndex].activate();
//		} else {
//			arrayIndex = 0;
//			while(arrayIndex < memberArray.length && memberArray[arrayIndex].getObjectId() != id) {
//				arrayIndex++;
//			}
//			if(memberArray[arrayIndex].getObjectId() == id) {
//				isFound = true;
//				return memberArray[arrayIndex].activate();
//			} else {
//				return isFound;
//			}
//		}
//	}
//	
//	public boolean deactivate(String id) {
//		arrayIndex = 0;
//		while(arrayIndex < holdingArray.length && holdingArray[arrayIndex].getObjectId() != id) {
//			arrayIndex++;
//		}
//		if(holdingArray[arrayIndex].getObjectId() == id) {
//			isFound = true;
//			return holdingArray[arrayIndex].deactivate();
//		} else {
//			arrayIndex = 0;
//			while(arrayIndex < memberArray.length && memberArray[arrayIndex].getObjectId() != id) {
//				arrayIndex++;
//			}
//			if(memberArray[arrayIndex].getObjectId() == id) {
//				isFound = true;
//				return memberArray[arrayIndex].deactivate();
//			} else {
//				return isFound;
//			}
//		}
//	}
	
	public void test() {
		//System.out.println(holdingList.size() + ", " + memberList.size());
		//System.out.println(holdingList.get(1).toString());
		//System.out.println(memberList.get(1).toString());
		System.out.println(holdingList.get(0).print());
	}
}
