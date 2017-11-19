/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naves;

import Interfaz.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import Informacion.*;
/**
 *
 * @author Usuario
 */
public class Naves  {
    // en esta funcion enviamos un rango y nos da un numero entre ese rango
    public static int Ranmdom(int max,int min){
        return(int)(Math.random()*(max-min));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Ventana ventanita = new Ventana ("Gala Gala");
      
      // Arreglo para el panel
      ArrayList arreglodat = new ArrayList ();
      //asteroide 
      /*Dat coor1= new Dat(400,250);
      DibujarAsteroide aste= new DibujarAsteroide (coor1,50,50,Color.GREEN);
      */
      //disparo
      Dat coor2= new Dat(400,250);
      DibujarDiparos dispa= new DibujarDiparos(coor2,26, Color.BLUE);
      
      // nave
      Dat coor3= new Dat(412,500);
      Dat coor4= new Dat(425,575);
      Dat coor5= new Dat(575,525);
      DibujaNave nave = new DibujaNave(coor3,coor4,coor5,Color.RED);
      
       //arreglodat.add(dispa);
       //arreglodat.add(aste);
       arreglodat.add(nave);
       //datos del texto
       textos vida = new textos("Vidas",Color.BLACK,1600,300);
       vida.setSize(23);
       arreglodat.add(vida);
       
       textos cont = new textos ("3",Color.BLACK,1600,400);
       cont.setSize(23);
       arreglodat.add(cont);
       
       
       textos puntos = new textos("Puntos",Color.BLACK,1600,90);
       puntos.setSize(23);
       arreglodat.add(puntos);
       
       textos acum = new textos ("0",Color.BLACK,1600,160);
       acum.setSize(23);
       arreglodat.add(acum);
       
       
       
      
       //creacion de asteroides 
       int rang1 = Ranmdom(700,50);
       Dat s1 = new Dat (rang1,-25);
       DibujarAsteroide asteroide1 = new DibujarAsteroide(s1,25,25,Color.black); 
       int rang2 = Ranmdom(700,50);
       Dat s2 = new Dat (rang2,0);
       DibujarAsteroide asteroide2 = new DibujarAsteroide(s2,25,25,Color.orange); 
       int rang3 = Ranmdom(700,50);
       Dat s3 = new Dat (rang3,0);
       DibujarAsteroide asteroide3 = new DibujarAsteroide(s3,25,25,Color.black); 
       int rang4 = Ranmdom(700,50);
       Dat s4 = new Dat (rang4,0);
       DibujarAsteroide asteroide4 = new DibujarAsteroide(s4,25,25,Color.orange); 
       int rang5 = Ranmdom(700,50);
       Dat s5 = new Dat (rang5,0);
       DibujarAsteroide asteroide5 = new DibujarAsteroide(s5,25,25,Color.black); 

       arreglodat.add(asteroide1);
       arreglodat.add(asteroide2);
       arreglodat.add(asteroide3);
       arreglodat.add(asteroide4);
       arreglodat.add(asteroide5);
       
       Pa p = new Pa (arreglodat);
       p.lNave(nave);
       p.lAste(asteroide1,asteroide2,asteroide3,asteroide4,asteroide5);
       //propiedades de la ventana 
       ventanita.add(p);
       ventanita.setSize(900,600);
       ventanita.setVisible(true);
       p.inicio();
    }
    
}
