package assignment2.test;

import java.util.Scanner;
import lms.model.facade.*;
import lms.model.util.*;

public class Menu {
	private static final int PREDEFINED_ID_LENGTH = 7;
	private LMSFacade lmsFacade = new LMSFacade();
	private int selection;
	private String objectId;
	private String objectTitle;
	private int numPage;
	private double loanFee;
	private double runningTime;
	private boolean isErrorOccur = false;
	private String memberId;
	
	public void initialize() {
		lmsFacade.addBook("b000001", "Intro to Java", 200);
		lmsFacade.addBook("b000002", "Learning UML", 124);
		lmsFacade.addBook("b000003", "Design Patterns", 345);
		lmsFacade.addBook("b000004", "Advanced Java", 287);
		lmsFacade.addVideo("v000001", "Java 1", 4, 1.37);
		lmsFacade.addVideo("v000002", "Java 2", 6.5, 1.28);
		lmsFacade.addVideo("v000003", "UML 1", 6.5, 1.47);
		lmsFacade.addVideo("v000004", "UML 2", 4, 1.12);
		lmsFacade.addMember("s000001", "Joe Bloggs");
		lmsFacade.addMember("s000002", "Jane Smith");
		lmsFacade.addMember("p000001", "Fred Bloggs");
		lmsFacade.addMember("p000002", "Fred Smith");
		lmsFacade.borrowHolding("p000002", "b000001");
		//lmsFacade.test();
		System.out.println(lmsFacade.printAllHoldings());
	}
	
