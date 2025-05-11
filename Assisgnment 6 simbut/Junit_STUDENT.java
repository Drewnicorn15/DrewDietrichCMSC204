
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Junit_STUDENT {
    
    private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_1");
		  graph.addRoad(town[1], town[3], 4, "Road_2");
		  graph.addRoad(town[1], town[5], 6, "Road_3");
		  graph.addRoad(town[3], town[7], 1, "Road_4");
		  graph.addRoad(town[3], town[8], 2, "Road_5");
		  graph.addRoad(town[4], town[8], 3, "Road_6");
		  graph.addRoad(town[6], town[9], 3, "Road_7");
		  graph.addRoad(town[9], town[10], 4, "Road_8");
		  graph.addRoad(town[8], town[10], 2, "Road_9");
		  graph.addRoad(town[5], town[10], 5, "Road_10");
		  graph.addRoad(town[10], town[11], 3, "Road_11");
		  graph.addRoad(town[2], town[11], 6, "Road_12");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}
    @Test
    public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_12", roads.get(3));
		graph.addRoad(town[4], town[11], 1,"Road_13");
		roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_12", roads.get(3));
		assertEquals("Road_13", roads.get(4));
		
	}
    @Test
    public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_10"));
		assertEquals(true, graph.containsTown("Town_8"));
	}
}
