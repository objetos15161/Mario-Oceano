import greenfoot.*;

/**
 * Clase para la caja de bonificación de moviemiento rápido. Las bonificaciones caerán desde la parte superior del escenario.
 * Aumentará la velocidad a la que puede moverse Mario por el escenario.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class MovRapido extends Bonificacion
{
    Oceano mundo;
    
    public void act() 
    {
        muevete();
        verificaFondo();
    }    
    
    /**
     * Hace caer la caja a una velocidad determinada.
     */
    public void muevete()
    {
        int vel=3; // Velocidad de caída de la caja.
        
        setLocation(getX(), getY()+vel);
    }
    
    /**
     * Quita la caja del mundo una vez que ha alcanzado el fondo.
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
