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
public class HDis extends Disparos implements Tabla {
 
    Color co;

public HDis(Dat coor,float radio, Color uncolor){
 super(coor,radio);
 this.co = uncolor;
}
    
 @Override
    public void dibujar(Graphics z) {
        //coordenadas para dibujar un circulo
        z.setColor(co);
        z.fillOval((int)(this.getX()-this.getRadio()),(int)(this.getY()-this.getRadio()),(int)(2*this.getRadio()),(int)(2*this.getRadio()));
    }
}