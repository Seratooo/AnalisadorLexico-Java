/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import exceptions.LexicalException;
import exceptions.SintaxeException;
import lexico.scanner;
import lexico.tokens;
import parser.isParser;

/**
 *
 * @author abubacar-dev
 */
public class ClassMain {
    public static void main(String[] args) {
        try{
                
        scanner sc = new scanner("/home/abubacar-dev/Documentos/arquivo.txt");
         sc.nextToken();
        isParser parser = new isParser(sc);
       // parser.E();
       // tokens.lista();
      //  parser.VarDeclaration();
      //parser.E();
     // parser.classFunc();
     //parser.MethodFunc();
    // parser.constructFunc();
    
    do{
        parser.VerifySintaxe();
    }while(true);
     
    //parser.importFunc();
    
        }catch(LexicalException ex){
              System.out.println("Erro Lexico: "+ ex.getMessage());
        }catch(SintaxeException ex){
              System.out.println("Erro Sitático: "+ ex.getMessage());
        }catch(Exception ex){
            System.out.println("AVISO: "+ex);
        }
    }
}
