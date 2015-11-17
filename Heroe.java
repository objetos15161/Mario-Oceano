import greenfoot.*;

/**
 * Write a description of class Heroe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroe extends Actor
{
    private int vidas = 3;
    
    public void act() 
    {
        muevete();
        hundete();
        pierdeUnaVida();
    }    
    
    public void hundete()
    {
        int x=getX();
        int y=getY();
        setLocation(x, y+1);
    }
    
    public void muevete()
    {
        int x=getX();
        int y=getY();
        
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            setImage("Mario Izq.png");
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            setImage("Mario Der.png");
        }
        if(Greenfoot.isKeyDown("a"))
        {
            y=y-3;
            setLocation(x, y);
            y=y-2;
            setLocation(x, y);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            y=y+3;
            setLocation(x, y);
        }
    }
    
    public void pierdeUnaVida()
    {
        vidas = vidas - 1;
    }
    
    public int dimeX()
    {
        int x = getX();
        
        return x;
    }
    
    public int dimeY()
    {
        int y = getY();
        
        return y;
    }
}
