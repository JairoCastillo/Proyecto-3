/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Pa extends JPanel implements KeyListener{
    //Definimos coordenadas
    Dat der = new Dat(30,0);    
    Dat izq = new Dat(-30,0);    
    //movimiento nulo cuando soltemos la tecla
    Dat no = new Dat(0,0);    
    
    
    ArrayList op;
    DibujaNave nave ;
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
                 Thread.sleep(50);
             }catch(InterruptedException e){System.out.println(e);}
            repaint();
        }
     }
}