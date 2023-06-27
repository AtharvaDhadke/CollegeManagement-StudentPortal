/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

/**
 *
 * @author Atharva
 */

import java.awt.Color;
import java.awt.Frame;
import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.filechooser.FileNameExtensionFilter;




public class Student_RegAdmin extends javax.swing.JFrame {
    
     String fname , lname ,email, phone ,gender , bloodgroup , address, father_name ,
             mother_name, father_no , mother_no , father_occ , mother_occ , dept , year,
             enroll , percentage , username ,password , conf_password ,bdate;
     
     static String imagepath;
     
     boolean once = false; 
     
      private Color redColor = new Color(204,51,0);
       private int mouseX;
    private int mouseY;
    
    private byte byteImage[];
    /**
     * Creates new form Student_Reg
     */
    public Student_RegAdmin() {
        initComponents();
    }
    
    boolean validation()
    {
        fname=tf_firstname.getText();
        lname=tf_lastname.getText();
        email=tf_email.getText();
        phone=tf_phoneno.getText();
        gender=(String)cmb_gender.getSelectedItem();
        bloodgroup=(String)cmb_bloodgroup.getSelectedItem();
        address=ta_address.getText();
        imagepath= txtImagePath.getText();
        
        
        father_name=tf_fathername.getText();
        mother_name=tf_mothername.getText();
        father_no=tf_fatherno.getText();
        mother_no=tf_motherno.getText();
        father_occ=tf_fatherocc.getText();
        mother_occ=tf_motherocc.getText();
            
        dept=(String)cmb_dept.getSelectedItem();
        year=(String)cmb_year.getSelectedItem();
        enroll=tf_enroll.getText();
        percentage=tf_percentage.getText();
        username=tf_username.getText();
        password=tf_password.getText();
        conf_password=tf_confpass.getText();
        
        try
        {
    //   Date selectedDate = JDateChooser1.getDate();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        //bdate = dateformat.format(selectedDate);
        }
        catch(Exception e){}
       

        
        if(fname.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Name", "Error", JOptionPane.ERROR_MESSAGE);
            tf_firstname.grabFocus();
            return false;
        }
        if(lname.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your  Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            tf_lastname.grabFocus();
            return false;
        }
        if(email.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Email", "Error", JOptionPane.ERROR_MESSAGE);
            tf_email.grabFocus();
         
            return false;
        }
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", tf_email.getText()))) 
            {
            JOptionPane.showMessageDialog(null, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
            tf_email.grabFocus();
            return false;
            }
        
        
        if(phone.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Phone number", "Error", JOptionPane.ERROR_MESSAGE);
            tf_phoneno.grabFocus();
            return false;
        }
        if(address.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Address", "Error", JOptionPane.ERROR_MESSAGE);
            ta_address.grabFocus();
            return false;
        }
        if(father_name.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Father's Name", "Error", JOptionPane.ERROR_MESSAGE);
            tf_fathername.grabFocus();
            return false;
        }
        
        if(mother_name.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Mother's Name", "Error", JOptionPane.ERROR_MESSAGE);
            tf_mothername.grabFocus();
            return false;
        }
        if(father_no.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Father's Number", "Error", JOptionPane.ERROR_MESSAGE);
            tf_fatherno.grabFocus();
            return false;
        }
        
        if(mother_no.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Mother's Number", "Error", JOptionPane.ERROR_MESSAGE);
            tf_motherno.grabFocus();
            return false;
        }
        if(father_occ.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Father's Ocuupation", "Error", JOptionPane.ERROR_MESSAGE);
            tf_fatherocc.grabFocus();
            return false;
        }
        if(mother_occ.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Mother's Ocuupation", "Error", JOptionPane.ERROR_MESSAGE);
            tf_motherocc.grabFocus();
            return false;
        }
        
        if(enroll.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Enrollment Number", "Error", JOptionPane.ERROR_MESSAGE);
            tf_enroll.grabFocus();
            return false;
        }
        
        if(percentage.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Percentage", "Error", JOptionPane.ERROR_MESSAGE);
            tf_percentage.grabFocus();
            return false;
        }
        
        if(username.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Username", "Error", JOptionPane.ERROR_MESSAGE);
            tf_username.grabFocus();
            return false;
        }
        
        if(password.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Pssword", "Error", JOptionPane.ERROR_MESSAGE);
            tf_password.grabFocus();
            return false;
        }
        
        if(conf_password.trim().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please Enter Your Confirm Pssword", "Error", JOptionPane.ERROR_MESSAGE);
            tf_confpass.grabFocus();
            return false;
        }
        
         if(!password.equals( conf_password))
        {
            JOptionPane.showMessageDialog(null, "Password Does not match", "Error", JOptionPane.ERROR_MESSAGE);
            tf_confpass.grabFocus();
            return false;
        }
        return true;
    
    }
    
    public void checkPassword()
    {   
       password=tf_password.getText();
      if(password.length()<8)
        {   
            lbl_pass_error.setText("!Password should be 8 digit");
        }
      else
        {
            lbl_pass_error.setText("");
        }             
    }
    
    public void checkPhone()
    {   
        phone=tf_phoneno.getText();
        //int i=Integer.parseInt(phone);
       
      if(phone.length()==10)
        {   
            lbl_phone_error.setText("");
            tf_phoneno.setEditable(false);
        }
     
      else
        {
            lbl_phone_error.setText("! Phone number should be 10 digit");
           
        }
      
    }
    
    public void checkPhone_Father()
    {   
        father_no=tf_fatherno.getText();
        //int i=Integer.parseInt(phone);
       
      if(father_no.length()==10)
        {   
            lbl_phone_error_father.setText("");
            tf_fatherno.setEditable(false);
        }
     
      else
        {
            lbl_phone_error_father.setText("!Phone number should be 10 digit");
           
        }
      
    }
    
    public void checkPhone_Mother()
    {   
        mother_no=tf_motherno.getText();
        //int i=Integer.parseInt(phone);
       
      if(mother_no.length()==10)
        {   
            lbl_phone_error_mother.setText("");
            tf_motherno.setEditable(false);
        }
     
      else
        {
            lbl_phone_error_mother.setText("!Phone number should be 10 digit");
           
        }
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_submit = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        tf_percentage = new javax.swing.JTextField();
        cmb_year = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cmb_dept = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tf_enroll = new javax.swing.JTextField();
        tf_confpass = new javax.swing.JPasswordField();
        jLabel22 = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        jLabel23 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        lbl_pass_error = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_mothername = new javax.swing.JTextField();
        tf_fathername = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_fatherno = new javax.swing.JTextField();
        tf_motherno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tf_fatherocc = new javax.swing.JTextField();
        tf_motherocc = new javax.swing.JTextField();
        lbl_phone_error_father = new javax.swing.JLabel();
        lbl_phone_error_mother = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        photo_label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_firstname = new javax.swing.JTextField();
        tf_lastname = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_phoneno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_address = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        cmb_bloodgroup = new javax.swing.JComboBox<>();
        cmb_gender = new javax.swing.JComboBox<>();
        txtImagePath = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lbl_phone_error = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 65));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_submit.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 830, 140, 40));

        btn_reset.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 830, 130, 40));

        btn_back.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btn_back.setText("< Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        getContentPane().add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 830, 120, 40));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Academic Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel17.setText("Percentage Score :");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 220, 37));

        tf_percentage.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel4.add(tf_percentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 250, 40));

        cmb_year.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cmb_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Year", "Second Year", "Third Year" }));
        jPanel4.add(cmb_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 250, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setText("Academic Year :");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 50));

        cmb_dept.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cmb_dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer", "Mechanical", "Electrical", "Civil" }));
        jPanel4.add(cmb_dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 250, 40));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel19.setText("Department :");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 158, 37));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel20.setText("Enrollment No :");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 190, 37));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setText("Password :");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 70, 170, 50));

        tf_enroll.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel4.add(tf_enroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 250, 40));

        tf_confpass.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel4.add(tf_confpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 150, 210, 40));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setText("Confirm Password :");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 150, 220, -1));

        tf_password.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tf_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_passwordKeyReleased(evt);
            }
        });
        jPanel4.add(tf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 80, 210, 40));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setText("Username :");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 27, -1, 30));

        tf_username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 20, 200, 40));

        lbl_pass_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_pass_error.setText(" ");
        jPanel4.add(lbl_pass_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 120, 300, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 1520, 210));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parents Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel11.setText("Father Name :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 32, 212, 43));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel12.setText("Mother Name :");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 100, 212, 43));

        tf_mothername.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel3.add(tf_mothername, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 105, 255, 43));

        tf_fathername.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel3.add(tf_fathername, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 37, 255, 43));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel13.setText("Father Mobile No :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 231, 45));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel14.setText("Mother Mobile No :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 230, 43));

        tf_fatherno.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tf_fatherno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_fathernoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_fathernoKeyReleased(evt);
            }
        });
        jPanel3.add(tf_fatherno, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 240, 40));

        tf_motherno.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tf_motherno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_mothernoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_mothernoKeyReleased(evt);
            }
        });
        jPanel3.add(tf_motherno, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 102, 240, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel15.setText("Occupation :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, 180, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel16.setText("Occupation :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, 180, 40));

        tf_fatherocc.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tf_fatherocc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fatheroccActionPerformed(evt);
            }
        });
        jPanel3.add(tf_fatherocc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 40, 230, 40));

        tf_motherocc.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel3.add(tf_motherocc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 102, 230, 40));

        lbl_phone_error_father.setForeground(new java.awt.Color(255, 0, 0));
        lbl_phone_error_father.setText(" ");
        jPanel3.add(lbl_phone_error_father, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 280, -1));

        lbl_phone_error_mother.setForeground(new java.awt.Color(255, 0, 0));
        lbl_phone_error_mother.setText(" ");
        jPanel3.add(lbl_phone_error_mother, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 260, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 1520, 160));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Registration");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photo_label.setBackground(new java.awt.Color(255, 255, 255));
        photo_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(photo_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 10, 168, 162));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel3.setText("First Name :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel4.setText("Last Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 92, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Email :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 162, -1, -1));

        tf_firstname.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel2.add(tf_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 21, 250, 40));

        tf_lastname.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel2.add(tf_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 250, 40));

        tf_email.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jPanel2.add(tf_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 158, 250, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel6.setText("Phone No :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 29, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel7.setText("Gender :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 88, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel8.setText("Address :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 23, -1, -1));

        tf_phoneno.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        tf_phoneno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_phonenoActionPerformed(evt);
            }
        });
        tf_phoneno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_phonenoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_phonenoKeyReleased(evt);
            }
        });
        jPanel2.add(tf_phoneno, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 21, 220, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 182, 117, 30));

        ta_address.setColumns(20);
        ta_address.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        ta_address.setLineWrap(true);
        ta_address.setRows(5);
        ta_address.setWrapStyleWord(true);
        jScrollPane1.setViewportView(ta_address);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 13, 220, 100));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel10.setText("Blood Group :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 149, 166, 40));

        cmb_bloodgroup.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cmb_bloodgroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A +", "A -", "B +", "B -", "AB +", "AB -", "O +", "O -" }));
        jPanel2.add(cmb_bloodgroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 149, 220, 40));

        cmb_gender.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cmb_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel2.add(cmb_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 81, 220, 50));

        txtImagePath.setEditable(false);
        jPanel2.add(txtImagePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 178, 220, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Image Path :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(949, 182, 119, -1));

        lbl_phone_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_phone_error.setText(" ");
        jPanel2.add(lbl_phone_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 300, -1));

        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText(" ");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 270, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel25.setText("D.O.B  :");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 130, 100, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 1520, 230));

        jLabel2.setBackground(new java.awt.Color(255, 102, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/university/portal/books_bg.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1600, 830));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 820, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel6MouseDragged(evt);
            }
        });
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("—");
        jLabel27.setOpaque(true);
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });

        lblClose.setBackground(new java.awt.Color(255, 255, 255));
        lblClose.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 0, 0));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.setOpaque(true);
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(51, 51, 51));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("University Portal");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 1442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClose))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("JPEG files","jpeg","jpg"));
        chooser.showOpenDialog(this);
        File sourceFile = chooser.getSelectedFile();
        if(sourceFile != null){
            String sourceFilePath = sourceFile.getAbsolutePath();
            txtImagePath.setText(sourceFilePath);
            BufferedImage thumbnail;
            try{
                thumbnail = Thumbnails.of(sourceFile).size(221,250).asBufferedImage();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(thumbnail, "jpg", baos);
                byteImage = baos.toByteArray();
                
                photo_label.setIcon(new ImageIcon(thumbnail));
            } catch(IOException e){
            
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_phonenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_phonenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_phonenoActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        tf_firstname.setText("");
        tf_lastname.setText("");
        tf_email.setText("");
        tf_phoneno.setText("");
        cmb_gender.setSelectedIndex(0);
        cmb_bloodgroup.setSelectedIndex(0);
        ta_address.setText("");
        
        tf_fathername.setText("");
        tf_mothername.setText("");
        tf_fatherno.setText("");
        tf_motherno.setText("");
        tf_fatherocc.setText("");
        tf_motherocc.setText("");
        
        cmb_dept.setSelectedIndex(0);
        cmb_year.setSelectedIndex(0);
        tf_enroll.setText("");
        tf_percentage.setText("");
        tf_username.setText("");
        tf_password.setText("");
        tf_confpass.setText("");
        
    }//GEN-LAST:event_btn_resetActionPerformed

    private void tf_fatheroccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fatheroccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_fatheroccActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        validation();
     
        
        PreparedStatement ps;
       
        String query ="INSERT INTO `studentdb`(`First_Name`, `Last_Name`, `Email`, `PhoneNo`, `Gender`, `BloodGroup`, `Address`, `DOB`, `ImagePath`, `Image`, `FatherName`, `MotherName`, `FatherMobileNo`, `MotherMobileNo`, `FatherOccupation`, `MotherOccupation`, `Department`, `Year`, `EnrollmentNo`, `Percentage`, `username`, `Password`) Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            
             ps.setString(1, fname);
             ps.setString(2, lname);
             ps.setString(3, email);
             ps.setString(4, phone);
             ps.setString(5, gender);           
             ps.setString(6, bloodgroup);
             ps.setString(7, address);
             ps.setString(8, bdate);
             ps.setString(9, imagepath);
             ps.setBytes(10, byteImage);  
             ps.setString(11, father_name);
             ps.setString(12, mother_name);
             ps.setString(13, father_no);
             ps.setString(14,mother_no );
             ps.setString(15, father_occ);
             ps.setString(16, mother_occ);
             ps.setString(17, dept);
             ps.setString(18, year);
             ps.setString(19, enroll);
             ps.setString(20, percentage);
             ps.setString(21, username);
             ps.setString(22, password);
          
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Inserted In SQL");
                new Student_Login().setVisible(true);
                this.dispose();
            }
         
            
        } catch(SQLException ex)
        {
//              Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
//        ****************************************************************************************
        if(once == false){  
         try
        {   
          
            String valueToSearch = username;
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
           
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM studentdb  ");
            while(rs.next())
            {
                     boolean isExists = false;
                   String[] usernamedata = {rs.getString("username")};
             
                        for (int i = 0; i < usernamedata.length; i++) {   
                            
                            String arrayValue = usernamedata[i];
      
                            if (valueToSearch.equals(arrayValue)) {
                               isExists = true;   
                                JOptionPane.showMessageDialog(null, "Username Not accepted. Please try different Username");
                                  break;
                            }
                        }             
            }
            
            once = true;
        }
    
        catch(Exception e){}
       
     }
        
     
    }//GEN-LAST:event_btn_submitActionPerformed
  

    
    private void tf_phonenoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_phonenoKeyPressed
        // TODO add your handling code here:
        
        
        char c = evt.getKeyChar();
        if(Character.isLetter(c))
        {
            tf_phoneno.setEditable(false);
        }
        
        else
        {
            tf_phoneno.setEditable(true);
 
        }
    }//GEN-LAST:event_tf_phonenoKeyPressed

    private void tf_phonenoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_phonenoKeyReleased
        // TODO add your handling code here:
        checkPhone();
    }//GEN-LAST:event_tf_phonenoKeyReleased

    private void tf_fathernoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_fathernoKeyReleased
        // TODO add your handling code here:
        checkPhone_Father();
    }//GEN-LAST:event_tf_fathernoKeyReleased

    private void tf_mothernoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_mothernoKeyReleased
        // TODO add your handling code here:
        checkPhone_Mother();
    }//GEN-LAST:event_tf_mothernoKeyReleased

    private void tf_fathernoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_fathernoKeyPressed
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if(Character.isLetter(c))
        {
            tf_fatherno.setEditable(false);
        }
        
        else
        {
            tf_fatherno.setEditable(true);
 
        }
    }//GEN-LAST:event_tf_fathernoKeyPressed

    private void tf_mothernoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_mothernoKeyPressed
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if(Character.isLetter(c))
        {
            tf_motherno.setEditable(false);
        }
        
        else
        {
            tf_motherno.setEditable(true);
 
        }
    }//GEN-LAST:event_tf_mothernoKeyPressed

    private void tf_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_passwordKeyPressed
        // TODO add your handling code here:
        checkPassword();
    }//GEN-LAST:event_tf_passwordKeyPressed

    private void tf_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_passwordKeyReleased
        // TODO add your handling code here:
        checkPassword();
    }//GEN-LAST:event_tf_passwordKeyReleased

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        
         new Admin_StudentProfile().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:

        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        // TODO add your handling code here:
        jLabel23.setBackground(new Color(229, 229, 229));
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        // TODO add your handling code here:

        jLabel23.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel27MouseExited

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Close", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (ans == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        // TODO add your handling code here:

        lblClose.setBackground(redColor);
        lblClose.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        // TODO add your handling code here:
        lblClose.setBackground(Color.WHITE);
        lblClose.setForeground(redColor);
    }//GEN-LAST:event_lblCloseMouseExited

    private void jPanel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseDragged
        // TODO add your handling code here:

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - mouseX, y - mouseY);
    }//GEN-LAST:event_jPanel6MouseDragged

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        // TODO add your handling code here:

        this.mouseX = evt.getX();
        this.mouseY = evt.getY();
    }//GEN-LAST:event_jPanel6MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student_RegAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_RegAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_RegAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_RegAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_RegAdmin().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox<String> cmb_bloodgroup;
    private javax.swing.JComboBox<String> cmb_dept;
    private javax.swing.JComboBox<String> cmb_gender;
    private javax.swing.JComboBox<String> cmb_year;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_pass_error;
    private javax.swing.JLabel lbl_phone_error;
    private javax.swing.JLabel lbl_phone_error_father;
    private javax.swing.JLabel lbl_phone_error_mother;
    private javax.swing.JLabel photo_label;
    private javax.swing.JTextArea ta_address;
    private javax.swing.JPasswordField tf_confpass;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_enroll;
    private javax.swing.JTextField tf_fathername;
    private javax.swing.JTextField tf_fatherno;
    private javax.swing.JTextField tf_fatherocc;
    private javax.swing.JTextField tf_firstname;
    private javax.swing.JTextField tf_lastname;
    private javax.swing.JTextField tf_mothername;
    private javax.swing.JTextField tf_motherno;
    private javax.swing.JTextField tf_motherocc;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_percentage;
    private javax.swing.JTextField tf_phoneno;
    private javax.swing.JTextField tf_username;
    private javax.swing.JTextField txtImagePath;
    // End of variables declaration//GEN-END:variables
    
      
}

