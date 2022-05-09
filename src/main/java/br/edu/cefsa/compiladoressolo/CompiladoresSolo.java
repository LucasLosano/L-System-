/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.edu.cefsa.compiladoressolo;

import br.edu.cefsa.arquivo.ArquivoDAO;
import br.edu.cefsa.draw.Draw;
import br.edu.cefsa.gramatica.Gramatica;

/**
 *
 * @author losan
 */
public class CompiladoresSolo {

    public static void main(String[] args) throws Exception {
        String[] entrada = ArquivoDAO.readTextFile("gramatica.txt").split(";");
        Gramatica gramatica = new Gramatica(entrada);
        String saida = gramatica.gerarSaida();
        Draw draw = new Draw(saida);
        draw.desenhar();
        ArquivoDAO.writeToExitFile("bla.html", draw.getSvg());
        System.out.print(entrada);
    }
}
