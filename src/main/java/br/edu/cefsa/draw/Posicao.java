/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.draw;

/**
 *
 * @author losan
 */
public class Posicao {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    final double passo = 5;
    final double angulo = 25;
    private double passoX = 0;
    private double passoY = passo;
    private int rotacao = 0;

    public Posicao() {
    }
    
    
    public Posicao(int x1, int y1, int x2, int y2, int rotacao) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.rotacao = rotacao;
    }

    public Posicao(Posicao posicaoAtual) {
        this.x1 = posicaoAtual.getX1();
        this.y1 = posicaoAtual.getY1();
        this.x2 = posicaoAtual.getX2();
        this.y2 = posicaoAtual.getY2();
        this.rotacao = posicaoAtual.getRotacao();
        this.passoX = posicaoAtual.getPassoX();
        this.passoY = posicaoAtual.getPassoY();
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
    
    public int getRotacao() {
        return rotacao;
    }

    public void setRotacao(int rotacao) {
        this.y2 = rotacao;
    }

    public double getPassoX() {
        return passoX;
    }

    public void setPassoX(double passoX) {
        this.passoX = passoX;
    }

    public double getPassoY() {
        return passoY;
    }

    public void setPassoY(double passoY) {
        this.passoY = passoY;
    }
    
    
    
    public void mover()
    {
        x1 = x2;
        y1 = y2;
        x2 += passoX;
        y2 -= passoY;
    }

    public void rodar(boolean lado) {
        if(lado)
            rotacao += angulo;
        else
            rotacao -= angulo;
        
        atualizaPasso();
    }

    private void atualizaPasso() {
        double radianos = rotacao*Math.PI/180;
        
        passoX = passo*Math.sin(radianos);
        passoY = passo*Math.cos(radianos);
    }
}
