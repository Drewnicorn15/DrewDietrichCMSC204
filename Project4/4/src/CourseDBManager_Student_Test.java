import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_Student_Test {
    private CourseDBManagerInterface dataMgr = new CourseDBManager();

    @Before
    public void setUp() throws Exception
    {
        dataMgr = new CourseDBManager();
    }
    @After
	public void tearDown() throws Exception {
		dataMgr = null;
	}
    @Test
    public void addTest()
    {
        try {
			dataMgr.add("code",10000,1,"SC450","Mr. Clean");
            assertEquals(dataMgr.get(10000).toString(), "\nCourse:code CRN:10000 Credits:1 Instructor:Mr. Clean Room:SC450");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
    }

}
