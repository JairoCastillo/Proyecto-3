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
public class Disparos extends Dat{
    private float r;

public Disparos (){
    super();
    this.r=0;
}

public Disparos(Dat q,float ra){
    super(q);
    this.r = r;
}
//copia
public Disparos(Disparos c){
    super(c);
    this.r = c.r;
}
//por si necesitamos el radio del circulo
public float getRadio(){
    return this.r;
}
public void setRadio(float rd){
    this.r= rd;
}

public Dat geC(){
    Dat q = new Dat(this.getX(),getY())  ;
    return q;
}



}
