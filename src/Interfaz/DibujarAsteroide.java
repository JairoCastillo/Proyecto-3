/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
public class DibujarAsteroide extends Asteroides implements Tabla{
    Color c;

    public DibujarAsteroide(Dat coor,float x,float y,Color uncolor){
        super(coor,x,y);
        this.c= uncolor;
}

    
    @Override
    public void dibujar(Graphics z) {
        z.setColor(c);
        //solo con datos enteros
        z.fillRect((int)this.getX(),(int) this.getY(),(int)this.GetLa(1),(int)this.GetLa(2));
    }

}
