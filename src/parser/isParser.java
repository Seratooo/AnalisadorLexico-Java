/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import exceptions.SintaxeException;
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
            throw new SintaxeException("Numero ou identificador experado na linha: " + token.getLine() + " : " + token.getText());

        }
        pos++;
    }

    private void OP() {
        if (token.getType() != 18 && token.getType() != 19 && token.getType() != 20 && token.getType() != 21) {
            throw new SintaxeException("Operador inválido, na linha: " + token.getLine() + ": " + token.getText());
        }
    }

    //VERIFICANDO DECLARAÇÃO DE VARIÁVEIS
    public void VarDeclaration() {
        token = listaDeTokens.get(pos);
        if (modifiers.contains(token.getText())) {
            Modifiers();
            pos--;
        }

        Type();
        Identifier();
        semicolun();
    }

    private void Type() {
        token = listaDeTokens.get(pos);
        pos++;
        if (token.getType() != 5) {
            throw new SintaxeException("Tipo de dados invalido: " + token.getLine() + " : " + token.getText());
        }
    }

    private void Identifier() {
        token = listaDeTokens.get(pos);
        if (token.getType() != 0) {
            throw new SintaxeException("Identificador inválido: " + token.getLine() + " : " + token.getText());

        }
    }

    //VERIFICANDO O PACKAGE
    public void packegeFunc() {
        Package();
        Identifier();
        semicolun();
    }

    private void Package() {

        token = listaDeTokens.get(pos);
        pos++;
        if (!"package".equals(token.getText())) {
            throw new SintaxeException("Esperava a declaração do pacote na linha " + token.getLine() + " encontrei : " + token.getText());
        }
    }

    private void semicolun() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 9) {
            throw new SintaxeException("Esperava um ponto e vírgula no final na linha " + token.getLine() + " encontrei : " + token.getText());
        }
    }

    private void comma() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 11) {
            throw new SintaxeException("Esperava um vírgula na linha " + token.getLine() + " encontrei : " + token.getText());
        }
    }

    private void point() {

        token = listaDeTokens.get(pos);
        pos++;
        if (token.getType() != 10) {
            throw new SintaxeException("Esperava um ponto na linha " + token.getLine() + " encontrei : " + token.getText());
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
            throw new SintaxeException("Esperava a declaração do import na linha " + token.getLine() + " encontrei : " + token.getText());
        }
    }

    private void ImportIdentifier() {
        token = listaDeTokens.get(pos);
        if (token.getType() == 0) {
            Identifier();
        } else {
            throw new SintaxeException("Esperava um identificador na linha " + token.getLine() + " encontrei : " + token.getText());
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
        Type();
    }

    private void modifier() {
        token = listaDeTokens.get(pos);
        pos++;
        if (!modifiers.contains(token.getText())) {
            throw new SintaxeException("Esperava um modificador valido na linha " + token.getLine() + " encontrei : " + token.getText());
        }
        // if(modifiers.contains(token.getText())){
        //     modifiers = modifiers.replaceAll(token.getText(), "");
        // }
    }

    private void ml() {
        if (listaDeTokens.get(pos).getType() != 0 && !"int".equals(listaDeTokens.get(pos).getText())
                && !"interface".equals(listaDeTokens.get(pos).getText()) && !"class".equals(listaDeTokens.get(pos).getText())
                && !"void".equals(listaDeTokens.get(pos).getText())) {
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
            throw new SintaxeException("Esperava a delcaracao de interface na linha " + token.getLine() + " encontrei : " + token.getText());
        } else {
            pos++;
        }
        Identifier();
        if (listaDeTokens.get(pos + 1).getText().equals("extends")) {
            pos++;
            Extends();
        }
        interfaceBody();

    }

    private void interfaceBody() {
        abrirChaves();    
        do{
              if (modifiers.contains(listaDeTokens.get(pos + 1).getText()) && listaDeTokens.get(pos + 2).getType() != 0) {
                    int i = pos;
                    do {
                          i++;
                     } while (listaDeTokens.get(i).getType() != 0);

                    if (listaDeTokens.get(i + 1).getType() == 7) {
                          pos++;
                          MethodFunc();
                    } else {
                          pos++;
                          VarDeclaration();
                    }
            }
              
            if (types.contains(listaDeTokens.get(pos + 1).getText())
              && listaDeTokens.get(pos + 2).getType() == 0
              && listaDeTokens.get(pos + 3).getType() == 9) {
                pos++;
                VarDeclaration();
            }
                
           if (listaDeTokens.get(pos + 1).getType() == 5
             && listaDeTokens.get(pos + 2).getType() == 0
             && listaDeTokens.get(pos + 3).getType() == 7) {
                pos++;
                MethodFunc();
            }
           
        } while (listaDeTokens.get(pos + 1).getType() != 13);
        fecharChaves();
    }

    private void abrirChaves() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 12) {
            throw new SintaxeException("Esperava abrir chaves na linha " + token.getLine() + " encontrei : " + token.getText());

        }
    }

    private void fecharChaves() {
        pos++;
        if (pos < listaDeTokens.size()) {
            token = listaDeTokens.get(pos);
            if (token.getType() != 13) {
                throw new SintaxeException("Esperava fechar chaves na linha " + token.getLine() + " encontrei : " + token.getText());

            }
        } else {
            throw new SintaxeException("Esperava fechar chaves na linha " + token.getLine());
        }
    }

    private void Extends() {
        token = listaDeTokens.get(pos);
        if (!token.getText().equals("extends")) {
            throw new SintaxeException("Esperava extends na linha " + token.getLine() + " encontrei : " + token.getText());
        } else {
            pos++;
        }
        Identifier();
    }

    public void Implements() {
        token = listaDeTokens.get(pos);
        if (!token.getText().equals("implements")) {
            throw new SintaxeException("Esperava implements na linha " + token.getLine() + " encontrei : " + token.getText());
        } else {
            pos++;
        }
        Identifier();
    }

    //VERIFICANDO CLASS
    public void classFunc() {
        Modifiers();
        Class();
    }

    private void Class() {
        pos--;
        token = listaDeTokens.get(pos);
        if (!token.getText().equals("class")) {
            throw new SintaxeException("Esperava class na linha " + token.getLine() + " encontrei : " + token.getText());
        } else {
            pos++;
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

        do {
            //METODOS COM MODIFICADORES
            if ((modifiers.contains(listaDeTokens.get(pos + 1).getText()) && listaDeTokens.get(pos + 2).getType() == 0)
                    || listaDeTokens.get(pos + 1).getType() == 0) {
                pos++;
                constructFunc();
            }
            
            if (modifiers.contains(listaDeTokens.get(pos + 1).getText()) && listaDeTokens.get(pos + 2).getType() != 0) {
                int i = pos;
                do {
                    i++;
                } while (listaDeTokens.get(i).getType() != 0);

                if (listaDeTokens.get(i + 1).getType() == 7) {
                    pos++;
                    MethodFunc();
                } else {
                    pos++;
                    VarDeclaration();
                }
            }
         //METODOS E DECLARACOES SEM MODIFICADORES DE ACESSO
            if (types.contains(listaDeTokens.get(pos + 1).getText())
                    && listaDeTokens.get(pos + 2).getType() == 0
                    && listaDeTokens.get(pos + 3).getType() == 9) {
                pos++;
                VarDeclaration();
            }

            if (listaDeTokens.get(pos + 1).getType() == 5
                    && listaDeTokens.get(pos + 2).getType() == 0
                    && listaDeTokens.get(pos + 3).getType() == 7) {
                pos++;
                MethodFunc();
            }

        } while (listaDeTokens.get(pos + 1).getType() != 13);

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
        Type();
        methodDef();
        if ("throws".equals(listaDeTokens.get(pos + 1).getText())) {
            pos++;
            Throws();
        }
    }

    private void Throws() {
        token = listaDeTokens.get(pos);
        if (!token.getText().equals("throws")) {
            throw new SintaxeException("Esperava throws na linha " + token.getLine() + " encontrei : " + token.getText());
        }
        pos++;
        Identifier();
    }
    
    private void methodBody() {
       
        if(listaDeTokens.get(pos+1).getType()==9){
            semicolun();
        }else{
            abrirChaves();
            
            do{
                //VARIAVEL LOCAL
             if (types.contains(listaDeTokens.get(pos + 1).getText())
                    && listaDeTokens.get(pos + 2).getType() == 0
                    && listaDeTokens.get(pos + 3).getType() == 9) {
                pos++;
                VarDeclaration();
            }
                
            } while (listaDeTokens.get(pos + 1).getType() != 13);
            
            fecharChaves(); 
        }
       
       
    }

    private void methodDef() {
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
            throw new SintaxeException("Esperava abrir parenteses na linha " + token.getLine() + " encontrei : " + token.getText());

        }
    }

    private void FecharParentes() {
        pos++;
        token = listaDeTokens.get(pos);
        if (token.getType() != 8) {
            throw new SintaxeException("Esperava fechar parenteses na linha " + token.getLine() + " encontrei : " + token.getText());

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
        Identifier();
        pos++;
    }

    //VERIFICANDO CONSTRUTOR
    public void constructFunc() {
        if (modifiers.contains(listaDeTokens.get(pos).getText())) {
            modifier();
        }
        Construct();
        if ("throws".equals(listaDeTokens.get(pos + 1).getText())) {
            pos++;
            Throws();
        }

        constructBody();
    }

    private void Construct() {
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

            if (token.getText().equals("package")) {
                do {
                    packegeFunc();
                } while (token.getType() != 9);
                callTheNext();
            }

            if (token.getText().equals("import")) {
                do {
                    importFunc();
                } while (token.getType() != 9);
                callTheNext();
            }

            if (modifiers.contains(token.getText())) {
                if (listaDeTokens.get(pos + 1).getText().equals("class")) {
                    do {
                        classFunc();
                    } while (token.getType() != 13);
                    callTheNext();
                }

            }
            
            if(token.getText().equals("interface")){
                do{
                    interfaceFunc(); 
                }while(token.getType() != 13);
                callTheNext();
            }

        }
    }

}
