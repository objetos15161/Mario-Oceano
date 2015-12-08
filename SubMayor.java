import greenfoot.*;

/**
 * Clase para el Submarino Mayor. Seguirá a Mario y le disparará.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class SubMayor extends Submarino
{
    private Oceano mundo;
    private SimpleTimer tDisparo = new SimpleTimer(); // Temporizador para la frecuencia de los disparos.
    
    public void act() 
    {
        sigue();
        dispara();
        reaccionDisparo();
    }    
    
    /**
     * Método para hacer que el submarino sigua a Mario.
     */
    public void sigue()
    {
        int vel=1;// Velocidad con la que se acercará este submarino a Mario.
        mundo=(Oceano)getWorld();
        
        if(getY()>mundo.dimeYMario())
        {
            setLocation(getX(), getY()-vel);
        }
        if(getY()<mundo.dimeYMario())
        {
            setLocation(getX(), getY()+vel);
        }
        if(getX()<mundo.dimeXMario())
        {
            setImage("SubMayor Der.png");
            setLocation(getX()+vel, getY());
        }
        if(getX()>mundo.dimeXMario())
        {
            setImage("SubMayor Izq.png");
            setLocation(getX()-vel, getY());
        }
    }
    
    /**
     * Efectúa el disparo a Mario cada cierto tiempo.
     */
    public void dispara()
    {
        mundo=(Oceano)getWorld();
        int tiempo = 4000; // Tiempo entre cada disparo (en milésimas de segundo).
        
        if(tDisparo.millisElapsed()>tiempo)
        {
            mundo.addObject(new DispEnemigo(), getX(), getY());
            tDisparo.mark();
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
