/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Informacion.*;
/**
 *
 * @author Usuario
 */
public class Asteroides extends Dat {
  private float l1;
  private float l2;

public Asteroides(){
  //toma un constructor sin atributos del padre
    super();
    this.l1=0;
    this.l2=0;
}

public Asteroides(Dat coor,float x,float y){
    //toma el contructor de las coordenadas
    super(coor);
 
    this.l1=x;
    this.l2=y;
}

public Asteroides(Asteroides nueva){
    super(nueva.getX(),nueva.getY());
    this.l1=nueva.l1;
    this.l2=nueva.l2;
}
//retoramos los lados de la figura creada
public float GetLa(int la){
    if(la==1){
        return this.l1;
    }
    if(la==2){
        return this.l2;
    }
    if (la!=1 && la!=2){
        return 0;
    }
    return 0;
}
}