	public void printMenu() {
		Scanner sc = new Scanner(System.in);
		// repeat until the user selects the "Exit" option
		do {
			// print menu options to screen
			System.out.println("*************** LIBRARY MANAGEMENT - MENU ***************");
			System.out.println();
			System.out.println("1.  Add Holding");
			System.out.println("2.  Remove Holding");
			System.out.println("3.  Add Member");
			System.out.println("4.  Remove Member");
			System.out.println("5.  Borrow Holding");
			System.out.println("6.  Return Holding");
			System.out.println("7.  Print All Holdings");
			System.out.println("8.  Print All Members");
			System.out.println("9.  Print Specific Holding");
			System.out.println("10. Print Specific Member");
			System.out.println("11. Activate");
			System.out.println("12. Deactivate");
			System.out.println("13. Reset Member's Credit");
			System.out.println("14. Save to File");
			System.out.println("15. Load from File");
			System.out.println("0.  Exit");
			System.out.println();
			System.out.println("*********************************************************");
			// get selection from user
			System.out.print("Enter selection: ");
			selection = sc.nextInt();
			
			switch(selection) {
				case 1:
					System.out.print("Please enter holding ID: ");
					objectId = sc.next();
					System.out.println();
					if(objectId.charAt(0) == 'b') {
						System.out.print("Please enter book title: ");
						objectTitle = sc.next();
						System.out.println();
						System.out.print("Please enter the total number of pages of this book: ");
						numPage = sc.nextInt();
						System.out.println();
						if(objectId.length() == PREDEFINED_ID_LENGTH && objectTitle.length() != 0 && numPage > 0) {
							if(!lmsFacade.addBook(objectId, objectTitle, numPage)) {
								System.out.println("Error: Holding array is full");
							}
						}
					} else if(objectId.charAt(0) == 'v') {
						System.out.print("Please enter video title: ");
						objectTitle = sc.next();
						sc.nextLine();
						System.out.println();
						System.out.println("Please choose one of the following video loan fee options: ");
						System.out.println("1. $4");
						System.out.println("2. $6.5");
						System.out.println("Please enter your selection: ");
						selection = sc.nextInt();
						System.out.println("selection = " + selection);
						if (selection == 1) {
							loanFee = 4.0;
						} else if (selection == 2) {
							loanFee = 6.5;
						} else {
							System.out.print("\nMust be 1 or 2, exit to main menu...");
							break;
						}
						System.out.println();
						System.out.println("Please enter video running time: ");
						runningTime = sc.nextDouble();
						if(objectId.length() == PREDEFINED_ID_LENGTH && objectTitle.length() != 0 && runningTime > 0) {
							if(!lmsFacade.addVideo(objectId, objectTitle, loanFee, runningTime)) {
								System.out.println("Error: Holding array is full");
							} else {
								System.out.println("Success: Creating holding is successful.");
							}
						}
					} else {
						System.out.println("Error: invalid input, ID must start with 'b' or 'v'");
					}
					break;
					case 2:
						System.out.println("Please enter the ID of the holding to be removed: ");
						objectId = sc.next();
						if ((objectId.charAt(0) == 'b' || objectId.charAt(0) == 'v')
								&& objectId.length() == PREDEFINED_ID_LENGTH) {
							try {
								Integer.parseInt(objectId.substring(1, 6));
							} catch (NumberFormatException e) {
								System.out.println("Format Error: " + e.toString());
								isErrorOccur = true;
							}
						} else {
							System.out.println("Error ID: Either not start with 'b' or 'v' or the length is not PREDEFINED_ID_LENGTH.");
							isErrorOccur = true;
						}
						if (!isErrorOccur) {
							if (!lmsFacade.removeHolding(objectId)) {
								System.out.println("Error: holding with the given ID does not exist.");
							}
						}
						break;
					case 3:
						System.out.print("Please enter member ID: ");
						objectId = sc.next();
						System.out.println();
						System.out.println("Please enter member name: ");
						objectTitle = sc.next();
						System.out.println();
						if(objectId.charAt(0) == 's' || objectId.charAt(0) == 'p') {
							if(objectId.length() == PREDEFINED_ID_LENGTH) {
								if(objectTitle.length() > 0) {
									lmsFacade.addMember(objectId, objectTitle);
								} else {
									System.out.println("Error: member name can not be blank");
								}
							} else {
								System.out.println("Error: member ID length is wrong. Please refer to the 'predefined ID length'. ");
							}
						} else {
							System.out.println("Error: member ID must start with 's' or 'p'.");
						}
						break;
					case 4:
						System.out.print("Please enter the ID of the member to be removed: ");
						objectId = sc.next();
						System.out.println();
						if ((objectId.charAt(0) == 's' || objectId.charAt(0) == 'p')
								&& objectId.length() == PREDEFINED_ID_LENGTH) {
							try {
								Integer.parseInt(objectId.substring(1, 6));
							} catch (NumberFormatException e) {
								System.out.println("Format Error: " + e.toString());
								isErrorOccur = true;
							}
						} else {
							System.out.println("Error ID: Either not start with 's' or 'p' or the length is not PREDEFINED_ID_LENGTH.");
							isErrorOccur = true;
						}
						if (!isErrorOccur) {
							if (!lmsFacade.removeHolding(objectId)) {
								System.out.println("Error: member with the given ID does not exist.");
							}
						}
						break;
					case 5:
						System.out.print("Please enter the member ID: ");
						memberId = sc.next();
						System.out.println();
						System.out.print("Please enter the holding ID of the holding wish to borrow: ");
						objectId = sc.next();
						if(!lmsFacade.borrowHolding(memberId, objectId)) {
							System.out.println("Error borrow holding");
						}
						break;
					case 6:
						System.out.print("Please enter the member ID: ");
						memberId = sc.next();
						System.out.println();
						System.out.print("Please enter the holding ID of the holding need to be returned: ");
						objectId = sc.next();
						DateTime todaysDate = new DateTime();
						if(!lmsFacade.returnHolding(memberId, objectId, todaysDate)) {
							System.out.println("Errow return holding");
						}
						break;
					case 7:
						lmsFacade.printAllHoldings();
						break;
					case 8:
						lmsFacade.printAllMembers();
						break;
					case 9:
						System.out.print("Please enter the holding ID: ");
						objectId = sc.next();
						System.out.println();
						lmsFacade.printSpecificHolding(objectId);
						break;
					case 10:
						System.out.print("Please enter the member ID: ");
						memberId = sc.next();
						System.out.println();
						lmsFacade.printSpecificMember(memberId);
						break;
					case 11:
						System.out.print("Please enter the ID of the holding or member: ");
						objectId = sc.next();
						System.out.println();
						lmsFacade.activate(objectId);
						break;
					case 12:
						System.out.print("Please enter the ID of the holding or member: ");
						objectId = sc.next();
						System.out.println();
						lmsFacade.deactivate(objectId);
						break;
					case 13:
						System.out.print("Please enter the member ID: ");
						memberId = sc.next();
						System.out.println();
						if(!lmsFacade.resetMembersCredit(memberId)) {
							System.out.println("Error resetting member credit");
						}
						break;
					case 14:
						break;
					case 15:
						break;
					case 0:
						break;
					default:
						System.out.println("Error: Invalid input. Must be a number between 0 - 15!");
						System.out.println();	
			}
		} while (selection != 0);
	sc.close();
	}
}
