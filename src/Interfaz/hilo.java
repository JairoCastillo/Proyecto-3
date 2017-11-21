/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Informacion.textos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import naves.Principal;
import static naves.Principal.Ranmdom;

/**
 *
 * @author Usuario
 */
public class hilo extends Thread{
    int conta=0;
    Pa panel;
    //Definimos coordenadas y movimiento nulo cuando soltemos la tecla
    
    
    public hilo(Pa panel) {
        System.out.println("entra hilo");
        this.panel = panel;
        
    }

    @Override
    public void run() {
        while (conta<2) {
            try {
                if (!panel.getNave().bal.isEmpty()) {
                    panel.getNave().Movim();
                    //metodo para mover la bala por todo el panel
                }
                for (int i = 0; i < panel.getAsteroides().size(); i++) {
                    DibujarAsteroide rect = (DibujarAsteroide) panel.getAsteroides().get(i);
                    rect.Movim(panel.getMov());
                    if (rect.getY() > 525) {
                        int a = Ranmdom(800, 50);
                        rect.setY(0);
                        rect.setX(a);
                    }
                }//usamos esta varible para añadir mas asteroides

                if (panel.getContAsteroides() < panel.getMAXAST()) {
                    int a = Ranmdom(800, 50);
                    Dat Inicio = new Dat(a, 0);
                    DibujarAsteroide nuevo = new DibujarAsteroide(Inicio, 25, 25, Color.GREEN);
                    panel.getAsteroides().add(nuevo);
                    panel.getOp().add(nuevo);
                    nuevo.Movim(panel.getMov());
                    panel.setContAsteroides(panel.getContAsteroides() + 1);
                }
                int Nivel = 1;
                String Niveles = "" + Nivel;
                textos tNivel = new textos("Fase", Color.WHITE, 1400, 900);
                tNivel.setSize(43);
                textos tFase = new textos(Niveles, Color.RED, 1400, 1000);
                tFase.setSize(23);
                panel.getOp().add(tFase);
                panel.getOp().add(tNivel);

                if (panel.getScore() >= 100 && panel.getScore() < 150) {
                    Nivel = 2;
                    String NuevoNivel = "" + Nivel;
                    tFase.setColor(Color.BLACK);
                    //texto para reemplazar
                    textos Nrnivel = new textos(NuevoNivel, Color.RED, 1400, 1000);
                    Nrnivel.setSize(23);
                    tFase = Nrnivel;
                    panel.getOp().add(tFase);
                    //con estas variables modificamos la velocidad y los numero de asteeroides
                    panel.setMov(12);
                    panel.setMAXAST(6);
                    for (int i = 0; i < panel.getAsteroides().size(); i++) {
                        DibujarAsteroide rect = (DibujarAsteroide) panel.getAsteroides().get(i);
                        rect.pintar(Color.YELLOW);
                    }
                }

                if (panel.getScore() >= 100 && panel.getScore() < 150) {
                    Nivel = 3;
                    String NuevoNivel = "" + Nivel;
                    tFase.setColor(Color.BLACK);
                    //texto para reemplazar
                    textos Nrnivel = new textos(NuevoNivel, Color.RED, 1400, 1000);
                    Nrnivel.setSize(23);
                    tFase = Nrnivel;
                    panel.getOp().add(tFase);
                    //con estas variables modificamos la velocidad y los numero de asteeroides
                    panel.setMov(16);
                    panel.setMAXAST(7);
                    for (int i = 0; i < panel.getAsteroides().size(); i++) {
                        DibujarAsteroide rect = (DibujarAsteroide) panel.asteroides.get(i);
                        rect.pintar(Color.WHITE);
                    }
                }
                /*if(panel.getVidas() <= 0){
                          FinDeJuego = false;
                          op.add(Final);
                      }*/
                Colision();
                Thread.sleep(30);
                conta++;
                //System.out.println(conta);
                 panel.repaint();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    

    public void Colision() {
        int i, j;
        for (i = 0; i < panel.getNave().bal.size(); i++) {
            DibujarDiparos bala = (DibujarDiparos) panel.getNave().bal.get(i);
            for (j = 0; j < panel.getAsteroides().size(); j++) {
                DibujarAsteroide aste = (DibujarAsteroide) panel.getAsteroides().get(j);

                Dat coorbala = new Dat(bala.getX(), bala.getY());
                Dat corder = new Dat(aste.getX() + 30, aste.getY());
                Dat corizq = new Dat(aste.getX() - 15, aste.getY());
                Dat corcen = new Dat(aste.getX(), aste.getY());
                if (coorbala.getX() > corizq.getX() && coorbala.getX() < corder.getX()
                        && coorbala.getY() < corcen.getY() && coorbala.getY() < corcen.getY()) {
                    aste.pintar(Color.BLACK);
                    bala.pintar(Color.BLACK);
                    bala.setY(-100);
                    aste.setY(-100);
                    panel.getNave().bal.remove(bala);
                    panel.getAsteroides().remove(aste);
                    panel.setContAsteroides(panel.getContAsteroides() -1);
                    panel.setScore(panel.getScore() + 5);
                    panel.getPuntos().setColor(Color.BLACK);
                    String nuevoScore = "" + panel.getScore();
                    textos nS = new textos(nuevoScore, Color.RED, 1600, 160);
                    nS.setSize(23);
                    panel.setPuntos(nS);
                    panel.getOp().add(panel.getPuntos());
                }
                if (corcen.getY() > 475 && corcen.getY() < 550 && (panel.getNave().c1.getX()) < corcen.getX() && panel.getNave().c2.getX() > corcen.getX()) {
                    panel.setScore(panel.getScore() - 5);
                    panel.setLife(panel.getLife()-1);
                    String nScore = "" + panel.getScore();
                    String nLife = "" + panel.getLife();
                    panel.getVidas().setColor(Color.RED);
                    panel.getPuntos().setColor(Color.RED);
                    textos nLi = new textos(nLife, Color.RED, 1600, 400);
                    nLi.setSize(23);
                    panel.setVidas(nLi);
                    textos nSco = new textos(nScore, Color.RED, 1600, 700);
                    nSco.setSize(23);
                    panel.setPuntos(nSco);

                    panel.getOp().add(panel.getVidas());
                    panel.getOp().add(panel.getPuntos());

                    panel.asteroides.remove(aste);
                    aste.setY(3000);
                    panel.setContAsteroides(panel.getContAsteroides()-1);
                    
                }
            }
        }
        
    }
}
