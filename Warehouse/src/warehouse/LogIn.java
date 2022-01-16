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
public class LogIn {
    Scanner input= new Scanner(System.in); 
 public String userName;
public String password;
public String emailAddres;

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

    public String getEmailAddres() {
        return emailAddres;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }

   
 
public void enroll(){
 System.out.println("------------------------------------------------");
        System.out.println("ثبت نام");
        System.out.println("لطفا یک نام کاربری انتخاب کنید");
      String inputUserName=input.next();
     setUserName(inputUserName);
        System.out.println("لطفا یک کلمه عبور انتخاب کنید"); 
      String inputPssword=input.next();   
    setPassword(inputPssword);
    System.out.println("لطفا ایمیل خود را وارد کنید");
    String inputEmailAddres=input.next();
    setEmailAddres(inputEmailAddres);
    System.out.println("لطفا چند لحظه صبر کنید");
    System.out.println("نام کار بری و رمز عبور به ایمیل شما ارسال شد");
}
}
