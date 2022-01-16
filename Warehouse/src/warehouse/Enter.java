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
public class Enter {
       Scanner input=new Scanner(System.in);
    public  String userName;
    public String password;

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public void login(){
     System.out.println("----------------------------------------------------"); 
        System.out.println("نام کاربری");
     String inputUserName=input.next();
        setUserName(inputUserName);
        System.out.println("کلمه عبور");
     String inputPassword=input.next();
        setPassword(inputPassword);
        
    }
}
