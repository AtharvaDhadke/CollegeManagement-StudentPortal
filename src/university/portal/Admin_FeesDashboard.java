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

/**
 *
 * @author Atharva Dhadke
 */
public class Admin_FeesDashboard extends javax.swing.JFrame {

    /**
     * Creates new form Admin_DashBoard
     */
    
     static String ret_fname, ret_lname, ret_email, ret_phoneNo, ret_gender, ret_bloodGroup, ret_address , ret_password;
   static String ret_fatherName, ret_motherName, ret_fatherNO,ret_motherNo, ret_fatherOcc, ret_motherOcc;
   static String ret_dept,ret_year, ret_enroll, ret_percentage, ret_username ,dob ;
   
   String name = ret_fname +" " +ret_lname;
   String dept , year , enroll;
    
   String f_student , f_enroll , f_yeardept , f_total , f_date;
   
   int co = Admin_DashBoardMain.comp_total_count;
   int me = Admin_DashBoardMain.mech_total_count;
   int cv= Admin_DashBoardMain.civil_total_count;
   int ee= Admin_DashBoardMain.elec_total_count;
   
   int comp_count = 0;
   int  mech_count , civil_count , elec_count,allCount;
    
    
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

    
    
     
    public Admin_FeesDashboard() {
        initComponents();
        String username = FirstPage.adusername;
        
//        ***************Comps Table *************************

         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `dept` = 'Computer'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery (); 
            
            while(rs.next())
            {   
                comp_count++;
            } 
            
//             System.out.println("Comps Fees Paid : " +comp_count);
             String co_count = String.valueOf(comp_count);
             lbl_compscount.setText(co_count+"/"+co);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
// *******************************************MECH **********************************************************

           try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `dept` = 'Mechanical'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery (); 
            
            while(rs.next())
            {   
                mech_count++;
            } 
            
//             System.out.println("Mech Fees Paid : " +mech_count);
             String m_count = String.valueOf(mech_count);
             lbl_mech.setText(m_count+"/"+me);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
           
// *******************************************Civil **********************************************************

           try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `dept` = 'Civil'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery (); 
            
            while(rs.next())
            {   
                civil_count++;
            } 
            
//             System.out.println("Civil Fees Paid :" +civil_count);
             String c_count = String.valueOf(mech_count);
             lbl_civil.setText(c_count+"/"+cv);
        }
        catch(Exception e)
        {
                e.getMessage();
        }    
           
// *******************************************MECH **********************************************************

           try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `dept` = 'Electrical'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery (); 
            
            while(rs.next())
            {   
                elec_count++;
            } 
            
//             System.out.println("Elec Fees Paid :" +elec_count);
             String e_count = String.valueOf(elec_count);
             lbl_elec.setText(e_count+"/"+ee);
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
        jPanel2 = new javax.swing.JPanel();
        pnl_Computer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_compscount = new javax.swing.JLabel();
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
        jLabel18 = new javax.swing.JLabel();
        pnl_ViewByPayment = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_notice = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_home = new javax.swing.JLabel();
        lbl_library = new javax.swing.JLabel();
        lbl_Student = new javax.swing.JLabel();
        lbl_collage = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

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

        jPanel2.setBackground(new java.awt.Color(239, 239, 239));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lbl_compscount.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_compscount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_compscount.setText("99");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Computer ");

