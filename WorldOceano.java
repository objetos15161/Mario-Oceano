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
        Greenfoot.setWorld(new Menu());
        construyeNivel1();
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
    
    public void heroeAlcanzado()
    {
        h.pierdeUnaVida();
        h.setLocation(150, 140);
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
    
    public void agregaDispIzq()
    {
        int x, y;
        int vel=1;
        
        x = h.dimeX();
        y = h.dimeY();
        addObject(new DispIzq(), x, y);
    }
    
    public void agregaDispDer()
    {
        int x, y;
        int vel=1;
        
        x = h.dimeX();
        y = h.dimeY();
        addObject(new DispDer(), x, y);
    }
}
