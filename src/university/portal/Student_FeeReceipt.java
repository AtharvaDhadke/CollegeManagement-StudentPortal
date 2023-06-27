/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Atharva Dhadke
 */
public class Student_FeeReceipt extends javax.swing.JFrame {
    
     
    String StudentName,EnrollmentNo,Dept,Year,Username,YearDepartment,TutionFees,Devlpoment,Insurance,Exam,Icard,CMD,Form,Total;
    String paymentMode,modeofPayment,paymentDate;
    String creditNo,creditName,creditCvv,creditBank;
    String debitNo,debitName,debitCvv,debitBank;
    String dd,ddAccNo,ddIFSC,ddBank;
    String cheaqueNo,cheaqueAccNo,cheaqueIFSC,cheaqueBank;
    
    int transactionId;
    int id;
    
    String voucher;
    
    

    /**
     * Creates new form Student_FeeReceipt
     */
    public Student_FeeReceipt() {
        initComponents();
        
       Random random = new Random();
         id =random.nextInt(10000);
         transactionId= id*6;
         
         String trans = String.valueOf(transactionId);         
         lbl_r_trans.setText(trans);
         
         voucher = "AJH"+trans;
         lbl_r_voucher.setText(voucher);
        
        try
        {
            String test = FirstPage.username;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            PreparedStatement ps;
            
            String sql = "SELECT * FROM feestructure WHERE username='" + test + "'";
            ps = con.prepareStatement(sql);
            
          
            ResultSet rs = ps.executeQuery ();
            while(rs.next())
            {
               
               
            StudentName  = rs.getString("StudentName");
             EnrollmentNo  = rs.getString("EnrollmentNo");
              Dept  = rs.getString("Department");
               Year  = rs.getString("Year");
                Username  = rs.getString("Username");
                 YearDepartment  = rs.getString("YearDepartment");
                  TutionFees  = rs.getString("TutionFees");
                   Devlpoment  = rs.getString("DevelopmentFees");
                    Insurance  = rs.getString("InsuranceFees");
                     Exam  = rs.getString("ExamFees");
                      Icard  = rs.getString("ICard");
                       CMD  = rs.getString("CMD");
                        Form  = rs.getString("FormFee");
                         Total  = rs.getString("Total");
                      
            
          }
        }
        catch(Exception e)
        {
            System.out.println("Caught Exception");
            e.getMessage();
        }
        
        try
        {
            String test = FirstPage.username;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            PreparedStatement ps;
            
            String sql = "SELECT * FROM feespayment WHERE username='" + test + "'";
            ps = con.prepareStatement(sql);
            
          
            ResultSet rs = ps.executeQuery ();
            while(rs.next())
            {
               
               
                 paymentMode  = rs.getString("PaymentAmount");
                  modeofPayment  = rs.getString("ModeOfPayment");
                   paymentDate  = rs.getString("PaymentDate");

          }
        }
        catch(Exception e)
        {
            System.out.println("Caught Exception");
            e.getMessage();
        }
 
        lbl_r_tution.setText(TutionFees);
        lbl_r_development.setText(Devlpoment);
        lbl_r_insurance.setText(Insurance);
        lbl_r_exam.setText(Exam);
        lbl_r_id.setText(Icard);
        lbl_r_moneyDeposit.setText(CMD);
        lbl_r_formFee.setText(Form);
        lbl_r_total.setText(Total);
        lbl_r_name.setText(StudentName);
        lbl_r_enroll.setText(EnrollmentNo);
        lbl_r_class.setText(Year+" "+Dept);
        lbl_r_course.setText("Diploma in "+Dept+" [Full Time]");
        lbl_date.setText(paymentDate);
        rec_paymentMode.setText(modeofPayment);
        rec_amount.setText(Total);
        
        try{
            if(modeofPayment.equals("Debit Card"))
            {
                 try
                {
                    String test = FirstPage.username;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
                    PreparedStatement ps;

                    String sql = "SELECT * FROM debitcard WHERE username='" + test + "'";
                    ps = con.prepareStatement(sql);


                    ResultSet rs = ps.executeQuery ();
                    while(rs.next())
                    {
                         debitNo  = rs.getString("debitcardNo");
                         debitName  = rs.getString("debitcardName");
                         debitCvv  = rs.getString("debitcardNoCvv");
                         debitBank  = rs.getString("debitcardBank");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Caught Exception");
                    e.getMessage();
                }
                 
                 rec_bankName.setText(debitBank);
                 
            }
            else if(modeofPayment.equals("Credit Card"))
            {
                try
                {
                    String test = FirstPage.username;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
                    PreparedStatement ps;

                    String sql = "SELECT * FROM creditcard WHERE username='" + test + "'";
                    ps = con.prepareStatement(sql);


                    ResultSet rs = ps.executeQuery ();
                    while(rs.next())
                    {   
                         creditNo  = rs.getString("creditCardNo");
                         creditName  = rs.getString("creditCardName");
                         creditCvv  = rs.getString("creditCardCvv");
                         creditBank  = rs.getString("creditCardBank");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Caught Exception");
                    e.getMessage();
                }
                 
                 rec_bankName.setText(creditBank);
            }

            else if(modeofPayment.equals("Demand Draft"))
            {
               try
                {
                    String test = FirstPage.username;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
                    PreparedStatement ps;

                    String sql = "SELECT * FROM demanddraft WHERE username='" + test + "'";
                    ps = con.prepareStatement(sql);


                    ResultSet rs = ps.executeQuery ();
                    while(rs.next())
                    {   
                         dd  = rs.getString("recipient");
                         ddAccNo  = rs.getString("accountno");
                         ddIFSC  = rs.getString("ifsc");
                         ddBank  = rs.getString("bankname");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Caught Exception");
                    e.getMessage();
                }
                 
                 rec_bankName.setText(ddBank);
            }

            else if(modeofPayment.equals("Cheaque"))
            {
                try
                {
                    String test = FirstPage.username;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
                    PreparedStatement ps;

                    String sql = "SELECT * FROM cheaque WHERE username='" + test + "'";
                    ps = con.prepareStatement(sql);


                    ResultSet rs = ps.executeQuery ();
                    while(rs.next())
                    {   
                         cheaqueNo  = rs.getString("cheaqueno");
                         cheaqueAccNo  = rs.getString("accountno");
                         cheaqueIFSC  = rs.getString("ifsc");
                         cheaqueBank  = rs.getString("bankname");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Caught Exception");
                    e.getMessage();
                }
                 
                 rec_bankName.setText(cheaqueBank);
                
            }
            else
            {
                System.out.println("NOthing working");
            }
        }
        catch(Exception e){}
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl_receipt = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        rec_date = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        lbl_r_development = new javax.swing.JLabel();
        lbl_r_insurance = new javax.swing.JLabel();
        lbl_r_id = new javax.swing.JLabel();
        lbl_r_exam = new javax.swing.JLabel();
        lbl_r_formFee = new javax.swing.JLabel();
        lbl_r_moneyDeposit = new javax.swing.JLabel();
        lbl_r_total = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        lbl_r_name = new javax.swing.JLabel();
        lbl_r_enroll = new javax.swing.JLabel();
        lbl_r_course = new javax.swing.JLabel();
        lbl_r_class = new javax.swing.JLabel();
        lbl_r_voucher = new javax.swing.JLabel();
        lbl_r_trans = new javax.swing.JLabel();
        lbl_r_tution = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        rec_paymentMode = new javax.swing.JLabel();
        rec_bankName = new javax.swing.JLabel();
        rec_amount = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel50 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_Print = new javax.swing.JLabel();
        lbl_back1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        pnl_receipt.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 41)); // NOI18N
        jLabel46.setText("University");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel47.setText("(An Autonomous Institute of Govt.of Maharashta-Accredited by NBA-AICTE)");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel48.setText("RECEIPT OF PAYMENT");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel49.setText("Date :");

        rec_date.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel51.setText("Name :");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel52.setText("Enrollment No. :");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel53.setText("Voucher Id :");

        jLabel55.setBackground(new java.awt.Color(255, 102, 102));
        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel55.setText("Transaction Id :");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel56.setText("Course :");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel57.setText("Class :");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel45.setText("AC GI NAME");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel58.setText("Recieved Amount");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel59.setText("Paid Amount");
        jPanel4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel60.setText("Tution Fee");

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel61.setText("Development Fee");

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel62.setText("Insurance Fee");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel63.setText("ICard");

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel64.setText("Exam Fee");

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel65.setText("Form and Prospectus Fee");

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel66.setText("Caution Money Deposit");

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel67.setText("Voucher Total");

        lbl_r_development.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_development.setText("jLabel69");

        lbl_r_insurance.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_insurance.setText("jLabel70");

        lbl_r_id.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_id.setText("jLabel71");

        lbl_r_exam.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_exam.setText("jLabel72");

        lbl_r_formFee.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_formFee.setText("jLabel73");

        lbl_r_moneyDeposit.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_moneyDeposit.setText("jLabel74");

        lbl_r_total.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        lbl_r_total.setText("jLabel75");

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel76.setText("0.00");

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel77.setText("0.00");

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel78.setText("0.00");

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel79.setText("0.00");

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel80.setText("0.00");

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel81.setText("0.00");

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel82.setText("0.00");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel83.setText("0.00");

        lbl_r_name.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_name.setText("jLabel68");

        lbl_r_enroll.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_enroll.setText("jLabel69");

        lbl_r_course.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_course.setText("jLabel70");

        lbl_r_class.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_class.setText("jLabel71");

        lbl_r_voucher.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_voucher.setText(" ");

        lbl_r_trans.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N

        lbl_r_tution.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbl_r_tution.setText("jLabel54");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel54.setText("Payment Mode :");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel68.setText("Bank Name :");

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel69.setText("Amount Paid :");

        rec_paymentMode.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N

        rec_bankName.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N

        rec_amount.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        rec_amount.setText("jLabel72");

        jLabel73.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\College Project\\version 2.1\\Fees Paid.png")); // NOI18N
        jLabel73.setText("Error 404 Image not found");

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel74.setText("Cashier");

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel75.setText("Anil Shamrao Deshmukh");

        jPanel5.setBackground(new java.awt.Color(254, 200, 218));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(248, 84, 138)));

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(204, 0, 51));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("N.B : 1) This receipt should be preserved . 2) This receipt must be produced at the time of refund");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel50.setText("RECEIPT OF PAYMENT");

