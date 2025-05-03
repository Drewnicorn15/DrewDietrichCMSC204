
import java.util.LinkedList;

public class CarQueue{
    private LinkedList<Integer> LL;
    public CarQueue()
    {
        LL = new LinkedList<>();
        for(int i = 0;i<6;i++)
        {
            LL.add((int)(Math.random()*4));
        }
    }
    public int deleteQueue()
    {
        return LL.remove();
    }
    public void addToQueue()
    {
        class addToQueueRunnable implements Runnable
        {
            @Override
            public void run() {
                try{
                for(int i = 0;i<6;i++)
                {
                    LL.add((int)(Math.random()*4));
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
            }
        }

        Runnable r = new addToQueueRunnable();
	    Thread t = new Thread(r);
	    t.start();
    }
}
