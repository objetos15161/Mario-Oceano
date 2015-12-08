import greenfoot.*;

/**
 * Pantalla de ayuda
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class Ayuda extends World
{
    public static final int ALTM = 600; // Altura del menú.
    public static final int ANCM = 900; // Ancho del menú.
    
    private BotonMenu menu = new BotonMenu();
    
    /**
     * Constructor de la clase Ayuda.
     */
    public Ayuda()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(ANCM, ALTM, 1); 
        addObject(menu, ANCM-120, 105);
    }
    
    /**
     * Hace funcionar al botón de regreso al menú.
     */
    public void act()
    {
        if(Greenfoot.getMouseInfo() != null)
        {
            if(Greenfoot.mousePressed(menu))
            {
                Greenfoot.setWorld(new Menu());
            }
        }
    }
}
