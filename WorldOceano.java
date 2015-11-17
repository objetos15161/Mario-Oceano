import greenfoot.*;

/**
 * Write a description of class WorldOceano here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldOceano extends World
{
    private Heroe h;

    /**
     * Constructor for objects of class WorldOceano.
     * 
     */
    public WorldOceano()
    {    
        super(900, 600, 1); 
//        construyeMenu();
        construyeNivel1();
    }
    
    public void construyeMenu()
    {
        BotonInicio inicio;
        BotonAyuda ayuda;
        
        inicio = new BotonInicio();
        ayuda = new BotonAyuda();
        setBackground("Fondo Menú.jpg");
        addObject(inicio, 300, 400);
        addObject(ayuda, 300, 500);
/*
        if(  )            ¿Condición para determinar el botón presionado?
        {
            construyeNivel1();
        }
*/
    }
    
    public void construyeNivel1()
    {
        h = new Heroe();
        Tiburon tib = new Tiburon();
        SubMenor sme = new SubMenor();
        SubMayor sma = new SubMayor();
        
        setBackground("Fondo Nivel 1.jpg");
        addObject(sma, 500, 500);
        addObject(sme, 850, 250);
        addObject(tib, 100, 550);
        addObject(h, 150, 140);        
    }
    
    public int obtenXDeHeroe()
    {
        int x;
        x = h.dimeX();

        return x;
    }
    
    public int obtenYDeHeroe()
    {
        int y;
        y = h.dimeY();

        return y;
    }
}
