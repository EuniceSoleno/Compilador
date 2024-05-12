/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Token;

/**
 *
 * @author eunice
 */
public class LexemaInfo {
    private String lexema;
    private int linha;
    private String token;
    
    public LexemaInfo() {
    }
    

    public LexemaInfo(String lexema, String token, int linha) {
        this.lexema = lexema;
        this.linha = linha;
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public int getLinha() {
        return linha;
    }

    public String getToken() {
        return token;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
