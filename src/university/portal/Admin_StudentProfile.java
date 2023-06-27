/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static university.portal.Student_Dashboard.ret_fname;

/**
 *
 * @author Atharva Dhadke
 */
public class Admin_StudentProfile extends javax.swing.JFrame {

    /**
     * Creates new form Admin_DashBoard
     */
    
     static String ret_fname, ret_lname, ret_email, ret_phoneNo, ret_gender, ret_bloodGroup, ret_address , ret_password;
   static String ret_fatherName, ret_motherName, ret_fatherNO,ret_motherNo, ret_fatherOcc, ret_motherOcc;
   static String ret_dept,ret_year, ret_enroll, ret_percentage, ret_username ,dob ;
   
   String name = ret_fname +" " +ret_lname;
   String dept , year , enroll;
    
  
   
   int comp_count , mech_count , civil_count , elec_count;
    static byte byteImage[];
    
         PreparedStatement ps;
     Connection con ;
     ResultSet rs;
     DefaultTableModel tblModel;
     DefaultTableModel ComptblModel;
     DefaultTableModel mechtblModel;
     DefaultTableModel civiltblModel;
     DefaultTableModel electblModel;
     private int mouseX;
    private int mouseY;
    private Color redColor = new Color(204,51,0); 

    
    
     
    public Admin_StudentProfile() {
        initComponents();
         
       String username = FirstPage.adusername;
        
         try
        {
         
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            PreparedStatement ps;
            
            String sql = "SELECT * FROM studentdb";
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
            dob = rs.getString("DOB");
             
            byteImage = rs.getBytes("Image");
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(byteImage));
            ImageIcon icon = new ImageIcon(image);
          
            }
        }
        catch(Exception e)
        {
            e.getMessage();
        }

          
//          *********************************Comp************************************************************************
        
        try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb where `Department`= 'Computer'";
            ps = con.prepareStatement(sql);
            
             rs = ps.executeQuery ();
             ComptblModel = (DefaultTableModel)table.getModel();
             ComptblModel.setRowCount(0);
            while(rs.next())
            {
                dept    =rs.getString("Department");
                year    =rs.getString("Year");
                enroll  =rs.getString("EnrollmentNo");
                name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                
                System.out.println(tbdata);
                
                ComptblModel.addRow(tbdata);

            } 
            comp_count=ComptblModel.getRowCount();
           
            System.out.println(comp_count);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        String co_count = String.valueOf(comp_count);
        lbl_count.setText(co_count);
        
        
    //          *********************************Mech************************************************************************
        
        try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb where `Department`= 'Mechanical'";
            ps = con.prepareStatement(sql);
            
             rs = ps.executeQuery ();
             mechtblModel = (DefaultTableModel)table.getModel();
             mechtblModel.setRowCount(0);
            while(rs.next())
            {
                dept    =rs.getString("Department");
                year    =rs.getString("Year");
                enroll  =rs.getString("EnrollmentNo");
                name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                
                System.out.println(tbdata);
                
                mechtblModel.addRow(tbdata);

            } 
            mech_count=mechtblModel.getRowCount();
           
            System.out.println(comp_count);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        String m_count = String.valueOf(mech_count);
        lbl_mech.setText(m_count);  
        
    //  *********************************Civil************************************************************************
        
        try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb where `Department`= 'Civil'";
            ps = con.prepareStatement(sql);
            
             rs = ps.executeQuery ();
             civiltblModel = (DefaultTableModel)table.getModel();
             civiltblModel.setRowCount(0);
            while(rs.next())
            {
                dept    =rs.getString("Department");
                year    =rs.getString("Year");
                enroll  =rs.getString("EnrollmentNo");
                name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                
                System.out.println(tbdata);
                
                civiltblModel.addRow(tbdata);

            } 
            civil_count=civiltblModel.getRowCount();
           
            System.out.println(comp_count);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        String ce_count = String.valueOf(civil_count);
        lbl_civil.setText(ce_count);  
        
        
