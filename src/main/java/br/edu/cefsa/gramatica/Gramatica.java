/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.gramatica;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author losan
 */
public class Gramatica {
    private String[] variaveis;
    private int repeticoes;
    private String inicial;
    private double angulo;
    private Map<String, String> regras = new HashMap<String, String>();

    public Gramatica(String[] entradaArquivo) {
        variaveis = entradaArquivo[0].split(",");
        repeticoes = Integer. parseInt(entradaArquivo[1]);
        inicial = entradaArquivo[2];
        angulo = Double.parseDouble(entradaArquivo[3]);
        for(int i = 4; i < entradaArquivo.length; i++)
        {
            String[] regraKeyValue = entradaArquivo[i].split("=");
            regras.put(regraKeyValue[0], regraKeyValue[1]);
        }
    }

    public String[] getVariaveis() {
        return variaveis;
    }

    public void setVariaveis(String[] variaveis) {
        this.variaveis = variaveis;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public Map<String, String> getRegras() {
        return regras;
    }

    public void setRegras(Map<String, String> regras) {
        this.regras = regras;
    }
    
    public String gerarSaida()
    {
        String palavra = inicial;
        String proximaPalavra = "";
        String charAtual = "";
        for(int i = 0; i < repeticoes; i++)
        {
            for(int j = 0; j < palavra.length(); j++)
            {
                charAtual += palavra.charAt(j);
                if(regras.keySet().contains(charAtual))
                    proximaPalavra += regras.get(charAtual);
                else
                    proximaPalavra += charAtual;
                charAtual = "";
            }
            palavra = proximaPalavra;
        }
        return palavra;
    }
    
}
