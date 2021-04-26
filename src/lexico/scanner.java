
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
  
    
    public scanner(String filename){
        try{
             
            txtConteudo = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);       
            System.out.println("------------  ANALISADOR LEXICO -----------");
            System.out.println(txtConteudo);    
            System.out.println("--------------------------------------------");
            txtConteudo = txtConteudo.toLowerCase(); 
            
            content = txtConteudo.toCharArray();
            pos = 0;
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

 
    public String ReturnConteudo(){
        return txtConteudo;
    }
    public tokens ReurnTokens(){
        return Token;
    }
    public void OpenRelatives(){
                     Token = new tokens();
                     Token.setType(Token.TK_OPEN_RELATIVES);
                     Token.setText("("); 
                     Retorna(Token);  
                     WriteToken(Token);
    }
     public void CloseRelatives(){
                     Token = new tokens();
                     Token.setType(Token.TK_CLOSE_RELATIVES);
                     Token.setText(")"); 
                     Retorna(Token);  
                     WriteToken(Token);
    }
     public void Semicolon(){
                     Token = new tokens();
                     Token.setType(Token.TK_SEMICOLON);
                     Token.setText(";"); 
                     Retorna(Token);  
                     WriteToken(Token);
    }
     public void Comma(){
                     Token = new tokens();
                     Token.setType(Token.TK_COMMA);
                     Token.setText(","); 
                     Retorna(Token); 
                     WriteToken(Token);
    }
    public void ABreto(){
                     Token = new tokens();
                     Token.setType(Token.TK_AB_RETO);
                     Token.setText("["); 
                     Retorna(Token);
                     WriteToken(Token);
    }
    public void FBreto(){
                     Token = new tokens();
                     Token.setType(Token.TK_FB_RETO);
                     Token.setText("]"); 
                     Retorna(Token);
                     WriteToken(Token);
    }
     public void Point(){
                     Token = new tokens();
                     Token.setType(Token.TK_POINT);
                     Token.setText("."); 
                     Retorna(Token);
                     WriteToken(Token);
    }
     public void OPchaves(){
                     Token = new tokens();
                     Token.setType(Token.TK_OPCHAVES);
                     Token.setText("{"); 
                     Retorna(Token); 
                     WriteToken(Token);
    }
     public void CSchaves(){
                     Token = new tokens();
                     Token.setType(Token.TK_CSCHAVES);
                     Token.setText("}"); 
                     Retorna(Token);
                     WriteToken(Token);
    }
     public void Number(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_NUMBER);
                     Token.setText(term); 
                     Retorna(Token);
                     WriteToken(Token);
    }
     public void Atribuicao(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_ATRIBUICAO);
                     Token.setText(term); 
                     Retorna(Token);  
    } public void Adicao(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_ADICAO);
                     Token.setText(term); 
                     Retorna(Token);
                     WriteToken(Token);
    }
     public void Subtracao(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_SUBTRACAO);
                     Token.setText(term); 
                     Retorna(Token);
                     WriteToken(Token);
    }
      public void Multiplicacao(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_MULTIPLICACAO);
                     Token.setText(term); 
                     Retorna(Token); 
                     WriteToken(Token);
    }
     public void Divisao(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_DIVISAO);
                     Token.setText(term); 
                     Retorna(Token);
                     WriteToken(Token);
    }
      public void Maior(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_MAIOR);
                     Token.setText(term); 
                     Retorna(Token);  
                     WriteToken(Token);
    }
       public void Menor(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_MENOR);
                     Token.setText(term); 
                     Retorna(Token);  
                     WriteToken(Token);
    }
        public void NotLogico(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_NOT_LOGICO);
                     Token.setText(term); 
                     Retorna(Token); 
                     WriteToken(Token);
    }
      public void Complemento(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_COMPLEMENTO);
                     Token.setText(term); 
                     Retorna(Token);  
                     WriteToken(Token);
    }
      public void Ternario(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_TERNARIO);
                     Token.setText(term); 
                     Retorna(Token);  
                     WriteToken(Token);
    }
      public void AndLogico(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_AND_LOGICO);
                     Token.setText(term); 
                     Retorna(Token); 
                     WriteToken(Token);
    }
      public void OrLogico(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_OR_LOGICO);
                     Token.setText(term); 
                     Retorna(Token);  
                     WriteToken(Token);
    }
      public void Xor(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_XOR);
                     Token.setText(term); 
                     Retorna(Token); 
                     WriteToken(Token);
    }
      public void Resto(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_RESTO);
                     Token.setText(term); 
                     Retorna(Token); 
                     WriteToken(Token);
    }
       public void Separador(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_SEPARADOR);
                     Token.setText(term); 
                     Retorna(Token);
                     WriteToken(Token);
    }
      public void Arroba(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_ARROBA);
                     Token.setText(term); 
                     Retorna(Token);  
                     WriteToken(Token);
    }
      public void Comentario(String term){
                     Token = new tokens();
                     Token.setType(Token.TK_COMENTARIO);
                     Token.setText(term); 
                     Retorna(Token); 
                     WriteToken(Token);
    }
      public void ComentarioPADRAO(char currentChar){
          String term="";        
          do{
                        do{
                             if((isChar(currentChar) || isComment(currentChar) || isDigit(currentChar) ||  isOperator(currentChar) || currentChar !=' ' || currentChar !='\t') && currentChar!='*'){
                               term +=currentChar; 
                               currentChar = nextChar();
                                
                             } 
                        }while(currentChar!='*');
                                term +=currentChar;
                                currentChar = nextChar();
                       }while(currentChar !='/');
                                term+=currentChar;
                                
                                System.out.println(term);
                                currentChar = nextChar();
                         
                                Token = new tokens();
                                Token.setType(Token.TK_COMENTARIO);
                                Token.setText(term);
                                Retorna(Token);
                                WriteToken(Token);
      }
     public void VerifyIDENT_OR_RESRV(String term){
                   term = term.trim();
                   Token = new tokens();
                   
                    if(term.equals("int") || term.equals("if") || term.equals("else") || term.equals("abstract") 
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
                            || term.equals("with") || term.equals("while")){
                          Token.setType(Token.TK_RESERVED_WORD);
                    }else if(term.contains("/")){
                        throw new LexicalException("Identificador Invalido");
                    }else{
                         Token.setType(Token.TK_IDENT); 
                    }              
                    Token.setText(term);
                    Retorna(Token);
                    WriteToken(Token);
                    
     }
    public void nextToken(){
        String term="";
        if(isEOF()){
             pos=0; 
        }
        estado=0;  
       
        currentChar = content[pos];
        while(pos<txtConteudo.length()) {
             
             if(currentChar == ' ' || isSpace(currentChar)){
                 currentChar=nextChar();
             }
           
            // System.out.println("Pos: "+pos+" CHAR: "+currentChar+" ESTADO: "+estado+"\n");
             switch (estado){
                 case 0:
                     //SE FOR IDENTIFICADOR OU PALAVRA RESERVADA
                     if(pos == 0){ currentChar =' '; }
                     
                     if(isChar(currentChar) && !isOperator(currentChar) && !isRelatives(currentChar)){
                        do{
                            if((isChar(currentChar) || isDigit(currentChar)) && !isRelatives(currentChar)){ 
                            term +=currentChar;
                            currentChar = nextChar();
                            }else{
                                break; 
                            }
                     }while(isChar(currentChar)!=false || isDigit(currentChar)!=false);
                        VerifyIDENT_OR_RESRV(term);
                        term="";
                       
                     } else if(currentChar=='"' || isSpace(currentChar) || currentChar=='\''){
                       if(isEOF()){
                           return;
                       }
                        do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                        term="";
                        
                      }else if(currentChar==':'){
                        term +=currentChar;
                         Separador(term);
                        
                        do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                        term="";
                        
                      }else if(currentChar=='@'){
                        term +=currentChar;
                         Separador(term);
                        
                        do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                        term="";
                        
                      }else if(currentChar=='('){
                       OpenRelatives();
                        term +=currentChar;
                        
                        do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                        term="";
                        
                      }else if(currentChar==')'){
                       CloseRelatives();
                       term +=currentChar;
                       
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar==';'){
                       Semicolon();
                       term +=currentChar;
                       
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar==','){
                       Comma();
                       term +=currentChar;
                       
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='{'){
                       OPchaves();
                       term +=currentChar;
                       
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='}'){
                       CSchaves();
                       term +=currentChar;
                       
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='['){
                       ABreto();
                       term +=currentChar;
                       
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar==']'){
                       FBreto();
                       term +=currentChar;
                       
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='.'){
                       Point();
                       term +=currentChar;
                       
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='+'){
                       term +=currentChar;
                       Adicao(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='-'){
                       term +=currentChar;
                       Subtracao(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='='){
                       term +=currentChar;
                       Atribuicao(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='*'){
                       term +=currentChar;
                       Multiplicacao(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='/'){
                          term +=currentChar;
                          
                          if(nextChar()=='/' && !isEOF()){
                           do{
                              if(isChar(currentChar) || isComment(currentChar) || isDigit(currentChar) ||  isOperator(currentChar) || currentChar !=' ' || currentChar !='\t' || currentChar !='*'){
                              term +=currentChar;
                              currentChar = nextChar();
                               }
                              }while(currentChar !='\n');
                              Comentario(term);
                              term="";
                              break;
                          }
                         else{
                               Divisao(term);
                          }    
                       
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='>'){
                       term +=currentChar;
                       Maior(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='<'){
                       term +=currentChar;
                       Menor(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='!'){
                       term +=currentChar;
                       NotLogico(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='~'){
                       term +=currentChar;
                       Complemento(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='?'){
                       term +=currentChar;
                       Ternario(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='&'){
                       term +=currentChar;
                       AndLogico(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='|'){
                       term +=currentChar;
                       OrLogico(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='^'){
                       term +=currentChar;
                       Xor(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(currentChar=='%'){
                       term +=currentChar;
                       Resto(term);
                       do{
                          currentChar = nextChar();
                        }while(currentChar==' ');
                       term="";

                      }else if(isDigit(currentChar) || currentChar=='.'){
                        do{
                            if(isDigit(currentChar) || currentChar=='.'){ 
                            term +=currentChar;
                            currentChar = nextChar();
                            }
                     }while((isDigit(currentChar)!=false) && (currentChar!='.'));
                        Number(term);
                        term="";
                       
                     }else{
                        estado = 0; term="";
                        break;
                     }
                break;
                
                     
            }

        }
     
    
    }
    
    private boolean isComment(char c){
        return c=='/';
    }
    private boolean isDigit(char c){
        return c>='0' & c<='9';
    }
    private boolean isRelatives(char c){
        return c=='[' || c==']' || c=='{' || c=='}';
    }
    private boolean isChar(char c){
        return (c>='a' && c<='z') || (c>='A' && c>='Z');
    }
    private boolean isOperator(char c){
        return c == '>' || c== '<' || c== '='|| c== '!' || c=='+' || c=='-' || c=='~' || c=='?'
                || c=='&' || c=='|' || c=='^' || c=='%' || c=='*' || c=='/';
    }
    private boolean isSpace(char c){
        return c==' ' || c== '\t' || c== '\n' || c== '\r';
       
    }
    private char nextChar(){
        return content[pos++];
    }
    private boolean isEOF(){
        return pos == content.length;
    }
    private void back(){
       pos--;
    }
}

//COMENTARIOS /* */ - / NUMEROS DECIMAIS