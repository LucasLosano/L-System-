/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.draw;

import java.util.Stack;

/**
 *
 * @author losan
 */
public class Draw {
    Stack<Posicao> posicoes = new Stack<Posicao>();
    Posicao posicaoAtual = new Posicao( 650, 1000, 650, 1000, 0);
    StringBuilder svg = new StringBuilder(); 
    String desenho;

    public Draw(String desenho) {
        svg.append("<svg height=\"1500\" width=\"1500\">");
        this.desenho = desenho;
    }

    public Posicao getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(Posicao posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public String getSvg() {
        return svg.append("</svg>").toString();
    }
    
    private void desenhaLinha()
    {
        posicaoAtual.mover();
        svg.append("<line x1=\"" + posicaoAtual.getX1() + "\" y1=\"" + posicaoAtual.getY1() + "\" x2=\"" + posicaoAtual.getX2() + "\" y2=\"" + posicaoAtual.getY2() + "\" style=\"stroke:rgb(255,0,0);stroke-width:1\" />");
    }
    
    private void rodarDireita()
    {
        posicaoAtual.rodar(true);
    }
    
    private void rodarEsquerda()
    {
        posicaoAtual.rodar(false);
    }
    
    private void push()
    {
        posicoes.add(new Posicao(posicaoAtual));
    }
    
    private void pop()
    {
        posicaoAtual = posicoes.pop();
    }
    
    public void desenhar()
    {
        for(char letra : desenho.toCharArray())
        {
            if(letra == 'F')
                desenhaLinha();
            if(letra == '+')
                rodarDireita();
            if(letra == '-')
                rodarEsquerda();
            if(letra == '[')
                push();
            if(letra == ']')
                pop();
        }
    }
}
