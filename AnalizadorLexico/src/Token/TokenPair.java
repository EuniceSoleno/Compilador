package Token;

import java.util.ArrayList;

public class TokenPair {

    //lexema corresponde ao simbolo
    //token corresponde ao agrupamento destes simbolos
    public String lexema;
    public String token;
    public int linha;

    ArrayList<LexemaInfo> tabelaSimbolos = new ArrayList<>();

    public TokenPair(String lexema, String token, int linha) {
        this.lexema = lexema;
        this.token = token;
        this.linha = linha;
        
        LexemaInfo newLexema = new LexemaInfo(lexema, token, linha);

        if (!tabelaSimbolos.contains(newLexema)) {
            tabelaSimbolos.add(newLexema);
        }
    }

}
