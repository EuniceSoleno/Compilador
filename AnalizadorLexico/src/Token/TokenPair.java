package Token;

import java.util.ArrayList;

public class TokenPair {

    //lexema corresponde ao simbolo
    //token corresponde ao agrupamento destes simbolos
    public String lexema;
    public String token;
    public int linha;

    ArrayList<LexemaInfo> tabelaSimbolos = new ArrayList<>();

    public TokenPair() {
    }
    
    public TokenPair(String lexema, String token, int linha) {
        this.lexema = lexema;
        this.token = token;
        this.linha = linha;
        
        LexemaInfo newLexema = new LexemaInfo(lexema, token, linha);

        if (!tabelaSimbolos.contains(newLexema)) {
            tabelaSimbolos.add(newLexema);
        }
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public ArrayList<LexemaInfo> getTabelaSimbolos() {
        return tabelaSimbolos;
    }

    public void setTabelaSimbolos(ArrayList<LexemaInfo> tabelaSimbolos) {
        this.tabelaSimbolos = tabelaSimbolos;
    }
    
    

}
