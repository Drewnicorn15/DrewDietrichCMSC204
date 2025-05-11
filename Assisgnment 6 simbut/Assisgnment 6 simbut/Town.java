/**
 * @author Drew
 */
public class Town implements Comparable<Town>{
    String name;
    public Town(String s)
    {
        name= s;
    }
    public String getName()
    {
        return name;
    }
    @Override
    public int compareTo(Town o)
    {
        return equals(o)?0:1; 
    }
    @Override
    public boolean equals(Object T)
    {
        if(T instanceof Town town)
            return name.equals(town.getName());
        else
            return false;
    }
    @Override
    public int hashCode()
    {
        return name.hashCode();
    }
    @Override
    public String toString()
    {
        return name;
    }
}
