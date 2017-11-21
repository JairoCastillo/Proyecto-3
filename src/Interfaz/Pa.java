/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Informacion.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import static naves.Principal.Ranmdom;

/**
 *
 * @author Usuario
 */
/*
creamos un arraya para guardar todos los asteroides
Definimos coordenadas y movimiento nulo cuando soltemos la tecla
contador para restar los asteroides por si se presentan colisiones
      
*/

public class Pa extends JPanel implements KeyListener {
    Dat der = new Dat(25, 0);
    Dat izq = new Dat(-25, 0);
    Dat no = new Dat(0, 0);
    ArrayList op;
    ArrayList asteroides = new ArrayList();
    DibujaNave nave;
    Boolean FinDeJuego = true;
    int contAsteroides = 5;
    int score;
    int life = 3;
    int Mov = 10;
    int MAXAST = 5;

    textos puntos;
    textos Vidas;
    textos Final;
    /*
     escuchador para recibir entradas desde el panel
    */
   
    public Pa(ArrayList y) {
        
        this.op = y;
        this.addKeyListener(this);
        setFocusable(true);
    }
    /*  
    creamos un objeto para dibujar mientras recorre el array y que toma parametros
    pedimos la dimension de nuestra grafica
     creamos un grafico auxiliar llamdo buff
     */
     public void paint(Graphics g) {
        Dimension d = getSize();
        Image Imagen = createImage(d.width, d.height);
        Graphics buff = Imagen.getGraphics();
        Tabla dib;

        for (int i = 0; i < op.size(); i++) {
            dib = (Tabla) op.get(i);
            dib.dibujar(buff);
        }
        g.drawImage(Imagen, 0, 0, null);
    }

//metodo para recibir graphics para llamar
    @Override
    public void update(Graphics q) {
        paint(q);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
      /*
        metodo para recibir la nave
    */
      
    public void lNave(DibujaNave q) {
        this.nave = q;
    }

    /*
    metodo para asignar por parametros los asteroides
    */
    public void lAste(DibujarAsteroide a, DibujarAsteroide b, DibujarAsteroide c, DibujarAsteroide d, DibujarAsteroide e) {
        asteroides.add(a);
        asteroides.add(b);
        asteroides.add(c);
        asteroides.add(d);
        asteroides.add(e);

    }

    /*
    Puntos dinamicos
    */
    public void RefPuntos(textos a) {
        this.puntos = a;
    }
    
    /*
        Vidas dinamicos
    */

    public void RefVidas(textos b) {
        this.Vidas = b;
    }

    public void ReFinal(textos c) {
        this.Final = c;
    }

     public ArrayList getOp() {
        return op;
    }
       /*
        metodo del array de objetos
    */
  
    public void setOp(ArrayList op) {
        this.op = op;
    }

    public ArrayList getAsteroides() {
        return asteroides;
    }
      /*
        asteroides
    */
  
    
    public void setAsteroides(ArrayList asteroides) {
        this.asteroides = asteroides;
    }

    public DibujaNave getNave() {
        return nave;
    }
          /*
            Dibuja la nave
    */
  
    public void setNave(DibujaNave nave) {
        this.nave = nave;
    }

    public Boolean getFinDeJuego() {
        return FinDeJuego;
    }
      /*
        finalizar
    */
  
    public void setFinDeJuego(Boolean FinDeJuego) {
        this.FinDeJuego = FinDeJuego;
    }

    public int getContAsteroides() {
        return contAsteroides;
    }
     /*
        asteroides
    */
  
    public void setContAsteroides(int contAsteroides) {
        this.contAsteroides = contAsteroides;
    }

    public int getScore() {
        return score;
    }
    /*
       recibe puntuacion
    */
  
    public void setScore(int score) {
        this.score = score;
    }

    public int getLife() {
        return life;
    }
      /*
            vidas que restan
    */
  
    public void setLife(int life) {
        this.life = life;
    }

    public int getMov() {
        return Mov;
    }
      /*
            movimiento
    */
  
    public void setMov(int Mov) {
        this.Mov = Mov;
    }

    public int getMAXAST() {
        return MAXAST;
    }
      /*
            recibe los metioritos
    */
  
    public void setMAXAST(int MAXAST) {
        this.MAXAST = MAXAST;
    }

    public textos getPuntos() {
        return puntos;
    }
    /*
        recibe puntos
    */
    public void setPuntos(textos puntos) {
        this.puntos = puntos;
    }
      /*
        retorna la variable vidas
    */
  
    public textos getVidas() {
        return Vidas;
    }
      /*
        vidas
    */
  
    public void setVidas(textos Vidas) {
        this.Vidas = Vidas;
    }

    public textos getFinal() {
        return Final;
    }
      /*
  
    */
  
    public void setFinal(textos Final) {
        this.Final = Final;
    }
    /*
    Ordenes por teclado
    */
    @Override
    public void keyPressed(KeyEvent e) {
        int boton = e.getKeyCode();
        //condiciones de movimiento por teclas
        if (boton == KeyEvent.VK_LEFT) {
            getNave().mover(izq);
            System.out.println("<--");
            hilo h = new hilo(this);
            h.run();  
        }
        if (boton == KeyEvent.VK_RIGHT) {
            getNave().mover(der);
            System.out.println("-->");
            hilo h = new hilo(this);
            h.run(); 
        }
        if (boton == KeyEvent.VK_X) {
            DibujarDiparos balas = getNave().Bala();
            getNave().bal.add(balas);
            System.out.println("X");
            getOp().add(balas);
            hilo h = new hilo(this);
            h.run(); 
        }
    }
    /*condiciones de movimiento por teclas
      */
    @Override
    public void keyReleased(KeyEvent e) {
        int boton = e.getKeyCode();
       if (boton == KeyEvent.VK_RIGHT) {
            getNave().mover(no);

        }
        if (boton == KeyEvent.VK_LEFT) {
            getNave().mover(no);

        }

    }

    
    
}
