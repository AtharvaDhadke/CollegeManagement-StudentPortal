/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Atharva
 */
public class DataRetrieve {
   
    
    
    public static void main(String args[])
    {
        String ret_fname, ret_lname, ret_email, ret_phoneNo, ret_gender, ret_bloodGroup, ret_address ;
        String ret_fatherName, ret_motherName, ret_fatherNO,ret_motherNo, ret_fatherOcc, ret_motherOcc;
        String ret_dept,ret_year, ret_enroll, ret_percentage, ret_username;
        
       
        try
        {
            String test = "Harsh2426";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            PreparedStatement ps;
            
            String sql = "SELECT * FROM studentdb WHERE username='" + test + "'";
            ps = con.prepareStatement(sql);
            
            //Statement stmt = con.createStatement();
          
            ResultSet rs = ps.executeQuery ();
            while(rs.next())
            {
            ret_fname  = rs.getString("FIRST_NAME");
            ret_lname = rs.getString("LAST_NAME");
            ret_email = rs.getString("Email");
            ret_phoneNo = rs.getString("PhoneNo");
            ret_gender  = rs.getString("Gender");
            ret_bloodGroup    = rs.getString("BloodGroup");     
            ret_address       = rs.getString("Address");  
            ret_fatherName    = rs.getString("FatherName");   
            ret_motherName  =rs.getString("MotherName");                   
            ret_fatherNO     =rs.getString("FatherMobileNo");
            ret_motherNo   =rs.getString("MotherMobileNo");
            ret_fatherOcc =rs.getString("FatherOccupation");
            ret_motherOcc =rs.getString("MotherOccupation");
            ret_dept    =rs.getString("Department");
            ret_year    =rs.getString("Year");
            ret_enroll  =rs.getString("EnrollmentNo");
            ret_percentage  =rs.getString("Percentage");
            ret_username    =rs.getString("username");
            
            
            System.out.println(ret_fname);
             System.out.println(ret_lname);
              System.out.println(ret_email);
               System.out.println(ret_phoneNo);
                System.out.println(ret_gender);
                 System.out.println(ret_bloodGroup);
                  System.out.println(ret_address);
                   System.out.println(ret_fatherName);
                    System.out.println(ret_motherName);
                     System.out.println(ret_fatherNO);
                      System.out.println(ret_motherNo);
                       System.out.println(ret_fatherOcc);
                        System.out.println(ret_motherOcc);
                         System.out.println(ret_dept);
                          System.out.println(ret_year);
                           System.out.println(ret_enroll);
                            System.out.println(ret_percentage);
                             System.out.println(ret_username);    
            }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

}
