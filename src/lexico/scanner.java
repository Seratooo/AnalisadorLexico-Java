package lexico;

import exceptions.LexicalException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static lexico.tokens.Retorna;
import static main.AnalexForm.WriteToken;

/**
 *
 * @author abubacar-dev
 */
public class scanner {

    private char[] content;
    private int estado;
    private int pos;
    String txtConteudo;
    char currentChar;
    public tokens Token;
    
    //ABRE O FICHEIRO E CONVERTE NO FORMATO STRING
    public scanner(String filename) {
        try {

            txtConteudo = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
            System.out.println("------------  ANALISADOR LEXICO -----------");
            System.out.println(txtConteudo);
            System.out.println("--------------------------------------------");
            txtConteudo = txtConteudo.toLowerCase();

            content = txtConteudo.toCharArray();
            pos = 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //RETORNA O CONTEÚDO DO FICHEIRO LIDO
    public String ReturnConteudo() {
        return txtConteudo;
    }
    //TORNA OS TOKENS
    public tokens ReurnTokens() {
        return Token;
    }
    //RETORNA O RESULTADO DO TOKEN ABRIR PARÊNTESES
    public void OpenRelatives() {
        Token = new tokens();
        Token.setType(Token.TK_OPEN_RELATIVES);
        Token.setText("(");
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN FECHAR PARÊNTESES
    public void CloseRelatives() {
        Token = new tokens();
        Token.setType(Token.TK_CLOSE_RELATIVES);
        Token.setText(")");
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN PONTO E VÍRGULA
    public void Semicolon() {
        Token = new tokens();
        Token.setType(Token.TK_SEMICOLON);
        Token.setText(";");
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN VÍRGULA
    public void Comma() {
        Token = new tokens();
        Token.setType(Token.TK_COMMA);
        Token.setText(",");
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN ABRIR PARÊNTESES RETO
    public void ABreto() {
        Token = new tokens();
        Token.setType(Token.TK_AB_RETO);
        Token.setText("[");
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN FECHAR PARÊNTESES RETO
    public void FBreto() {
        Token = new tokens();
        Token.setType(Token.TK_FB_RETO);
        Token.setText("]");
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN PONTO
    public void Point() {
        Token = new tokens();
        Token.setType(Token.TK_POINT);
        Token.setText(".");
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN ABRIR CHAVES
    public void OPchaves() {
        Token = new tokens();
        Token.setType(Token.TK_OPCHAVES);
        Token.setText("{");
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN FECHAR CHAVES
    public void CSchaves() {
        Token = new tokens();
        Token.setType(Token.TK_CSCHAVES);
        Token.setText("}");
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN NUMERO INTEIRO
    public void Number(String term) {
        Token = new tokens();
        Token.setType(Token.TK_NUMBER);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN NUMERO DECIMAL
    public void NumberDec(String term) {
        Token = new tokens();
        Token.setType(Token.TK_NUMBER_DEC);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN SINAL DE ATRIBUICAO
    public void Atribuicao(String term) {
        Token = new tokens();
        Token.setType(Token.TK_ATRIBUICAO);
        Token.setText(term);
        Retorna(Token);
    }
    //RETORNA O RESULTADO DO TOKEN SINAL DE ADICAO
    public void Adicao(String term) {
        Token = new tokens();
        Token.setType(Token.TK_ADICAO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN SINAL DE SUBTRACAO
    public void Subtracao(String term) {
        Token = new tokens();
        Token.setType(Token.TK_SUBTRACAO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN SINAL DE MULTIPLICACAO
    public void Multiplicacao(String term) {
        Token = new tokens();
        Token.setType(Token.TK_MULTIPLICACAO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN SINAL DE DIVISAO
    public void Divisao(String term) {
        Token = new tokens();
        Token.setType(Token.TK_DIVISAO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN SINAL DE MAIOR
    public void Maior(String term) {
        Token = new tokens();
        Token.setType(Token.TK_MAIOR);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN SINAL DE MENOR
    public void Menor(String term) {
        Token = new tokens();
        Token.setType(Token.TK_MENOR);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN NEGACAO
    public void NotLogico(String term) {
        Token = new tokens();
        Token.setType(Token.TK_NOT_LOGICO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN SINAL DE COMPLEMENTO
    public void Complemento(String term) {
        Token = new tokens();
        Token.setType(Token.TK_COMPLEMENTO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN TERNARIO
    public void Ternario(String term) {
        Token = new tokens();
        Token.setType(Token.TK_TERNARIO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN AND
    public void AndLogico(String term) {
        Token = new tokens();
        Token.setType(Token.TK_AND_LOGICO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN OR
    public void OrLogico(String term) {
        Token = new tokens();
        Token.setType(Token.TK_OR_LOGICO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN XOR
    public void Xor(String term) {
        Token = new tokens();
        Token.setType(Token.TK_XOR);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN RESTO
    public void Resto(String term) {
        Token = new tokens();
        Token.setType(Token.TK_RESTO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN SEPARADOR
    public void Separador(String term) {
        Token = new tokens();
        Token.setType(Token.TK_SEPARADOR);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN @
    public void Arroba(String term) {
        Token = new tokens();
        Token.setType(Token.TK_ARROBA);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN COMENTARIO
    public void Comentario(String term) {
        Token = new tokens();
        Token.setType(Token.TK_COMENTARIO);
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);
    }
    //RETORNA O RESULTADO DO TOKEN PALAVRA RESERVADA OU IDENTIFICADOR
    public void VerifyIDENT_OR_RESRV(String term) {
        term = term.trim();
        Token = new tokens();

        if (term.equals("int") || term.equals("if") || term.equals("else") || term.equals("abstract")
                || term.equals("assert") || term.equals("boolean") || term.equals("break")
                || term.equals("byte") || term.equals("case") || term.equals("catch")
                || term.equals("char") || term.equals("class") || term.equals("const") || term.equals("continue")
                || term.equals("default") || term.equals("do") || term.equals("double") || term.equals("enum")
                || term.equals("extends") || term.equals("final") || term.equals("finally") || term.equals("float")
                || term.equals("for") || term.equals("goto") || term.equals("implements") || term.equals("import")
                || term.equals("instanceof") || term.equals("interface") || term.equals("long") || term.equals("native")
                || term.equals("new") || term.equals("package") || term.equals("private") || term.equals("protected")
                || term.equals("public") || term.equals("return") || term.equals("short") || term.equals("static")
                || term.equals("strictfp") || term.equals("super") || term.equals("switch") || term.equals("synchronized")
                || term.equals("this") || term.equals("throw") || term.equals("throws") || term.equals("transient")
                || term.equals("try") || term.equals("void") || term.equals("volatile") || term.equals("open")
                || term.equals("module") || term.equals("requires") || term.equals("transitive") || term.equals("exports")
                || term.equals("opens") || term.equals("to") || term.equals("uses") || term.equals("provides")
                || term.equals("with") || term.equals("while")) {
            Token.setType(Token.TK_RESERVED_WORD);
        } else if (term.contains("/")) {
            throw new LexicalException("Identificador Invalido");
        } else {
            Token.setType(Token.TK_IDENT);
        }
        Token.setText(term);
        Retorna(Token);
        WriteToken(Token);

    }
    //FUNCAO PRINCIPAL
    public void nextToken() {
        String term = "";
        if (isEOF()) {
            pos = 0;
        }
        estado = 0;
        currentChar = content[pos];
        while (pos < txtConteudo.length()) {
            if (currentChar == ' ' || isSpace(currentChar)) {
                currentChar = nextChar();
            }
            switch (estado) {
                case 0:
                    //LIMPA A VARIÁVEL QUE RECEBERÁ OS CARATECTERES NA POSICAO 0
                    if (pos == 0) {
                        currentChar = ' ';
                    }
                    //FUNCAO QUE VERIFICA IDENTIFICADOR OU PALAVRA RESERVADA
                    if (isChar(currentChar) && !isOperator(currentChar) && !isRelatives(currentChar)) {
                        do {
                            if ((isChar(currentChar) || isDigit(currentChar)) && !isRelatives(currentChar)) {
                                term += currentChar;
                                currentChar = nextChar();
                            } else {
                                break;
                            }
                        } while (isChar(currentChar) != false || isDigit(currentChar) != false);
                        VerifyIDENT_OR_RESRV(term);
                        term = "";
                      //FUNCAO QUE VERIFICA SE EXISTE ESPAÇOS EM BRANCO E OUTROS CARACTERES INVÁLIDOS
                    } else if (currentChar == '"' || isSpace(currentChar) || currentChar == '\'') {
                        if (isEOF()) {
                            return;
                        }
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE :
                    } else if (currentChar == ':') {
                        term += currentChar;
                        Separador(term);

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA D0 @
                    } else if (currentChar == '@') {
                        term += currentChar;
                        Separador(term);

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE (
                    } else if (currentChar == '(') {
                        OpenRelatives();
                        term += currentChar;

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE )
                    } else if (currentChar == ')') {
                        CloseRelatives();
                        term += currentChar;

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE ;
                    } else if (currentChar == ';') {
                        Semicolon();
                        term += currentChar;

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE ,
                    } else if (currentChar == ',') {
                        Comma();
                        term += currentChar;

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE {
                    } else if (currentChar == '{') {
                        OPchaves();
                        term += currentChar;

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE }
                    } else if (currentChar == '}') {
                        CSchaves();
                        term += currentChar;

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE [
                    } else if (currentChar == '[') {
                        ABreto();
                        term += currentChar;

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE ]
                    } else if (currentChar == ']') {
                        FBreto();
                        term += currentChar;

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE .
                    } else if (currentChar == '.') {
                        Point();
                        term += currentChar;

                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE +
                    } else if (currentChar == '+') {
                        term += currentChar;
                        Adicao(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE -
                    } else if (currentChar == '-') {
                        term += currentChar;
                        Subtracao(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE =
                    } else if (currentChar == '=') {
                        term += currentChar;
                        Atribuicao(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE *
                    } else if (currentChar == '*') {
                        term += currentChar;
                        Multiplicacao(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE /
                    } else if (currentChar == '/') {
                        term += currentChar;

                        currentChar = nextChar();
                     //VERIFICA A OCORRENCIA DE // (COMENTARIO)
                        if (currentChar == '/') {
                            do {
                                term += currentChar;
                                currentChar = nextChar();

                                if (isEOF()) {
                                    back();
                                    break;
                                }
                            } while (currentChar != '\n');
                            // Comentario(term);
                            term = "";
                            
                          //VERIFICA A OCORRENCIA DE /* (COMENTARIO)
                        } else if (currentChar == '*') {
                            try {
                                do {
                                    term += currentChar;
                                    currentChar = nextChar();
                                    if (currentChar == '*') {
                                        do {
                                            term += currentChar;
                                            currentChar = nextChar();
                                        } while (currentChar == '*');
                                        if (currentChar == '/') {
                                            term += currentChar;
                                            break;
                                        }
                                    }
                                } while (true);
                            } catch (Exception ex) {
                                break;
                            }
                            // Comentario(term);
                            term = "";

                        } else {
                            Divisao(term);
                            back();
                        }
                        do {
                            currentChar = nextChar();

                        } while (currentChar == ' ');
                        term = "";

                    //VERIFICA A OCORRENCIA DE >
                    } else if (currentChar == '>') {
                        term += currentChar;
                        Maior(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE <
                    } else if (currentChar == '<') {
                        term += currentChar;
                        Menor(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE !
                    } else if (currentChar == '!') {
                        term += currentChar;
                        NotLogico(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE ~
                    } else if (currentChar == '~') {
                        term += currentChar;
                        Complemento(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE ?
                    } else if (currentChar == '?') {
                        term += currentChar;
                        Ternario(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE &
                    } else if (currentChar == '&') {
                        term += currentChar;
                        AndLogico(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE |
                    } else if (currentChar == '|') {
                        term += currentChar;
                        OrLogico(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE ^
                    } else if (currentChar == '^') {
                        term += currentChar;
                        Xor(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A OCORRENCIA DE %
                    } else if (currentChar == '%') {
                        term += currentChar;
                        Resto(term);
                        do {
                            currentChar = nextChar();
                        } while (currentChar == ' ');
                        term = "";
                     //VERIFICA A SE É NÚMERO INTEIRO
                    } else if (isDigit(currentChar)) {
                        int v = 0;
                        do {
                            if (isDigit(currentChar)) {
                                term += currentChar;
                                currentChar = nextChar();
                              //VERIFICA SE PODE SER NUMERO DECIMAL
                                if (currentChar == '.') {

                                    currentChar = nextChar();

                                    if (isDigit(currentChar)) {
                                        term += '.';
                                        v = 1;
                                    } else {
                                        back();
                                        currentChar = '.';
                                        break;
                                    }
                                }
                            }

                        } while ((isDigit(currentChar) != false));
                        if (v == 0) {
                            Number(term);
                        } else {
                            NumberDec(term);
                            v = 0;
                        }
                        term = "";
                     //SE NEM 1 DAS OPCOES FOR VALIDA
                    } else {
                        estado = 0;
                        term = "";
                        break;
                    }
                    break;

            }

        }

    }
   //VERIFICA SE É COMENTARIO
    private boolean isComment(char c) {
        return c == '/';
    }
   //VERIFICA SE É DIGITO
    private boolean isDigit(char c) {
        return c >= '0' & c <= '9';
    }
   //VERIFICA SE É PARÊNTESES
    private boolean isRelatives(char c) {
        return c == '[' || c == ']' || c == '{' || c == '}';
    }
   //VERIFICA SE É CARACTER
    private boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c >= 'Z');
    }
   //VERIFICA SE É OPERADOR
    private boolean isOperator(char c) {
        return c == '>' || c == '<' || c == '=' || c == '!' || c == '+' || c == '-' || c == '~' || c == '?'
                || c == '&' || c == '|' || c == '^' || c == '%' || c == '*' || c == '/';
    }
   //VERIFICA SE É ESPAÇO
    private boolean isSpace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';

    }
   //AVANÇA PARA PROXIMO CARATER
    private char nextChar() {
        return content[pos++];
    }
   //VERIFICA SE É O FINAL DO ARQUIVO
    private boolean isEOF() {
        return pos == content.length;
    }
   //VOLTA UMA POSICAO NO CONTADOR DO ARQUIVO
    private void back() {
        pos--;
    }
}
