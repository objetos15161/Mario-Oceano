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
    private int dir = 1;    //Dirección hacia la que está mirando el héroe. Se usará para determinar la dirección de sus disparos.
    private WorldOceano mundo;
    
    public void act() 
    {
        muevete();
        hundete();
        dispara();
        verificaAlcanzado();
        dir = dimeDir();
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
            dir = 0;
            setImage("Mario Izq.png");
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            dir = 1;
            setImage("Mario Der.png");
        }
        if(Greenfoot.isKeyDown("up"))
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
    
    public int dimeDir()
    {
        return dir;
    }
    
    public void verificaAlcanzado()
    {
        mundo = (WorldOceano)getWorld();
        if(this.isTouching(Submarino.class))
        {
            mundo.heroeAlcanzado();
        }
    }
    
    public void dispara()
    {
        mundo = (WorldOceano)getWorld();
        if(Greenfoot.isKeyDown("a"))
            if(dir==0)
                mundo.agregaDispIzq();
            else if (dir==1)
                mundo.agregaDispDer();
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
