/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author RASHA
 */
public class Time {
    public static void showTime(String[] args) {
         
   Date dNow = new Date();
      SimpleDateFormat ft = 
      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
      System.out.println( ft.format(dNow));   
    }
    
    
    
    
    
}
