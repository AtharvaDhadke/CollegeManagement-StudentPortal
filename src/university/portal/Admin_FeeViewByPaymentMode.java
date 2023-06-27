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
public class Admin_FeeViewByPaymentMode extends javax.swing.JFrame {

    /**
     * Creates new form Admin_DashBoard
     */
   

    String studentName , enroll,deptyear ,mode, date , amount;
  

    
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

    
    
      int creditCOunt , debitCount , cheaqueCount , demandCount;
    public Admin_FeeViewByPaymentMode() {
        initComponents();
        
         table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
          table.getTableHeader().setOpaque(false);
          table.getTableHeader().setBackground(new Color(58, 63, 67));
          table.getTableHeader().setForeground(new Color(255,255,255));  
          
//         *******************************************Credit **************************************************
         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `ModeOfPayment` = 'Credit Card'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             
            DefaultTableModel ComptblModel = (DefaultTableModel)table.getModel();
            
            ComptblModel.setRowCount(0);
            
            while(rs.next())
            {
                studentName= rs.getString("StudentName");
                enroll= rs.getString("EnrollmentNo");
                deptyear= rs.getString("YearDepartment");
                amount= rs.getString("PaymentAmount");
                mode= rs.getString("ModeOfPayment");
                date =rs.getString("PaymentDate");
                
                String tbdata[] ={enroll,studentName,deptyear ,mode,amount,date};
                ComptblModel.addRow(tbdata);

            } 
               creditCOunt=ComptblModel.getRowCount();
            String credit_c=String.valueOf(creditCOunt);
            lbl_credit.setText(credit_c);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
         
//            *******************************************Debit **************************************************
         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `ModeOfPayment` = 'Debit Card'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             
            DefaultTableModel mechtblModel = (DefaultTableModel)table.getModel();
            
            mechtblModel.setRowCount(0);
            
            while(rs.next())
            {
                studentName= rs.getString("StudentName");
                enroll= rs.getString("EnrollmentNo");
                deptyear= rs.getString("YearDepartment");
                amount= rs.getString("PaymentAmount");
                mode= rs.getString("ModeOfPayment");
                date =rs.getString("PaymentDate");
                
                String tbdata[] ={enroll,studentName,deptyear ,mode,amount,date};
                mechtblModel.addRow(tbdata);

            } 
               debitCount=mechtblModel.getRowCount();
            String debit_c=String.valueOf(debitCount);
            lbl_debit.setText(debit_c);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
         
//         **************************Cheaque******************************************

             try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `ModeOfPayment` = 'Cheaque'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             
            DefaultTableModel civiltblModel = (DefaultTableModel)table.getModel();
            
            civiltblModel.setRowCount(0);
            
            while(rs.next())
            {
                studentName= rs.getString("StudentName");
                enroll= rs.getString("EnrollmentNo");
                deptyear= rs.getString("YearDepartment");
                amount= rs.getString("PaymentAmount");
                mode= rs.getString("ModeOfPayment");
                date =rs.getString("PaymentDate");
                
                String tbdata[] ={enroll,studentName,deptyear ,mode,amount,date};
                civiltblModel.addRow(tbdata);

            } 
               cheaqueCount=civiltblModel.getRowCount();
            String cheaque_c=String.valueOf(cheaqueCount);
            lbl_cheaque.setText(cheaque_c);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
             
//         **************************Demand Draft******************************************

             try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `ModeOfPayment` = 'Demand Draft'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             
            DefaultTableModel electblModel = (DefaultTableModel)table.getModel();
            
            electblModel.setRowCount(0);
            
            while(rs.next())
            {
                studentName= rs.getString("StudentName");
                enroll= rs.getString("EnrollmentNo");
                deptyear= rs.getString("YearDepartment");
                amount= rs.getString("PaymentAmount");
                mode= rs.getString("ModeOfPayment");
                date =rs.getString("PaymentDate");
                
                String tbdata[] ={enroll,studentName,deptyear ,mode,amount,date};
                electblModel.addRow(tbdata);

            } 
               demandCount=electblModel.getRowCount();
            String demand_c=String.valueOf(demandCount);
            lbl_Demand.setText(demand_c);
        }
        catch(Exception e)
        {
                e.getMessage();
        } 

        //****************************************Main Table***************************************************
         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `ModeOfPayment` = 'Credit Card'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             
            DefaultTableModel ComptblModel = (DefaultTableModel)table.getModel();
            
            ComptblModel.setRowCount(0);
            
