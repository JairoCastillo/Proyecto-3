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
public class Dat {
    float x;
    float y;
    
    public Dat(){
        this.x=0;
        this.y=0;
    }
    public Dat(float x, float y){
        this.x = x;
        this.y =y;
    }
    
    public Dat(Dat q){
        this.x = q.x;
        this.y = q.y;
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

}