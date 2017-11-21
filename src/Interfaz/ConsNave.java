/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Informacion.*;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ConsNave extends Dat{
    //Creamos un arraylist para las balas
    ArrayList bal = new ArrayList();
    //creamos nuevas coordenadas
    public Dat c1 = new Dat(); //coordenada izquierda
    public Dat c2= new Dat(); //coordenada derecha
    
public ConsNave(){
    super();
    this.c1.setX(0);
    this.c1.setY(0);
    
    this.c2.setX(0);
    this.c2.setY(0);
}
//recibimos las coordenadas 
public ConsNave(Dat a,Dat b,Dat c){
    //enviamos "a" a la clase padre
    super(a.getX(),a.getY());
    
    this.c1.setX(b.getX());
    this.c1.setY(b.getY());
    
    this.c2.setX(c.getX());
    this.c2.setY(c.getY());
}
    //si creamos otra nave por parametro
    //coordenadas de c set y get
    public ConsNave(ConsNave c){
        //coordenadas
        super(c.getX(),c.getY());
        //coordenadas en c1
        this.c1.setX(c.getX());
        this.c1.setY(c.getY());
        //coordenadas en c2
        this.c2.setX(c.getX());
        this.c2.setY(c.getX());
    }
    //modificar los vertices para mover nuestra nave
    public void setVerticesNave(Dat q,int lado){
        //modificamos sus lados
         if(lado==1){
             this.setX(q.getX());
             this.setY(q.getY());
         
         }
         if(lado==2){
             this.c1.setX(q.getX());
             this.c1.setY(q.getY());
         }
         if(lado==3){
             this.c2.setX(q.getX());
             this.c2.setY(q.getY());
         }
    }
    //metodo para mover nuestra nave 
    public void  mover(Dat nuevoDat){
        //llamamos la funcion del vertice
        setVerticesNave((this.suma(nuevoDat)),1);
        setVerticesNave((this.c1.suma(nuevoDat)),2);
        setVerticesNave((this.c2.suma(nuevoDat)),3);
        //creamos un metodo de la suma en la clase Dat
        
    }
    
    
}