//        ***************************************************Elec*****************************************************
      try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb where `Department`= 'Mechanical'";
            ps = con.prepareStatement(sql);
            
             rs = ps.executeQuery ();
             electblModel = (DefaultTableModel)table.getModel();
             electblModel.setRowCount(0);
            while(rs.next())
            {
                dept    =rs.getString("Department");
                year    =rs.getString("Year");
                enroll  =rs.getString("EnrollmentNo");
                name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                
                System.out.println(tbdata);
                
                electblModel.addRow(tbdata);

            } 
            elec_count=electblModel.getRowCount();
           
            System.out.println(elec_count);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        String e_count = String.valueOf(elec_count);
        lbl_elec.setText(e_count);   
        
        
    //*********************************Main Table******************************************
//    name = ret_fname +" " +ret_lname;
         
           table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
          table.getTableHeader().setOpaque(false);
          table.getTableHeader().setBackground(new Color(58, 63, 67));
          table.getTableHeader().setForeground(new Color(255,255,255));
//          table.setRowHeight(40);
          

          try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb ";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             tblModel = (DefaultTableModel)table.getModel();
             tblModel.setRowCount(0);
            while(rs.next())
            {
                 dept    =rs.getString("Department");
            year    =rs.getString("Year");
            enroll  =rs.getString("EnrollmentNo");
            name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                tblModel.addRow(tbdata);

            } 
        }
        catch(Exception e)
        {
                e.getMessage();
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

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_home = new javax.swing.JLabel();
        lbl_library = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnl_Computer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_count = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnl_mechanical = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_mech = new javax.swing.JLabel();
        pnl_Electrical = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_elec = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pnl_Civil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_civil = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnl_addAccount = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnl_deleteAcc = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnl_alldept = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(58, 63, 67));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 850));

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\final admin .png")); // NOI18N
        jLabel19.setText("jLabel19");

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("MR Admin");
        jLabel20.setOpaque(true);

        lbl_home.setBackground(new java.awt.Color(58, 63, 67));
        lbl_home.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_home.setForeground(new java.awt.Color(255, 255, 255));
        lbl_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_home.setText("Home");
        lbl_home.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_home.setOpaque(true);
        lbl_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_homeMouseExited(evt);
            }
        });

        lbl_library.setBackground(new java.awt.Color(58, 63, 67));
        lbl_library.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_library.setForeground(new java.awt.Color(255, 255, 255));
        lbl_library.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_library.setText("Library Management");
        lbl_library.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_library.setOpaque(true);
        lbl_library.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_libraryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_libraryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_libraryMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_library, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(lbl_home, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_library, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(437, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 900));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("—");
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
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

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("University Portal");

        jPanel5.setBackground(new java.awt.Color(122, 125, 128));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Fees Management Dashboard");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 483, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 50));

        jPanel2.setBackground(new java.awt.Color(239, 239, 239));

        pnl_Computer.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Computer.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_Computer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_ComputerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_ComputerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_ComputerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_ComputerMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_ComputerMouseReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Computer icon 95px.png")); // NOI18N
        jLabel1.setText(".");

        lbl_count.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_count.setText("1");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Computer ");

        javax.swing.GroupLayout pnl_ComputerLayout = new javax.swing.GroupLayout(pnl_Computer);
        pnl_Computer.setLayout(pnl_ComputerLayout);
        pnl_ComputerLayout.setHorizontalGroup(
            pnl_ComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ComputerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        pnl_ComputerLayout.setVerticalGroup(
            pnl_ComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ComputerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_count, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_mechanical.setBackground(new java.awt.Color(255, 255, 255));
        pnl_mechanical.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_mechanical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_mechanicalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_mechanicalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_mechanicalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_mechanicalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_mechanicalMouseReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Mech 85px.png")); // NOI18N
        jLabel3.setText(".");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Mechanical");

        lbl_mech.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_mech.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mech.setText("1");

        javax.swing.GroupLayout pnl_mechanicalLayout = new javax.swing.GroupLayout(pnl_mechanical);
        pnl_mechanical.setLayout(pnl_mechanicalLayout);
        pnl_mechanicalLayout.setHorizontalGroup(
            pnl_mechanicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(lbl_mech, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_mechanicalLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_mechanicalLayout.setVerticalGroup(
            pnl_mechanicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mechanicalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_mech, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pnl_Electrical.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Electrical.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_Electrical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_ElectricalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_ElectricalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_ElectricalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_ElectricalMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_ElectricalMouseReleased(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\electrical 85px.png")); // NOI18N
        jLabel5.setText(".");

        lbl_elec.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_elec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_elec.setText("1");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Electrical");

        javax.swing.GroupLayout pnl_ElectricalLayout = new javax.swing.GroupLayout(pnl_Electrical);
        pnl_Electrical.setLayout(pnl_ElectricalLayout);
        pnl_ElectricalLayout.setHorizontalGroup(
            pnl_ElectricalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(lbl_elec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_ElectricalLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_ElectricalLayout.setVerticalGroup(
            pnl_ElectricalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ElectricalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_elec, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnl_Civil.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Civil.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_Civil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_CivilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_CivilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_CivilMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_CivilMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_CivilMouseReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Civil Yellow Final.png")); // NOI18N
        jLabel4.setText(".");

        lbl_civil.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_civil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_civil.setText("1");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Civil");

        javax.swing.GroupLayout pnl_CivilLayout = new javax.swing.GroupLayout(pnl_Civil);
        pnl_Civil.setLayout(pnl_CivilLayout);
        pnl_CivilLayout.setHorizontalGroup(
            pnl_CivilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(lbl_civil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_CivilLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_CivilLayout.setVerticalGroup(
            pnl_CivilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CivilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnl_addAccount.setBackground(new java.awt.Color(71, 71, 135));
        pnl_addAccount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(71, 71, 135), 5, true));
        pnl_addAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_addAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_addAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_addAccountMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_addAccountMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_addAccountMouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add A Account");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Add +");
        jLabel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        javax.swing.GroupLayout pnl_addAccountLayout = new javax.swing.GroupLayout(pnl_addAccount);
        pnl_addAccount.setLayout(pnl_addAccountLayout);
        pnl_addAccountLayout.setHorizontalGroup(
            pnl_addAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_addAccountLayout.setVerticalGroup(
            pnl_addAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pnl_deleteAcc.setBackground(new java.awt.Color(34, 112, 147));
        pnl_deleteAcc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 112, 147), 5, true));
        pnl_deleteAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_deleteAccMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_deleteAccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_deleteAccMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_deleteAccMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_deleteAccMouseReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Delete A Account");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Delete -");
        jLabel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        javax.swing.GroupLayout pnl_deleteAccLayout = new javax.swing.GroupLayout(pnl_deleteAcc);
        pnl_deleteAcc.setLayout(pnl_deleteAccLayout);
        pnl_deleteAccLayout.setHorizontalGroup(
            pnl_deleteAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_deleteAccLayout.setVerticalGroup(
            pnl_deleteAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_deleteAccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("All CopyRights Reserved /University");

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Enrollment No", "Name", "Department", "Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setFocusable(false);
        table.setGridColor(new java.awt.Color(153, 153, 153));
        table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table.setOpaque(false);
        table.setRowHeight(30);
        table.setShowVerticalLines(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(200);
            table.getColumnModel().getColumn(0).setPreferredWidth(200);
            table.getColumnModel().getColumn(0).setMaxWidth(200);
            table.getColumnModel().getColumn(1).setMinWidth(400);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(1).setMaxWidth(400);
            table.getColumnModel().getColumn(2).setMinWidth(250);
            table.getColumnModel().getColumn(2).setPreferredWidth(250);
            table.getColumnModel().getColumn(2).setMaxWidth(250);
            table.getColumnModel().getColumn(3).setMinWidth(300);
            table.getColumnModel().getColumn(3).setPreferredWidth(300);
            table.getColumnModel().getColumn(3).setMaxWidth(300);
        }

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 29)); // NOI18N
        jLabel17.setText("Student Details");

        jPanel6.setBackground(new java.awt.Color(122, 125, 128));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Student Profiles According To Departemnt");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_alldept.setBackground(new java.awt.Color(238, 153, 33));
        pnl_alldept.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 153, 33), 5, true));
        pnl_alldept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_alldeptMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_alldeptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_alldeptMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_alldeptMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_alldeptMouseReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("All Department");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Students");
        jLabel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        javax.swing.GroupLayout pnl_alldeptLayout = new javax.swing.GroupLayout(pnl_alldept);
        pnl_alldept.setLayout(pnl_alldeptLayout);
        pnl_alldeptLayout.setHorizontalGroup(
            pnl_alldeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_alldeptLayout.setVerticalGroup(
            pnl_alldeptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_alldeptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(pnl_Computer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(pnl_mechanical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(pnl_Civil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(pnl_Electrical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(pnl_alldept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnl_addAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(pnl_deleteAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Computer, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_mechanical, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Electrical, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Civil, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_addAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_deleteAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_alldept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 1210, 850));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnl_ComputerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ComputerMouseClicked
        // TODO add your handling code here:
        System.out.println("clicked");
        try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb where `Department`= 'Computer'";
            ps = con.prepareStatement(sql);
            
             rs = ps.executeQuery ();
             tblModel = (DefaultTableModel)table.getModel();
             tblModel.setRowCount(0);
            while(rs.next())
            {
                dept    =rs.getString("Department");
                year    =rs.getString("Year");
                enroll  =rs.getString("EnrollmentNo");
                name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                tblModel.addRow(tbdata);

            } 
            comp_count=tblModel.getRowCount();
           
            System.out.println(comp_count);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        String co_count = String.valueOf(comp_count);
        lbl_count.setText(co_count);
        
    }//GEN-LAST:event_pnl_ComputerMouseClicked

    private void pnl_ComputerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ComputerMouseEntered
        // TODO add your handling code here:
        
        pnl_Computer.setBackground(new Color(212, 225, 238));
       // jPanel2.setBackground(new Color(255,255,255));
        pnl_Computer.setLocation(pnl_Computer.getLocation().x, pnl_Computer.getLocation().y-7);
                
    }//GEN-LAST:event_pnl_ComputerMouseEntered

    private void pnl_ComputerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ComputerMouseExited
        // TODO add your handling code here:
        pnl_Computer.setBackground(new Color(255,255,255));
      //  jPanel2.setBackground(new Color(239,239,239));
         pnl_Computer.setLocation(pnl_Computer.getLocation().x, pnl_Computer.getLocation().y+7);
      
        
    }//GEN-LAST:event_pnl_ComputerMouseExited

    private void pnl_mechanicalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_mechanicalMouseClicked
        // TODO add your handling code here:
        
         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb where `Department`= 'Mechanical'";
            ps = con.prepareStatement(sql);
            
             rs = ps.executeQuery ();
             tblModel = (DefaultTableModel)table.getModel();
             tblModel.setRowCount(0);
            while(rs.next())
            {
                dept    =rs.getString("Department");
                year    =rs.getString("Year");
                enroll  =rs.getString("EnrollmentNo");
                name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                tblModel.addRow(tbdata);

            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        
    }//GEN-LAST:event_pnl_mechanicalMouseClicked

    private void pnl_mechanicalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_mechanicalMouseEntered
        // TODO add your handling code here:
         pnl_mechanical.setBackground(new Color(230, 247, 224));
          pnl_mechanical.setLocation(pnl_mechanical.getLocation().x, pnl_mechanical.getLocation().y-7);
        
    }//GEN-LAST:event_pnl_mechanicalMouseEntered

    private void pnl_mechanicalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_mechanicalMouseExited
        // TODO add your handling code here:
         pnl_mechanical.setBackground(new Color(255,255,255));
         pnl_mechanical.setLocation(pnl_mechanical.getLocation().x, pnl_mechanical.getLocation().y+7);
    }//GEN-LAST:event_pnl_mechanicalMouseExited

    private void pnl_CivilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_CivilMouseClicked
        // TODO add your handling code here:
        
           try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb where `Department`= 'Civil'";
            ps = con.prepareStatement(sql);
            
             rs = ps.executeQuery ();
             tblModel = (DefaultTableModel)table.getModel();
             tblModel.setRowCount(0);
            while(rs.next())
            {
                dept    =rs.getString("Department");
                year    =rs.getString("Year");
                enroll  =rs.getString("EnrollmentNo");
                name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                tblModel.addRow(tbdata);

            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        
    }//GEN-LAST:event_pnl_CivilMouseClicked

    private void pnl_CivilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_CivilMouseEntered
        // TODO add your handling code here:
         pnl_Civil.setBackground(new Color(235, 225, 166));
         pnl_Civil.setLocation(pnl_Civil.getLocation().x, pnl_Civil.getLocation().y-7);
    }//GEN-LAST:event_pnl_CivilMouseEntered

    private void pnl_CivilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_CivilMouseExited
        // TODO add your handling code here:
         pnl_Civil.setBackground(new Color(255,255,255));
         pnl_Civil.setLocation(pnl_Civil.getLocation().x, pnl_Civil.getLocation().y+7);
    }//GEN-LAST:event_pnl_CivilMouseExited

    private void pnl_ElectricalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ElectricalMouseClicked
        // TODO add your handling code here:
         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb where `Department`= 'Electrical'";
            ps = con.prepareStatement(sql);
            
             rs = ps.executeQuery ();
             tblModel = (DefaultTableModel)table.getModel();
             tblModel.setRowCount(0);
            while(rs.next())
            {
                dept    =rs.getString("Department");
                year    =rs.getString("Year");
                enroll  =rs.getString("EnrollmentNo");
                name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                tblModel.addRow(tbdata);

            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        
    }//GEN-LAST:event_pnl_ElectricalMouseClicked

    private void pnl_ElectricalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ElectricalMouseEntered
        // TODO add your handling code here:
        pnl_Electrical.setBackground(new Color(190, 220, 190));
        pnl_Electrical.setLocation(pnl_Electrical.getLocation().x, pnl_Electrical.getLocation().y-7);
    }//GEN-LAST:event_pnl_ElectricalMouseEntered

    private void pnl_ElectricalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ElectricalMouseExited
        // TODO add your handling code here:
        
          pnl_Electrical.setBackground(new Color(255, 255, 255));
          pnl_Electrical.setLocation(pnl_Electrical.getLocation().x, pnl_Electrical.getLocation().y+7);
    }//GEN-LAST:event_pnl_ElectricalMouseExited

    private void pnl_addAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMouseEntered
        // TODO add your handling code here:
        pnl_addAccount.setBackground(new Color(124, 124, 169));
        pnl_addAccount.setLocation(pnl_addAccount.getLocation().x, pnl_addAccount.getLocation().y-5);
    }//GEN-LAST:event_pnl_addAccountMouseEntered

    private void pnl_addAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMouseExited
        // TODO add your handling code here:
         pnl_addAccount.setBackground(new Color(71,71,135));
         pnl_addAccount.setLocation(pnl_addAccount.getLocation().x, pnl_addAccount.getLocation().y+5);
    }//GEN-LAST:event_pnl_addAccountMouseExited

    private void pnl_deleteAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deleteAccMouseClicked
        // TODO add your handling code here:
     new Admin_viewStudents().setVisible(true);
       
    }//GEN-LAST:event_pnl_deleteAccMouseClicked

    private void pnl_deleteAccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deleteAccMouseEntered
        // TODO add your handling code here:
         pnl_deleteAcc.setBackground(new Color(107, 159, 183));
         pnl_deleteAcc.setLocation(pnl_deleteAcc.getLocation().x, pnl_deleteAcc.getLocation().y-5);
    }//GEN-LAST:event_pnl_deleteAccMouseEntered

    private void pnl_deleteAccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deleteAccMouseExited
        // TODO add your handling code here:
        pnl_deleteAcc.setBackground(new Color(34,112,147));
        pnl_deleteAcc.setLocation(pnl_deleteAcc.getLocation().x, pnl_deleteAcc.getLocation().y+5);
    }//GEN-LAST:event_pnl_deleteAccMouseExited

    private void pnl_addAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMouseClicked
        // TODO add your handling code here:
        new Student_RegAdmin().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_pnl_addAccountMouseClicked

    private void lbl_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseEntered
        // TODO add your handling code here:
        lbl_home.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_homeMouseEntered

    private void lbl_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseExited
        // TODO add your handling code here:
          lbl_home.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_homeMouseExited

    private void lbl_libraryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_libraryMouseExited
        // TODO add your handling code here:
        lbl_library.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_libraryMouseExited

    private void lbl_libraryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_libraryMouseEntered
        // TODO add your handling code here:
        lbl_library.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_libraryMouseEntered

    private void pnl_ComputerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ComputerMousePressed
        // TODO add your handling code here:
        
         pnl_Computer.setLocation(pnl_Computer.getLocation().x, pnl_Computer.getLocation().y-5);
        
    }//GEN-LAST:event_pnl_ComputerMousePressed

    private void pnl_ComputerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ComputerMouseReleased
        // TODO add your handling code here:
        pnl_Computer.setLocation(pnl_Computer.getLocation().x, pnl_Computer.getLocation().y+5);
    }//GEN-LAST:event_pnl_ComputerMouseReleased

    private void pnl_mechanicalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_mechanicalMousePressed
        // TODO add your handling code here:
         pnl_mechanical.setLocation(pnl_mechanical.getLocation().x, pnl_mechanical.getLocation().y-5);
    }//GEN-LAST:event_pnl_mechanicalMousePressed

    private void pnl_mechanicalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_mechanicalMouseReleased
        // TODO add your handling code here:
         pnl_mechanical.setLocation(pnl_mechanical.getLocation().x, pnl_mechanical.getLocation().y+5);
    }//GEN-LAST:event_pnl_mechanicalMouseReleased

    private void pnl_CivilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_CivilMousePressed
        // TODO add your handling code here:
         pnl_Civil.setLocation(pnl_Civil.getLocation().x, pnl_Civil.getLocation().y-5);
    }//GEN-LAST:event_pnl_CivilMousePressed

    private void pnl_CivilMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_CivilMouseReleased
        // TODO add your handling code here:
         pnl_Civil.setLocation(pnl_Civil.getLocation().x, pnl_Civil.getLocation().y+5);
    }//GEN-LAST:event_pnl_CivilMouseReleased

    private void pnl_ElectricalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ElectricalMousePressed
        // TODO add your handling code here:
         pnl_Electrical.setLocation(pnl_Electrical.getLocation().x, pnl_Electrical.getLocation().y-5);
    }//GEN-LAST:event_pnl_ElectricalMousePressed

    private void pnl_ElectricalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ElectricalMouseReleased
        // TODO add your handling code here:
         pnl_Electrical.setLocation(pnl_Electrical.getLocation().x, pnl_Electrical.getLocation().y+5);
    }//GEN-LAST:event_pnl_ElectricalMouseReleased

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:

        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        // TODO add your handling code here:
        jLabel23.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        // TODO add your handling code here:

        jLabel23.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel23MouseExited

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

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - mouseX,y - mouseY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:

        this.mouseX = evt.getX();
        this.mouseY = evt.getY();

    }//GEN-LAST:event_jPanel1MousePressed

    private void lbl_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseClicked
        // TODO add your handling code here:
        new Admin_DashBoardMain().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_homeMouseClicked

    private void lbl_libraryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_libraryMouseClicked
        // TODO add your handling code here:
        new Admin_LibraryDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_libraryMouseClicked

    private void pnl_addAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMousePressed
        // TODO add your handling code here:
        pnl_addAccount.setLocation(pnl_addAccount.getLocation().x, pnl_addAccount.getLocation().y-5);
    }//GEN-LAST:event_pnl_addAccountMousePressed

    private void pnl_addAccountMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMouseReleased
        // TODO add your handling code here:
        pnl_addAccount.setLocation(pnl_addAccount.getLocation().x, pnl_addAccount.getLocation().y+5);
    }//GEN-LAST:event_pnl_addAccountMouseReleased

    private void pnl_deleteAccMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deleteAccMousePressed
        // TODO add your handling code here:
        pnl_deleteAcc.setLocation(pnl_deleteAcc.getLocation().x, pnl_deleteAcc.getLocation().y-5);
    }//GEN-LAST:event_pnl_deleteAccMousePressed

    private void pnl_deleteAccMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deleteAccMouseReleased
        // TODO add your handling code here:
        pnl_deleteAcc.setLocation(pnl_deleteAcc.getLocation().x, pnl_deleteAcc.getLocation().y+5);
    }//GEN-LAST:event_pnl_deleteAccMouseReleased

    private void pnl_alldeptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_alldeptMouseClicked
        // TODO add your handling code here:
        
         //*********************************Main Table******************************************
