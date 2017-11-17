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
       // Arreglo para el panel
       ArrayList obj = new ArrayList ();
       //coordenadas posciones
       Dat coor1= new Dat (250,250);
       Dat coor2= new Dat (500,250);
       //graficos 
       HAste h= new HAste(coor1,70,70,Color.BLACK);
       HDis h2= new HDis(coor2,50,Color.BLUE);
      
       //Panel y ventana
       Pa p = new Pa (obj);
       Ventana v= new Ventana ("Gala Gala");
        
       obj.add(h);
       obj.add(h2);
       
     
       //propiedades de la ventana 
       v.add(p);
       v.setSize(800,600);
       v.setVisible(true);
       
    }
    
}