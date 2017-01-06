package assignment2;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CustomFileWriter {
	public void writeToFileHolding(Holding holding) {
		String filename = "holdings.txt"; 		// path & filename
		FileWriter outStream = null;            // create an Object variable
		System.out.println("\nWriting to File......");
		try {
			//create a new object of the FileWriter class & assign to the Object variable
			outStream = new FileWriter(filename, true);
			//append / write  data to the file.  
			outStream.append(holding.toString() + '\n');
			System.out.println(holding.toString());
		} catch(FileNotFoundException e) {
			//display the inbuilt error message belonging to e object
			System.out.println(e);  
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try	{
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeToFileHoldingBackup(Holding holding) {
		String filename = "holdings_backup.txt"; // path & filename
		FileWriter outStream = null; // create an Object variable
		System.out.println("\nWriting to File......");
		try {
			// create a new object of the FileWriter class & assign to the
			// Object variable
			outStream = new FileWriter(filename, true);
			// append / write data to the file.
			outStream.append(holding.toString() + '\n');
			System.out.println(holding.toString());
		} catch (FileNotFoundException e) {
			// display the inbuilt error message belonging to e object
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeToFileMember(Member member) {
		String filename = "members.txt"; 		// path & filename
		FileWriter outStream = null;            // create an Object variable
		System.out.println("\nWriting to File......");
		try {
			//create a new object of the FileWriter class & assign to the Object variable
			outStream = new FileWriter(filename, true);
			//append / write  data to the file.  
			outStream.append(member.toString() + '\n');
			System.out.println(member.toString());
		} catch(FileNotFoundException e) {
			//display the inbuilt error message belonging to e object
			System.out.println(e);  
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try	{
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeToFileMemberBackup(Member member) {
		String filename = "members_backup.txt"; // path & filename
		FileWriter outStream = null; // create an Object variable
		System.out.println("\nWriting to File......");
		try {
			// create a new object of the FileWriter class & assign to the
			// Object variable
			outStream = new FileWriter(filename, true);
			// append / write data to the file.
			outStream.append(member.toString() + '\n');
			System.out.println(member.toString());
		} catch (FileNotFoundException e) {
			// display the inbuilt error message belonging to e object
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
