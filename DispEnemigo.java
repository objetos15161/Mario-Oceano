import greenfoot.*;

/**
 * Clase para el disparo de los submarinos.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */
public class DispEnemigo extends Disparo
{
    private Oceano mundo;
    SimpleTimer aux = new SimpleTimer(); // Temporizador auxiliar para el método encuentraAMario().
    
    public void act() 
    {
        encuentraAMario();
        verificaOrilla();
        muevete();
    }    
    
    /**
     * Retira del mundo a este objeto una vez que ha alcanzado el borde del mundo.
     */
    public void verificaOrilla()
    {
        mundo=(Oceano)getWorld();
        
        if(this.isAtEdge())
        {
            mundo.removeObject(this);
        }
    }
    
    /**
     * Realiza el movimiento del disparo.
     */
    public void muevete()
    {
        move(2);
    }
    
    /**
     * Gira a este objeto para que vea hacia las coordenadas actuales de Mario.
     * Se hace uso del temporizador 'aux' para que este objeto no gire continuamente y solo lo haga al entrar al mundo.
     */
    public void encuentraAMario()
    {
        mundo=(Oceano)getWorld();
        
        if(aux.millisElapsed() < 50)
        {
            turnTowards(mundo.dimeXMario(), mundo.dimeYMario());
        }
    }
}
