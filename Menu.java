import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private BotonInicio inicio;
    private BotonAyuda ayuda;
    private BotonRecords records;
    
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(900, 600, 1); 
        
        setBackground("Fondo Menú.jpg");
        muestraBotones();
        
        act();
    }
    
    public void muestraBotones()
    {        
        inicio = new BotonInicio();
        ayuda = new BotonAyuda();
        records = new BotonRecords();
        
        addObject(inicio, 300, 300);
        addObject(ayuda, 300, 400);
        addObject(records, 300, 500);
    }
    
    public void act()
    {
        if(Greenfoot.getMouseInfo()!=null)
            if(Greenfoot.mousePressed(inicio))
                Greenfoot.setWorld(new WorldOceano());
    }
}
