/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Informacion;

/**
 *
 * @author Usuario
 */
import naves.*;
import Interfaz.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class textos implements Tabla{
    String s;
    Color c;
    int anchoP;
    int altoP;
    int size;

    public textos(String hola, Color unColor, int a, int h) {
        this.s = hola;
        this.c = unColor;
        this.size = 10;
        this.anchoP = a;
        this.altoP = h;
    }

    public void Borrartextos(Graphics g,String txt)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Algerian", Font.PLAIN, this.getSize()));
        int ancho = (int)g.getFontMetrics().getStringBounds(txt, g).getWidth();
        int alto = (int)g.getFontMetrics().getAscent();
        int x = this.anchoP/2 - ancho/2;
        int y = this.altoP/2 + alto/4;        
        g.drawString(txt, x, y);
    }
            //fuente de letas etc.
    public void Pintartexto(Graphics g,String txt)
    {
        g.setColor(Color.BLUE);
        g.setFont(new Font("Algerian", Font.PLAIN, this.getSize()));
        int ancho = (int)g.getFontMetrics().getStringBounds(txt, g).getWidth();
        int alto = (int)g.getFontMetrics().getAscent();
        int x = this.anchoP/2 - ancho/2;
        int y = this.altoP/2 + alto/4;        
        g.drawString(txt, x, y);
    }
    
    @Override
    public void dibujar(Graphics g){
        g.setColor(c);
        g.setFont(new Font("Monospaced", Font.PLAIN, this.getSize()));
        int ancho = (int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        int alto = (int)g.getFontMetrics().getAscent();
        int x = this.anchoP/2 - ancho/2;
        int y = this.altoP/2 + alto/4;        
        g.drawString(s, x, y);
    }
    
    public void setSize(int nuevoSize){
        size = nuevoSize;
    }
    
    public int getSize(){
        return size;
    }  
}
