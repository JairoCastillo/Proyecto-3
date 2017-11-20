/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Informacion.*;
import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.Color;
import Interfaz.*;
/**
 *
 * @author Usuario
 */
public class DibujaNave extends ConsNave implements Tabla{
//objeto con color
  Color color;
  
 //coordenadas de la clase Dat 
public DibujaNave(Dat a,Dat b,Dat c,Color xcolor){
    super(a,b,c);
    this.color = xcolor;
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
        z.fillPolygon(p);
    
    }
    //creamos una nueva nave pero esta la pintamos para el movimiento sin rastro
    public void paint(Graphics z,Color xcolor) {
   
    z.setColor(xcolor);
    int x[] = {(int)this.getX(),(int)this.c1.getX(),(int)this.c2.getX()};    
    int y[] = {(int)this.getY(),(int)this.c1.getY(),(int)this.c2.getY()};    
        
    Polygon p = new Polygon(x,y,3);
   
    z.fillPolygon(p);
   
    }
    
    public DibujarDiparos Bala(){
        //aqui le asignamos las coordenas de donde inicia el objeto bala, en este caso inicia en la punta del triangulo
        Dat sal = new Dat(this.getX(),this.getY());
        DibujarDiparos bal = new DibujarDiparos(sal,60,Color.GREEN);
        return bal;
    }
    
    //metodo para el
    public void Movim(){
        for(int i=0;i<this.bal.size();i++){
            //casteamos los atos a la clase
            DibujarDiparos y = (DibujarDiparos)this.bal.get(i);
            //movimiento de la bala
            float x= y.getY();
            y.setY(x-= 6);
        }
    }
}