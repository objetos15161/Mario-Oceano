import greenfoot.*;

/**
 * Clase para la mina. Las minas caerán desde la parte superior del escenario y no podrán ser destruidas por los disparos normales del jugador.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class Mina extends Enemigo
{
    Oceano mundo;
    
    public void act() 
    {
        muevete();
        verificaFondo();
    }    
    
    /**
     * Hace caer a la mina a una velocidad determinada.
     */
    public void muevete()
    {
        int vel=3; // Velocidad de caída de la mina.
        
        setLocation(getX(), getY()+vel);
    }
    
    /**
     * Quita a la mina del mundo una vez que ha alcanzado el fondo.
     */
    public void verificaFondo()
    {
        mundo=(Oceano)getWorld();
        
        if(getY() >= (mundo.ALTM-1))
        {
            mundo.removeObject(this);
        }
    }
}
