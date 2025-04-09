
/**
 * @author Drew Dietrich
 */
public class CourseDBElement {
    private String ID;
    private int CRN;
    private int numCred;
    private String roomNum;
    private String name;

    public CourseDBElement(String i,int c,int n,String r,String p)
    {
        ID = i;
        CRN = c;
        numCred = n;
        roomNum = r;
        name = p;
    }
    public int getCRN()
    {
        return CRN;
    }
    @Override
    public String toString()
    {
        return "\nCourse:"+ID+ " CRN:"+CRN +" Credits:"+numCred + " Instructor:" +name +" Room:"+roomNum;
    }
    @Override
    public int hashCode()
    {
        return CRN;
    }
    public String getID() 
    {
    	return ID;
    }
	public String getRoomNum() {
		return roomNum;
    }
}
