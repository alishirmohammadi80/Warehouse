
package warehouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author RASHA
 */
public class Database {
    public static void main(String[] args) {
     Scanner input=new Scanner(System.in);
        try {
            
             Class.forName("org.sqlite.JDBC");

Connection a = DriverManager.getConnection("jdbc:sqlite:Database_DB.db"); 
  Statement statment=a.createStatement();
//   table User_Table
//     String createTable="CREATE TABLE User("
//                    + "userName varchar(60),"
//                    + "password varchar(60),"
//                      +  "email varchar(60));";
//           statment.executeUpdate(createTable);
//====================================
////teble Kala
// String createTable="CREATE TABLE Kala("
//                    + "NAME varchar(60),"
//                    + "TADAD_KALA int,"
//                    + "CODE_KALA int);";
//        statment.executeUpdate(createTable);
//=========================================
Time tim=new Time();
Time.showTime(args);
//a------------------------------------------------------------------------------
LogIn log=new LogIn();
log.enroll();
String userName=log.getUserName();
String pasword=log.getPassword();
String email=log.getEmailAddres();

 String insertIntoUser="INSERT INTO User(userName,password,email) VALUES('%s','%s','%s') ";
insertIntoUser=String.format(insertIntoUser,userName,pasword,email);
statment.execute(insertIntoUser);
//------------------------------------------------------------------------------
   GmailService Gmail=new GmailService();
            Gmail.send("Enroll gmail",email,"user_name is:"+ userName+"\t"+"--"+"pasword is :"+pasword);
//------------------------------------------------------------------------------

Enter enter=new Enter();
enter.login();
            if (enter.getUserName().equalsIgnoreCase(log.getUserName())) {
                System.out.println("شما با موفقیت وارد شدید");
            } else {
                System.out.println("نام کار بری یا کلمه عبور اشتباه است ");
                System.out.println("دوباره تلاش کنید");
                enter.login();
            }

//------------------------------------------------------------------------------

boolean runMenu=true;
            do {                
                showMenu();
                int result=input.nextInt();
                switch(result){
//------------------------------------------------------------------------------                    
                  case 1:
                          Import object=new Import();
        System.out.println("------------------------------------------------");                  
                      System.out.println("1)ثبت کالای جدید"); 
                      System.out.println("2)اضافه کردن تعداد کالاهای موجود");
                      int natige=input.nextInt();
                      switch(natige){
//******************************************************************************                          
                       case 1:
                           object.importKala();
                           String name=object.getNameKala();
                             int tadad=object.getTadadKala();
                             int code=object.getCodeKala();
   String insertIntoKalaTeble ="INSERT INTO Kala(NAME,TADAD_KALA,CODE_KALA) VALUES('%s','%d','%d') ";
insertIntoKalaTeble=String.format(insertIntoKalaTeble, name,tadad,code);
statment.execute(insertIntoKalaTeble);
                          break;
//******************************************************************************                          
                        case 2:
                            object.importKala();
                           String namekala=object.getNameKala();
                            String select="SELECT * FROM Kala WHERE NAME='%s';";
                    select=String.format(select,namekala);
            ResultSet rs1 = statment.executeQuery(select);
                     
            while (rs1.next()) {
               int tadadKala=rs1.getInt("TADAD_KALA");
                tadadKala=tadadKala+object.getTadadKala();

   String updateKala="UPDATE Kala SET TADAD_KALA = '%d' WHERE  NAME='%s'; ";
updateKala=String.format(updateKala, tadadKala,namekala);
statment.executeUpdate(updateKala);
            
            }
//******************************************************************************                      
            break;
                          
                      } 
break;
//------------------------------------------------------------------------------
                 case 2:         
                         Delete dlite=new Delete();
                         dlite.deleteMenu();
                           String nameKala=dlite.getNameKala();
                            String selectKala="SELECT * FROM Kala WHERE NAME='%s';";
                   selectKala=String.format(selectKala,nameKala);
            ResultSet rs2 = statment.executeQuery(selectKala);
                     
            while (rs2.next()) {
               int tadadKala=rs2.getInt("TADAD_KALA");
                tadadKala=tadadKala-dlite.getTadadKala();

   String updateTableKala="UPDATE Kala SET TADAD_KALA = '%d' WHERE  NAME='%s'; ";
updateTableKala=String.format(updateTableKala, tadadKala,dlite.getNameKala());
statment.executeUpdate(updateTableKala);
            
            }

               break;
//------------------------------------------------------------------------------                     
                 case 3:
                     String show= "select * from  Kala;";
            ResultSet rs3 = statment.executeQuery(show);
                     System.out.println("name"+"\t"+"tadad"+"\t"+"code");
            while (rs3.next()) {
                
                String name_kala = rs3.getString("NAME");
               int tadadKala=rs3.getInt("TADAD_KALA");
               int codeKala=rs3.getInt("CODE_KALA");
                System.out.println(name_kala + "\t" + tadadKala + "\t"+codeKala );
            }
            break;
//------------------------------------------------------------------------------            
                 case 4:
                  Search serch=new Search();
                serch.searchKala();
                  String searchNatige=serch.getNameKala();
   String selectTableKala="SELECT * FROM Kala WHERE NAME='%s';";
                    selectTableKala=String.format(selectTableKala,searchNatige);
            ResultSet rs4 = statment.executeQuery(selectTableKala);
                     System.out.println("name"+"\t"+"tadad"+"\t"+"code");
            while (rs4.next()) {
                
                String namekala = rs4.getString("NAME");
               int tadadKala=rs4.getInt("TADAD_KALA");
               int codeKala=rs4.getInt("CODE_KALA");
                System.out.println(namekala + "\t" + tadadKala + "\t"+codeKala );

            }
                  
                    break;
//------------------------------------------------------------------------------                     
                case 5:
                     System.out.println("------------------------------------------------");
                    System.out.println("نام کالا را وارد کنید");
                    String Delete=input.next();
                    String delete="DELETE FROM Kala WHERE Name='%s';";
                    delete=String.format(delete,Delete);
                    statment.executeUpdate(delete);
                    break;
//------------------------------------------------------------------------------                    
                 case 6:
                  runMenu=false;   
                    break;
//------------------------------------------------------------------------------                    
                }
                
                
            } while (runMenu);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
        public static void showMenu(){
         System.out.println("------------------------------------------------");
       System.out.println("1)ثبت کالا");   
       System.out.println("2)خارج کردن کالا");
       System.out.println("3)نمایش کلا های موجود");
       System.out.println("4)جستوجوی کالا");
        System.out.println("5)حذف کالا");
       System.out.println("6)خروج از برنامه");
       System.out.print(":"+"لطفا یک گزینه را انتخاب کنید");
     
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
