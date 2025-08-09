/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseConnection;

import admin.AdminPanel;
import getterAndSetter.RegisterModel;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author iesha
 */
public class DbOperation {
   public static ResultSet login(String email1,String pass1){
           
   {
       ResultSet rs = null;
        try {
            Database dbc = new Database();
            Connection conn = dbc.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("select * from register where email=? and password =?");
            ps.setString(1, email1);
            ps.setString(2, pass1);
            
             rs = ps.executeQuery();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
   }
}
   public static boolean register(RegisterModel reg)
   {
       boolean status = false;
        try {
            Database dbc = new Database();
           Connection conn =  dbc.getConnection();
           
            PreparedStatement ps = conn.prepareStatement("insert into register values(?,?,?,?,?,?) ");
            ps.setString(1, reg.getName());
            ps.setString(2, reg.getEmail());
            ps.setString(3, reg.getPassword());
            ps.setString(4, reg.getGender());
            ps.setString(5, reg.getPhoneno());
            ps.setString(6, reg.getModule());
            
          int i = ps.executeUpdate();
          if(i>0)
          {
              status = true;
          }
          else{
              status = false;
          }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
   }
   public static ResultSet showAllEmpsData()
   {
       ResultSet rs = null;
       try {
           Database dbc = new Database();
           Connection conn = dbc.getConnection();
           
           PreparedStatement ps = conn.prepareStatement("select * from register where module = 'employee'");
            rs = ps.executeQuery();
           
       } catch (Exception e) {
           System.out.println(e);
       }
       return rs;
   }
   public static ResultSet getSelectedEmployee(String email)
   {ResultSet rs = null;
       try {
           Database dbc = new Database();
           Connection conn = dbc.getConnection();
           PreparedStatement ps = conn.prepareStatement("select * from register where email = ?");
           ps.setString(1, email);
            rs = ps.executeQuery();
           
       } catch (Exception e) {
           System.out.println(e);
       }
       return rs;
   }
   public static int updateEmpDetails(RegisterModel reg)
   {int i=0;
       try {
           Database dbc = new Database();
           Connection conn = dbc.getConnection();
           PreparedStatement ps = conn.prepareStatement("update register set name = ?,password = ?, gender = ?,phone_no = ? where email = ?");
           ps.setString(1, reg.getName());
           ps.setString(2, reg.getPassword());
           ps.setString(3, reg.getGender());
           ps.setString(4, reg.getPhoneno());
           ps.setString(5, reg.getEmail());
           
           i = ps.executeUpdate();
           
       } catch (Exception e) {
           System.out.println(e);
       }
       return i;
   }
   public static int deleteEmpDetails( String email)
   {int i=0;
       try {
           Database dbc = new Database();
           Connection conn = dbc.getConnection();
           PreparedStatement ps = conn.prepareStatement("delete from register where email = ?");
           ps.setString(1,email);
           i = ps.executeUpdate();
       } catch (Exception e) {
           System.out.println(e);
       }
       return i;
   }
   public static boolean insertImageDetails(FileInputStream fis, String... str)
   {
       boolean status = false;
       try {
           Database dbc = new Database();
           Connection conn = dbc.getConnection();
           PreparedStatement ps = conn.prepareStatement("insert into items values(?,?,?,?,?,?)");
           ps.setString(1, str[0]);
           ps.setString(2, str[1]);
           ps.setString(3, str[2]);
           ps.setString(4, str[3]);
           ps.setString(5, str[4]);
           ps.setBinaryStream(6, fis);
           
           int i = ps.executeUpdate();
           if(i>0)
           {
               status = true;
           }
           else{
               status = false;
           }
           
           
       } catch (Exception e) {
           System.out.println(e);
       }
       return status;
   }
  public static int changePasswordAdmin(String email1, String oldPassword, String newPassword, String confirmPassword) {
    int i = 0;
    try {
        Database dbc = new Database();
        Connection conn = dbc.getConnection();
        PreparedStatement ps = conn.prepareStatement("update register set password = ? where email = ? and password = ? and module = 'admin'");
        ps.setString(1, newPassword);
        ps.setString(2, email1);
        ps.setString(3, oldPassword);
        i = ps.executeUpdate();
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
    return i;
}
  public static int changePasswordEmp(String email,String oldPassword,String newPassword)
  {
      int i = 0;
      try {
          Database dbc = new Database();
          Connection conn = dbc.getConnection();
          PreparedStatement ps = conn.prepareStatement("update register set password = ? where email = ? and password = ? and module = 'employee'");
          ps.setString(1, newPassword);
          ps.setString(2, email);
          ps.setString(3, oldPassword);
          i = ps.executeUpdate();
      } catch (Exception e) {
          System.out.println(e);
      }
      return i;
  }
  public static ResultSet showAllItemData()
  {
      ResultSet rs = null;
      try {
          Database dbc = new Database();
          Connection conn = dbc.getConnection();
          PreparedStatement ps = conn.prepareStatement("select * from items");
          rs = ps.executeQuery();
      } catch (Exception e) {
          System.out.println(e);
      }
      return rs;
  }
  public static ResultSet getSelectedItem(String item_id)
  {
      ResultSet rs = null;
      try {
          Database dbc = new Database();
          Connection conn = dbc.getConnection();
          PreparedStatement ps = conn.prepareStatement("select * from items where item_id = ?");
          ps.setString(1, item_id);
           rs = ps.executeQuery();
      } catch (Exception e) {
          System.out.println(e);
      }
      return rs;
  }
  public static boolean updateItems(FileInputStream fis,String itemName,String itemId,String itemPrice,String itemDesc,String itemCategory)
  {
      boolean status = false;
      try {
          Database dbc = new Database();
          Connection conn = dbc.getConnection();
          PreparedStatement ps = conn.prepareStatement("update items set item_name = ?,item_price = ?,item_category = ?,item_desc = ?,item_img = ? where item_id=?");
          ps.setString(1,itemName);
           ps.setString(2,itemPrice);
           ps.setString(3,itemCategory);
           ps.setString(4,itemDesc);
           ps.setBinaryStream(5,fis);
           ps.setString(6, itemId);
           int i = ps.executeUpdate();
           if(i>0)
           {
               status = true;
           }
           else{
               status = false;
           }
           
      } catch (Exception e) 
      {
          System.out.println(e);
      }
      return status;
  }
   public static int deleteItemDetails( String itemId)
   {int i=0;
       try {
           Database dbc = new Database();
           Connection conn = dbc.getConnection();
           PreparedStatement ps = conn.prepareStatement("delete from items where item_id = ?");
           ps.setString(1,itemId);
           i = ps.executeUpdate();
       } catch (Exception e) {
           System.out.println(e);
       }
       return i;
   }
  public static int changePasswordByEmp(String email,String oldPassword,String newPassword)
  {
      int i = 0;
      try {
          Database dbc = new Database();
          Connection conn = dbc.getConnection();
          PreparedStatement ps = conn.prepareStatement("update register set password = ? where email = ? and password = ? and module = 'employee'");
          ps.setString(1, newPassword);
          ps.setString(2, email);
          ps.setString(3, oldPassword);
          i = ps.executeUpdate();
      } catch (Exception e) {
          System.out.println(e);
      }
      return i;
  }
  public static ResultSet viewAllEmployeeByEmployee()
  {  ResultSet rs = null;
      try {
          Database dbc = new Database();
          Connection conn = dbc.getConnection();
          PreparedStatement ps = conn.prepareStatement("select * from register where module = 'employee'");
          rs = ps.executeQuery();
      } catch (Exception e) {
          System.out.println(e);
      }
      return rs;
  }
  public static int updateMyProfile(String name,String email,String phoneno,String gender)
  { int i = 0;
      try {
           Database dbc = new Database();
      Connection conn = dbc.getConnection();
      PreparedStatement ps = conn.prepareStatement("update register set name = ?,phone_no = ?,gender = ? where email = ? and module = 'employee'");
      ps.setString(1, name);
      ps.setString(2, phoneno);
      ps.setString(3, gender);
      ps.setString(4, email);
      i = ps.executeUpdate();
      } 
      catch (Exception e) {
          System.out.println(e);
      }
      return i;
  }
  public static boolean insertCustomerDetails(String... d)
  {
      boolean status  = false;
      String name1 = d[0];
      String email1 = d[1];
      String pass1 = d[2];
      String gender1 = d[3];
      String phno1 = d[4];
      String module1 = d[5];
      try {
          Database dbc = new Database();
          Connection conn = dbc.getConnection();
          PreparedStatement ps = conn.prepareStatement("insert into register values(?,?,?,?,?,?)");
          ps.setString(1, name1);
          ps.setString(2, email1);
          ps.setString(3, pass1);
          ps.setString(4, gender1);
          ps.setString(5, phno1);
          ps.setString(6, module1);
          int i = ps.executeUpdate();
          if(i>0)
          {
            status = true;  
          }
          else{
              status = false;
          }
      } catch (Exception e) {
          System.out.println(e);
      }
      return status;
  }
  public static ResultSet checkCustomerExists(String phno1)
  {
      ResultSet rs = null;
      try {
      Database dbc = new Database();
      Connection conn = dbc.getConnection();
      PreparedStatement ps = conn.prepareStatement("select * from register where phone_no = ?");
      ps.setString(1, phno1);
      rs = ps.executeQuery();
      
      
      } catch (Exception e) {
          System.out.println(e);
      }
      return rs;
  }
}
