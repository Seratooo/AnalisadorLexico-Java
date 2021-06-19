/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author abubacar-dev
 */
public class SintaxeException extends RuntimeException{
    public static String errors="";
    public static int qnt=0;
    public static void SintaxeException(String msg){
        if(!errors.contains(msg)){
             //System.out.println(msg);
             errors+=msg+"\n";
             qnt++;
        }
       
    }
    public static void erros(){
        System.out.println();
        System.out.println(errors);
        System.out.println("Quantidade de Erros: "+qnt);
    }
}
