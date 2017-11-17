/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

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

public Asteroides(Asteroides q){
    super(q.getX(),q.getY());
    this.l1=q.l1;
    this.l2=q.l2;
}

public float GetLa(int la){
    if(la==1){
        return this.l1;
    }
    if(la==2){
        return this.l2;
    }
    if (la!=0 && la!=1){
        return 0;
    }
    return 0;
}
}