        lbl_date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\FirstPage\\University_Logo-removebg-preview.png")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel49)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187)
                                .addComponent(jLabel50)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rec_date, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel48))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_r_name, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addComponent(jLabel53)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_r_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_r_enroll, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(231, 231, 231)
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_r_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_r_course, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel75)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel57)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbl_r_class, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator3)
                                    .addComponent(jSeparator4)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(326, 326, 326)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel47)))))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel66)
                                                .addGap(23, 23, 23))
                                            .addComponent(jLabel65)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel64)
                                                .addGap(158, 158, 158))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel63)
                                                .addGap(200, 200, 200))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel62)
                                                .addGap(112, 112, 112))
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                    .addComponent(jLabel61)
                                                    .addGap(80, 80, 80))
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                    .addComponent(jLabel60)
                                                    .addGap(149, 149, 149))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbl_r_moneyDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl_r_formFee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl_r_exam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl_r_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl_r_insurance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl_r_development, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl_r_tution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(270, 270, 270)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel82)
                                            .addComponent(jLabel81)
                                            .addComponent(jLabel80)
                                            .addComponent(jLabel79)
                                            .addComponent(jLabel78)
                                            .addComponent(jLabel76)
                                            .addComponent(jLabel77)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel67)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                                        .addComponent(lbl_r_total)
                                        .addGap(255, 255, 255)
                                        .addComponent(jLabel83)))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel54)
                                    .addGap(18, 18, 18)
                                    .addComponent(rec_paymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel68)
                                        .addComponent(jLabel69))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rec_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rec_bankName, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addGap(0, 606, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel74)
                .addGap(705, 705, 705))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel47))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel48))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(rec_date, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel49)
                                    .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel50)
                                .addGap(18, 18, 18)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(lbl_r_voucher))
                    .addComponent(lbl_r_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel52)
                        .addComponent(lbl_r_enroll))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(lbl_r_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(lbl_r_course))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(lbl_r_class))
                .addGap(54, 54, 54)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel61)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel62)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel63)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel64)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel65)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel77)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel78)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel79)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel80)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel81)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel82)))
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(lbl_r_total)
                            .addComponent(jLabel67))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel54)
                                    .addComponent(rec_paymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel68)
                                    .addComponent(rec_bankName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel69)
                                    .addComponent(rec_amount))
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel74)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel75)
                        .addGap(68, 68, 68)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(lbl_r_development)
                                .addGap(22, 22, 22)
                                .addComponent(lbl_r_insurance)
                                .addGap(22, 22, 22)
                                .addComponent(lbl_r_id)
                                .addGap(22, 22, 22)
                                .addComponent(lbl_r_exam)
                                .addGap(22, 22, 22)
                                .addComponent(lbl_r_formFee)
                                .addGap(22, 22, 22)
                                .addComponent(lbl_r_moneyDeposit))
                            .addComponent(lbl_r_tution))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jScrollPane2.setViewportView(jPanel6);

        javax.swing.GroupLayout pnl_receiptLayout = new javax.swing.GroupLayout(pnl_receipt);
        pnl_receipt.setLayout(pnl_receiptLayout);
        pnl_receiptLayout.setHorizontalGroup(
            pnl_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_receiptLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_receiptLayout.setVerticalGroup(
            pnl_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lbl_Print.setBackground(new java.awt.Color(153, 153, 153));
        lbl_Print.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_Print.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Print.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Print.setText("Print");
        lbl_Print.setOpaque(true);
        lbl_Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_PrintMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_PrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_PrintMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_PrintMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_PrintMouseReleased(evt);
            }
        });

        lbl_back1.setBackground(new java.awt.Color(153, 153, 153));
        lbl_back1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_back1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_back1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_back1.setText("BACK");
        lbl_back1.setOpaque(true);
        lbl_back1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_back1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_back1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_back1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_back1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_back1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_receipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lbl_back1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(422, 422, 422)
                        .addComponent(lbl_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 426, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Print)
                    .addComponent(lbl_back1))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, -1, 850));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_PrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_PrintMouseClicked
        // TODO add your handling code here:
        //       new Admin_LibraryDashboard().setVisible(true);
        //       this.dispose();
        
        printRecord(jPanel6);
    }//GEN-LAST:event_lbl_PrintMouseClicked

    private void lbl_PrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_PrintMouseEntered
        // TODO add your handling code here:

        lbl_Print.setBackground(new Color(0,0,0));
        lbl_Print.setLocation(lbl_Print.getLocation().x, lbl_Print.getLocation().y-4);
    }//GEN-LAST:event_lbl_PrintMouseEntered

    private void lbl_PrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_PrintMouseExited
        // TODO add your handling code here:
        lbl_Print.setBackground(new Color(153,153,153));
        lbl_Print.setLocation(lbl_Print.getLocation().x, lbl_Print.getLocation().y+4);
    }//GEN-LAST:event_lbl_PrintMouseExited

    private void lbl_PrintMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_PrintMousePressed
        // TODO add your handling code here:
        lbl_Print.setLocation(lbl_Print.getLocation().x, lbl_Print.getLocation().y-4);
        
    }//GEN-LAST:event_lbl_PrintMousePressed

    private void lbl_PrintMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_PrintMouseReleased
        // TODO add your handling code here:
        lbl_Print.setLocation(lbl_Print.getLocation().x, lbl_Print.getLocation().y+4);
        
        
    }//GEN-LAST:event_lbl_PrintMouseReleased

    private void lbl_back1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lbl_back1MouseClicked

    private void lbl_back1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back1MouseEntered
        // TODO add your handling code here:
        
        lbl_back1.setBackground(new Color(0,0,0));
        lbl_back1.setLocation(lbl_back1.getLocation().x, lbl_back1.getLocation().y-4);
    }//GEN-LAST:event_lbl_back1MouseEntered

    private void lbl_back1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back1MouseExited
        // TODO add your handling code here:
        lbl_back1.setBackground(new Color(153,153,153));
        lbl_back1.setLocation(lbl_back1.getLocation().x, lbl_back1.getLocation().y+4);
    }//GEN-LAST:event_lbl_back1MouseExited

    private void lbl_back1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back1MousePressed
        // TODO add your handling code here:
        lbl_back1.setLocation(lbl_back1.getLocation().x, lbl_back1.getLocation().y-4);
    }//GEN-LAST:event_lbl_back1MousePressed

    private void lbl_back1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back1MouseReleased
        // TODO add your handling code here:
         lbl_back1.setLocation(lbl_back1.getLocation().x, lbl_back1.getLocation().y+4);

         this.dispose();
    }//GEN-LAST:event_lbl_back1MouseReleased

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
            java.util.logging.Logger.getLogger(Student_FeeReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_FeeReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_FeeReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_FeeReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_FeeReceipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_Print;
    private javax.swing.JLabel lbl_back1;
    private javax.swing.JLabel lbl_date;
    static javax.swing.JLabel lbl_r_class;
    static javax.swing.JLabel lbl_r_course;
    static javax.swing.JLabel lbl_r_development;
    static javax.swing.JLabel lbl_r_enroll;
    static javax.swing.JLabel lbl_r_exam;
    static javax.swing.JLabel lbl_r_formFee;
    static javax.swing.JLabel lbl_r_id;
    static javax.swing.JLabel lbl_r_insurance;
    static javax.swing.JLabel lbl_r_moneyDeposit;
    static javax.swing.JLabel lbl_r_name;
    static javax.swing.JLabel lbl_r_total;
    static javax.swing.JLabel lbl_r_trans;
    static javax.swing.JLabel lbl_r_tution;
    static javax.swing.JLabel lbl_r_voucher;
    private javax.swing.JPanel pnl_receipt;
    static javax.swing.JLabel rec_amount;
    static javax.swing.JLabel rec_bankName;
    private javax.swing.JLabel rec_date;
    static javax.swing.JLabel rec_paymentMode;
    // End of variables declaration//GEN-END:variables
    
    private void printRecord(JPanel panel){
        // Create PrinterJob Here
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        // Set Printer Job Name
        printerJob.setJobName("Print Record");
        // Set Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                // Check If No Printable Content
                if(pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                // Make 2D Graphics to map content
                Graphics2D graphics2D = (Graphics2D)graphics;
                // Set Graphics Translations
                // A Little Correction here Multiplication was not working so I replaced with addition
                graphics2D.translate(pageFormat.getImageableX()+10, pageFormat.getImageableY()+10);
                // This is a page scale. Default should be 0.3 I am using 0.5
                graphics2D.scale(0.5, 0.5);
                
                // Now paint panel as graphics2D
                panel.paint(graphics2D);
                
                // return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        // Store printerDialog as boolean
        boolean returningResult = printerJob.printDialog();
        // check if dilog is showing
        if(returningResult){
            // Use try catch exeption for failure
            try{
                // Now call print method inside printerJob to print
                printerJob.print();
            }catch (PrinterException printerException){
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }



}
