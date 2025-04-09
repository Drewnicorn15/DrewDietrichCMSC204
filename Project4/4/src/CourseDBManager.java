

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Drew Dietrich
 */
public class CourseDBManager implements CourseDBManagerInterface{
    CourseDBStructure DB;
    public CourseDBManager()
    {
		DB = new CourseDBStructure(15);
    }
    public CourseDBManager(int size)
    {
		DB = new CourseDBStructure(size);
    }
    /**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
    @Override
	public void add(String id, int crn, int credits, String roomNum, String instructor)
    {
		DB.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
    }
	
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
    @Override
	public CourseDBElement get(int crn)
    {
		try
		{
			return DB.get(crn);
		}catch(IOException e){
			return null;
		}
		
    }
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
    @Override
	public void readFile(File input) throws FileNotFoundException
    {
		Scanner scan = new Scanner(input);
		while(scan.hasNext()){
		String next = scan.nextLine();
		String[] splitNext = next.split(" ");
		add(splitNext[0], Integer.parseInt(splitNext[1]), Integer.parseInt(splitNext[2]), splitNext[3], splitNext[4]);
		}
		scan.close();
    }
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll()
    {
		return DB.showAll();
    }
	
}
