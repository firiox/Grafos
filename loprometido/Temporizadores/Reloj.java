/*
 * Manejo de Temporizadores en Java 
 * Reloj.java
 */

import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.Date;
import java.awt.*;

class Vista extends Canvas {
    
    Color color=Color.red;
    int x,y;
    
    public void paint(Graphics g) {
        if (color ==  null) return;
        g.setColor(color);
        g.fillOval(x*5,y, 50, 50);
    }
    
    public void mostrar(int vx,int vy) {
        this.x=vx; this.y=vy;
        repaint();
    }
}

/**
 * Modelo de reloj utilizando javax.swing.Timer.
 */
public class Reloj 
 {
     /**
      * Lanza un timer cada segundo, avisando a los observadores de este
      * modelo del cambio. 
      */
     public static Timer timer;
     public int px=0;
     static Vista vista = new Vista();

     public Reloj()
     {
         timer = new Timer (1000, new ActionListener ()
         {
             public void actionPerformed(ActionEvent e)
             {
                 vista.mostrar(px++,0);
             }
         });
         
         timer.start();
     }
         
    public static void main(String args[]) {
        Frame f = new Frame();
        f.add(vista);
        f.setSize(200, 220);
        f.setVisible(true);
        Reloj modelo = new Reloj();
        
        for (int i = 0; i < 200; i++) {
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
        f.dispose();
        Reloj.timer.stop();
    }
}

