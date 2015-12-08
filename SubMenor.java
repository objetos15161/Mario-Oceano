import greenfoot.*;

/**
 * Clase para el Submarino Menor; este submarino se moverá por el escenario, si llega a estar viendo en dirección hacia a Mario y a su misma altura
 * en el escenario, comenzará a seguirlo y a dispararle.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class SubMenor extends Submarino
{
    private int detectado=0; // Bandera que indica si el submarino ha detectado a Mario.
    private int dir; // Dirección hacia la que ve el submarino actualmente (0 = izquierda, 1 = derecha).
    private int avX=2, avY=2; // Qué tanto avanzará el submarino en x y en y.
    private Oceano mundo;
    private SimpleTimer tDisparo = new SimpleTimer(); // Temporizador para la frecuencia de los disparos.

    public void act() 
    {
        verificaDetectado();
        if(detectado==0)
        {
            muevete();
            verificaOrilla();
        }
        else
        {
            sigue();
            dispara();
        }
        reaccionDisparo();
    }    

    /**
     * Método encargado de activar la bandera de detección del submarino.
     * Si el submarino le quita una vida a Mario, comenzará a buscarlo otra vez.
     */
    public void verificaDetectado()
    {
        mundo = (Oceano)getWorld();

        if(getY() >= mundo.dimeYMario()-5 && getY() <= mundo.dimeYMario()+5) // ¿El submarino está a la altura de Mario?
        {
            // ¿El submarino está mirando hacia Mario?
            if(dir==0 && mundo.dimeXMario()<getX()) 
            {
                detectado=1;
            }
            if(dir==1 && mundo.dimeXMario()>getX())
            {
                detectado=1;
            }
        }
        if(this.isTouching(Mario.class))
        {
            detectado=0;
        }
    }

    /**
     * Movimiento de búsqueda del submarino.
     */
    public void muevete()
    {
        setLocation(getX()+avX, getY()+avY);
    }

    /**
     * El submarino cambiará de dirección al toparse con un borde del mundo.
     * Su imágen cambiará de acuerdo a la dirección en la que avance, al igual que su bandera de dirección.
     */
    public void verificaOrilla()
    {
        mundo = (Oceano)getWorld();

        if(getX() >= (mundo.ANCM-1))
        {
            setImage("SubMenor Izq.png");
            avX=-avX;
            dir=0;
        }
        if(getY() >= (mundo.ALTM-1))
        {
            avY=-avY;
        }
        if(getX() <= 1)
        {
            setImage("SubMenor Der.png");
            avX=-avX;
            dir=1;
        }
        if(getY() <= 1)
        {
            avY=-avY;
        }
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
            setImage("SubMenor Der.png");
            dir = 1;
            setLocation(getX()+vel, getY());
        }
        if(getX()>mundo.dimeXMario())
        {
            setImage("SubMenor Izq.png");
            dir = 0;
            setLocation(getX()-vel, getY());
        }
    }

    /**
     * Efectúa el disparo a Mario cada cierto tiempo.
     */
    public void dispara()
    {
        mundo=(Oceano)getWorld();
        int tiempo = 7000; // Tiempo entre cada disparo (en milésimas de segundo).

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
            detectado=0;
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
