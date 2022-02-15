 
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentGroup 
{
	// Maximum number of students stored in array
	private final static int MAX_STUDENTS = 200;
	
	// Instance variables
	private Student[] students;	// array of Student objects
	private int numStudents;	// number of actual objects in array

	/** Constructs an empty student group with capacity for MAX_STUDENTS
	 */
	public StudentGroup() 
	{
		students = new Student[MAX_STUDENTS];
		numStudents = 0;
	}
	
	/** Constructs a student group with capacity for MAX_STUDENTS
	 *  and populates it with the student data found in the given file
	 *  @param fileName name of file containing student data
	 */
	public StudentGroup(String fileName) 
	{
		students = new Student[MAX_STUDENTS];
		numStudents = 0;
		readFile(fileName);
	}

	/**
	 * Uses a linear search to find a student by their name
	 * @param name, the name we are looking for
	 * @return the student with the matching name or null if there is no such student
	 */
	public Student findByName(String name) 
	{

		for(int i = 0; i < numStudents; i++) {
			if(students[i].getName().equals(name)) {
				return students[i];
			}
		}
		
		return null;
		
	}
	
	/**
	 * Sorts the list alphabetically by name using an insertion sort
	 */
	public void sortByName() 
	{
		int iterate;		
		Student key;

		for (int index = 1; index < numStudents; index++) { 
			key = students[index];
			iterate = index - 1;
			while (iterate >= 0) {
				if (key.getName().compareTo(students[iterate].getName()) > 0) {//here too
					break;
				}
			students[iterate + 1] = students[iterate];
			iterate--;
			}
		students[iterate + 1] = key;
		}
	}

	/**
	 * Sorts the list based on the student IDs by using a selection sort
	 */
	public void sortByID() 
	{
	    for (int i = 1; i < numStudents; i++) {
	        for (int j = i; j > 0; j--) {
	            if (students[j - 1].getID() > students[j].getID()) {
	                Student temp = students[j];
	                students[j] = students[j - 1];
	                students[j - 1] = temp;
	            }
	        }
	    }
	}

	/**
	 * Finds a student that has a specific ID by using a binary search.
	 * @param id, the id value we are searching for
	 * @return the student with the matching ID or null if no such student exists
	 */
	public Student findByID(int id) 
	{
        int lowIndex = 0;
        int highIndex = numStudents-1;
        
        while (lowIndex <= highIndex) {

        	int midIndex = (highIndex + lowIndex) / 2;

        	if (students[midIndex].getID() == id) {
                return students[midIndex];
            } 

            else if (students[midIndex].getID() < id) {
 
            	lowIndex = midIndex + 1;
            	
            } else if (students[midIndex].getID() > id) {

                highIndex = midIndex - 1;
                
            }
        }
        
        return null;

	}

	/** Provides the group of students
	 *  @return the group of students as a string
	 */
	@Override
	public String toString() 
	{
		String str = "[";
		for (int index = 0; index < numStudents; index++) 
		{
			str += students[index].toString();
			if (index == numStudents - 1) 
				str += "]";
			else
				str += ",\n ";
		}
		return str;
	}

	/** Reads student entries from a given file and stores them in the array
	 *  @param fileName name of file containing student data in format
	 *         LAST<space>FIRST<space>ID<space>GPA
	 */
	private void readFile(String fileName) 
	{
		try 
		{
			// Open file for reading
			Scanner scan = new Scanner(new FileReader(fileName));
			
			// Continue reading and adding students until  no more entries
			// Entries are in form LAST<space>FIRST<space>ID<space>GPA
			while (scan.hasNextLine()) 
			{						
				String inputStr = scan.nextLine();
				Scanner strScan = new Scanner(inputStr);
				String lastName = strScan.next();
				String firstName = strScan.next();
				int id = strScan.nextInt();
				double gpa = strScan.nextDouble();

				Student stu = new Student(lastName, firstName, id, gpa);
				students[numStudents] = stu;
				numStudents++;
			}
			scan.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		} 
		catch (Exception e) 
		{
			System.out.println("Error reading from file " + fileName +
									  "\nError:  " + e.getMessage());
		}
	}
}
