


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
/**
 * @author Drew Dietrich
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	LinkedList<CourseDBElement>[] table;
	Set<Integer> keys;
    public CourseDBStructure(String teString,int size)
	{
		keys = new TreeSet<>();
		table = (LinkedList<CourseDBElement>[]) new LinkedList<?>[size];
	}
	public CourseDBStructure(int size)
	{
		keys = new TreeSet<>();
		int trueSize = (int)(Math.ceil(size/1.5));
		trueSize += trueSize%4 +3;
		while (!isPrime(trueSize))
			trueSize +=4;
		table = (LinkedList<CourseDBElement>[]) new LinkedList<?>[trueSize];
	}

    /** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) 
    {
		if(keys.contains(element.hashCode())){
			for(CourseDBElement e:table[element.hashCode()%table.length])
				if(e.hashCode()==element.hashCode())
					table[element.hashCode()%table.length].remove(e);
		} 
		else
		{
			keys.add(element.hashCode());
		}
		if(table[element.hashCode()%table.length] ==null)
		{
			table[element.hashCode()%table.length] = new LinkedList<>();
			table[element.hashCode()%table.length].add(element);
		}else
			table[element.hashCode()%table.length].add(element);
    }
	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */

    @Override
	public CourseDBElement get(int crn) throws IOException
    {
		if(table[crn%table.length] ==null) {throw new IOException();}
		else 
			return table[crn%table.length].getLast();
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
		ArrayList<String> output = new ArrayList<>();
		for(LinkedList<CourseDBElement> L:table){
			if(L!=null)
				for(CourseDBElement ele:L)
					output.add(ele.toString());
		}
		return output;

    }
	private boolean isPrime(int number)
	{
		if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
	}
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
    @Override
	public int getTableSize()
    {
		return table.length;

    }
}
