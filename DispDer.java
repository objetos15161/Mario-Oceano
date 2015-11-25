import greenfoot.*;

/**
 * Write a description of class DispDer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DispDer extends Disparo
{
    private WorldOceano mundo;
    
    public void act() 
    {
        muevete();
        checaOrilla();
    }    
    
    public void muevete()
    {   
        setLocation(getX()+3, getY());
    }
    
    public void checaOrilla()
    {
        mundo = (WorldOceano)getWorld();
        
        if(this.isAtEdge())
            mundo.removeObject(this);
    }
}
