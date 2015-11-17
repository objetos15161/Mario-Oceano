import greenfoot.*;

/**
 * Write a description of class SubMenor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SubMenor extends Actor
{
    private WorldOceano mundo;
    
    public void act() 
    {
        sigue();
    }    
    
    public void sigue()
    {
        int xHeroe, yHeroe, vel;
        
        vel = 2; //Establece la velocidad con que seguirá al héroe.
        mundo = (WorldOceano)getWorld();
        xHeroe = mundo.obtenXDeHeroe();
        yHeroe = mundo.obtenYDeHeroe();
        if ( xHeroe > getX() )
        {
            setLocation( getX()+vel, getY() );
        }
        else if ( xHeroe < getX() )
        {
            setLocation( getX()-vel, getY() );
        }
        if ( yHeroe > getY() )
        {
            setLocation( getX(), getY()+vel );
        }
        else if ( yHeroe < getY() )
        {
            setLocation( getX(), getY()-vel );
        }
    }
}