            while(rs.next())
            {
                studentName= rs.getString("StudentName");
                enroll= rs.getString("EnrollmentNo");
                deptyear= rs.getString("YearDepartment");
                amount= rs.getString("PaymentAmount");
                mode= rs.getString("ModeOfPayment");
                date =rs.getString("PaymentDate");
                
                String tbdata[] ={enroll,studentName,deptyear ,mode,amount,date};
                ComptblModel.addRow(tbdata);

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
        jPanel2 = new javax.swing.JPanel();
        pnl_Computer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_credit = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnl_mechanical = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_debit = new javax.swing.JLabel();
        pnl_Electrical = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Demand = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pnl_Civil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_cheaque = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_elec = new javax.swing.JLabel();
        lbl_mech = new javax.swing.JLabel();
        lbl_comp = new javax.swing.JLabel();
        lbl_back = new javax.swing.JLabel();
        lbl_civil = new javax.swing.JLabel();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Admin_FeesManagement\\Creditcard.png")); // NOI18N
        jLabel1.setText(".");

        lbl_credit.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_credit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_credit.setText("99");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Credit Card");

        javax.swing.GroupLayout pnl_ComputerLayout = new javax.swing.GroupLayout(pnl_Computer);
        pnl_Computer.setLayout(pnl_ComputerLayout);
        pnl_ComputerLayout.setHorizontalGroup(
            pnl_ComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_credit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_ComputerLayout.setVerticalGroup(
            pnl_ComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ComputerLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Admin_FeesManagement\\debitcard.png")); // NOI18N
        jLabel3.setText(".");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Debit Card");

        lbl_debit.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_debit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_debit.setText("99");

        javax.swing.GroupLayout pnl_mechanicalLayout = new javax.swing.GroupLayout(pnl_mechanical);
        pnl_mechanical.setLayout(pnl_mechanicalLayout);
        pnl_mechanicalLayout.setHorizontalGroup(
            pnl_mechanicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(lbl_debit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_mechanicalLayout.setVerticalGroup(
            pnl_mechanicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mechanicalLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Admin_FeesManagement\\dd.png")); // NOI18N
        jLabel5.setText(".");

        lbl_Demand.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_Demand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Demand.setText("99");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Demand Draft");

        javax.swing.GroupLayout pnl_ElectricalLayout = new javax.swing.GroupLayout(pnl_Electrical);
        pnl_Electrical.setLayout(pnl_ElectricalLayout);
        pnl_ElectricalLayout.setHorizontalGroup(
            pnl_ElectricalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(lbl_Demand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_ElectricalLayout.setVerticalGroup(
            pnl_ElectricalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ElectricalLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Demand, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Admin_FeesManagement\\cheque.png")); // NOI18N
        jLabel4.setText(".");

        lbl_cheaque.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_cheaque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cheaque.setText("99");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Cheaque");

        javax.swing.GroupLayout pnl_CivilLayout = new javax.swing.GroupLayout(pnl_Civil);
        pnl_Civil.setLayout(pnl_CivilLayout);
        pnl_CivilLayout.setHorizontalGroup(
            pnl_CivilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(lbl_cheaque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_CivilLayout.setVerticalGroup(
            pnl_CivilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CivilLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_cheaque, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 29)); // NOI18N
        jLabel17.setText("Student Details");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("All CopyRights Reserved /University");

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Enrollment No", "Student Name", "Department/Year", "Mode Of Payment", "Total Fees Paid", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true
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
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(153, 153, 153));
        table.setShowVerticalLines(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(122, 125, 128));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Fee Record By Mode Of Payment");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 979, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnl_Computer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(pnl_mechanical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(pnl_Civil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_Electrical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_mechanical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Computer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Civil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Electrical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 1200, 850));

        jPanel6.setBackground(new java.awt.Color(58, 63, 67));
        jPanel6.setPreferredSize(new java.awt.Dimension(400, 850));

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\final admin .png")); // NOI18N
        jLabel19.setText("jLabel19");

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("MR Admin");
        jLabel20.setOpaque(true);

        lbl_elec.setBackground(new java.awt.Color(58, 63, 67));
        lbl_elec.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_elec.setForeground(new java.awt.Color(255, 255, 255));
        lbl_elec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_elec.setText("Electrical Dept");
        lbl_elec.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_elec.setOpaque(true);
        lbl_elec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_elecMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_elecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_elecMouseExited(evt);
            }
        });

        lbl_mech.setBackground(new java.awt.Color(58, 63, 67));
        lbl_mech.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_mech.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mech.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mech.setText("Mechanical Dept");
        lbl_mech.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_mech.setOpaque(true);
        lbl_mech.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_mechMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_mechMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_mechMouseExited(evt);
            }
        });

        lbl_comp.setBackground(new java.awt.Color(58, 63, 67));
        lbl_comp.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_comp.setForeground(new java.awt.Color(255, 255, 255));
        lbl_comp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_comp.setText("Computer Dept");
        lbl_comp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_comp.setOpaque(true);
        lbl_comp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_compMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_compMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_compMouseExited(evt);
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

        lbl_civil.setBackground(new java.awt.Color(58, 63, 67));
        lbl_civil.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_civil.setForeground(new java.awt.Color(255, 255, 255));
        lbl_civil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_civil.setText("Civil Dept");
        lbl_civil.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_civil.setOpaque(true);
        lbl_civil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_civilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_civilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_civilMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
            .addComponent(lbl_comp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_mech, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_elec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_civil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(lbl_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_mech, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_elec, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(lbl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 900));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnl_ComputerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ComputerMouseClicked
        // TODO add your handling code here:
       
        
         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql ="SELECT * FROM feespayment where `ModeOfPayment` = 'Credit Card'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             
            DefaultTableModel ComptblModel = (DefaultTableModel)table.getModel();
            
            ComptblModel.setRowCount(0);
            
            while(rs.next())
            {
                studentName= rs.getString("StudentName");
                enroll= rs.getString("EnrollmentNo");
                deptyear= rs.getString("YearDepartment");
                amount= rs.getString("PaymentAmount");
                mode= rs.getString("ModeOfPayment");
                date =rs.getString("PaymentDate");
                
                String tbdata[] ={enroll,studentName,deptyear ,mode,amount,date};
                ComptblModel.addRow(tbdata);

            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        
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
            
            String sql ="SELECT * FROM feespayment where `ModeOfPayment` = 'Debit Card'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             
            DefaultTableModel mechtblModel = (DefaultTableModel)table.getModel();
            
            mechtblModel.setRowCount(0);
            
            while(rs.next())
            {
                studentName= rs.getString("StudentName");
                enroll= rs.getString("EnrollmentNo");
                deptyear= rs.getString("YearDepartment");
                amount= rs.getString("PaymentAmount");
                mode= rs.getString("ModeOfPayment");
                date =rs.getString("PaymentDate");
                
                String tbdata[] ={enroll,studentName,deptyear ,mode,amount,date};
                mechtblModel.addRow(tbdata);

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
            
            String sql ="SELECT * FROM feespayment where `ModeOfPayment` = 'Cheaque'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             
            DefaultTableModel civiltblModel = (DefaultTableModel)table.getModel();
            
            civiltblModel.setRowCount(0);
            
            while(rs.next())
            {
                studentName= rs.getString("StudentName");
                enroll= rs.getString("EnrollmentNo");
                deptyear= rs.getString("YearDepartment");
                amount= rs.getString("PaymentAmount");
                mode= rs.getString("ModeOfPayment");
                date =rs.getString("PaymentDate");
                
                String tbdata[] ={enroll,studentName,deptyear ,mode,amount,date};
                civiltblModel.addRow(tbdata);

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
            
            String sql ="SELECT * FROM feespayment where `ModeOfPayment` = 'Demand Draft'";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             
            DefaultTableModel electblModel = (DefaultTableModel)table.getModel();
            
            electblModel.setRowCount(0);
            
            while(rs.next())
            {
                studentName= rs.getString("StudentName");
                enroll= rs.getString("EnrollmentNo");
                deptyear= rs.getString("YearDepartment");
                amount= rs.getString("PaymentAmount");
                mode= rs.getString("ModeOfPayment");
                date =rs.getString("PaymentDate");
                
                String tbdata[] ={enroll,studentName,deptyear ,mode,amount,date};
                electblModel.addRow(tbdata);

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

    private void lbl_elecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_elecMouseClicked
        // TODO add your handling code here:
        new Admin_FeesRecordElec().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_elecMouseClicked

    private void lbl_elecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_elecMouseEntered
        // TODO add your handling code here:
        lbl_elec.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_elecMouseEntered

    private void lbl_elecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_elecMouseExited
        // TODO add your handling code here:
        lbl_elec.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_elecMouseExited

    private void lbl_mechMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mechMouseClicked
        // TODO add your handling code here:
        new Admin_FeesRecordMech().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_mechMouseClicked

    private void lbl_mechMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mechMouseEntered
        // TODO add your handling code here:
        lbl_mech.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_mechMouseEntered

    private void lbl_mechMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mechMouseExited
        // TODO add your handling code here:
        lbl_mech.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_mechMouseExited

    private void lbl_compMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_compMouseClicked
        // TODO add your handling code here:
        new Admin_FeesRecordComps().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_compMouseClicked

    private void lbl_compMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_compMouseEntered
        // TODO add your handling code here:
        lbl_comp.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_compMouseEntered

    private void lbl_compMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_compMouseExited
        // TODO add your handling code here:
        lbl_comp.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_compMouseExited

    private void lbl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseClicked
        // TODO add your handling code here:
        new Admin_FeesDashboard().setVisible(true);
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

    private void lbl_civilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_civilMouseClicked
        // TODO add your handling code here:
        new Admin_FeesRecordCivil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_civilMouseClicked

    private void lbl_civilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_civilMouseEntered
        // TODO add your handling code here:
        lbl_civil.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_civilMouseEntered

    private void lbl_civilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_civilMouseExited
        // TODO add your handling code here:
        lbl_civil.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_civilMouseExited

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
            java.util.logging.Logger.getLogger(Admin_FeeViewByPaymentMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_FeeViewByPaymentMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_FeeViewByPaymentMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_FeeViewByPaymentMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_FeeViewByPaymentMode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_Demand;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JLabel lbl_cheaque;
    private javax.swing.JLabel lbl_civil;
    private javax.swing.JLabel lbl_comp;
    private javax.swing.JLabel lbl_credit;
    private javax.swing.JLabel lbl_debit;
    private javax.swing.JLabel lbl_elec;
    private javax.swing.JLabel lbl_mech;
    private javax.swing.JPanel pnl_Civil;
    private javax.swing.JPanel pnl_Computer;
    private javax.swing.JPanel pnl_Electrical;
    private javax.swing.JPanel pnl_mechanical;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