//    name = ret_fname +" " +ret_lname;
         
           table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
          table.getTableHeader().setOpaque(false);
          table.getTableHeader().setBackground(new Color(58, 63, 67));
          table.getTableHeader().setForeground(new Color(255,255,255));
//          table.setRowHeight(40);
          

          try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb ";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             tblModel = (DefaultTableModel)table.getModel();
             tblModel.setRowCount(0);
            while(rs.next())
            {
                 dept    =rs.getString("Department");
            year    =rs.getString("Year");
            enroll  =rs.getString("EnrollmentNo");
            name=rs.getString("FIRST_NAME");
                String tbdata[] ={enroll,name,dept,year};
                tblModel.addRow(tbdata);

            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        }     
        
    }//GEN-LAST:event_pnl_alldeptMouseClicked

    private void pnl_alldeptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_alldeptMouseEntered
        // TODO add your handling code here:
        
        pnl_alldept.setBackground(new Color(247, 207, 151));
        pnl_alldept.setLocation(pnl_alldept.getLocation().x, pnl_alldept.getLocation().y-5);
        
    }//GEN-LAST:event_pnl_alldeptMouseEntered

    private void pnl_alldeptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_alldeptMouseExited
        // TODO add your handling code here:
        
        pnl_alldept.setBackground(new Color(238,153,33));
        pnl_alldept.setLocation(pnl_alldept.getLocation().x, pnl_alldept.getLocation().y+5);
    }//GEN-LAST:event_pnl_alldeptMouseExited

    private void pnl_alldeptMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_alldeptMousePressed
        // TODO add your handling code here:
        pnl_alldept.setLocation(pnl_alldept.getLocation().x, pnl_alldept.getLocation().y-5);
    }//GEN-LAST:event_pnl_alldeptMousePressed

    private void pnl_alldeptMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_alldeptMouseReleased
        // TODO add your handling code here:
          pnl_alldept.setLocation(pnl_alldept.getLocation().x, pnl_alldept.getLocation().y+5);
    }//GEN-LAST:event_pnl_alldeptMouseReleased

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_StudentProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_civil;
    private javax.swing.JLabel lbl_count;
    private javax.swing.JLabel lbl_elec;
    private javax.swing.JLabel lbl_home;
    private javax.swing.JLabel lbl_library;
    private javax.swing.JLabel lbl_mech;
    private javax.swing.JPanel pnl_Civil;
    private javax.swing.JPanel pnl_Computer;
    private javax.swing.JPanel pnl_Electrical;
    private javax.swing.JPanel pnl_addAccount;
    private javax.swing.JPanel pnl_alldept;
    private javax.swing.JPanel pnl_deleteAcc;
    private javax.swing.JPanel pnl_mechanical;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
