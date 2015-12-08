import greenfoot.*;

/**
 * La clase del personaje del jugador.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class Mario extends Actor
{
    private Oceano mundo;
    private SimpleTimer tDisparo = new SimpleTimer(); // Temporizador para el lapso entre los disparos.
    private SimpleTimer tInv = new SimpleTimer(); // Temporizador para la duración de la inmunidad de Mario.
    private int dir = 1; // Dirección hacia la que está mirando Mario actualmente (0 = izquierda, 1 = derecha).
    private int vidas = 3;
    private int inv = 0; // Indica si Mario es invencible actualmente. Será invencible temporalmente cada que entre al juego tras perder una vida.
    private int habilidad = 0; // Habilidad actual de Mario. 0 = Ninguna, 1 = Mov. rápido, 2 = Disparo rápido, 3 = Disparo plus.

    public void act() 
    {
        hundete();
        muevete();
        dispara();
        agotaInvencible();
        contactoConBonif();
        contactoConFondo();
        if(inv==0)
        {
            contactoConEnemigo();
        }
    }    

    /**
     * Proporciona acceso a la posición en el eje x de Mario.
     * @return Posición en 'x' de Mario.
     */
    public int dimeX()
    {
        return getX();
    }

    /**
     * Proporciona acceso a la posición en el eje y de Mario.
     * @return Posición en 'y' de Mario.
     */
    public int dimeY()
    {
        return getY();
    }

    /**
     * Proporciona acceso a la cantidad de vidas de Mario.
     * @return Número de vidas de Mario.
     */
    public int dimeVidas()
    {
        return vidas;
    }

    /**
     * Proporciona acceso a la habilidad actual de Mario.
     * @return Habilidad equipada de Mario.
     */
    public int dimeHabilidad()
    {
        return habilidad;
    }

    /**
     * El efecto de hundimiento de Mario lo provoca este método.
     */
    public void hundete()
    {
        int x=getX(), y=getY();
        int velH=1; // Velocidad a la que se hundirá Mario.

        setLocation(x, y + velH);
    }

    /**
     * El jugador podrá controlar a Mario mediante este método.
     */
    public void muevete()
    {
        int x=getX(), y=getY();

        if(habilidad == 1)
        {
            if(Greenfoot.isKeyDown("left"))
            {
                move(-5);
                dir = 0;
                if(inv==0)
                {
                    setImage("Mario Izq.png");
                }
                else
                {
                    setImage("Mario Inv Izq.png");
                }
            }
            if(Greenfoot.isKeyDown("right"))
            {
                move(5);
                dir = 1;
                if(inv==0)
                {
                    setImage("Mario Der.png");
                }
                else
                {
                    setImage("Mario Inv Der.png");
                }
            }
            if(Greenfoot.isKeyDown("up"))
            {
                y=y-4;
                setLocation(x, y);
                y=y-1;
                setLocation(x, y);
            }
            if(Greenfoot.isKeyDown("down"))
            {
                y=y+4;
                setLocation(x, y);
            }
        }
        else
        {
            if(Greenfoot.isKeyDown("left"))
            {
                move(-3);
                dir = 0;
                if(inv==0)
                {
                    setImage("Mario Izq.png");
                }
                else
                {
                    setImage("Mario Inv Izq.png");
                }
            }
            if(Greenfoot.isKeyDown("right"))
            {
                move(3);
                dir = 1;
                if(inv==0)
                {
                    setImage("Mario Der.png");
                }
                else
                {
                    setImage("Mario Inv Der.png");
                }
            }
            if(Greenfoot.isKeyDown("up"))
            {
                y=y-2;
                setLocation(x, y);
                y=y-1;
                setLocation(x, y);
            }
            if(Greenfoot.isKeyDown("down"))
            {
                y=y+3;
                setLocation(x, y);
            }
        }
    }

    /**
     * Agregará al mundo los disparos de Mario.
     * Permite a Mario disparar cada segundo.
     */
    public void dispara()
    {
        int lapso = 1000; // Tiempo entre cada disparo (milisegundos).
        
        mundo = (Oceano)getWorld();
        
        if(habilidad==2)
        {
            lapso=450;
        }

        if(Greenfoot.isKeyDown("a") && tDisparo.millisElapsed() > lapso)
        {
            if(dir==0)
            {
                mundo.agregaDispMIzq();
            }
            else if(dir==1)
            {
                mundo.agregaDispMDer();
            }
            tDisparo.mark();
        }
    }

    /**
     * Hace a Mario invencible e inicia su temporizador.
     */
    public void activaInvencible()
    {
        inv = 1;
        if(dir==0)
        {
            setImage("Mario Inv Izq.png");
        }
        else
        {
            setImage("Mario Inv Der.png");
        }
        tInv.mark();
    }

    /**
     * Desactiva la inmunidad de Mario cuando pase el tiempo determinado.
     * Cambia su imagen para indicárselo al jugador.
     */
    public void agotaInvencible()
    {
        int tiempo=4000; // Tiempo que durará la inmunidad de Mario (en milésimas de segundo).

        if (tInv.millisElapsed()>tiempo)
        {
            inv = 0;
            if(dir==0)
            {
                setImage("Mario Izq.png");
            }
            else
            {
                setImage("Mario Der.png");
            }
        }
    }
    
    /**
     * Vigila si Mario ha obtenido una bonificación.
     */
    public void contactoConBonif()
    {
        if(this.isTouching(Bonificacion.class))
        {
            if(this.isTouching(Vida.class))
            {
                vidas++;
            }
            if(this.isTouching(MovRapido.class))
            {
                habilidad=1;
            }
            if(this.isTouching(DispRapido.class))
            {
                habilidad=2;
            }
            if(this.isTouching(DispPlus.class))
            {
                habilidad=3;
            }
            removeTouching(Bonificacion.class);
        }
    }

    /**
     * Vigila si un enemigo ha tocado a Mario, le quita una vida y lo regresa a su punto de partida.
     * Solo se llamará si Mario no es invencible actualmente.
     */
    public void contactoConEnemigo()
    {
        mundo=(Oceano)getWorld();

        if(this.isTouching(Enemigo.class) || this.isTouching(DispEnemigo.class))
        {
            setLocation(70,70);
            habilidad=0;
            activaInvencible();
            vidas--;
            if(vidas<0)
            {
                mundo.juegoPerdido();
            }
        }
    }

    public void contactoConFondo()
    {
        mundo=(Oceano)getWorld();

        if(this.getY() >= mundo.ALTM-1)
        {
            setLocation(70,70);
            habilidad=0;
            activaInvencible();
            vidas--;
            if(vidas<0)
            {
                mundo.juegoPerdido();
            }
        }
    }
}
