import greenfoot.*;

/**
 * Disparo perteneciente a Mario, se moverá hacia a la derecha.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class DispMDer extends DispMario
{
    private Oceano mundo;

    public void act() 
    {
        muevete();
        eliminaObstaculos();
        checaOrilla();
    }    

    /**
     * Realizará el movimiento hacia la derecha del disparo.
     */
    public void muevete()
    {
        mundo = (Oceano)getWorld();
        if(mundo.dimeHabMario()==3)
            setImage("Disparo Rojo.png");
        if(mundo.dimeHabMario()==2)
        {
            setImage("Disparo Azul.png");
            setLocation(getX()+7, getY());
        }
        else
        {
            setLocation(getX()+4, getY());
        }
    }

    /**
     * Quitará el disparo cuando éste haya alcanzado la orilla del mundo.
     */
    public void checaOrilla()
    {
        mundo = (Oceano)getWorld();

        if(this.isAtEdge())
        {
            mundo.removeObject(this);
        }
    }

    public void eliminaObstaculos()
    {
        mundo=(Oceano)getWorld();

        if(mundo.dimeHabMario()==3)
        {
            if(this.isTouching(Mina.class))
            {
                removeTouching(Mina.class);
            }
            if(this.isTouching(DispEnemigo.class))
            {
                removeTouching(DispEnemigo.class);
            }
        }
    }
}
