package Token;

public class Token {

    //Delimitadores
    public static final String TOKEN_V = "virgula";
    public static final String TOKEN_PVC = "ponto_virgula";
    public static final String TOKEN_AP = "Abrir_Parenteses";
    public static final String TOKEN_FP = "Fechar_Parenteses";
    public static final String TOKEN_AC = "Abrir_Chaves";
    public static final String TOKEN_FC = "Fechar_Chaves";

    //Fim do Arquivo
    public static final String TOKEN_END = "final_Arquivo";

    //Operadores aritmetricos
    public static final String TOKEN_OS = "Operador_soma";
    public static final String TOKEN_OSUB = "Operador_subtracao";
    public static final String TOKEN_OM = "Operador_Multiplicacao";
    public static final String TOKEN_OD = "Operador_Divisao";
    public static final String TOKEN_MOD = "Operador_Modulo";
    public static final String TOKEN_ATRIB_ADICAO = "Operador_Atribuição_Adiçao";
    public static final String TOKEN_ATRIB_SUB = "Operador_Atribuição_Subtração";
    public static final String TOKEN_ATRIB_MULT = "Operador_Atribuição_MULT";
    public static final String TOKEN_ATRIB_DIV = "Operador_Atribuição_DIVISAO";
    public static final String TOKEN_ATRIB_MOD = "Operador_Atribuição_Modulo";
    public static final String TOKEN_INCREMENTO = "Operador_Incremento";
    public static final String TOKEN_DECREMENTO = "Operador_Decremento";

    //operador Relacional
    public static final String TOKEN_ORM = "Operador_maior";
    public static final String TOKEN_ORN = "Operador_menor";
    public static final String TOKEN_I = "Operador_Igualdade";
    public static final String TOKEN_ORMI = "Operador_maior_Igual";
    public static final String TOKEN_ORNI = "Operador_menor_Igual";
    public static final String TOKEN_DIF = "Operador_Diferente";
    public static final String TOKEN_2IGUAL = "Operador_Igual_Igual";

    //Operadores Logicos
    public static final String TOKEN_E = "Operador_Logico_E";
    public static final String TOKEN_OU = "Operador_Logico_Ou";
    public static final String TOKEN_NEGACAO = "Operador_Logico_Negacao";

    //Operadores Bitwise
    public static final String TOKEN_E_BIT = "Operador_E_Bit_Bit";
    public static final String TOKEN_OU_BIT = "Operador_OU_Bit_Bit";
    public static final String TOKEN_EXCLUSIVO = "Operador_Exclusivo_Bit_Bit";
    public static final String TOKEN_COMPLEMENTO = "Operador_Complemento_Bit_Bit";
    public static final String TOKEN_DESLOCAMENTO_E = "Operador_Deslocamento_Esquerda_Bit_Bit";
    public static final String TOKEN_DESLOCAMENTO_D = "Operador_Deslocamento_Direita_Bit_Bit";

    //Outros Operadores
    public static final String TOKEN_OA = "Operador_De_Acesso";
    public static final String TOKEN_SEPARADOR = "Operador_Separador _De_Caso";
    public static final String TOKEN_OP = "Operador_Ternario";
    public static final String TOKEN_REFERENCIA_DE_METODO = "Operador_De_Referncia_De_Metodo";

    //
    public static final String TOKEN_DIGITO = "Digito";
    public static final String TOKEN_ID = "Identificador";
    public static final String TOKEN_KW = "KeyWord";

    //Comentarios
    public static final String TOKEN_CLU = "Comentario_de_Linha_Unica";
    public static final String TOKEN_COMENTARIO = "Comentario";

    //Palavras Reservadas
    public static final String TOKEN_ABSTRACT = "Palavra Resevada astract";
    public static final String TOKEN_ASSERT = "Palavra Resevada assert";
    public static final String TOKEN_BOLEAN = "Palavra Resevada bolean";
    public static final String TOKEN_BREAK = "Palavra Resevada break";
    public static final String TOKEN_BYTE = "Palavra Resevada byte";
    public static final String TOKEN_CASE = "Palavra Resevada case";
    public static final String TOKEN_CATCH = "Palavra Resevada cath";
    public static final String TOKEN_CHAR = "Palavra Resevada char";
    public static final String TOKEN_CLASS = "Palavra Resevada class";
    public static final String TOKEN_CONST = "Palavra Resevada const";
    public static final String TOKEN_CONTINUE = "Palavra Resevada continue";
    public static final String TOKEN_DEFAULT = "Palavra Resevada default";
    public static final String TOKEN_DO = "Palavra Resevada do";
    public static final String TOKEN_DOUBLE = "Palavra Resevada double";
    public static final String TOKEN_ELSE = "Palavra Resevada else";
    public static final String TOKEN_ENUM = "Palavra Resevada enum";
    public static final String TOKEN_EXTENDS = "Palavra Resevada extends";
    public static final String TOKEN_FINAL = "Palavra Resevada final";
    public static final String TOKEN_FINALLY = "Palavra Resevada finally";
    public static final String TOKEN_FLOAT = "Palavra Resevada float";
    public static final String TOKEN_FOR = "Palavra Resevada for";
    public static final String TOKEN_GOTO = "Palavra Resevada goto";
    public static final String TOKEN_IF = "Palavra Resevada if";
    public static final String TOKEN_IMPLEMENTS = "Palavra Resevada implements";
    public static final String TOKEN_IMPORT = "Palavra Resevada import";
    public static final String TOKEN_INSTANCEOF = "Palavra Resevada instanceof";
    public static final String TOKEN_INT = "Palavra Resevada int";
    public static final String TOKEN_INTERFACE = "Palavra Resevada interface";
    public static final String TOKEN_LONG = "Palavra Resevada long";
    public static final String TOKEN_NATIVE = "Palavra Resevada native";
    public static final String TOKEN_NEW = "Palavra Resevada new";
    public static final String TOKEN_PACKEGE = "Palavra Resevada packege";
    public static final String TOKEN_PRIVATE = "Palavra Resevada private";
    public static final String TOKEN_PROTECTED = "Palavra Resevada protected";
    public static final String TOKEN_PUBLIC = "Palavra Resevada public";
    public static final String TOKEN_RETURN = "Palavra Resevada return";
    public static final String TOKEN_SHORT = "Palavra Resevada short";
    public static final String TOKEN_STATIC = "Palavra Resevada static";
    public static final String TOKEN_STRICTFP = "Palavra Resevada strictfp";
    public static final String TOKEN_SUPER = "Palavra Resevada super";
    public static final String TOKEN_SWITCH = "Palavra Resevada switch";
    public static final String TOKEN_SYNCHRONIZE = "Palavra Resevada synchronize";
    public static final String TOKEN_THIS = "Palavra Resevada this";
    public static final String TOKEN_THROW = "Palavra Resevada throw";
    public static final String TOKEN_THROWS = "Palavra Resevada throws";
    public static final String TOKEN_TRANSIENT = "Palavra Resevada transient";
    public static final String TOKEN_TRY = "Palavra Resevada try";
    public static final String TOKEN_VOID = "Palavra Resevada void";
    public static final String TOKEN_VOLATILE = "Palavra Resevada volatile";
    public static final String TOKEN_WHILE = "Palavra Resevada while";
    public static final String TOKEN_TRUE = "Palavra Resevada true";
    public static final String TOKEN_FALSE = "Palavra Resevada false";
    public static final String TOKEN_NULL = "Palavra Resevada null";

}
