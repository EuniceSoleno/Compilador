/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Token;

import java.io.IOException;

/**
 *
 * @author eunice
 */
public class Main {

    public static void main(String[] args) {

        try {

            Lexer lexer = new Lexer("ficheiro.txt");
            TokenPair token;
            int linha;
            
            System.out.println("Lexema\t\t\tToken\t\t\tLinha");
            do {
                token = lexer.lerLexema();
                System.out.println(token.lexema + "\t\t\t" + token.token +"\t\t\t" + token.linha);
                //token.imprimirTabela();
            } while (!token.token.equals(Token.TOKEN_END));
            
            lexer.close();
        } catch (IOException ex) {
            System.out.println("erro");
        }

    }

}
