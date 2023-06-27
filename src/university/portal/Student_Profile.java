package university.portal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Atharva 
 */
public class Student_Profile extends javax.swing.JFrame {
    /**
     * Creates new form Student_Profile
     */
   static String ret_fname, ret_lname, ret_email, ret_phoneNo, ret_gender, ret_bloodGroup, ret_address , ret_password;
   static String ret_fatherName, ret_motherName, ret_fatherNO,ret_motherNo, ret_fatherOcc, ret_motherOcc;
   static String ret_dept,ret_year, ret_enroll, ret_percentage, ret_username ;
  
    static byte byteImage[];
      private Color redColor = new Color(204,51,0);
      
       private int mouseX;
    private int mouseY;
      
    public Student_Profile() {
        initComponents();
        lbl_username.setText(FirstPage.username);
        try
        {
            String test = FirstPage.username;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            PreparedStatement ps;
            
            String sql = "SELECT * FROM studentdb WHERE username='" + test + "'";
            ps = con.prepareStatement(sql);
            
          
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
            ret_password    =rs.getString("Password");
//            dob = rs.getString("DOB");
             
            
            lbl_studentname.setText(ret_fname + " " + ret_lname);
            lbl_email.setText(ret_email);
            lbl_number.setText(ret_phoneNo);
            lbl_gender.setText(ret_gender);
            lbl_bloodgrp.setText(ret_bloodGroup);
            lbl_address.setText(ret_address);
            lbl_fathername.setText(ret_fatherName);
            lbl_mothername.setText(ret_motherName);
            lbl_fathercontact.setText(ret_fatherNO);
            lbl_mothercontact.setText(ret_motherNo);
            lbl_fatherocc.setText(ret_fatherOcc);
            lbl_motherocc.setText(ret_motherOcc);
            lbl_dept.setText(ret_dept);
            lbl_year.setText(ret_year);
            lbl_enroll.setText(ret_enroll);
            lbl_percentage.setText(ret_percentage);
            lbl_username.setText(ret_username);
//            lbl_dob.setText(dob);
            
            byteImage = rs.getBytes("Image");
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(byteImage));
            ImageIcon icon = new ImageIcon(image);
            lbl_photo.setIcon(icon);
            
            }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        lbl_leftLibrary = new javax.swing.JLabel();
        lbl_back = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_photo = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        lbl_number = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_bloodgrp = new javax.swing.JLabel();
        lbl_fathername = new javax.swing.JLabel();
        lbl_fathercontact = new javax.swing.JLabel();
        lbl_fatherocc = new javax.swing.JLabel();
        lbl_mothername = new javax.swing.JLabel();
        lbl_mothercontact = new javax.swing.JLabel();
        lbl_motherocc = new javax.swing.JLabel();
        lbl_dept = new javax.swing.JLabel();
        lbl_enroll = new javax.swing.JLabel();
        lbl_year = new javax.swing.JLabel();
        lbl_percentage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbl_address = new javax.swing.JTextArea();
        lbl_editbtn = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(58, 63, 67));
        jPanel7.setPreferredSize(new java.awt.Dimension(400, 850));

        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\final admin .png")); // NOI18N
        jLabel23.setText("jLabel19");

        lbl_username.setBackground(new java.awt.Color(0, 0, 0));
        lbl_username.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_username.setOpaque(true);

        lbl_leftLibrary.setBackground(new java.awt.Color(58, 63, 67));
        lbl_leftLibrary.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_leftLibrary.setForeground(new java.awt.Color(255, 255, 255));
        lbl_leftLibrary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_leftLibrary.setText("Library Management");
        lbl_leftLibrary.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_leftLibrary.setOpaque(true);
        lbl_leftLibrary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_leftLibraryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_leftLibraryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_leftLibraryMouseExited(evt);
            }
        });

        lbl_back.setBackground(new java.awt.Color(153, 153, 153));
        lbl_back.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_back.setText("BACK");
        lbl_back.setOpaque(true);
        lbl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_backMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_backMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_backMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
            .addComponent(lbl_leftLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(lbl_leftLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
                .addComponent(lbl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 900));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel2.setText("Student Name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 89, -1, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel3.setText("Phone Number :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 254, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel4.setText("Gender :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 142, -1, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel5.setText("Blood Group :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 314, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel6.setText("Email :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 202, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel7.setText("Mother's Name :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 641, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel8.setText("Address :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 118, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel9.setText("Mother's Contact No :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 701, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel10.setText("Faher's Name :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 641, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel11.setText("Mother's Occupation : ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 761, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel12.setText("Father's Contact No :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 701, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel13.setText("Father's Occupation : ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 761, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel17.setText("Department :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 941, -1, -1));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 891, -1, -1));

        jPanel4.setBackground(new java.awt.Color(122, 125, 128));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STUDENT PROFILE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(422, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(346, 346, 346))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, -1));

        jPanel5.setBackground(new java.awt.Color(122, 125, 128));
        jPanel5.setPreferredSize(new java.awt.Dimension(1200, 70));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Parents Details");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(483, 483, 483))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 551, 1222, -1));

        jPanel6.setBackground(new java.awt.Color(122, 125, 128));
        jPanel6.setPreferredSize(new java.awt.Dimension(1200, 70));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Academic Details");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(463, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(478, 478, 478))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 841, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel19.setText("Year :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 1001, -1, 40));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel20.setText("Percentage :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1011, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel21.setText("Enrollment No. :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 941, -1, -1));

        lbl_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(942, 104, 227, 244));

        lbl_studentname.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lbl_studentname.setText(" ");
        jPanel1.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 92, 660, -1));

        lbl_gender.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lbl_gender.setText(" ");
        jPanel1.add(lbl_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 145, 290, -1));

        lbl_number.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lbl_number.setText("     ");
        jPanel1.add(lbl_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 254, 290, -1));

        lbl_email.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lbl_email.setText("    ");
        jPanel1.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 202, 600, -1));

        lbl_bloodgrp.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lbl_bloodgrp.setText(" ");
        jPanel1.add(lbl_bloodgrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 314, 340, -1));

        lbl_fathername.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbl_fathername.setText(" ");
        jPanel1.add(lbl_fathername, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 641, 280, -1));

        lbl_fathercontact.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbl_fathercontact.setText(" ");
        jPanel1.add(lbl_fathercontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 701, 260, -1));

        lbl_fatherocc.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbl_fatherocc.setText(" ");
        jPanel1.add(lbl_fatherocc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 761, 280, -1));

        lbl_mothername.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbl_mothername.setText(" ");
        jPanel1.add(lbl_mothername, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 641, 240, -1));

        lbl_mothercontact.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbl_mothercontact.setText(" ");
        jPanel1.add(lbl_mothercontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 701, 240, -1));

        lbl_motherocc.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbl_motherocc.setText(" ");
        jPanel1.add(lbl_motherocc, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 761, 210, -1));

        lbl_dept.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lbl_dept.setText(" ");
        jPanel1.add(lbl_dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 941, 250, -1));

        lbl_enroll.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lbl_enroll.setText(" ");
        jPanel1.add(lbl_enroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 941, 250, -1));

        lbl_year.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lbl_year.setText(" ");
        jPanel1.add(lbl_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 1001, 250, -1));

        lbl_percentage.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        lbl_percentage.setText(" ");
        jPanel1.add(lbl_percentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1011, 250, -1));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        lbl_address.setEditable(false);
        lbl_address.setColumns(20);
        lbl_address.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_address.setLineWrap(true);
        lbl_address.setRows(5);
        lbl_address.setWrapStyleWord(true);
        lbl_address.setBorder(null);
        jScrollPane2.setViewportView(lbl_address);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 740, 140));

        lbl_editbtn.setBackground(new java.awt.Color(153, 153, 153));
        lbl_editbtn.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_editbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_editbtn.setText("Edit Details");
        lbl_editbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_editbtn.setOpaque(true);
        lbl_editbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_editbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_editbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_editbtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_editbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_editbtnMouseReleased(evt);
            }
        });
        jPanel1.add(lbl_editbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 1104, 197, 60));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 1240, 850));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel8MouseDragged(evt);
            }
        });
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel8MousePressed(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("—");
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
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

        jLabel26.setBackground(new java.awt.Color(51, 51, 51));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("University Portal");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 513, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_leftLibraryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_leftLibraryMouseClicked
        // TODO add your handling code here:
        new Library_Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_leftLibraryMouseClicked

    private void lbl_leftLibraryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_leftLibraryMouseEntered
        // TODO add your handling code here:
        lbl_leftLibrary.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_leftLibraryMouseEntered

    private void lbl_leftLibraryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_leftLibraryMouseExited
        // TODO add your handling code here:
        lbl_leftLibrary.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_leftLibraryMouseExited

    private void lbl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseClicked
        // TODO add your handling code here:
        new Student_Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_backMouseClicked

    private void lbl_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseEntered
        // TODO add your handling code here:

        lbl_back.setBackground(new Color(255,255,255));
        lbl_back.setLocation(lbl_back.getLocation().x, lbl_back.getLocation().y-4);
    }//GEN-LAST:event_lbl_backMouseEntered

    private void lbl_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseExited
        // TODO add your handling code here:
        lbl_back.setBackground(new Color(153,153,153));
        lbl_back.setLocation(lbl_back.getLocation().x, lbl_back.getLocation().y+4);
    }//GEN-LAST:event_lbl_backMouseExited

    private void lbl_backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMousePressed
        // TODO add your handling code here:
        lbl_back.setLocation(lbl_back.getLocation().x, lbl_back.getLocation().y-4);
    }//GEN-LAST:event_lbl_backMousePressed

    private void lbl_backMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseReleased
        // TODO add your handling code here:
        lbl_back.setLocation(lbl_back.getLocation().x, lbl_back.getLocation().y+4);
    }//GEN-LAST:event_lbl_backMouseReleased

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:

        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        // TODO add your handling code here:
        jLabel25.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
        // TODO add your handling code here:

        jLabel25.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel25MouseExited

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        int ans = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit","Close",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(ans == JOptionPane.YES_OPTION){
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

    private void jPanel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseDragged
        // TODO add your handling code here:

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - mouseX,y - mouseY);
    }//GEN-LAST:event_jPanel8MouseDragged

    private void jPanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MousePressed
        // TODO add your handling code here:

        this.mouseX = evt.getX();
        this.mouseY = evt.getY();
    }//GEN-LAST:event_jPanel8MousePressed

    private void lbl_editbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_editbtnMouseClicked
        // TODO add your handling code here:
        
              new Student_editDetails().setVisible(true);
        this.dispose();
        
        
        
    }//GEN-LAST:event_lbl_editbtnMouseClicked

    private void lbl_editbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_editbtnMouseEntered
        // TODO add your handling code here:
        lbl_editbtn.setBackground(new Color(255,255,255));
        lbl_editbtn.setLocation(lbl_editbtn.getLocation().x, lbl_editbtn.getLocation().y-4);
    }//GEN-LAST:event_lbl_editbtnMouseEntered

    private void lbl_editbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_editbtnMouseExited
        // TODO add your handling code here:
        lbl_editbtn.setBackground(new Color(153,153,153));
        lbl_editbtn.setLocation(lbl_editbtn.getLocation().x, lbl_editbtn.getLocation().y+4);
    }//GEN-LAST:event_lbl_editbtnMouseExited

    private void lbl_editbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_editbtnMousePressed
        // TODO add your handling code here:
        
         lbl_editbtn.setLocation(lbl_editbtn.getLocation().x, lbl_editbtn.getLocation().y-4);
    }//GEN-LAST:event_lbl_editbtnMousePressed

    private void lbl_editbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_editbtnMouseReleased
        // TODO add your handling code here:
         lbl_editbtn.setLocation(lbl_editbtn.getLocation().x, lbl_editbtn.getLocation().y+4);
    }//GEN-LAST:event_lbl_editbtnMouseReleased

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClose;
    private javax.swing.JTextArea lbl_address;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JLabel lbl_bloodgrp;
    private javax.swing.JLabel lbl_dept;
    private javax.swing.JLabel lbl_editbtn;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_enroll;
    private javax.swing.JLabel lbl_fathercontact;
    private javax.swing.JLabel lbl_fathername;
    private javax.swing.JLabel lbl_fatherocc;
    private javax.swing.JLabel lbl_gender;
    private javax.swing.JLabel lbl_leftLibrary;
    private javax.swing.JLabel lbl_mothercontact;
    private javax.swing.JLabel lbl_mothername;
    private javax.swing.JLabel lbl_motherocc;
    private javax.swing.JLabel lbl_number;
    private javax.swing.JLabel lbl_percentage;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel lbl_year;
    // End of variables declaration//GEN-END:variables
}
