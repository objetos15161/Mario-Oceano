import greenfoot.*;

/**
 * Write a description of class DispIzq here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DispIzq extends Disparo
{
    private WorldOceano mundo;
    
    public void act() 
    {
        muevete();
        checaOrilla();
        //checaGolpe();
    }    
    
    public void muevete()
    {   
        setLocation(getX()-3, getY());
    }
    
    public void checaOrilla()
    {
        mundo = (WorldOceano)getWorld();
        
        if(this.isAtEdge())
            mundo.removeObject(this);
    }
    
    public void checaGolpe()
    {
        mundo = (WorldOceano)getWorld();
        
        if(this.isTouching(Submarino.class))
            mundo.removeObject(this);
        if(this.isTouching(Tiburon.class))
            mundo.removeObject(this);
    }
}
