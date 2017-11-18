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
import static naves.Naves.Ranmdom;


/**
 *
 * @author Usuario
 */
public class Pa extends JPanel implements KeyListener{
    ArrayList op;
    DibujaNave nave ;
    //Definimos coordenadas
    Dat der = new Dat(30,0);    
    Dat izq = new Dat(-30,0);    
    //movimiento nulo cuando soltemos la tecla
    Dat no = new Dat(0,0);    
    
    //creamos los asteroides
    DibujarAsteroide asteroide1;
    DibujarAsteroide asteroide2;
    DibujarAsteroide asteroide3;
    DibujarAsteroide asteroide4;
    DibujarAsteroide asteroide5;
   
    public Pa (ArrayList y){
        this.op = y;
        //escuchador para recibir entradas desde el panel
        this.addKeyListener(this);
        setFocusable(true);
    }

public void paint (Graphics g){
    //creamos un objeto para dibujar mientras recorre el array y que toma parametros
    //pedimos la dimension de nuestra grafica
    Dimension d= getSize();
    Image Imagen = createImage(d.width,d.height);
    //creamos un grafico auxiliar
    Graphics aux=Imagen.getGraphics();
    
    Tabla dib;
    for(int i=0;i<op.size();i++){
        dib=(Tabla)op.get(i);
        dib.dibujar(aux);
    }
    g.drawImage(Imagen,0,0,null);
}    

//metodo para recibir graphics

public void update(Graphics q){
    paint(q);
}


    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int boton = e.getKeyCode();
         //condiciones de movimiento por teclas
         if(boton == KeyEvent.VK_RIGHT){
             this.nave.mover(der);
         
         }
         if(boton == KeyEvent.VK_LEFT){
             this.nave.mover(izq);
         }
         //accion para disparar 
         if(boton == KeyEvent.VK_X){
             DibujarDiparos balas = nave.Bala();
             nave.bal.add(balas);
             op.add(balas);
         }
    }
    
   
    @Override
    public void keyReleased(KeyEvent e) {
          int boton = e.getKeyCode();
         //condiciones de movimiento por teclas
         if(boton == KeyEvent.VK_RIGHT){
             this.nave.mover(no);
        
         }
         if(boton == KeyEvent.VK_LEFT){
             this.nave.mover(no);
         }
    
    }   //asignamos por parametros los asteroides
     public void lAste(DibujarAsteroide a,DibujarAsteroide b,DibujarAsteroide c,DibujarAsteroide d,DibujarAsteroide e){
          asteroide1= a;
          asteroide2= b;
          asteroide3= c;
          asteroide4= d;
          asteroide5= e;
   }
    
     public void  lNave(DibujaNave q){
        this.nave = q;
    } 
    
     //metodo para iniciar el juego
     public void inicio(){
         while(true){
             
             try{
                 if(!nave.bal.isEmpty()){
                     nave.Movim();
                     //metodo para mover la bala por todo el panel
                 }
                 //metodo para capturar la coordenada y sumarla
                 asteroide1.Movim();
                 asteroide2.Movim();
                 asteroide3.Movim();
                 asteroide4.Movim();
                 asteroide5.Movim();
                   //creamos un condicional para q cuando lleguen a una coordenada limite este vuelva a inicio
                 if(asteroide1.getY()>500){
                     int a = Ranmdom(800,50);
                     asteroide1.setY(0);
                     asteroide1.setX(a);
                 }
                 if(asteroide2.getY()>500){
                     int a = Ranmdom(800,50);
                     asteroide2.setY(0);
                     asteroide2.setX(a);
                 }
                 if(asteroide3.getY()>500){
                     int a = Ranmdom(800,50);
                     asteroide3.setY(0);
                     asteroide3.setX(a);
                 }
                 if(asteroide4.getY()>500){
                     int a = Ranmdom(800,50);
                     asteroide4.setY(0);
                     asteroide4.setX(a);
                 }
                 if(asteroide5.getY()>500){
                     int a = Ranmdom(800,50);
                     asteroide5.setY(0);
                     asteroide5.setX(a);
                 }
                 Thread.sleep(50);
             }catch(InterruptedException e){System.out.println(e);}
            repaint();
        }
     }
}