/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import java.awt.event.*;

/**
 *
 * @author Usuario
 */
public class Ventana extends JFrame implements WindowListener{
    
    public Ventana (String superior){
        super(superior);
        setSize(800,600);
        addWindowListener(this);
        setBackground(Color.WHITE);
    }

    @Override
    public void windowOpened(WindowEvent e) {
  
    }

    @Override
    public void windowClosing(WindowEvent e) {
  
    }

    @Override
    public void windowClosed(WindowEvent e) {
       System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {
  
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
  
    }

    @Override
    public void windowActivated(WindowEvent e) {
    
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    
    }
}
