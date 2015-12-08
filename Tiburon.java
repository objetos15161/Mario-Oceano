import greenfoot.*;

/**
 * Tiburón. Es el enemigo más débil, se mueve sin dirección determinada.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class Tiburon extends Enemigo
{
    private int avX=2, avY=2; // Qué tanto avanzará el tiburón en x y en y.
    private Oceano mundo;
    
    public void act() 
    {
        muevete();
        verificaOrilla();
        reaccionDisparo();
    }    
    
    /**
     * Movimiento del tiburón.
     */
    public void muevete()
    {
        setLocation(getX()+avX, getY()+avY);
    }
    
    /**
     * El tiburón cambiará de dirección al toparse con un borde del mundo.
     * Su imágen cambiará de acuerdo a la dirección en la que avance.
     */
    public void verificaOrilla()
    {
        mundo = (Oceano)getWorld();
        
        if(getX() >= (mundo.ANCM-1))
        {
            setImage("Tiburón Izq.png");
            avX=-avX;
        }
        if(getY() >= (mundo.ALTM-1))
        {
            avY=-avY;
        }
        if(getX() <= 1)
        {
            setImage("Tiburón Der.png");
            avX=-avX;
        }
        if(getY() <= 1)
        {
            avY=-avY;
        }
    }
    
    /**
     * Vigila si este enemigo ha sido alcanzado por un disparo del jugador, y realiza las acciones correspondientes.
     */
    public void reaccionDisparo()
    {
        int finNivel=0; // Determina si éste fue el último enemigo requerido para avanzar un nivel.
        int detLado=Greenfoot.getRandomNumber(2); // Determina de qué lado de la pantalla se hará el respawn de este enemigo.
        mundo = (Oceano)getWorld();
        
        if(this.isTouching(DispMario.class))
        {
            if(mundo.dimeHabMario()!=3)
            {
                removeTouching(DispMario.class);
            }
            finNivel=mundo.enemigoVencido();
            if(finNivel==0)
            {
                if(detLado==0)
                {
                    setLocation(2, 2+Greenfoot.getRandomNumber(mundo.ALTM-2));
                }
                else
                {
                    setLocation(mundo.ANCM-2, 2+Greenfoot.getRandomNumber(mundo.ALTM-2));
                }
            }
        }
    }
}