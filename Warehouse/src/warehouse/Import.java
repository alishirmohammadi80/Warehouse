/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import java.util.Scanner;

/**
 *
 * @author RASHA
 */
public class Import {
     Scanner input=new Scanner(System.in);
     public String nameKala;
  public int codeKala;
  public int tadadKala;

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getNameKala() {
        return nameKala;
    }

    public void setNameKala(String nameKala) {
        this.nameKala = nameKala;
    }

    public int getCodeKala() {
        return codeKala;
    }

    public void setCodeKala(int codeKala) {
        this.codeKala = codeKala;
    }

    public int getTadadKala() {
        return tadadKala;
    }

    public void setTadadKala(int tadadKala) {
        this.tadadKala = tadadKala;
    }

   

    
    
    public void importKala(){
         System.out.println("------------------------------------------------");
        System.out.println("نام کالا را وارد کنید");   
        String inputNameKala=input.next();
        setNameKala(inputNameKala);
        System.out.println("تعداد کالا را وارد کنید");
        int inputTadadKala=input.nextInt();
        setTadadKala(inputTadadKala);
        System.out.println("کد کالا را وارد کنید");
       int inputCodeKala=input.nextInt();
        setCodeKala(inputCodeKala);
        
        
    } 
    
   
    
    
    
}
