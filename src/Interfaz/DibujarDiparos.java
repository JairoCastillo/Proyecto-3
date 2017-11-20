/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Informacion.*;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
public class DibujarDiparos extends Disparos implements Tabla{
 
    Color color;

public DibujarDiparos(Dat c,float radio, Color xcolor){
    super(c,radio);
    this.color = xcolor;
}
    
 @Override
    public void dibujar(Graphics z) {
        z.setColor(color);
        z.drawOval((int)(this.getX()-this.getRadio()),(int)(this.getY()-this.getRadio()),(int)(2*this.getRadio()),(int)(2*this.getRadio()));
    }

    void pintar(Color a) {
        this.color = a;
    }

  
}
