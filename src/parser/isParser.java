/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import exceptions.SintaxeException;
import static exceptions.SintaxeException.SintaxeException;
import java.util.ArrayList;
import lexico.scanner;
import lexico.tokens;
import static lexico.tokens.listaDeTokens;

/**
 *
 * @author abubacar-dev
 */
public class isParser {

    private scanner isScanner;
    tokens token;
    int pos = 0;
    String modifiers = "public private static abstract final protected native synchronized transient volatile";
    String types = "int boolean float double string";
    String typesFunc = "int boolean float double string void";
    

    public isParser(scanner isScaner) {
        this.isScanner = isScaner;
    }

    //VERIFICANDO EXPRESSÕES
    public void E() {
        tokens tk = null;
        if (listaDeTokens.get(listaDeTokens.size() - 1).getType() == 18) {
            tk = listaDeTokens.get(listaDeTokens.size() - 1);
        }
        listaDeTokens.add(tk);
        T();
        El();
    }

    private void El() {
        token = listaDeTokens.get(pos);
        pos++;
        if (token != null) {
            OP();
            T();
            El();
        }

    }

    private void T() {
        token = listaDeTokens.get(pos);
        if (token.getType() != 0 && token.getType() != 1 && token.getType() != 2) {
            SintaxeException("Numero ou identificador experado na linha: " + token.getLine() + " : " + token.getText());

        }
        pos++;
    }

    private void OP() {
        if (token.getType() != 18 && token.getType() != 19 && token.getType() != 20 && token.getType() != 21) {
            SintaxeException("Operador inválido, na linha: " + token.getLine() + ": " + token.getText());
        }
    }

    //VERIFICANDO DECLARAÇÃO DE VARIÁVEIS
    public void VarDeclaration() {
        token = listaDeTokens.get(pos);
        if (!typesFunc.contains(token.getText())) {
            do{
                if(listaDeTokens.get(pos+1).getType()!=9){
                                        modifier(); 
                }else{
                    TypeFunc();
                    pos++;
                }
              
            }while(!typesFunc.contains(listaDeTokens.get(pos).getText()));
          //  pos--;
        }
       
        Identifier();
       if(listaDeTokens.get(pos+1).getType()!=9){
            methodDef();
            methodBody();
       }else{
        semicolun();
       }
    }

    private void Type() {
        token = listaDeTokens.get(pos);
        pos++;
        if (!types.contains(token.getText())){
            SintaxeException("Tipo de dados invalido: " + token.getLine() + " : " + token.getText());
        }
    }
    private void TypeFunc() {
        if(token.getType()==0){
            pos--;
        }
        token = listaDeTokens.get(pos);
        pos++;
        if (!typesFunc.contains(token.getText())){
            SintaxeException("Tipo de dados invalido na linha: " + token.getLine());
        }
        
    }