        javax.swing.GroupLayout pnl_ComputerLayout = new javax.swing.GroupLayout(pnl_Computer);
        pnl_Computer.setLayout(pnl_ComputerLayout);
        pnl_ComputerLayout.setHorizontalGroup(
            pnl_ComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ComputerLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_compscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_ComputerLayout.setVerticalGroup(
            pnl_ComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ComputerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_compscount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.add(pnl_Computer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

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
        lbl_mech.setText("99");

        javax.swing.GroupLayout pnl_mechanicalLayout = new javax.swing.GroupLayout(pnl_mechanical);
        pnl_mechanical.setLayout(pnl_mechanicalLayout);
        pnl_mechanicalLayout.setHorizontalGroup(
            pnl_mechanicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mechanicalLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_mech, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_mechanicalLayout.setVerticalGroup(
            pnl_mechanicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mechanicalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_mech, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.add(pnl_mechanical, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

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
        lbl_elec.setText("99");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Electrical");

        javax.swing.GroupLayout pnl_ElectricalLayout = new javax.swing.GroupLayout(pnl_Electrical);
        pnl_Electrical.setLayout(pnl_ElectricalLayout);
        pnl_ElectricalLayout.setHorizontalGroup(
            pnl_ElectricalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ElectricalLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_elec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_ElectricalLayout.setVerticalGroup(
            pnl_ElectricalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ElectricalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_elec, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel2.add(pnl_Electrical, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, -1, -1));

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
        lbl_civil.setText("99");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Civil");

        javax.swing.GroupLayout pnl_CivilLayout = new javax.swing.GroupLayout(pnl_Civil);
        pnl_Civil.setLayout(pnl_CivilLayout);
        pnl_CivilLayout.setHorizontalGroup(
            pnl_CivilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CivilLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_civil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_CivilLayout.setVerticalGroup(
            pnl_CivilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CivilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.add(pnl_Civil, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, -1));

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
        jLabel2.setText("View All Department");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Fees Record");
        jLabel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        javax.swing.GroupLayout pnl_addAccountLayout = new javax.swing.GroupLayout(pnl_addAccount);
        pnl_addAccount.setLayout(pnl_addAccountLayout);
        pnl_addAccountLayout.setHorizontalGroup(
            pnl_addAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel2.add(pnl_addAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("All CopyRights Reserved /University");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 828, 290, -1));

        pnl_ViewByPayment.setBackground(new java.awt.Color(34, 112, 147));
        pnl_ViewByPayment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 112, 147), 5, true));
        pnl_ViewByPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_ViewByPaymentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_ViewByPaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_ViewByPaymentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_ViewByPaymentMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_ViewByPaymentMouseReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(" View By Payment Mode");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Fees Record");
        jLabel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        javax.swing.GroupLayout pnl_ViewByPaymentLayout = new javax.swing.GroupLayout(pnl_ViewByPayment);
        pnl_ViewByPayment.setLayout(pnl_ViewByPaymentLayout);
        pnl_ViewByPaymentLayout.setHorizontalGroup(
            pnl_ViewByPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_ViewByPaymentLayout.setVerticalGroup(
            pnl_ViewByPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ViewByPaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2.add(pnl_ViewByPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 550, -1));

        lbl_notice.setBackground(new java.awt.Color(238, 82, 79));
        lbl_notice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_notice.setForeground(new java.awt.Color(255, 255, 255));
        lbl_notice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_notice.setText("Add/Change Notice");
        lbl_notice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 82, 79), 3));
        lbl_notice.setOpaque(true);
        lbl_notice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_noticeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_noticeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_noticeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_noticeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_noticeMouseReleased(evt);
            }
        });
        jPanel2.add(lbl_notice, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 690, 270, 80));

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
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 70));

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

        lbl_Student.setBackground(new java.awt.Color(58, 63, 67));
        lbl_Student.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_Student.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Student.setText("Student Management");
        lbl_Student.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_Student.setOpaque(true);
        lbl_Student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_StudentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_StudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_StudentMouseExited(evt);
            }
        });

        lbl_collage.setBackground(new java.awt.Color(58, 63, 67));
        lbl_collage.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_collage.setForeground(new java.awt.Color(255, 255, 255));
        lbl_collage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_collage.setText("Collage Forum");
        lbl_collage.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_collage.setOpaque(true);
        lbl_collage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_collageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_collageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_collageMouseExited(evt);
            }
        });

        lbl_id.setBackground(new java.awt.Color(58, 63, 67));
        lbl_id.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id.setText("Generate ID Card");
        lbl_id.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_id.setOpaque(true);
        lbl_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_idMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_idMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_idMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_library, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_Student, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addComponent(lbl_collage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(8, 8, 8)
                .addComponent(lbl_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_library, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_collage, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

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
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnl_ComputerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ComputerMouseClicked
        // TODO add your handling code here:
       new Admin_FeesRecordComps().setVisible(true);
       this.dispose();
       
        
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
         new Admin_FeesRecordMech().setVisible(true);
         this.dispose();
        
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
         new Admin_FeesRecordCivil().setVisible(true);
         this.dispose();
        
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
         new Admin_FeesRecordElec().setVisible(true);
         this.dispose();
        
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

    private void pnl_addAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMouseExited
        // TODO add your handling code here:
        pnl_addAccount.setBackground(new Color(71,71,135));
        pnl_addAccount.setLocation(pnl_addAccount.getLocation().x, pnl_addAccount.getLocation().y+5);
    }//GEN-LAST:event_pnl_addAccountMouseExited

    private void pnl_addAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMouseEntered
        // TODO add your handling code here:
        pnl_addAccount.setBackground(new Color(124, 124, 169));
        
         pnl_addAccount.setLocation(pnl_addAccount.getLocation().x, pnl_addAccount.getLocation().y-5);
    }//GEN-LAST:event_pnl_addAccountMouseEntered

    private void pnl_addAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMouseClicked
        // TODO add your handling code here:   
        new Admin_FeesAllDeptRecord().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pnl_addAccountMouseClicked

    private void pnl_ViewByPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ViewByPaymentMouseClicked
       // TODO add your handling code here:
       new Admin_FeeViewByPaymentMode().setVisible(true);
       this.dispose();
        
        
    }//GEN-LAST:event_pnl_ViewByPaymentMouseClicked

    private void pnl_ViewByPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ViewByPaymentMouseEntered
        // TODO add your handling code here:
         pnl_ViewByPayment.setBackground(new Color(107, 159, 183));
         pnl_ViewByPayment.setLocation(pnl_ViewByPayment.getLocation().x, pnl_ViewByPayment.getLocation().y-5);
    }//GEN-LAST:event_pnl_ViewByPaymentMouseEntered

    private void pnl_ViewByPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ViewByPaymentMouseExited
        // TODO add your handling code here:
        pnl_ViewByPayment.setBackground(new Color(34,112,147));
         pnl_ViewByPayment.setLocation(pnl_ViewByPayment.getLocation().x, pnl_ViewByPayment.getLocation().y+5);
    }//GEN-LAST:event_pnl_ViewByPaymentMouseExited

    private void lbl_noticeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_noticeMouseClicked
        // TODO add your handling code here:
        new Admin_FeesNotice().setVisible(true);
        
    }//GEN-LAST:event_lbl_noticeMouseClicked

    private void lbl_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseClicked
        // TODO add your handling code here:
        new Admin_DashBoardMain().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_homeMouseClicked

    private void lbl_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseEntered
        // TODO add your handling code here:
        lbl_home.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_homeMouseEntered

    private void lbl_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseExited
        // TODO add your handling code here:
        lbl_home.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_homeMouseExited

    private void lbl_libraryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_libraryMouseClicked
        // TODO add your handling code here:
        new Admin_LibraryDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_libraryMouseClicked

    private void lbl_libraryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_libraryMouseEntered
        // TODO add your handling code here:
        lbl_library.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_libraryMouseEntered

    private void lbl_libraryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_libraryMouseExited
        // TODO add your handling code here:
        lbl_library.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_libraryMouseExited

    private void lbl_StudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_StudentMouseClicked
        // TODO add your handling code here:
        new Admin_StudentProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_StudentMouseClicked

    private void lbl_StudentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_StudentMouseEntered
        // TODO add your handling code here:
        lbl_Student.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_StudentMouseEntered

    private void lbl_StudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_StudentMouseExited
        // TODO add your handling code here:
        lbl_Student.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_StudentMouseExited

    private void lbl_collageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_collageMouseClicked
        // TODO add your handling code here:
        new Admin_StudentForumDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_collageMouseClicked

    private void lbl_collageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_collageMouseEntered
        // TODO add your handling code here:
        lbl_collage.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_collageMouseEntered

    private void lbl_collageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_collageMouseExited
        // TODO add your handling code here:
        lbl_collage.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_collageMouseExited

    private void lbl_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_idMouseClicked
        // TODO add your handling code here:
        new Admin_IdCard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_idMouseClicked

    private void lbl_idMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_idMouseEntered
        // TODO add your handling code here:
        lbl_id.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_idMouseEntered

    private void lbl_idMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_idMouseExited
        // TODO add your handling code here:
        lbl_id.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_idMouseExited

    private void pnl_addAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMousePressed
        // TODO add your handling code here:
         pnl_addAccount.setLocation(pnl_addAccount.getLocation().x, pnl_addAccount.getLocation().y-5);
    }//GEN-LAST:event_pnl_addAccountMousePressed

    private void pnl_addAccountMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addAccountMouseReleased
        // TODO add your handling code here:
        pnl_addAccount.setLocation(pnl_addAccount.getLocation().x, pnl_addAccount.getLocation().y+5);
    }//GEN-LAST:event_pnl_addAccountMouseReleased

    private void pnl_ViewByPaymentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ViewByPaymentMousePressed
        // TODO add your handling code here:
        pnl_ViewByPayment.setLocation(pnl_ViewByPayment.getLocation().x, pnl_ViewByPayment.getLocation().y-5);
    }//GEN-LAST:event_pnl_ViewByPaymentMousePressed

    private void pnl_ViewByPaymentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ViewByPaymentMouseReleased
        // TODO add your handling code here:
        pnl_ViewByPayment.setLocation(pnl_ViewByPayment.getLocation().x, pnl_ViewByPayment.getLocation().y+5);
    }//GEN-LAST:event_pnl_ViewByPaymentMouseReleased

    private void lbl_noticeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_noticeMouseExited
        // TODO add your handling code here:
        lbl_notice.setBackground(new Color(238,82,79));  
        lbl_notice.setLocation(lbl_notice.getLocation().x, lbl_notice.getLocation().y+4);
    }//GEN-LAST:event_lbl_noticeMouseExited

    private void lbl_noticeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_noticeMouseEntered
        // TODO add your handling code here:
        lbl_notice.setBackground(new Color(243, 134, 132));
       
        lbl_notice.setLocation(lbl_notice.getLocation().x, lbl_notice.getLocation().y-4);
    }//GEN-LAST:event_lbl_noticeMouseEntered

    private void lbl_noticeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_noticeMousePressed
        // TODO add your handling code here:'
          lbl_notice.setLocation(lbl_notice.getLocation().x, lbl_notice.getLocation().y-5);
          
    }//GEN-LAST:event_lbl_noticeMousePressed

    private void lbl_noticeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_noticeMouseReleased
        // TODO add your handling code here:
        lbl_notice.setLocation(lbl_notice.getLocation().x, lbl_notice.getLocation().y+5);
    }//GEN-LAST:event_lbl_noticeMouseReleased

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
            java.util.logging.Logger.getLogger(Admin_FeesDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_FeesDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_FeesDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_FeesDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_FeesDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_Student;
    private javax.swing.JLabel lbl_civil;
    private javax.swing.JLabel lbl_collage;
    private javax.swing.JLabel lbl_compscount;
    private javax.swing.JLabel lbl_elec;
    private javax.swing.JLabel lbl_home;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_library;
    private javax.swing.JLabel lbl_mech;
    private javax.swing.JLabel lbl_notice;
    private javax.swing.JPanel pnl_Civil;
    private javax.swing.JPanel pnl_Computer;
    private javax.swing.JPanel pnl_Electrical;
    private javax.swing.JPanel pnl_ViewByPayment;
    private javax.swing.JPanel pnl_addAccount;
    private javax.swing.JPanel pnl_mechanical;
    // End of variables declaration//GEN-END:variables
}
