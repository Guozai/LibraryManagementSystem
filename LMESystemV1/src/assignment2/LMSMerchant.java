package assignment2;

import java.util.*;
import assignment2.CustomFileWriter;
import lms.model.util.*;

public class LMSMerchant {
	// private static final int DEFAULT_MAX_INDEX_ARRAY_HOLDING = 15;
	// private static final int DEFAULT_MAX_INDEX_ARRAY_MEMBER = 15;
	// private int indexHolding = 0;
	// private int indexMember = 0;

	private ArrayList<Holding> holdingList = new ArrayList<Holding>();
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private int indexArrayList = 0;
	// private Holding[] holdingArray = new
	// Holding[DEFAULT_MAX_INDEX_ARRAY_HOLDING];
	// private Member[] memberArray = new
	// Member[DEFAULT_MAX_INDEX_ARRAY_MEMBER];

	public boolean addBook(String id, String title, int numPages) {
		Holding book = new Book(id, title, numPages);
		holdingList.add(book);
		return true;
	}

	public boolean addVideo(String id, String title, double loanFee, double runningTime) {
		Holding video = new Video(id, title, loanFee, runningTime);
		holdingList.add(video);
		return true;
	}

	private boolean isFound = false;

	public boolean removeHolding(String holdingId) {
		indexArrayList = 0;
		isFound = false;
		while (indexArrayList < holdingList.size() && !isFound) {
			if (holdingList.get(indexArrayList).getObjectId().equals(holdingId)) {
				holdingList.remove(indexArrayList);
				isFound = true;
			}
			indexArrayList++;
		}
		if (isFound) {
			return true;
		} else {
			return false;
		}
	}

