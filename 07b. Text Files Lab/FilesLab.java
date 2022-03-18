import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilesLab 
{
	public static void main(String[] args) 
	{
		try
		{
			// run 70-point version
			processIntegers("test1.txt", "output1.txt");
			System.out.println();
			
			// run 85-point version
			testLines("test2a.txt", "output2a.txt");
			
			// run 85-point version
			testLines("test2b.txt", "output2b.txt");
			System.out.println();
			
			// run 100-point version - good data
			extractSubstrings("test3a.txt", "output3a.txt");		
			
			// run 100-point version - bad data
			extractSubstrings("test3b.txt", "output3b.txt");		
			System.out.println();
		}
		catch (IOException exc)
		{
			System.out.println("Exception occurred: " + exc.getMessage());
			exc.printStackTrace();			
		}
	}
	
	/**
	 * Processes the integers by ordering them and edits the output file
	 * @param inFile the file with the data
	 * @param outFile the output file
	 * @throws FileNotFoundException propagates the FileNotFoundException
	 */
	public static void processIntegers(String inFile, String outFile) throws FileNotFoundException
	{
		
		PrintWriter myFile = new PrintWriter(outFile);
		Scanner scan = new Scanner(new File(inFile));
		int numLines = scan.nextInt();
		
		int biggest = 0;
		int smallest = 0;
		
		for(int i = 0; i < numLines; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			
			if(a > b && a > c) {
				biggest = a;
			}
			else if(b > c) {
				biggest = b;
			}
			else {
				biggest = c;
			}
			
			if(a < b && a < c) {
				smallest = a;
			}
			else if(b < c) {
				smallest = b;
			}
			else {
				smallest = c;
			}
			
			myFile.write(smallest + "  " + biggest +  "\n");
		}
		
		myFile.close();
		scan.close();
		
		System.out.println("Smallest and largest integers from " + inFile 
			+ " written to " + outFile);
	}
	
	/**
	 * Checks if a line has a certain string
	 * @param inFile the lines to check
	 * @param outFile the output file 
	 * @throws FileNotFoundException propagates the FileNotFoundException
	 */
	public static void testLines(String inFile, String outFile) throws FileNotFoundException
	{
		PrintWriter myFile = new PrintWriter(outFile);
		Scanner scan = new Scanner(new File(inFile));
		String key = scan.nextLine();
		
		while(scan.hasNextLine()) {
			String check = scan.nextLine();
			if(check.toUpperCase().indexOf(key.toUpperCase()) != -1) {
				myFile.write(check + "\n");
			}
		}
		
		myFile.close();
		scan.close();
		
		System.out.println("Lines from " + inFile + " written to " + outFile);
	}
	
	public static void extractSubstrings(String inFile, String outFile) throws FileNotFoundException
	{
		System.out.println("Requested substrings from " + inFile + " written to " + outFile);
	}
	
	private static String getSubstring(int index1, int index2, String text)
	{
		return "";
	}
}
