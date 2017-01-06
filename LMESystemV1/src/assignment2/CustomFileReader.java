package assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CustomFileReader
{
	public String readFile()
	{
		StringBuilder stringBuilder = new StringBuilder();
		try	{
			/*
			 * Convenience class for reading character files. The constructors
			 * of this class assume that the default character encoding and the
			 * default byte-buffer size are appropriate.
			 */
			
			/* This is responsible for reading the file into an object.
			 * Note this is a good example of cohesion, this class does
			 * not attempt to process the data for us, its job is to get the data.*/
			FileReader fileReader = new FileReader("holdings.txt");
			
			/*
			 * Reads text from a character-input stream, buffering characters so
			 * as to provide for the efficient reading of characters, arrays,
			 * and lines. The buffer size may be specified, or the default size
			 * may be used. The default is large enough for most purposes. In
			 * general, each read request made of a Reader causes a
			 * corresponding read request to be made of the underlying character
			 * or byte stream. It is therefore advisable to wrap a
			 * BufferedReader around any Reader whose read() operations may be
			 * costly, such as FileReaders and InputStreamReaders. For example,
			 * BufferedReader in = new BufferedReader(new FileReader("foo.in"));
			 */
			
			/* This is responsible for reading the data with the file */
			BufferedReader br = new BufferedReader(fileReader);
			String line = null;
			System.out.println("\n*******************************");
			System.out.println("\nREADING FILE");
			System.out.println("*******************************\n\n");
			while ((line = br.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(line, ":");

				while (st.hasMoreElements())
				{
					String newToken = st.nextToken();
					
					stringBuilder.append(newToken + ":");

				} // inner loop
				
				stringBuilder.append("\n");
			}
			br.close();
		}
		catch (FileNotFoundException e1)
		{
			try	{
				FileReader fileReader = new FileReader("holdings_backup.txt");
			
				/* This is responsible for reading the data with the file */
				BufferedReader br = new BufferedReader(fileReader);
				String line = null;
				System.out.println("\n*******************************");
				System.out.println("\nREADING FILE");
				System.out.println("*******************************\n\n");
				while ((line = br.readLine()) != null)
				{
					StringTokenizer st = new StringTokenizer(line, ":");

					while (st.hasMoreElements())
					{
						String newToken = st.nextToken();
						
						stringBuilder.append(newToken + ":");

					} // inner loop
					
					stringBuilder.append("\n");
				}
				br.close();
			}
			catch (FileNotFoundException e2)
			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // outer loop
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // outer loop
		try	{
			FileReader fileReader = new FileReader("members.txt");
			
			/* This is responsible for reading the data with the file */
			BufferedReader br = new BufferedReader(fileReader);
			String line = null;
			System.out.println("\n*******************************");
			System.out.println("\nREADING FILE");
			System.out.println("*******************************\n\n");
			while ((line = br.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(line, ":");

				while (st.hasMoreElements())
				{
					String newToken = st.nextToken();
					
					stringBuilder.append(newToken + ":");

				} // inner loop
				
				stringBuilder.append("\n");
			}
			br.close();
		}
		catch (FileNotFoundException e1)
		{
			try
			{
				FileReader fileReader = new FileReader("members_backup.txt");
			
				/* This is responsible for reading the data with the file */
				BufferedReader br = new BufferedReader(fileReader);
				String line = null;
				System.out.println("\n*******************************");
				System.out.println("\nREADING FILE");
				System.out.println("*******************************\n\n");
				while ((line = br.readLine()) != null)
				{
					StringTokenizer st = new StringTokenizer(line, ":");

					while (st.hasMoreElements())
					{
						String newToken = st.nextToken();
						
						stringBuilder.append(newToken + ":");

					} // inner loop
					
					stringBuilder.append("\n");
				}
				br.close();
			}
			catch (FileNotFoundException e3)
			{
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // outer loop
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // outer loop
		return stringBuilder.toString();
	}
}
