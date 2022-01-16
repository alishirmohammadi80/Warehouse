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
public class Search {
      Scanner input=new Scanner(System.in);
   String nameKala;
   int codeKala;

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

      
   
   
    public void searchKala(){
         System.out.println("------------------------------------------------");
        System.out.println("نام کالای را وارد کنید"); 
        String inputName=input.next();
        setNameKala(inputName);
        
        
    }  
}
