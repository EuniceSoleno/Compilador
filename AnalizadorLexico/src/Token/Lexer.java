package Token;

import Sintatico.Parser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Lexer {

    private FileReader file;
    private char caracter;
    int lineNumber;


    ArrayList<String> reservedWords = new ArrayList<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
            "volatile", "while", "true", "false", "null"
    ));

    //Leitura do Arquivo
    public Lexer(String filename) throws FileNotFoundException, IOException {
        file = new FileReader(filename);
        caracter = (char) file.read();
        lineNumber = 1;
    }

    //incrementado as linhas
    private void incrementCurrentLine(char c) {
        if (c == '\n') {
            lineNumber++;
        }
    }

    //ler proximo Caracter
    public int lerProximoCaracter() throws IOException {
        int prox = file.read();
        return prox;
    }
    
    //reconhecer Lexema
    public TokenPair lerLexema() {
        try {

            StringBuilder lexema = new StringBuilder();
            char proximoCaracter;
            int state = 0;

            while (caracter != -1) {
                switch (state) {
                    case 0:
                        if (caracter == ' ') {
                            state = 0;
                        } else if (caracter == '\r') {
                            state = 0;
                        } else if (caracter == ';') {
                            lexema.append(caracter);
                            state = 1;
                        } else if (caracter == ')') {
                            lexema.append(caracter);
                            state = 2;
                        } else if (caracter == '(') {
                            lexema.append(caracter);
                            state = 3;
                        } else if (caracter == '{') {
                            lexema.append(caracter);
                            state = 4;
                        } else if (caracter == '}') {
                            lexema.append(caracter);
                            state = 5;
                        } else if (caracter == '+') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '=') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 18;
                            } else if (proximoCaracter == '+') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 35;
                            } else {
                                lexema.append(caracter);
                                state = 6;
                            }

                        } else if (caracter == '-') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '=') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 19;
                            } else if (proximoCaracter == '-') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 36;
                            } else {
                                lexema.append(caracter);
                                state = 7;
                            }
                        } else if (caracter == '*') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '=') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 20;
                            } else {
                                lexema.append(caracter);
                                state = 8;
                            }

                        } else if (caracter == '/') {
                            proximoCaracter = (char) lerProximoCaracter();
                            switch (proximoCaracter) {
                                case '=':
                                    lexema.append(caracter);
                                    lexema.append(proximoCaracter);
                                    state = 21;
                                    break;
                                case '/':
                                    while (caracter != '\n' && caracter != -1) {
                                        caracter = (char) lerProximoCaracter();
                                    }
                                    state = 0;
                                    break;
                                case '*':
                                    while (true) {
                                        caracter = (char) lerProximoCaracter();
                                        if (caracter == '*') {
                                            caracter = (char) lerProximoCaracter();
                                            if (caracter == '/') {
                                                break;
                                            }
                                        }
                                        if (caracter == -1) {
                                            throw new IOException("Fim de arquivo encontrado dentro de um comentário de múltiplas linhas");
                                        }
                                    }
                                    state = 0;
                                    break;
                                default:
                                    lexema.append(caracter);
                                    state = 9;
                                    break;
                            }

                        } else if (caracter == '<') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '=') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 15;
                            } else {
                                lexema.append(caracter);
                                state = 10;
                            }

                        } else if (caracter == '>') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '=') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 16;
                            } else {
                                lexema.append(caracter);
                                state = 11;
                            }
                        } else if (caracter == '=') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '=') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 17;
                            } else {
                                lexema.append(caracter);
                                state = 12;
                            }

                        } else if (caracter == ',') {
                            lexema.append(caracter);
                            state = 13;
                        } else if (caracter == '%') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '=') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 22;
                            } else {
                                lexema.append(caracter);
                                state = 23;
                            }
                        } else if (caracter == '!') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '=') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 14;
                            } else {
                                lexema.append(caracter);
                                state = 24;
                            }
                        } else if (caracter == '&') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '&') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 25;
                            } else {
                                lexema.append(caracter);
                                state = 26;
                            }
                        } else if (caracter == '|') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == '|') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 27;
                            } else {
                                lexema.append(caracter);
                                state = 28;
                            }
                        } else if (caracter == '^') {
                            state = 29;

                        } else if (caracter == '«') {
                            state = 30;
                        } else if (caracter == '.') {
                            state = 31;
                        } else if (caracter == ':') {

                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == ':') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 32;
                            } else {
                                lexema.append(caracter);
                                state = 33;
                            }
                        } else if (caracter == '?') {
                            proximoCaracter = (char) lerProximoCaracter();
                            if (proximoCaracter == ':') {
                                lexema.append(caracter);
                                lexema.append(proximoCaracter);
                                state = 34;
                            } else {
                                System.out.println("token inexistente");
                            }
                        } else if (Character.isDigit(caracter)) {
                            lexema.append(caracter);
                            proximoCaracter = (char) lerProximoCaracter();
                            while (Character.isDigit(proximoCaracter)) {
                                lexema.append(proximoCaracter); // Adiciona os dígitos subsequentes ao lexema
                                proximoCaracter = (char) lerProximoCaracter();
                            }
                            if (proximoCaracter == '.') {
                                lexema.append(proximoCaracter); // Adiciona o ponto decimal ao lexema
                                proximoCaracter = (char) lerProximoCaracter();
                                while (Character.isDigit(proximoCaracter)) {
                                    lexema.append(proximoCaracter); // Adiciona os dígitos após o ponto decimal ao lexema
                                    proximoCaracter = (char) lerProximoCaracter();
                                }
                            }
                            state = 37;
                        } else if (Character.isLetter(caracter)) {

                            lexema.append(caracter);
                            caracter = '\0';
                            proximoCaracter = (char) lerProximoCaracter();
                            while ((Character.isLetter(proximoCaracter) || Character.isDigit(proximoCaracter) || proximoCaracter == '_') && proximoCaracter != ' ') {
                                lexema.append(proximoCaracter);
                                proximoCaracter = (char) lerProximoCaracter();
                            }
                            for (String word : reservedWords) {
                                if (lexema.toString().equals(word)) {
                                    switch (word) {
                                        case "abstract":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_ABSTRACT, lineNumber);
                                        case "assert":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_ASSERT, lineNumber);
                                        case "boolean":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_BOLEAN, lineNumber);
                                        case "break":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_BREAK, lineNumber);
                                        case "byte":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_BYTE, lineNumber);
                                        case "case":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_CASE, lineNumber);
                                        case "catch":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_CATCH, lineNumber);
                                        case "char":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_CHAR, lineNumber);
                                        case "class":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_CLASS, lineNumber);
                                        case "const":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_CONST, lineNumber);
                                        case "continue":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_CONTINUE, lineNumber);
                                        case "default":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_DEFAULT, lineNumber);
                                        case "do":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_DO, lineNumber);
                                        case "double":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_DOUBLE, lineNumber);
                                        case "else":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_ELSE, lineNumber);
                                        case "enum":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_ENUM, lineNumber);
                                        case "extends":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_EXTENDS, lineNumber);
                                        case "final":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_FINAL, lineNumber);
                                        case "finally":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_FINALLY, lineNumber);
                                        case "float":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_FLOAT, lineNumber);
                                        case "for":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_FOR, lineNumber);
                                        case "goto":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_GOTO, lineNumber);
                                        case "if":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_IF, lineNumber);
                                        case "implements":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_IMPLEMENTS, lineNumber);
                                        case "import":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_IMPORT, lineNumber);
                                        case "instanceof":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_INSTANCEOF, lineNumber);
                                        case "int":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_INT, lineNumber);
                                        case "interface":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_INTERFACE, lineNumber);
                                        case "long":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_LONG, lineNumber);
                                        case "native":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_NATIVE, lineNumber);
                                        case "new":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_NEW, lineNumber);
                                        case "packege":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_PACKEGE, lineNumber);
                                        case "private":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_PRIVATE, lineNumber);
                                        case "public":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_PUBLIC, lineNumber);
                                        case "return":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_RETURN, lineNumber);
                                        case "short":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_SHORT, lineNumber);

                                        case "strictfp":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_STRICTFP, lineNumber);
                                        case "while":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_WHILE, lineNumber);

                                        case "try":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_TRY, lineNumber);
                                        case "void":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_VOID, lineNumber);
                                        case "volatile":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_VOLATILE, lineNumber);
                                        case "null":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_NULL, lineNumber);
                                        case "false":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_FALSE, lineNumber);
                                        case "true":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_TRUE, lineNumber);

                                        case "super":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_SUPER, lineNumber);
                                        case "transient":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_TRANSIENT, lineNumber);
                                        case "switch":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_SWITCH, lineNumber);

                                        case "static":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_STATIC, lineNumber);
                                        case "this":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_THIS, lineNumber);
                                        case "throw":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_STRICTFP, lineNumber);
                                        case "synchronized":
                                            return new TokenPair(lexema.toString(), Token.TOKEN_STRICTFP, lineNumber);

                                    }
                                } else {

                                }
                            }
                            state = 40;
                        }
                        break;

                    case 1:

                        return new TokenPair(lexema.toString(), Token.TOKEN_PVC, lineNumber);
                    case 2:
                        return new TokenPair(lexema.toString(), Token.TOKEN_FP, lineNumber);
                    case 3:
                        return new TokenPair(lexema.toString(), Token.TOKEN_AP, lineNumber);
                    case 4:
                        return new TokenPair(lexema.toString(), Token.TOKEN_AC, lineNumber);
                    case 5:
                        return new TokenPair(lexema.toString(), Token.TOKEN_FC, lineNumber);
                    case 6:
                        return new TokenPair(lexema.toString(), Token.TOKEN_OS, lineNumber);
                    case 7:
                        return new TokenPair(lexema.toString(), Token.TOKEN_OSUB, lineNumber);
                    case 8:
                        return new TokenPair(lexema.toString(), Token.TOKEN_OM, lineNumber);
                    case 9:
                        return new TokenPair(lexema.toString(), Token.TOKEN_OD, lineNumber);
                    case 10:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ORN, lineNumber);
                    case 11:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ORM, lineNumber);
                    case 12:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ORNI, lineNumber);
                    case 13:
                        return new TokenPair(lexema.toString(), Token.TOKEN_V, lineNumber);
                    case 14:
                        return new TokenPair(lexema.toString(), Token.TOKEN_DIF, lineNumber);
                    case 15:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ORNI, lineNumber);
                    case 16:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ORMI, lineNumber);
                    case 17:
                        return new TokenPair(lexema.toString(), Token.TOKEN_2IGUAL, lineNumber);
                    case 18:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ATRIB_ADICAO, lineNumber);
                    case 19:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ATRIB_SUB, lineNumber);
                    case 20:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ATRIB_MULT, lineNumber);
                    case 21:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ATRIB_DIV, lineNumber);
                    case 22:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ATRIB_MOD, lineNumber);
                    case 23:
                        return new TokenPair(lexema.toString(), Token.TOKEN_MOD, lineNumber);
                    case 24:
                        return new TokenPair(lexema.toString(), Token.TOKEN_NEGACAO, lineNumber);
                    case 25:
                        return new TokenPair(lexema.toString(), Token.TOKEN_E, lineNumber);
                    case 26:
                        return new TokenPair(lexema.toString(), Token.TOKEN_E_BIT, lineNumber);
                    case 27:
                        return new TokenPair(lexema.toString(), Token.TOKEN_OU, lineNumber);
                    case 28:
                        return new TokenPair(lexema.toString(), Token.TOKEN_OU_BIT, lineNumber);
                    case 29:
                        return new TokenPair(lexema.toString(), Token.TOKEN_COMPLEMENTO, lineNumber);
                    case 30:
                        return new TokenPair(lexema.toString(), Token.TOKEN_DESLOCAMENTO_E, lineNumber);
                    case 31:
                        return new TokenPair(lexema.toString(), Token.TOKEN_OA, lineNumber);
                    case 32:
                        return new TokenPair(lexema.toString(), Token.TOKEN_REFERENCIA_DE_METODO, lineNumber);
                    case 33:
                        return new TokenPair(lexema.toString(), Token.TOKEN_SEPARADOR, lineNumber);
                    case 34:
                        return new TokenPair(lexema.toString(), Token.TOKEN_OP, lineNumber);
                    case 35:
                        return new TokenPair(lexema.toString(), Token.TOKEN_INCREMENTO, lineNumber);
                    case 36:
                        return new TokenPair(lexema.toString(), Token.TOKEN_DECREMENTO, lineNumber);
                    case 37:
                    case 38:
                    case 39:
                        return new TokenPair(lexema.toString(), Token.TOKEN_DIGITO, lineNumber);
                    case 40:
                        return new TokenPair(lexema.toString(), Token.TOKEN_ID, lineNumber);
                    case 41:

                }
                incrementCurrentLine(caracter);
                /*Parser parse = new Parser(lexema.toString(),lineNumber);*/
                caracter = (char) file.read();
               
            }

        } catch (IOException ex) {

            System.out.println("Erro ao ler os simbolos!" + ex.getMessage());
        }

        return new TokenPair("", Token.TOKEN_END, lineNumber);
    }

    public void close() throws IOException {
        file.close();
    }

    public TokenPair getNextToken() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
