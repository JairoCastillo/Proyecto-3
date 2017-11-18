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
    
    
    ArrayList x;
    DibujaNave nave ;
    public Pa (ArrayList y){
        this.x = y;
        //escuchador para recibir entradas desde el panel
        this.addKeyListener(this);
        setFocusable(true);
    }

public void paint (Graphics g){
    //creamos un objeto para dibujar mientras recorre el array y que toma parametros
    Tabla di;
    for(int i=0;i<x.size();i++){
        di=(Tabla)x.get(i);
        di.dibujar(g);
    }
}    

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int boton = e.getKeyCode();
         //condiciones de movimiento por teclas
         if(boton == KeyEvent.VK_RIGHT){
             this.nave.paint(this.getGraphics(), Color.white);
             this.nave.paint(this.getGraphics(), Color.black);
             this.nave.mover(der);
         
         }
         if(boton == KeyEvent.VK_LEFT){
             //pintar al mover la nave
             this.nave.paint(this.getGraphics(), Color.white);
             this.nave.paint(this.getGraphics(), Color.black);
             this.nave.mover(izq);
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
    
}
