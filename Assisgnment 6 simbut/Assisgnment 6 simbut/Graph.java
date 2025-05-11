import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
/**
 * @author Drew
 */
public class Graph  implements GraphInterface<Town, Road>{
    Set<Town> nodes;
    Set<Road> edges;
    HashMap<Town,HashSet<Road>> adjList;
    HashMap<Town, LinkedList<Road>> dijk;
    HashMap<Town, Integer> distace;
    public Graph()
    {
        nodes = new HashSet<>();
        edges = new HashSet<>();
        adjList = new HashMap<>();
    }
    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
    @Override
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)  throws IllegalArgumentException , NullPointerException
    {
        if(sourceVertex==null || destinationVertex==null)
            throw new NullPointerException();
        Road newR = new Road(sourceVertex,destinationVertex,weight,description);
	    edges.add(newR);
        if(adjList.get(sourceVertex) == null || adjList.get(destinationVertex) == null)
            throw new IllegalArgumentException();
        adjList.get(sourceVertex).add(newR);
        adjList.get(destinationVertex).add(newR);
        return newR;
    }
    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
    @Override
    public boolean addVertex(Town v) throws NullPointerException
    {
        if(v==null)
            throw new NullPointerException();
	nodes.add(v);
    adjList.put(v,new HashSet<>());
    return true;
    }
    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
    @Override
    public boolean containsEdge(Town sourceVertex, Town destinationVertex)
    {
	    for(Road r:adjList .get(sourceVertex))
	        if(r.getDestination().equals(destinationVertex))
		        return true;
        return false;
    }
    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
    @Override
    public boolean containsVertex(Town v)
    {
	    return nodes.contains(v);
    }
    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
    @Override
    public Set<Road> edgeSet()
    {
	return edges;
    }
    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
    @Override
    public Set<Road> edgesOf(Town vertex)throws IllegalArgumentException, NullPointerException
    {
        if(vertex==null)
            throw new NullPointerException();
        if(!adjList.containsKey(vertex))
            throw new IllegalArgumentException();
        return adjList.get(vertex);
    }
    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
    @Override
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
    {
        Road toReturn = null;
        if(weight<1 || description==null)
		    return null;
	    for(Road r:adjList.get(sourceVertex))
	        if(r.getDestination().equals(destinationVertex)){
		        toReturn = r;
                
            }
	    for(Road r:adjList.get(destinationVertex))
	        if(r.getDestination().equals(sourceVertex))
            {
                toReturn = r;
                
            }
            adjList.get(sourceVertex).remove(toReturn);
            adjList.get(destinationVertex).remove(toReturn);
        return toReturn;
    }
     /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
    @Override
    public boolean removeVertex(Town v)
    {
	    
	    adjList.remove(v);
        return nodes.remove(v);
    }
    @Override
    public Set<Town> vertexSet()
    {
	    return nodes;
    }
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
    @Override
    public Road getEdge(Town sourceVertex, Town destinationVertex)
    {
        for(Road r: edges)
            if((r.getDestination().equals(destinationVertex) && r.getSource().equals(sourceVertex)))
                return r;
        for(Road r:edges)
            if((r.getDestination().equals(sourceVertex) && r.getSource().equals(destinationVertex)))
                return new Road(sourceVertex,destinationVertex,r.getWeight(),r.getName());
        return null;
    }
    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
    public Town getVertex(String name)
    {
        for(Town T:nodes)
	        if(T.getName().equals(name))
                return T;
        return null;
    } 
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     */ 
    @Override 
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex)
    {
        dijkstraShortestPath(sourceVertex);
        ArrayList<String> out = new ArrayList<>();
        for(Road R:dijk.get(destinationVertex))
            out.add(R.toString());
        //out.add(T.toString());
        return out;
    }
    
    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
    @Override
    public void dijkstraShortestPath(Town sourceVertex)
    {
        dijk = new HashMap<>();
        distace = new HashMap<>(); 
        for(Town T:nodes){
            distace.put(T,0);
            dijk.put(T, new LinkedList<>());
        }
        Set<Road> validRoads = new HashSet<>();
        Set<Town> validTowns = new HashSet<>();
        validTowns.add(sourceVertex);
        for(Road r: adjList.get(sourceVertex))
        {
            validRoads.add(r);
        }
        while (validTowns.size() != nodes.size()){
            if(validRoads.isEmpty()) {break;}
            Road smallest= null;
            for(Road r: validRoads){
                if(validTowns.contains(r.getDestination()) && validTowns.contains(r.getSource())){continue;}
                if(smallest==null){smallest=r;}
                if((Math.max(distace.get(r.getSource()), distace.get(r.getDestination())) + r.getWeight()) <
                (Math.max(distace.get(smallest.getSource()), distace.get(smallest.getDestination())) + smallest.getWeight()))
                    smallest = r;
            }
            if(smallest==null){break;}
            if(!validTowns.contains(smallest.getSource()))
            {
                distace.put(smallest.getSource(), distace.get(smallest.getDestination())+smallest.getWeight());
                LinkedList<Road> toAdd = new LinkedList<>(dijk.get(smallest.getDestination()));
                toAdd.add(smallest);
                dijk.get(smallest.getSource()).addAll(toAdd);
            } 
            if(!validTowns.contains(smallest.getDestination()))
            {
                distace.put(smallest.getDestination(), distace.get(smallest.getSource())+smallest.getWeight());
                LinkedList<Road> toAdd = new LinkedList<>(dijk.get(smallest.getSource()));
                toAdd.add(smallest);
                dijk.get(smallest.getDestination()).addAll(toAdd);
            }
                
            validTowns.add(smallest.getDestination());
            validTowns.add(smallest.getSource());
            for(Road r:adjList.get(smallest.getDestination()))
                validRoads.add(r);
            for(Road r:adjList.get(smallest.getSource()))
                validRoads.add(r);
            validRoads.remove(smallest);
        }
    }
}

