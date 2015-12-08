import greenfoot.*;

/**
 * El menú desde donde se podrá acceder al juego y las demás opciónes.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class Menu extends World
{
    public static final int ALTM = 600; // Altura del menú.
    public static final int ANCM = 900; // Ancho del menú.

    public static final GreenfootSound musica = new GreenfootSound("Aquatic Ambiance.mp3");
    
    private BotonInicio inicio = new BotonInicio();
    private BotonAyuda ayuda = new BotonAyuda();
    private BotonCreditos creditos = new BotonCreditos();
    
    /**
     * Constructor de la clase Menu.
     */
    public Menu()
    {    
        super(ANCM, ALTM, 1); // Crea el menú de la altura y ancho determinados en sus respectivas constantes ALTM y ANCM.
        construyeMenu();
    }
    
    /**
     * Muestra los botones.
     */
    public void construyeMenu()
    {
        addObject(inicio, 230, 470);
        addObject(ayuda, 440, 470);
        addObject(creditos, 650, 470);
    }
    
    /**
     * Vigila cuál de los botones se ha presionado con el mouse y realiza la acción correspondiente.
     */
    public void act()
    {
        if(Greenfoot.getMouseInfo() != null)
        {
            if(Greenfoot.mousePressed(inicio))
            {
                Greenfoot.setWorld(new Oceano());
                if(!Menu.musica.isPlaying()) // Esta línea evita que la música se empalme.
                    musica.playLoop();
            }
            if(Greenfoot.mousePressed(ayuda))
            {
                Greenfoot.setWorld(new Ayuda());
            }
            if(Greenfoot.mousePressed(creditos))
            {
                Greenfoot.setWorld(new Creditos());
            }
        }
    }
}
