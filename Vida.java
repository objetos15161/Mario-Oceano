import greenfoot.*;

/**
 * Clase para la bonificación de vida. Las bonificaciones caerán desde la parte superior del escenario.
 * Aumentará el número de vidas de Mario en uno.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class Vida extends Bonificacion
{
    Oceano mundo;
    
    public void act() 
    {
        muevete();
        verificaFondo();
    }    
    
    /**
     * Hace caer a la vida a una velocidad determinada.
     */
    public void muevete()
    {
        int vel=3; // Velocidad de caída de la vida.
        
        setLocation(getX(), getY()+vel);
    }
    
    /**
     * Quita la vida del mundo una vez que ha alcanzado el fondo.
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
