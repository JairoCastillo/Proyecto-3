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
      Ventana ventanita = new Ventana ("Gala Gala");
      
        // Arreglo para el panel
       ArrayList arreglodat = new ArrayList ();
       //coordenadas posciones
       Dat coor1= new Dat (250,250);
       Dat coor2= new Dat (500,250);
       //graficos 
       DibujarAsteroide h= new DibujarAsteroide(coor1,70,70,Color.BLUE);
       DibujarDiparos j= new DibujarDiparos(coor2,50,Color.BLACK);
      
       //coordenadas para la nave
       Dat coor3= new Dat (475,500);
       Dat coor4= new Dat (425,575);
       Dat coor5= new Dat (525,575);
       
       DibujaNave nave = new DibujaNave(coor3,coor4,coor5,Color.red);
        
       //objetos agrega 
     arreglodat.add(h);
       arreglodat.add(j);
       arreglodat.add(nave); 
       Pa p = new Pa (arreglodat);
       
       p.lNave(nave);
       
       //propiedades de la ventana 
       ventanita.add(p);
       ventanita.setSize(800,600);
       ventanita.setVisible(true);
       
    }
    
}