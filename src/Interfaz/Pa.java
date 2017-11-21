/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Informacion.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import static naves.Principal.Ranmdom;
/**
 *
 * @author Usuario
 */
public class Pa extends JPanel implements KeyListener{
    ArrayList op;
    //creamos un arraya para guardar todos los asteroides
    ArrayList asteroides = new ArrayList();
    DibujaNave nave;
    //Definimos coordenadas y movimiento nulo cuando soltemos la tecla
    Dat der = new Dat(25,0);    
    Dat izq = new Dat(-25,0);    
    Dat no = new Dat(0,0);    
    
    //contador para restar los asteroides por si se presentan colisiones
   int contAsteroides = 5; 
   
    textos puntos;
    textos vidas;
    textos gameover;
    public Pa (ArrayList y){
        this.op = y;
        //escuchador para recibir entradas desde el panel
        this.addKeyListener(this);
        setFocusable(true);
    }

public void paint (Graphics g){
    //creamos un objeto para dibujar mientras recorre el array y que toma parametros
    //pedimos la dimension de nuestra grafica
    Dimension d= getSize();
    Image Imagen = createImage(d.width,d.height);
    //creamos un grafico auxiliar llamdo buff
    Graphics buff=Imagen.getGraphics();
    Tabla dib;
    
    for(int i=0;i<op.size();i++){
        dib=(Tabla)op.get(i);
        dib.dibujar(buff);
    }
    g.drawImage(Imagen,0,0,null);
}    


//metodo para recibir graphics para llamar
public void update(Graphics q){
    paint(q);
}

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
         int boton = e.getKeyCode();
         //condiciones de movimiento por teclas
         if(boton == KeyEvent.VK_LEFT){
             this.nave.mover(izq);
             
         }
         if(boton == KeyEvent.VK_RIGHT){
             this.nave.mover(der);
         }
         //accion para disparar 
         if(boton == KeyEvent.VK_X){
             DibujarDiparos balas = nave.Bala();
             nave.bal.add(balas);
             op.add(balas);
         } 
    }
    
   
    @Override
    public void keyReleased(KeyEvent e) {
          int boton = e.getKeyCode();
         //condiciones de movimiento por teclas
         if(boton == KeyEvent.VK_RIGHT){
             this.nave.mover(no);
              
         }
         if(boton == KeyEvent.VK_LEFT){
            this.nave.mover(no);
             
         }
    
    }
     public void lNave(DibujaNave q){
        this.nave = q;
    } 
    

    
    //asignamos por parametros los asteroides
     public void lAste(DibujarAsteroide a,DibujarAsteroide b,DibujarAsteroide c,DibujarAsteroide d,DibujarAsteroide e){
         asteroides.add(a);
         asteroides.add(b); 
         asteroides.add(c); 
         asteroides.add(d); 
         asteroides.add(e); 
  
   }
     
     //vidas dinamicas
     public void lpuntos(textos a){
            this.puntos= a;
}
     public void lvidas(textos q){
         this.vidas = q;
}
      public void lgameover(textos w){
          this.gameover = w;
}
      

public void Colision(){
    int i,j; 
    for(i=0;i<nave.bal.size();i++){
            DibujarDiparos bala = (DibujarDiparos) nave.bal.get(i);
                for(j=0;j<asteroides.size();j++){
                         DibujarAsteroide aste = (DibujarAsteroide) asteroides.get(j);
                         
                         Dat coorbala = new Dat(bala.getX(),bala.getY());
                         Dat corder = new Dat(aste.getX()+30,aste.getY());
                         Dat corizq = new Dat(aste.getX()-15,aste.getY());
                         Dat corcen = new Dat(aste.getX(),aste.getY());
                  if(coorbala.getX() > corizq.getX() && coorbala.getX() < corder.getX() && coorbala.getY() < corcen.getY()){
                      aste.pintar(Color.BLACK);
                      bala.pintar(Color.BLACK);
                      bala.setY(-100);
                      aste.setY(-100);
                      nave.bal.remove(bala);
                      asteroides.remove(aste);
                    contAsteroides--;
                  }       
                }
     }
}      
     public void inicio(){
         while(true){
             
             try{
                 if(!nave.bal.isEmpty()){
                     nave.Movim();
                     //metodo para mover la bala por todo el panel
                     }
                for(int i=0;i<asteroides.size();i++){
                     DibujarAsteroide rect = (DibujarAsteroide) asteroides.get(i);
                     rect.Movim();
                  if(rect.getY()>525){
                     int a = Ranmdom(800,50);
                     rect.setY(0);
                     rect.setX(a);
                    }
                }
                    if(contAsteroides < 5){
                        int a = Ranmdom (800,50);
                        Dat Inicio = new Dat(a,0);
                        DibujarAsteroide nuevo = new DibujarAsteroide(Inicio,25,25,Color.GREEN);
                        asteroides.add(nuevo);
                        op.add(nuevo);
                        nuevo.Movim();
                        contAsteroides++;
                    } 
                    Colision();
                    Thread.sleep(150);
             }catch(InterruptedException e){System.out.println(e);}
            repaint();
        }
     }

}
