import greenfoot.*;

/**
 * Clase Oceano, subclase de World, el juego se llevará a cabo en un mundo de esta clase.
 * 
 * @author Ulises Lara, Efrén Macías
 * @version 30/Nov/2015
 */

public class Oceano extends World
{
    public static final int ALTM = 600; // Altura del mundo.
    public static final int ANCM = 900; // Ancho del mundo.
    
    private SimpleTimer tMC = new SimpleTimer(); // Temporizador para las minas y cajas que caerán en el método sueltaMC().
    
    private Counter contVidas = new Counter("Vidas: ");
    private Counter contNivel = new Counter("Nivel: ");
    private Counter contEne = new Counter("Por vencer: ");
    
    private int nivel; // Nivel actual del mundo.
    
    private Mario mario = new Mario();
    private int eneVencidos; // Cuántos enemigos han sido destruidos en el nivel actual.
    private int eneAVencer; // Cantidad de enemigos que se deben vencer para completar el nivel actual.

    /**
     * Constructor de la clase Oceano.
     * 
     */
    public Oceano()
    {    
        super(ANCM, ALTM, 1); // Crea el mundo de la altura y ancho determinados en sus respectivas constantes ALTM y ANCM.
        Greenfoot.setWorld(new Menu()); // Despliega el menú en pantalla.
        construyeNivel1();
    }
    
    public void act()
    {
        sueltaMC();
        actualizaContadores();
    }
    
    /**
     * Hará que se muestren los objetos que componen el primer nivel.
     * En el primer nivel existirán en todo momento dos tiburones y dos submarinos menores.
     * Para superar el primer nivel habrá que vencer a ocho enemigos cualesquiera.
     */
    public void construyeNivel1()
    {
        Tiburon tiburonA=new Tiburon(), tiburonB=new Tiburon();
        SubMenor subMenorA=new SubMenor();
        
        setBackground("Fondo Nivel 1.jpg");
        nivel=1;
        eneAVencer=6;
        addObject(contVidas, ANCM/3, 20);
        addObject(contNivel, ANCM/2-15, 20);
        addObject(contEne, ANCM-(ANCM/3), 20);
        addObject(mario, 70, 70);
        mario.activaInvencible();
        addObject(tiburonA, 15, ALTM-50);
        addObject(tiburonB, ANCM/2, ALTM-20);
        addObject(subMenorA, ANCM-10, 20);
        Greenfoot.delay(40);
    }
    
    /**
     * Hará que se muestren los objetos que componen el segundo nivel.
     * En este nivel existirán dos tiburones, tres submarinos menores y un submarino mayor.
     * Para superar el primer nivel habrá que vencer a quince enemigos.
     */
    public void construyeNivel2()
    {
        Tiburon tiburonA=new Tiburon(), tiburonB=new Tiburon(), tiburonC=new Tiburon();
        SubMenor subMenor=new SubMenor();
        SubMayor subMayor=new SubMayor();
        
        setBackground("Fondo Nivel 2.jpg");
        nivel=2;
        eneAVencer=16;
        addObject(contVidas, ANCM/3, 20);
        addObject(contNivel, ANCM/2-15, 20);
        addObject(contEne, ANCM-(ANCM/3), 20);
        addObject(mario, 70, 70);
        mario.activaInvencible();
        addObject(tiburonA, ANCM-10, 15);
        addObject(tiburonB, (ANCM/3)*2, ALTM-15);
        addObject(tiburonC, ANCM-10, ALTM-15);
        addObject(subMenor, ANCM/2, ALTM-15);
        addObject(subMayor, ANCM-10, (ALTM/3)*2);
    }
    
    /**
     * Hará que se muestren los objetos que componen el tercer nivel.
     * En este nivel existirán tres tiburones, tres submarinos menores y dos submarinos mayores.
     * Para superar el primer nivel habrá que vencer a veinte enemigos.
     */
    public void construyeNivel3()
    {
        Tiburon tiburonA=new Tiburon(), tiburonB=new Tiburon(), tiburonC=new Tiburon();
        SubMenor subMenorA=new SubMenor(), subMenorB=new SubMenor();
        SubMayor subMayor=new SubMayor();
        
        setBackground("Fondo Nivel 3.jpg");
        nivel=3;
        eneAVencer=31;
        addObject(contVidas, ANCM/3, 20);
        addObject(contNivel, ANCM/2-15, 20);
        addObject(contEne, ANCM-(ANCM/3), 20);
        addObject(mario, 70, 70);
        mario.activaInvencible();
        addObject(tiburonA, ANCM-10, 15);
        addObject(tiburonB, (ANCM/3)*2, ALTM-15);
        addObject(tiburonC, ANCM/3, ALTM-30);
        addObject(subMenorA, ANCM/2, ALTM-15);
        addObject(subMenorB, 150, ALTM-20);
        addObject(subMayor, ANCM-10, (ALTM/3)*2);
    }
    
