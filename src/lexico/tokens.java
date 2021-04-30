
package lexico;

/**
 *
 * @author abubacar-dev
 */
public class tokens {
    //TOKENS DA LINGUAGEM
    public static final int TK_IDENT            = 0;
    public static final int TK_NUMBER           = 1;
    public static final int TK_NUMBER_DEC       = 2;
    public static final int TK_RESERVED_WORD    = 5;
    public static final int TK_OPEN_RELATIVES   = 7;
    public static final int TK_CLOSE_RELATIVES  = 8;
    public static final int TK_SEMICOLON        = 9;
    public static final int TK_POINT            = 10;
    public static final int TK_COMMA            = 11;
    public static final int TK_OPCHAVES         = 12;
    public static final int TK_CSCHAVES         = 13;
    public static final int TK_FB_RETO          = 14;
    public static final int TK_AB_RETO          = 15;
    public static final int TK_COMENTARIO       = 16;
    public static final int TK_ATRIBUICAO       = 17;
    public static final int TK_ADICAO           = 18;
    public static final int TK_SUBTRACAO        = 19;
    public static final int TK_MULTIPLICACAO    = 20;
    public static final int TK_DIVISAO          = 21;
    public static final int TK_MAIOR            = 22;
    public static final int TK_MENOR            = 23;
    public static final int TK_NOT_LOGICO       = 24;
    public static final int TK_COMPLEMENTO      = 25;
    public static final int TK_TERNARIO         = 26;
    public static final int TK_AND_LOGICO       = 27;
    public static final int TK_OR_LOGICO        = 28;
    public static final int TK_XOR              = 29;
    public static final int TK_RESTO            = 30;
    public static final int TK_SEPARADOR        = 31;
    public static final int TK_ARROBA           = 32;
    

    private int type;
    private String text;
   
     
    public tokens(){
        super();
    }

    @Override
    public String toString() {
        return "tokens {" + "type=" + type + ", text=" + text + '}';
    }
    public static void Retorna(tokens tk){
 
         switch(tk.getType()){
             case 0: 
                 System.out.println("TOK_IDENTIFICADOR ---------  -------- LEXEMA: "+tk.getText());
             break;
             case 1: 
                 System.out.println("TOK_NUM-INT ------------------------- LEXEMA: "+tk.getText());
             break;
             case 2: 
                 System.out.println("TOK_NUM-DEC ------------------------- LEXEMA: "+tk.getText());
             break;
             case 5: 
                 System.out.println("TOK_"+tk.getText().toUpperCase()+" ------------------------- LEXEMA: "+tk.getText());
             break;
             case 7: 
                 System.out.println("TOK_A-PARANTESES -------------------- LEXEMA: "+tk.getText());
             break;
             case 8: 
                 System.out.println("TOK_F-PARENTESES -------------------- LEXEMA: "+tk.getText());
             break;
             case 9: 
                 System.out.println("TOK_P-VIRGULA ----------------------- LEXEMA: "+tk.getText());
             break;
             case 10: 
                 System.out.println("TOK_PONTO --------------------------- LEXEMA: "+tk.getText());
             break;
             case 11: 
                 System.out.println("TOK_VIRGULA ------------------------- LEXEMA: "+tk.getText());
             break;
             case 12: 
                 System.out.println("TOK_A-CHAVES ------------------------ LEXEMA: "+tk.getText());
             break;
             case 13: 
                 System.out.println("TOK_F-CHAVES ------------------------ LEXEMA: "+tk.getText());
             break;
             case 14: 
                 System.out.println("TOK_FP-RETO ------------------------- LEXEMA: "+tk.getText());
             break;
             case 15: 
                 System.out.println("TOK_AB-RETO ------------------------- LEXEMA: "+tk.getText());
             break;
             case 16: 
                 System.out.println("TOK_COMENTARIO ---------------------- LEXEMA: "+tk.getText());
             break;
             case 17: 
                 System.out.println("TOK_ATRIBUICAO ---------------------- LEXEMA: "+tk.getText());
             break;
             case 18: 
                 System.out.println("TOK_ADICAO -------------------------- LEXEMA: "+tk.getText());
             break;
             case 19: 
                 System.out.println("TOK_SUBTRACAO ----------------------- LEXEMA: "+tk.getText());
             break;
             case 21: 
                 System.out.println("TOK_DIVISAO -------------------------- LEXEMA: "+tk.getText());
             break;
             case 20: 
                 System.out.println("TOK_MULTIPLICACAO -------------------- LEXEMA: "+tk.getText());
             break;
             case 22: 
                 System.out.println("TOK_MAIOR ----------------------------- LEXEMA: "+tk.getText());
             break;
             case 23: 
                 System.out.println("TOK_MENOR ----------------------------- LEXEMA: "+tk.getText());
             break;
             case 24: 
                 System.out.println("TOK_NOT ------------------------------- LEXEMA: "+tk.getText());
             break;
             case 25: 
                 System.out.println("TOK_COMPLEMENTO ----------------------- LEXEMA: "+tk.getText());
             break;
             case 26: 
                 System.out.println("TOK_TERNARIO --------------------------- LEXEMA: "+tk.getText());
             break;
             case 27: 
                 System.out.println("TOK_AND -------------------------------- LEXEMA: "+tk.getText());
             break;
             case 28: 
                 System.out.println("TOK_OR --------------------------------- LEXEMA: "+tk.getText());
             break;
             case 29: 
                 System.out.println("TOK_XOR -------------------------------- LEXEMA: "+tk.getText());
             break;
             case 30: 
                 System.out.println("TOK_RESTO ------------------------------- LEXEMA: "+tk.getText());
             break;
             case 31: 
                 System.out.println("TOK_SEPARADOR --------------------------- LEXEMA: "+tk.getText());
             break;
             case 32: 
                 System.out.println("TOK_ARROBA ------------------------------ LEXEMA: "+tk.getText());
             break;
         }
    }
    
   
    public void setType(int type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public tokens(int type, String text) {
        super();
        this.type = type;
        this.text = text;
    }
    
    
}
