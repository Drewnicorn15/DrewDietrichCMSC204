/**
 * @author Drew
 */
public class Road implements Comparable<Road>{
    Town from,to;
    int weight; 
    String name;
    public Road(Town source, Town destination, int degrees, String n)
    {
        from = source;
        to = destination;
        weight = degrees;
        name= n;
    }
    public Road(Town source, Town destination, String n)
    {
        from = source;
        to = destination;
        weight = 1;
        name= n;
    }
    public boolean contains(Town town)
    {
        return town.equals(from) || town.equals(to);
    }
    public boolean equals(Road r)
    {
        return r.getDestination().equals(to) && r.getSource().equals(from);
    }
    public Town getSource()
    {
        return from;
    }
    public Town getDestination()
    {
        return to;
    }
    public int getWeight()
    {
        return weight;
    }
    @Override
    public int compareTo(Road r)
    {   
        return equals(r)?0:1;
    }
    @Override
    public String toString()
    {
        //Vertex_1 via Edge_2 to Vertex_3 4 
        return from + " via " + name + " to " +to +" "+weight+" mi" ;
    }

    public String getName() {
        return name;
    }
}
