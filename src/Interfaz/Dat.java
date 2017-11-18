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
// esta clase sera la padre ya que las figuras heredaran sus coordenadas
public class Dat {
    private float x;
    private float y;
    
    public Dat(){
        this.x=0;
        this.y=0;
    }
    public Dat(float x, float y){
        this.x = x;
        this.y =y;
    }
    
    public Dat(Dat nueva){
        this.x = nueva.x;
        this.y = nueva.y;
    }
    
    public float getX(){
        return this.x;
    }
    
    public float getY(){
        return this.y;
    }
  
    public void setX(float x){
       this.x= x;
    }
    
    public void setY(float y){
       this.y= y;
    }
    
    //metodo suma para la clase Consnave
     public Dat suma(Dat e){
      float sx = this.x+e.getX();
      float sy =this.y+e.getY();
      
      //guardamos los metodos
      
      Dat s= new Dat(sx,sy);
      
      return s;
    }
}