import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Drew
 */
public class TownGraphManager implements TownGraphManagerInterface{
    Graph main;
    public TownGraphManager()
    {
        main = new Graph();
    }
    /**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName)
    {
        Road r= main.addEdge(new Town(town1), new Town(town2), weight, roadName);
        return r!=null;
    }
	
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2)
    {
        return main.getEdge(new Town(town1), new Town(town2)).getName();
    }
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
    @Override
	public boolean addTown(String v)
    {
        return main.addVertex(new Town(v));
    }   
	
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name)
    {
        return main.getVertex(name);
    }
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v)
    {
        return main.containsVertex(new Town(v));
    }
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2)
    {
        return main.containsEdge(new Town(town1), new Town(town2));
    }
	
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads()
    {
        ArrayList<String> s = new ArrayList<>();
        for(Road r:main.edgeSet())
            s.add(r.getName());
        Collections.sort(s);
        return s;
    }
	
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road)
    {
        return main.removeEdge(new Town(town1), new Town(town2),1, road) != null;
    }
	
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v)
    {
        return main.removeVertex(new Town(v));
    }

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns()
    {
        ArrayList<String> s = new ArrayList<>();
        for(Town T:main.vertexSet())
            s.add(T.toString());
        Collections.sort(s);
        return s;
    }
	
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2)
    {
        return main.shortestPath(new Town(town1), new Town(town2));
    }
}