	public boolean addMember(String id, String name) {
		if (id.charAt(0) == 's') {
			Member mb = new StandardMember(id, name);
			memberList.add(mb);
			return true;
		} else if (id.charAt(0) == 'p') {
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
		while (indexArrayList < memberList.size() && !isFound) {
			if (memberList.get(indexArrayList).getObjectId().equals(memberId)) {
				memberList.remove(indexArrayList);
				isFound = true;
			}
			indexArrayList++;
		}
		if (isFound) {
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
		while (pointerHolding < holdingList.size()
				&& !(holdingList.get(pointerHolding).getObjectId().equals(holdingId))) {
			pointerHolding++;
		}
		while (pointerMember < memberList.size() && !(memberList.get(pointerMember).getObjectId().equals(memberId))) {
			pointerMember++;
		}
		return memberList.get(pointerMember).borrowHolding(holdingList.get(pointerHolding));
	}

	public boolean returnHolding(String memberId, String holdingId, DateTime dateReturned) {
		pointerHolding = 0;
		pointerMember = 0;
		while (pointerHolding < holdingList.size()
				&& !(holdingList.get(pointerHolding).getObjectId().equals(holdingId))) {
			pointerHolding++;
		}
		while (pointerMember < memberList.size() && !(memberList.get(pointerMember).getObjectId().equals(memberId))) {
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
		for (indexArrayList = 0; indexArrayList < memberList.size(); indexArrayList++) {
			strOutput += memberList.get(indexArrayList).print() + "\n";
		}
		return strOutput;
	}

	public String printSpecificHolding(String holdingId) {
		indexArrayList = 0;
		while (indexArrayList < holdingList.size()
				&& !(holdingList.get(indexArrayList).getObjectId().equals(holdingId))) {
			indexArrayList++;
		}
		if (holdingList.get(indexArrayList).getObjectId().equals(holdingId)) {
			return holdingList.get(indexArrayList).print();
		} else {
			return "Error: no such holding with specified holdingId";
		}
	}

	public String printSpecificMember(String memberId) {
		indexArrayList = 0;
		while (indexArrayList < memberList.size() && !(memberList.get(indexArrayList).getObjectId().equals(memberId))) {
			indexArrayList++;
		}
		if (memberList.get(indexArrayList).getObjectId().equals(memberId)) {
			return memberList.get(indexArrayList).print();
		} else {
			return "Error: no member with specified memberId available";
		}
	}

	public boolean resetMembersCredit(String memberId) {
		indexArrayList = 0;
		while (indexArrayList < memberList.size() && !(memberList.get(indexArrayList).getObjectId().equals(memberId))) {
			indexArrayList++;
		}
		if (memberList.get(indexArrayList).getObjectId().equals(memberId)) {
			return memberList.get(indexArrayList).resetCredit();
		} else {
			return false;
		}
	}

	public double getLateFee(String memberId) {
		indexArrayList = 0;
		DateTime todaysDate = new DateTime();
		while (indexArrayList < holdingList.size()
				&& !(holdingList.get(indexArrayList).getMemberId().equals(memberId))) {
			indexArrayList++;
		}
		if (holdingList.get(indexArrayList).getMemberId().equals(memberId)) {
			return holdingList.get(indexArrayList).calculateLateFee(todaysDate);
		} else {
			System.out.println("Member ID not found.");
			return -1.0;
		}
	}

	public double getMembersBalance(String memberId) {
		indexArrayList = 0;
		while (indexArrayList < memberList.size() && !(memberList.get(indexArrayList).getObjectId().equals(memberId))) {
			indexArrayList++;
		}
		if (memberList.get(indexArrayList).getObjectId().equals(memberId)) {
			return memberList.get(indexArrayList).getCredit();
		} else {
			System.out.println("Error: No such member with given memberId");
			return -1.0;
		}
	}

	public boolean activate(String id) {
		indexArrayList = 0;
		isFound = false;
		while (indexArrayList < holdingList.size() && !(holdingList.get(indexArrayList).getObjectId().equals(id))) {
			indexArrayList++;
		}
		if (holdingList.get(indexArrayList).getObjectId().equals(id)) {
			isFound = true;
			return holdingList.get(indexArrayList).activate();
		} else {
			indexArrayList = 0;
			while (indexArrayList < memberList.size() && !(memberList.get(indexArrayList).getObjectId().equals(id))) {
				indexArrayList++;
			}
			if (memberList.get(indexArrayList).getObjectId().equals(id)) {
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
		while (indexArrayList < holdingList.size() && !(holdingList.get(indexArrayList).getObjectId().equals(id))) {
			indexArrayList++;
		}
		if (holdingList.get(indexArrayList).getObjectId().equals(id)) {
			isFound = true;
			return holdingList.get(indexArrayList).deactivate();
		} else {
			indexArrayList = 0;
			while (indexArrayList < memberList.size() && !(memberList.get(indexArrayList).getObjectId().equals(id))) {
				indexArrayList++;
			}
			if (memberList.get(indexArrayList).getObjectId().equals(id)) {
				isFound = true;
				return memberList.get(indexArrayList).deactivate();
			} else {
				return isFound;
			}
		}
	}

	public void fileWriter() {
		for (indexArrayList = 0; indexArrayList < holdingList.size(); indexArrayList++)
			try {
				CustomFileWriter fileWriter = new CustomFileWriter();
				fileWriter.writeToFileHolding(holdingList.get(indexArrayList));
				fileWriter.writeToFileHoldingBackup(holdingList.get(indexArrayList));
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		for (indexArrayList = 0; indexArrayList < memberList.size(); indexArrayList++)
			try {
				CustomFileWriter fileWriter = new CustomFileWriter();
				fileWriter.writeToFileMember(memberList.get(indexArrayList));
				fileWriter.writeToFileMemberBackup(memberList.get(indexArrayList));
			} catch (Exception e) {
				System.out.println(e.toString());
			}
	}

	public void fileReader() {
		try {
			CustomFileReader fileReader = new CustomFileReader();
			System.out.println(fileReader.readFile());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void test() {
		// System.out.println(holdingList.size() + ", " + memberList.size());
		// System.out.println(holdingList.get(1).toString());
		// System.out.println(memberList.get(1).toString());
		System.out.println(holdingList.get(0).print());
	}
}