    private void Identifier() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 0) {
            SintaxeException("Identificador inválido na linha: " + token.getLine());
            
        }
    }
    
    String err = "";
     private void error(String msg) {
        pos++;
        token = listaDeTokens.get(pos);
        if(!err.equals(msg)){
            SintaxeException(msg);
            err=msg;
        }
    }

    //VERIFICANDO O PACKAGE
    public void packegeFunc() {
        Package();
        pos--;
        Identifier();
        semicolun();
    }

    private void Package() {

        token = listaDeTokens.get(pos);
        pos++;
        if (!"package".equals(token.getText())) {
            SintaxeException("Esperava a declaração do pacote na linha " + token.getLine());
        }
    }

    private void semicolun() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 9) {
           SintaxeException("Esperava um ponto e vírgula no final na linha " + token.getLine());
        }
    }

    private void comma() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 11) {
            SintaxeException("Esperava um vírgula na linha " + token.getLine());
        }
    }

    private void point() {

        token = listaDeTokens.get(pos);
        pos++;
        if (token.getType() != 10) {
          SintaxeException("Esperava um ponto na linha " + token.getLine());
        }
    }

    //Verificando IMPORT
    public void importFunc() {
        Import();
        ImportIdentifier();
        semicolun();
    }

    private void Import() {

        token = listaDeTokens.get(pos);
        pos++;
        if (!"import".equals(token.getText())) {
           SintaxeException("Esperava a declaração do import na linha " + token.getLine());
        }
    }

    private void ImportIdentifier() {
        token = listaDeTokens.get(pos);
        if (token.getType() == 0) {
            pos--;
            Identifier();
        } else {
            SintaxeException("Esperava um identificador na linha " + token.getLine());
           
        }
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() == 10) {
            point();
            ImportIdentifier();
        } else {
            pos--;
        }
    }
    //Verificando MODIFICADORES

    public void Modifiers() {
        modifier();
        ml();
        TypeFunc();
    }

    private void modifier() {
        token = listaDeTokens.get(pos);
        if(!typesFunc.contains(token.getText()) && !token.getText().equals("class")){
            if (!modifiers.contains(token.getText())) {
              SintaxeException("existe modificador invalido na linha " + token.getLine());
               pos++;
            }else{
               pos++;
            }
      }

    }

    private void ml() {
        token = listaDeTokens.get(pos);
        if (!typesFunc.contains(token.getText()) && token.getType()!=0) {
            modifier();
            ml();
        }
               
    }

    //Verificando Interface
    public void interfaceFunc() {
        token = listaDeTokens.get(pos);
        if (modifiers.contains(token.getText())) {
            Modifiers();
            pos--;
        }
        Interface();
    }

    private void Interface() {
        token = listaDeTokens.get(pos);
        if (!token.getText().equals("interface")) {
             SintaxeException("Esperava a delcaracao de interface na linha " + token.getLine());
             pos++;
        } else {
            pos++;
        }
        pos--;
        Identifier();
        if (listaDeTokens.get(pos + 1).getText().equals("extends")) {
            pos++;
            Extends();
        }
        interfaceBody();

    }

    private void interfaceBody() {
        abrirChaves();    
       /* do{
              if (modifiers.contains(listaDeTokens.get(pos + 1).getText()) && listaDeTokens.get(pos + 2).getType() != 0) {
                    int i = pos;

                  try{
                        do {
                              i++;
                         } while (listaDeTokens.get(i).getType() != 0);
                  }catch(Exception e){
                         pos++;
                         VarDeclaration();
                  }
                                        
                    if (listaDeTokens.get(i + 1).getType() == 7) {
                          pos++;
                          MethodFunc();
                    }else {
                          pos++;
                          VarDeclaration();
                    }
            }
              
            else if (types.contains(listaDeTokens.get(pos + 1).getText())
              && listaDeTokens.get(pos + 2).getType() == 0
              && listaDeTokens.get(pos + 3).getType() == 9) {
                pos++;
                VarDeclaration();
            }
                
          else if (listaDeTokens.get(pos + 1).getType() == 5
             && listaDeTokens.get(pos + 2).getType() == 0
             && listaDeTokens.get(pos + 3).getType() == 7) {
                pos++;
                MethodFunc();
            }
          else{
             pos++;
             VarDeclaration(); 
          }
           
        } while (listaDeTokens.get(pos + 1).getType() != 13);*/
      
        while (listaDeTokens.get(pos + 1).getType() != 13){
            //METODOS COM MODIFICADORES
            
            if ((modifiers.contains(listaDeTokens.get(pos + 1).getText()) && listaDeTokens.get(pos + 2).getType() == 0 && listaDeTokens.get(pos + 3).getType() == 7)
                    || (listaDeTokens.get(pos + 1).getType() == 0 && listaDeTokens.get(pos + 2).getType() == 7)) {
                pos++;
                constructFunc();
            }else{
                pos++;
                VarDeclaration();
            }
        }
        
        fecharChaves();
    }

    private void abrirChaves() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 12) {
           SintaxeException("Esperava abrir chaves na linha " + token.getLine());
        }
    }

    private void fecharChaves() {
        pos++;
        if (pos < listaDeTokens.size()) {
            token = listaDeTokens.get(pos);
            if (token.getType() != 13) {
              SintaxeException("Esperava fechar chaves na linha " + token.getLine());

            }
        } else {
         SintaxeException("Esperava fechar chaves na linha " + token.getLine());
        }
    }

    private void Extends() {
        token = listaDeTokens.get(pos);
        if (!token.getText().equals("extends")) {
           SintaxeException("Esperava extends na linha " + token.getLine());
           pos++;
        } else {
            pos++;
        }
        pos--;
        Identifier();
    }

    public void Implements() {
        token = listaDeTokens.get(pos);
        if (!token.getText().equals("implements")) {
           SintaxeException("Esperava implements na linha " + token.getLine());
           pos++;
        } else {
            pos++;
        }
        pos--;
        Identifier();
    }

    //VERIFICANDO CLASS
    public void classFunc() {
        modifier();
        Class();
    }

    private void Class() {
        token = listaDeTokens.get(pos);
        if (!token.getText().equals("class")) {
            SintaxeException("Esperava class na linha " + token.getLine());
        }
        Identifier();

        if (listaDeTokens.get(pos + 1).getText().equals("extends")) {
            pos++;
            Extends();
        }
        if (listaDeTokens.get(pos + 1).getText().equals("implements")) {
            pos++;
            Implements();
        }

        ClassBody();
    }

    private void ClassBody() {
        abrirChaves();

       while (listaDeTokens.get(pos + 1).getType() != 13){
            //METODOS COM MODIFICADORES
            
            if ((modifiers.contains(listaDeTokens.get(pos + 1).getText()) && listaDeTokens.get(pos + 2).getType() == 0 && listaDeTokens.get(pos + 3).getType() == 7)
                    || (listaDeTokens.get(pos + 1).getType() == 0 && listaDeTokens.get(pos + 2).getType() == 7)) {
                pos++;
                constructFunc();
            }else{
                System.out.println("HAY");
                pos++;
                VarDeclaration();
            }
        }
        
        fecharChaves();
    }

    //Verificando MÉTODOS
    public void MethodFunc() {
        token = listaDeTokens.get(pos);
        if (modifiers.contains(token.getText())) {
            Modifiers();
            pos--;
        }

        method();
        methodBody();
    }

    private void method() {
        TypeFunc();
        methodDef();
        if ("throws".equals(listaDeTokens.get(pos + 1).getText())) {
            pos++;
            Throws();
        }
    }

    private void Throws() {
        token = listaDeTokens.get(pos);
        if (!token.getText().equals("throws")) {
           SintaxeException("Esperava throws na linha " + token.getLine());
           pos++;
        }
        pos--;
        Identifier();
    }
    
    private void methodBody() {
      
        if(listaDeTokens.get(pos+1).getType()==9){
            semicolun();
        }else{
                        
            abrirChaves();
            
           /* try{
            
            do{
                //VARIAVEL LOCAL
             if (types.contains(listaDeTokens.get(pos + 1).getText())
                    && listaDeTokens.get(pos + 2).getType() == 0
                    && listaDeTokens.get(pos + 3).getType() == 9) {
                pos++;
                VarDeclaration();
            }
                
            } while (listaDeTokens.get(pos + 1).getType() != 13);
            
            }catch(Exception e){
               // fecharChaves(); 
            }*/
            while (listaDeTokens.get(pos + 1).getType() != 13){
            //METODOS COM MODIFICADORES
            
            if ((modifiers.contains(listaDeTokens.get(pos + 1).getText()) && listaDeTokens.get(pos + 2).getType() == 0 && listaDeTokens.get(pos + 3).getType() == 7)
                    || (listaDeTokens.get(pos + 1).getType() == 0 && listaDeTokens.get(pos + 2).getType() == 7)) {
                pos++;
                constructFunc();
            }else{
                pos++;
                VarDeclaration();
            }
            }
        
            
            fecharChaves(); 
        }
       
       
    }

    private void methodDef() {
        pos--;
        Identifier();
        AbrirParenteses();
        if (listaDeTokens.get(pos + 1).getType() == 5) {
            pos++;
            ParamList();
        }
        FecharParentes();

    }

    private void AbrirParenteses() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 7) {
          SintaxeException("Esperava abrir parenteses na linha " + token.getLine());

        }
    }

    private void FecharParentes() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 8) {
         SintaxeException("Esperava fechar parenteses na linha " + token.getLine());

        }
    }

    private void ParamList() {

        Param();
        ParamListLinha();
    }

    private void ParamListLinha() {
        if (listaDeTokens.get(pos).getType() == 11) {
            pos++;
            Param();
            ParamListLinha();
        } else {
            pos--;
        }
    }

    private void Param() {
        Type();
        pos--;
        Identifier();
        pos++;
    }

    //VERIFICANDO CONSTRUTOR
    public void constructFunc() {
        token = listaDeTokens.get(pos);
        if (modifiers.contains(listaDeTokens.get(pos).getText()) && listaDeTokens.get(pos+1).getType()==0) {
            modifier();
            Construct();
            if ("throws".equals(listaDeTokens.get(pos + 2).getText())) {
                    pos++;
                    Throws();
            }

            constructBody();
        }
        else if(listaDeTokens.get(pos).getType()==0 && listaDeTokens.get(pos+1).getType()==7){
            Construct();
             if ("throws".equals(listaDeTokens.get(pos + 1).getText())) {
                    pos++;
                    Throws();
            }

            constructBody();
        }else{
            SintaxeException("Sintaxe para construtor errada na linha "+token.getLine());
        }
       
    }

    private void Construct() {
        pos--;
        Identifier();
        AbrirParenteses();
        if (listaDeTokens.get(pos + 1).getType() == 5) {
            pos++;
            ParamList();
        }
        FecharParentes();
    }

    private void constructBody() {
        abrirChaves();
        fecharChaves();
    }

    private void callTheNext() {
        pos++;
        token = listaDeTokens.get(pos);
    }

    public void VerifySintaxe() {
        token = listaDeTokens.get(pos);
        while (true) {

            if (token.getText().contains("package")) {
                do {
                    packegeFunc();
                } while (token.getType() != 9);
                callTheNext();
            }

           else if (token.getText().contains("import")) {
                do {
                    importFunc();
                } while (token.getType() != 9);
                callTheNext();
            }

           else if (modifiers.contains(token.getText())) {
                if (listaDeTokens.get(pos + 1).getText().equals("class")) {
                    do {
                        classFunc();   
                    } while (token.getType() != 13);
                    callTheNext();
                }
                
                else{
                 classFunc();
                }

            }
            
          else  if(token.getText().contains("interface")){
                do{
                    interfaceFunc(); 
                }while(token.getType() != 13);
                callTheNext();
            }
          else{
              pos--;
              error("Palavra não reconhecida na linha "+token.getLine());
              callTheNext();
          }

        }
    }

}
