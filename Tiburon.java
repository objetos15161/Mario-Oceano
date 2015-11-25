import greenfoot.*;

/**
 * Write a description of class Tiburon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiburon extends Actor
{
    private WorldOceano mundo;
    
    public void act() 
    {
        //sigue();
        verificaAlcanzado();
    }    
    
    public void sigue()
    {
        int xHeroe, yHeroe, vel;
        
        vel = 1; //Establece la velocidad con que seguirá al héroe.
        mundo = (WorldOceano)getWorld();
        xHeroe = mundo.obtenXDeHeroe();
        yHeroe = mundo.obtenYDeHeroe();
        if ( xHeroe > getX() )
        {
            setImage("Tiburón Der.png");
            setLocation( getX()+vel, getY() );
        }
        else if ( xHeroe < getX() )
        {
            setImage("Tiburón Izq.png");
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
    
    public void verificaAlcanzado()
    {
        mundo = (WorldOceano)getWorld();
        if(this.isTouching(Disparo.class))
        {
            mundo.removeObject(this);
        }
    }
}
