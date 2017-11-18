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

/**
 *
 * @author Usuario
 */
public class Naves  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Ventana ventanita = new Ventana ("Space");
      
      // Arreglo para el panel
      ArrayList arreglodat = new ArrayList ();
      //asteroide 
      Dat coor1= new Dat(400,250);
      DibujarAsteroide aste= new DibujarAsteroide (coor1,50,50,Color.GREEN);
      //disparo
      Dat coor2= new Dat(180,140);
      DibujarDiparos dispa= new DibujarDiparos(coor2, 50, Color.yellow);
      
      // nave
      Dat coor3= new Dat(475,500);
      Dat coor4= new Dat(425,575);
      Dat coor5= new Dat(575,525);
      DibujaNave nave = new DibujaNave(coor3,coor4,coor5,Color.RED);
      
      
       arreglodat.add(dispa);
       arreglodat.add(aste);
       arreglodat.add(nave);
     
       Pa p = new Pa (arreglodat);
       p.lNave(nave);
       //propiedades de la ventana 
       ventanita.add(p);
       ventanita.setSize(800,600);
       ventanita.setVisible(true);
       p.inicio();
    }
    
}