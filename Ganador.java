import greenfoot.*;

/**
 * Pantalla a mostrar cuando se ha ganado el juego.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class Ganador extends World
{
    public static final int ALTM = 600; // Altura de la pantalla.
    public static final int ANCM = 900; // Ancho de la pantalla.
    
    private SimpleTimer tiempo = new SimpleTimer();
    
    /**
     * Constructor de la clase Ganador.
     */
    public Ganador()
    {    
        super(ANCM, ALTM, 1); // Crea la pantalla de la altura y ancho determinados en sus respectivas constantes ALTM y ANCM.
    }
    
    /**
     * Retira esta pantalla tras cuatro segundos.
     */
    public void act()
    {
        if(tiempo.millisElapsed() > 4000)
        {
            Greenfoot.setWorld(new Menu());
        }
    }
}
