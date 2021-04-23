/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import exceptions.LexicalException;
import lexico.scanner;
import lexico.tokens;

/**
 *
 * @author abubacar-dev
 */
public class ClassMain {
    public static void main(String[] args) {
        try{
   
        scanner sc = new scanner("/home/abubacar-dev/Documentos/arquivo.txt");
        sc.nextToken();
            
        }catch(LexicalException ex){
              System.out.println("Erro Lexico "+ ex.getMessage());
        }catch(Exception ex){
            System.out.println("AVISO: "+ex);
        }
    }
}