    /**
     * Elimina todos los objetos de la pantalla y muestra la imagen de Juego Perdido.
     */
    public void juegoPerdido()
    {
        removeObjects(getObjects(null));
        Greenfoot.setWorld(new GameOver());
    }
    
    /**
     * Mantendrá al corriente los tres contadores del mundo (vidas, nivel actual y enemigos a vencer).
     */
    public void actualizaContadores()
    {
        contVidas.setValue(mario.dimeVidas());
        contNivel.setValue(nivel);
        contEne.setValue(eneAVencer-eneVencidos);
    }
    
    /**
     * Se llamará cada que Mario dispare y esté mirando hacia la izquierda.
     * Agregará un objeto disparo en las coordenadas de Mario.
     */
    public void agregaDispMIzq()
    {
        addObject(new DispMIzq(), mario.dimeX(), mario.dimeY());
    }
    
    /**
     * Se llamará cada que Mario dispare y esté mirando hacia la derecha.
     * Agregará un objeto disparo en las coordenadas de Mario.
     */
    public void agregaDispMDer()
    {
        addObject(new DispMDer(), mario.dimeX(), mario.dimeY());
    }
    
    /**
     * Método para obtener acceso a la ubicación en 'x' de Mario.
     */
    public int dimeXMario()
    {
        return mario.dimeX();
    }
    
    /**
     * Método para obtener acceso a la ubicación en 'y' de Mario.
     */
    public int dimeYMario()
    {
        return mario.dimeY();
    }
    
    /**
     * Método para obtener acceso a la habilidad actual de Mario.
     */
    public int dimeHabMario()
    {
        return mario.dimeHabilidad();
    }
    
    /**
     * Incrementa el contador de enemigos vencidos y verifica si el jugador ha superado el nivel actual (o ganado el juego).
     * Será llamado cada que el jugador elimine a un enemigo.
     */
    public int enemigoVencido()
    {
        int res=0;
        
        eneVencidos++;
        if(eneVencidos > eneAVencer)
        {
            res=1;
            if(eneVencidos>=6 && eneVencidos<=15)
            {
                removeObjects(getObjects(null));
                construyeNivel2();
            }
            if(eneVencidos>=16 && eneVencidos<=30)
            {
                removeObjects(getObjects(null));
                construyeNivel3();
            }
            if(eneVencidos >= 31)
            {
                removeObjects(getObjects(null));
                Greenfoot.setWorld(new Ganador());
            }
        }
        return res;
    }
    
     /**
     * Se crearán de forma aleatoria minas y cajas de bonificación en la parte superior de la pantalla.
     * Tendrán un valor en 'y' de cero y un valor en 'x' generado aletoriamente.
     * Se creará una de ellas cada que pasen cuatro segundos.
     */
    public void sueltaMC()
    {        
        int sorteoBonif=Greenfoot.getRandomNumber(10); // En caso de que el objeto a caer no sea una mina, esta variable determinará qué bonificación producir.
        
        if(tMC.millisElapsed()>=3500)
        {
            if(Greenfoot.getRandomNumber(2)==0)
                addObject(new Mina(), 50+Greenfoot.getRandomNumber(ANCM-100), 0);
            else
            {
                if(sorteoBonif==0)
                    addObject(new Vida(), 50+Greenfoot.getRandomNumber(ANCM-100), 0);
                else if(sorteoBonif>=1 && sorteoBonif<=3)
                    addObject(new MovRapido(), 50+Greenfoot.getRandomNumber(ANCM-100), 0);
                    else if(sorteoBonif>=4 && sorteoBonif<=6)
                        addObject(new DispRapido(), 50+Greenfoot.getRandomNumber(ANCM-100), 0);
                        else
                            addObject(new DispPlus(), 50+Greenfoot.getRandomNumber(ANCM-100), 0);
            }
            tMC.mark();
        }
    }
}
