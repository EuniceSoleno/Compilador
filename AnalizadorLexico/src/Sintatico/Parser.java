/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sintatico;

import Token.Lexer;
import Token.Token;
import Token.TokenPair;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author eunice
 */
public class Parser {
    
    private Lexer lexer;
    private Token token;
    
    
    //Construtor do Parser
    public Parser(String filename) throws IOException {
        try {
            lexer = new Lexer(filename);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + filename);

        }
    }
    
    
    //Busca e analise dos Tokens
    public void parse() {
        try {
            TokenPair tokenPair;
            do {
                tokenPair = lexer.lerLexema();
                switch (tokenPair.getToken()) {
                    
                    case Token.TOKEN_PACKEGE:
                        parsePackege();
                        System.out.print("Eunice Soleno");
                        break;
                        
                    case Token.TOKEN_CLASS:
                        parseClass();
                        break;
                        
                        
                    
                }
            } while (tokenPair.getToken() != Token.TOKEN_END);
        } finally {
            if (lexer != null) {
                try {
                    lexer.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o lexer: " + e.getMessage());
                }
            }
        }
    }
    
    
    //Parser's: Regras Da Gramática
    
    
    private void parsePackege(){
        TokenPair tokenPair = lexer.lerLexema();
        
        if(tokenPair.equals(Token.TOKEN_ID))
        {
            System.out.print("Correcto");
        }else{
            System.out.print("ERRO");
        }

        
    }
    
    private void parseClass() {
        
        TokenPair tokenPair = lexer.lerLexema();
        
        
        //verifica se o proxio token é um ID
        if (tokenPair.getToken().equals(Token.TOKEN_ID)) {
            
            String className = tokenPair.getLexema();

            // Verifica se o próximo token é o abre chaves '{'
            
            tokenPair = lexer.lerLexema();
            if (tokenPair.getToken() == Token.TOKEN_AC) {
                // Agora você pode analisar o corpo da classe
                //parseClassBody(className);
            } else {
                // Se o próximo token não for '{', então há um erro na sintaxe
                System.out.println("Erro de sintaxe: Esperado '{' após o nome da classe.");
            }
        } else {
            // Se o token atual não for o nome da classe, então há um erro na sintaxe
            System.out.println("Erro de sintaxe: Esperado o nome da classe.");
        }
}


    private void parseVariableDeclaration() {
        
    }

    
    private void parseClassBody(String className){
        
    }
}
