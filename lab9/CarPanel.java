import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	private int flipped;
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		flipped = 1;
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
					direction = carQueue.deleteQueue();
	               for(int i=0;i<20;i++)
	               {
						if(direction==3 && x<0)
							direction = 2;
						else if (direction==2 && x>300)
							direction=3;
						else if (direction==0 && y<0)
							direction = 1;
						else if (direction==1 && y>400)
							direction=0;
                        switch (direction) {
                               case 0 -> y-=10;
                               case 1 -> y+=10;
                               case 2 -> x = x+10;
                               default -> x-=10;
                           }
	            	   repaint();
	            	   Thread.sleep(delay*1000);
	            	   
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
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}