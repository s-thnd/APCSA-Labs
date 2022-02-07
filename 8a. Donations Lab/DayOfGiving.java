import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DayOfGiving 
{
	public static void main( String[] args) 
	{
		// Test the methods using the first input file
		testMethods("westGiving.txt");

		System.out.println("******************************************************\n");
		
		// Test the methods using the second input file
		testMethods("wolfGiving.txt");
	}
	
	public static Donation[] loadDonations(String inputFile)
	{
		// Check if the file exists
		File input = new File(inputFile);
		if (!input.exists())
		{
			System.out.println(inputFile 
				+ " not found. Check with your teacher.");
			System.out.println("Ending program");
			System.exit(0);
		}
		
		try
		{
			// Declare and create a Scanner object for the input File object 
			Scanner scan = new Scanner(new File(inputFile));

			
			// Read in the number of donations on the first line of
			// the file. Remember to flush the end-of-line character.
			int numDonations = scan.nextInt();
			scan.nextLine();

			
			// Declare and create an array of Donation objects using the
			// number of donations read from the file.
			Donation[] donationArray = new Donation[numDonations];
			
			
			// In a loop, read in each set of donation information. 
			// Create a Donation object and store it in your array.
			// Remember to flush the end-of-line character AFTER reading the amount.
			for(int i = 0; i < donationArray.length; i++) {
				String donorName = scan.nextLine();
				String recipient = scan.nextLine();
				int donorAge = scan.nextInt();
				double amount = scan.nextDouble();
				scan.nextLine();
				donationArray[i] = new Donation(donorName, donorAge, recipient, amount);
			}
		
			// Return your new array HERE
			return donationArray;
			
		}
		catch (IOException exc)
		{
			System.out.println(exc.getMessage());
			System.out.println("Ending program");
			System.exit(0);
		}
		return null;
	}

	public static void showDonations(Donation[] donations)
	{
		for(int i = 0; i < donations.length; i++) {
			System.out.println(donations[i]);
		}
		
	}
	
	public static double calcAverageDonation(Donation[] donations)
	{
		double total = 0;
		for(Donation d : donations) {
			total += d.getAmount();
		}
		return total/donations.length;
	}
	
	public static int calcNumInAgeRange(Donation[] donations, int minAge, int maxAge)
	{
		int count = 0;
		for(Donation d : donations) {
			if(d.getAge() >= minAge && d.getAge() <= maxAge) {
				count++;
			}
		}
		return count;
	}
	
	public static int updateDonation(Donation[] donations, String donor, double bigCheck)
	{
		int count = 0;
		for(Donation d : donations) {
			if(d.getDonor().equals(donor)) {
				d.changeAmount(bigCheck);
				count++;
			}
		}
		return count;
	}
	
	public static String getBiggestDonationRecipient(Donation[] donations)
	{
		double biggestVal = 0;
		String name = "";
		for(Donation d : donations) {
			if(d.getAmount() > biggestVal) {
				biggestVal = d.getAmount();
				name = d.getRecipient();
			}
		}
		return name;
	}
	
	/** Tests the methods for a given file
	 *  @param fileName name of file to read 
	 */
	public static void testMethods(String fileName) 
	{
		System.out.println("Test with file: " + fileName);
		
		// Populate array of Donation objects
		Donation[] heroGiving = loadDonations(fileName);
		
		// Display the donations
		showDonations(heroGiving);
		
		// Calculate the average amount of all donations
		double avgAmount = calcAverageDonation(heroGiving);
		System.out.printf("Average Donation Amount: $%,.2f %n%n", avgAmount);
		
		// Determine the number of donors in range [13, 215]
		int numYoungDonors = calcNumInAgeRange(heroGiving, 13, 25);
		System.out.println("Number of younger donors: " + numYoungDonors);
		
		// Determine the number of donors in range [60, 110]
		int numOlderDonors = calcNumInAgeRange(heroGiving, 60, 110);
		System.out.println("Number of older donors: " + numOlderDonors);
		System.out.println();
		
		// Change the donation amount for all donations from the given donor
		int numChanged = updateDonation(heroGiving, "Wonder Woman", 25_000);
		System.out.println("Changed " + numChanged + " donations from \"Wonder Woman\"");
		
		// Change the donation amount for all donations from the given donor
		numChanged = updateDonation(heroGiving, "The Avengers", 3_333);
		System.out.println("Changed " + numChanged + " donations from \"The Avengers\"");
		System.out.println();
		
		System.out.println("After updating:");
		showDonations(heroGiving);
		
		// Find the recipient of the largest donation amount
		String recipient = getBiggestDonationRecipient(heroGiving);
		System.out.println();
		System.out.println("Recipient of largest donation: " + recipient);
		System.out.println();
	}
	
}
