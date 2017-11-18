/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class DibujaNave extends ConsNave implements Tabla{
//objeto con color
  Color color;
  
 //coordenadas de la clase Dat 
public DibujaNave(Dat a,Dat b,Dat c,Color uncolor){
    super(a,b,c);
    this.color = uncolor;
}

    @Override
    public void dibujar(Graphics z) {
    //creacion de la nave con las coordenadas
    //creamos un arreglo que tenga todas las coordenadas de X y otra con las de Y
    //casteamos los valores para que sean enteros
    z.setColor(color);
    int x[] = {(int)this.getX(),(int)this.c1.getX(),(int)this.c2.getX()};    
    int y[] = {(int)this.getY(),(int)this.c1.getY(),(int)this.c2.getY()};    
        
    
    //creacion la figura para la nave
    //le damos los dos arreglos y el numero de vertices que tendra la figura
        Polygon p = new Polygon(x,y,3);
        //dibujamos la figura
        z.fillPolygon(p);
    
    }
    //creamos una nueva nave pero esta la pintamos para el movimiento sin rastro
    public void paint(Graphics z, Color uncolor) {
    z.setColor(uncolor);
    int x[] = {(int)this.getX(),(int)this.c1.getX(),(int)this.c2.getX()};    
    int y[] = {(int)this.getY(),(int)this.c1.getY(),(int)this.c2.getY()};    
        
        Polygon p = new Polygon(x,y,3);
        z.fillPolygon(p);
    
    }

}
