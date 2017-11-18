/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Pa extends JPanel {
    
    ArrayList x;
    
    public Pa (ArrayList y){
        this.x = y;
    }

public void paint (Graphics g){
    //creamos un objeto para dibujar mientras recorre el array y que toma parametros
    Tabla di;
    for(int i=0;i<x.size();i++){
        di=(Tabla)x.get(i);
        di.dibujar(g);
    }
}    
    
    
    
}
