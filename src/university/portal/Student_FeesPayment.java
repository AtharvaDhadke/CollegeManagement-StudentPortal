/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static university.portal.Student_FeeReceipt.*;
import static university.portal.Student_FeesStructure.*;

/**
 *
 * @author Atharva Dhadke
 */
public class Student_FeesPayment extends javax.swing.JFrame {

    /**
     * Creates new form Student_FeesPayment
     */
    
  
    String paymentMode,creditNo,creditName,creditCvv,creditBank;
    String debitNo,debitName,debitCvv,debitBank;
    String dd,ddAccNo,ddIFSC,ddBank;
    String cheaqueNo,cheaqueAccNo,cheaqueIFSC,cheaqueBank;
    String re_tution,re_development,re_insurance,re_exam,re_id,re_cmd,re_formFee,re_total,paymentdate,trc_id;
    int transactionId;
    
    String StudentName,EnrollmentNo,Dept,Year,Username,YearDepartment,TutionFees,Devlpoment,Insurance,Exam,Icard,CMD,Form,Total;
    
    
    static boolean flag = false;
    
    
    public Student_FeesPayment() {
        initComponents();
        
         pnl_cheaque.setVisible(false);
            pnl_demandDraft.setVisible(false);
            pnl_debitCard.setVisible(false);
            pnl_bankTransfer.setVisible(false);
            pnl_creditCard.setVisible(true);
        
        creditNo=tf_creditCardNo.getText();
            creditName=tf_creditCardName.getText();
            creditCvv=tf_creditCvv.getText();
            creditBank=(String)cmb_creditBank.getSelectedItem();
            
            debitNo=tf_debitCardNo.getText();
            debitName=tf__debit_nameOnCard.getText();
            debitCvv=tf_debitCvv.getText();
            debitBank=(String)cmb_debitBank.getSelectedItem();
        
        paymentMode=(String)cmb_paymentMode.getSelectedItem();
        System.out.println(paymentMode);
        
 
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
                     Date selectedDate = new Date(); //jDateChooser1.getDate();
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                    paymentdate = dateformat.format(selectedDate);
                    
                    lbl_date.setText(paymentdate);
                   lbl_paymentamount.setText(Total);
        
    }
             
        boolean CreditValidation()
        {
            creditNo=tf_creditCardNo.getText();
            creditName=tf_creditCardName.getText();
            creditCvv=tf_creditCvv.getText();
            creditBank=(String)cmb_creditBank.getSelectedItem();
            
     
            if(creditNo.trim().isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "Please Enter Credit card Number", "Error", JOptionPane.ERROR_MESSAGE);
                tf_creditCardNo.grabFocus();
                return false;
            }
            
            if(creditNo.length()!=16)
            {
                 JOptionPane.showMessageDialog(null, "Please Enter 16 digit Credit card number", "Error", JOptionPane.ERROR_MESSAGE);
                tf_creditCardNo.grabFocus();
                return false;
            }
            
           if(creditName.trim().isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "Please Enter Name on Card", "Error", JOptionPane.ERROR_MESSAGE);
                tf_creditCardName.grabFocus();
                return false;
            }
              
            if(creditCvv.trim().isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "Please Enter Credit card Cvv", "Error", JOptionPane.ERROR_MESSAGE);
                tf_creditCvv.grabFocus();
                return false;
            }
            
            if(creditCvv.length()!=3)
            {
                 JOptionPane.showMessageDialog(null, "Please Enter 3 digit Credit card Cvv", "Error", JOptionPane.ERROR_MESSAGE);
                tf_creditCvv.grabFocus();
                return false;
            }   
            return true;
        }
//         **************************************DEBIT CARD*************************************   
        boolean DebitValidation()
        {
            debitNo=tf_debitCardNo.getText();
            debitName=tf__debit_nameOnCard.getText();
            debitCvv=tf_debitCvv.getText();
            debitBank=(String)cmb_debitBank.getSelectedItem();
  
            if(debitCvv.trim().isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "Please Enter Debit card Cvv", "Error", JOptionPane.ERROR_MESSAGE);
                tf_debitCvv.grabFocus();
                return false;
            }

            if(debitCvv.length()!=3)
            {
                 JOptionPane.showMessageDialog(null, "Please Enter 3 digit Debit card Cvv", "Error", JOptionPane.ERROR_MESSAGE);
                tf_debitCvv.grabFocus();
                return false;
            }
             return true;
        }
//        ********************************************************
        public void CheckCreditCvv()
        {   
           creditCvv=tf_creditCvv.getText();
           
            if(creditCvv.length()==3)
            {     
                  lbl_error.setText(" ");   
            }
     
            else 
            {
                 lbl_error.setText("!Cvv Number should be 3 digit");              
              }
        }
        
        public void CheckCreditNumber()
        {   
           creditNo=tf_creditCardNo.getText();
           
            if(creditNo.length()==16)
            {     
                  lbl_no_error.setText(" ");   
            }
     
            else 
            {
                 lbl_no_error.setText("!Card Number should be 16 digit");              
              }
        }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Payment = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_makePayment = new javax.swing.JButton();
        lbl_paymentamount = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmb_paymentMode = new javax.swing.JComboBox<>();
        pnl_creditCard = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tf_creditCardNo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tf_creditCardName = new javax.swing.JTextField();
        tf_creditCvv = new javax.swing.JPasswordField();
        jLabel23 = new javax.swing.JLabel();
        cmb_creditBank = new javax.swing.JComboBox<>();
        lbl_error = new javax.swing.JLabel();
        lbl_no_error = new javax.swing.JLabel();
        pnl_debitCard = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        tf_debitCardNo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tf__debit_nameOnCard = new javax.swing.JTextField();
        tf_debitCvv = new javax.swing.JPasswordField();
        jLabel29 = new javax.swing.JLabel();
        cmb_debitBank = new javax.swing.JComboBox<>();
        pnl_cheaque = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        tf_cheaqueNo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        tf_cheaque_AccNo = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        tf_cheaque_IFSC = new javax.swing.JTextField();
        cmb_cheaque_bank = new javax.swing.JComboBox<>();
        pnl_demandDraft = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        tf_dd_draft = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        tf_dd_AccNo = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        tf_dd_IFSC = new javax.swing.JTextField();
        cmb_dd_bank = new javax.swing.JComboBox<>();
        pnl_bankTransfer = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        tf_bank_transfer = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        lbl_date = new javax.swing.JLabel();
        lbl_back2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnl_Payment.setBackground(new java.awt.Color(255, 255, 255));
        pnl_Payment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PAYMENT DETAILS");
        jLabel2.setOpaque(true);
        pnl_Payment.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 70));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel17.setText("Payment Amount :");
        pnl_Payment.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 240, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel18.setText("Payment Date :");
        pnl_Payment.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 200, 40));

        btn_makePayment.setBackground(new java.awt.Color(0, 0, 0));
        btn_makePayment.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_makePayment.setForeground(new java.awt.Color(255, 255, 255));
        btn_makePayment.setText("Make Payment");
        btn_makePayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_makePaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_makePaymentMouseExited(evt);
            }
        });
        btn_makePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_makePaymentActionPerformed(evt);
            }
        });
        pnl_Payment.add(btn_makePayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 590, 220, 50));

        lbl_paymentamount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pnl_Payment.add(lbl_paymentamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 260, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel16.setText("Mode of Payments :");
        pnl_Payment.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 240, 40));

        cmb_paymentMode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_paymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credit Card", "Debit Card", "Cheaque", "Demand Draft" }));
        cmb_paymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_paymentModeActionPerformed(evt);
            }
        });
        pnl_Payment.add(cmb_paymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 150, 40));

        pnl_creditCard.setBackground(new java.awt.Color(255, 255, 255));
        pnl_creditCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Fees Management\\Credit Card.jpg")); // NOI18N
        pnl_creditCard.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 13, 529, 298));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setText("Credit Card No :");
        pnl_creditCard.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 55, -1, 42));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setText("Name on card :");
        pnl_creditCard.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 123, 183, 36));

        tf_creditCardNo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_creditCardNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_creditCardNoActionPerformed(evt);
            }
        });
        tf_creditCardNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_creditCardNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_creditCardNoKeyReleased(evt);
            }
        });
        pnl_creditCard.add(tf_creditCardNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 55, 421, 42));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setText("CVV No :");
        pnl_creditCard.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 241, -1, 41));

        tf_creditCardName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_creditCardName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_creditCardNameActionPerformed(evt);
            }
        });
        pnl_creditCard.add(tf_creditCardName, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 121, 421, 42));

        tf_creditCvv.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_creditCvv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_creditCvvFocusGained(evt);
            }
        });
        tf_creditCvv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_creditCvvActionPerformed(evt);
            }
        });
        tf_creditCvv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_creditCvvKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_creditCvvKeyReleased(evt);
            }
        });
        pnl_creditCard.add(tf_creditCvv, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 242, 139, 40));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setText("Bank Name :");
        pnl_creditCard.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 183, -1, 40));

        cmb_creditBank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_creditBank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));
        pnl_creditCard.add(cmb_creditBank, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 183, 421, 40));

        lbl_error.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbl_error.setForeground(new java.awt.Color(255, 0, 0));
        pnl_creditCard.add(lbl_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 349, 22));

        lbl_no_error.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_no_error.setForeground(new java.awt.Color(255, 0, 0));
        pnl_creditCard.add(lbl_no_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 420, 20));

        pnl_Payment.add(pnl_creditCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1200, 340));

        pnl_debitCard.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Fees Management\\Debit Card.png")); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel26.setText("Debit Card No :");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel27.setText("Name on card :");

        tf_debitCardNo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel28.setText("CVV No :");

        tf__debit_nameOnCard.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        tf_debitCvv.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_debitCvv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_debitCvvActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel29.setText("Bank Name :");

        cmb_debitBank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_debitBank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));

        javax.swing.GroupLayout pnl_debitCardLayout = new javax.swing.GroupLayout(pnl_debitCard);
        pnl_debitCard.setLayout(pnl_debitCardLayout);
        pnl_debitCardLayout.setHorizontalGroup(
            pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_debitCardLayout.createSequentialGroup()
                .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_debitCardLayout.createSequentialGroup()
                        .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_debitCardLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_debitCardLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29))
                                .addGap(24, 24, 24)))
                        .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf__debit_nameOnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_debitCvv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_debitBank, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_debitCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_debitCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(jLabel25)
                .addGap(23, 23, 23))
        );
        pnl_debitCardLayout.setVerticalGroup(
            pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_debitCardLayout.createSequentialGroup()
                .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_debitCardLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_debitCardLayout.createSequentialGroup()
                                .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_debitCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf__debit_nameOnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60))
                            .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmb_debitBank, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(pnl_debitCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_debitCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_debitCardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pnl_Payment.add(pnl_debitCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1200, 340));

        pnl_cheaque.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Fees Management\\Bank Cheaque.jpg")); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setText("Cheaque No :");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setText("Account No :");

        tf_cheaqueNo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel33.setText("Bank Name :");

        tf_cheaque_AccNo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel34.setText("IFSC code :");

        tf_cheaque_IFSC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        cmb_cheaque_bank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_cheaque_bank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));

        javax.swing.GroupLayout pnl_cheaqueLayout = new javax.swing.GroupLayout(pnl_cheaque);
        pnl_cheaque.setLayout(pnl_cheaqueLayout);
        pnl_cheaqueLayout.setHorizontalGroup(
            pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cheaqueLayout.createSequentialGroup()
                .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_cheaqueLayout.createSequentialGroup()
                        .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_cheaqueLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_cheaqueLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cheaqueLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_cheaque_AccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_cheaque_IFSC, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_cheaque_bank, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cheaqueLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31)
                        .addGap(26, 26, 26)
                        .addComponent(tf_cheaqueNo, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_cheaqueLayout.setVerticalGroup(
            pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cheaqueLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_cheaqueLayout.createSequentialGroup()
                        .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_cheaqueNo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_cheaque_AccNo, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_cheaque_IFSC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(pnl_cheaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_cheaque_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 49, Short.MAX_VALUE))
        );

        pnl_Payment.add(pnl_cheaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1200, 340));

        pnl_demandDraft.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Fees Management\\Bank Cheaque.jpg")); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel36.setText("Recipient Name:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setText("Account No :");

        tf_dd_draft.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel38.setText("Bank Name :");

        tf_dd_AccNo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel39.setText("IFSC code :");

        tf_dd_IFSC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        cmb_dd_bank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_dd_bank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));

        javax.swing.GroupLayout pnl_demandDraftLayout = new javax.swing.GroupLayout(pnl_demandDraft);
        pnl_demandDraft.setLayout(pnl_demandDraftLayout);
        pnl_demandDraftLayout.setHorizontalGroup(
            pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_demandDraftLayout.createSequentialGroup()
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_dd_draft, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                        .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_demandDraftLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_dd_AccNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                            .addComponent(tf_dd_IFSC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                            .addComponent(cmb_dd_bank, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_demandDraftLayout.setVerticalGroup(
            pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_demandDraftLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dd_draft, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_dd_AccNo, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dd_IFSC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnl_demandDraftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_dd_bank, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_demandDraftLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pnl_Payment.add(pnl_demandDraft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1200, 340));

        pnl_bankTransfer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Fees Management\\bank-transfer1.png")); // NOI18N

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel41.setText("Bank Transfer :");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel42.setText("Account No :");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel43.setText("Bank Name :");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel44.setText("IFSC code :");

        jComboBox5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allahabad Bank", "Andhra Bank", "Axis Bank", "Bank of Bahrain and Kuwait", "Bank of Baroda - Corporate Banking", "Bank of Baroda - Retail Banking", "Bank of India", "Bank of Maharashtra", "Canara Bank", "Central Bank of India", "City Union Bank", "Corporation Bank", "Deutsche Bank", "Development Credit Bank", "Dhanlaxmi Bank", "Federal Bank", "ICICI Bank", "IDBI Bank", "Indian Bank", "Indian Overseas Bank", "IndusInd Bank", "ING Vysya Bank", "Jammu and Kashmir Bank", "Karnataka Bank Ltd", "Karur Vysya Bank", "Kotak Bank", "Laxmi Vilas Bank", "Oriental Bank of Commerce", "Punjab National Bank - Corporate Banking", "Punjab National Bank - Retail Banking", "Punjab & Sind Bank", "Shamrao Vitthal Co-operative Bank", "South Indian Bank", "State Bank of Bikaner & Jaipur", "State Bank of Hyderabad", "State Bank of India", "State Bank of Mysore", "State Bank of Patiala", "State Bank of Travancore", "Syndicate Bank", "Tamilnad Mercantile Bank Ltd.", "UCO Bank", "Union Bank of India", "United Bank of India", "Vijaya Bank", "Yes Bank Ltd" }));

        javax.swing.GroupLayout pnl_bankTransferLayout = new javax.swing.GroupLayout(pnl_bankTransfer);
        pnl_bankTransfer.setLayout(pnl_bankTransferLayout);
        pnl_bankTransferLayout.setHorizontalGroup(
            pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bankTransferLayout.createSequentialGroup()
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_bank_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                        .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bankTransferLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_bankTransferLayout.setVerticalGroup(
            pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bankTransferLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_bank_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnl_bankTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bankTransferLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pnl_Payment.add(pnl_bankTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1200, 340));

        lbl_date.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pnl_Payment.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 200, 40));

        lbl_back2.setBackground(new java.awt.Color(153, 153, 153));
        lbl_back2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_back2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_back2.setText("BACK");
        lbl_back2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_back2.setOpaque(true);
        lbl_back2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_back2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_back2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_back2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_back2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_back2MouseReleased(evt);
            }
        });
        pnl_Payment.add(lbl_back2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 116, 47));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_Payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_makePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_makePaymentActionPerformed
        // TODO add your handling code here:
            if(paymentMode.equals("Credit Card"))
            {
            CreditValidation();
            }
            
            if(paymentMode.equals("Debit Card"))
            {
               DebitValidation();
            }
            
           

            
            try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
                String sql =  "INSERT INTO `feespayment`(`PaymentAmount`, `ModeOfPayment`, `PaymentDate`, `Username`, `EnrollmentNo`, `StudentName`, `YearDepartment`, `dept`, `year`)  VALUES (?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement st = con.prepareStatement(sql);
                              // st.setInt(1, Integer.parseInt(textField.getText()));
                st.setString(1,Total);
                st.setString(2,paymentMode);
                st.setString(3,paymentdate);
                st.setString(4,Username);
                st.setString(5,EnrollmentNo);
                st.setString(6,StudentName); 
                st.setString(7,YearDepartment);
                st.setString(8,Dept);
                st.setString(9,Year);
                
                
                int rs = st.executeUpdate();
                if (rs > 0){
                    flag = true;
                 JOptionPane.showMessageDialog(null, "Fees Paid Successfully . You can view Fee Receipt");
                 
                this.dispose();
                
                con.close();
                }
              }   
            
            catch(Exception e){
            
        }         

      
      

        
        //rec_date.setText(bdate);
       // lbl_r_trans.setText(trc_id);

       // lbl_r_voucher.setText("AJH"+trc_id);

        try{
            if(paymentMode.equals("Debit Card"))
            {
                
                try{
                Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");

                    String sql =  "INSERT INTO `debitcard`(`debitcardNo`, `debitcardName`, `debitcardBank`, `debitcardNoCvv`, `username`,`Date`,`EnrollmentNo`,`StudentName`) VALUES (?,?,?,?,?,?,?,?)";

                    PreparedStatement st = con.prepareStatement(sql);
                                  // st.setInt(1, Integer.parseInt(textField.getText()));
                    st.setString(1,debitNo);
                    st.setString(2,debitName);
                    st.setString(3,debitBank);
                    st.setString(4,debitCvv);
                    st.setString(5,Username);
                    st.setString(6,paymentdate);
                    st.setString(7,EnrollmentNo);
                    st.setString(8,StudentName);



                    int rs = st.executeUpdate();
                    if (rs > 0)
//                     JOptionPane.showMessageDialog(null, "DebitCard added");

                    con.close();
            }catch(Exception e){

            }         

                System.out.println("Debit crd no  " +debitNo);
                System.out.println("Debit crd name " +debitName);
                System.out.println("Debit crd cvv " +debitCvv);
                System.out.println("Debit crd bank " +debitBank);
            }
            else if(paymentMode.equals("Credit Card"))
            {
                
                
                    try{
                Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");

                    String sql =  "INSERT INTO `creditcard`(`creditCardNo`, `creditCardName`, `creditCardCvv`, `creditCardBank`,`username`,`Date`,`EnrollmentNo`,`StudentName`) VALUES (?,?,?,?,?,?,?,?)";

                    PreparedStatement st = con.prepareStatement(sql);
                                  // st.setInt(1, Integer.parseInt(textField.getText()));
                    st.setString(1,creditNo);
                    st.setString(2,creditName);
                    st.setString(3,creditCvv);
                    st.setString(4,creditBank);
                    st.setString(5,Username);
                    st.setString(6,paymentdate);
                     st.setString(7,EnrollmentNo);
                    st.setString(8,StudentName);



                    int rs = st.executeUpdate();
                    if (rs > 0)
//                     JOptionPane.showMessageDialog(null, "CreditCard added");

                    con.close();
            }catch(Exception e){

            }         
                
                System.out.println(creditNo);
                System.out.println(creditName);
                System.out.println(creditCvv);
                System.out.println(creditBank);
            }

            else if(paymentMode.equals("Demand Draft"))
            {
                dd=tf_dd_draft.getText();
                ddAccNo=tf_dd_AccNo.getText();
                ddIFSC=tf_dd_IFSC.getText();
                ddBank=(String)cmb_dd_bank.getSelectedItem();
               
                
                try{
                Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");

                    String sql =  "INSERT INTO `demanddraft`(`recipient`, `accountno`, `ifsc`, `bankname`, `username`,`Date`,`EnrollmentNo`,`StudentName`) VALUES (?,?,?,?,?,?,?,?)";

                    PreparedStatement st = con.prepareStatement(sql);
                                  // st.setInt(1, Integer.parseInt(textField.getText()));
                    st.setString(1,dd);
                    st.setString(2,ddAccNo);
                    st.setString(3,ddIFSC);
                    st.setString(4,ddBank);
                    st.setString(5,Username);
                    st.setString(6,paymentdate);
                     st.setString(7,EnrollmentNo);
                    st.setString(8,StudentName);



                    int rs = st.executeUpdate();
                    if (rs > 0)
//                     JOptionPane.showMessageDialog(null, "DemandDraft added");

                    con.close();
                }catch(Exception e){

                 }
            }

            else if(paymentMode.equals("Cheaque"))
            {
                cheaqueNo=tf_cheaqueNo.getText();
                cheaqueAccNo=tf_cheaque_AccNo.getText();
                cheaqueIFSC=tf_cheaque_IFSC.getText();
                cheaqueBank=(String)cmb_cheaque_bank.getSelectedItem();
                
                try{
                Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");

                    String sql =  "INSERT INTO `cheaque`(`cheaqueno`, `accountno`, `ifsc`, `bankname`, `username`, `Date`,`EnrollmentNo`,`StudentName`) VALUES (?,?,?,?,?,?,?,?)";

                    PreparedStatement st = con.prepareStatement(sql);
                                  // st.setInt(1, Integer.parseInt(textField.getText()));
                    st.setString(1,cheaqueNo);
                    st.setString(2,cheaqueAccNo);
                    st.setString(3,cheaqueIFSC);
                    st.setString(4,cheaqueBank);
                    st.setString(5,Username);
                    st.setString(6,paymentdate);
                     st.setString(7,EnrollmentNo);
                    st.setString(8,StudentName);



                    int rs = st.executeUpdate();
                    if (rs > 0)
//                     JOptionPane.showMessageDialog(null, "Cheaque added");

                    con.close();
            }catch(Exception e){

            }         
                
            }
            else
            {
                System.out.println("NOthing working");
            }

        }
        catch(Exception e)
        {
            e.getMessage();
        }
        //*****************************************************************************
    try{
        if(paymentMode.equals("Debit Card"))
        {
            rec_paymentMode.setText("Debit Card");
            rec_bankName.setText(debitBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);

        }

        else if(paymentMode.equals("Credit Card"))
        {
            rec_paymentMode.setText("Credit Card");
            rec_bankName.setText(creditBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);

        }

        else if(paymentMode.equals("Cheaque"))
        {
            rec_paymentMode.setText("Cheaque");
            rec_bankName.setText(cheaqueBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);

        }
        else if(paymentMode.equals("Demand Draft"))
        {
            rec_paymentMode.setText("Demand Draft");
            rec_bankName.setText(ddBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);

        }
        if(paymentMode.equals("Bank Transfer"))
        {
            rec_paymentMode.setText("Bank Transfer");
            rec_bankName.setText(debitBank);
            rec_amount.setText(lbl_total.getText());

            System.out.println(" working"+rec_paymentMode);
            System.out.println(" working"+rec_bankName);
            System.out.println(" working"+rec_amount);

        }
}
catch(Exception e){}
        
        
        
    }//GEN-LAST:event_btn_makePaymentActionPerformed

    private void cmb_paymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_paymentModeActionPerformed
        // TODO add your handling code here:

        paymentMode=(String)cmb_paymentMode.getSelectedItem();
        //        System.out.println(paymentMode);

        if(paymentMode.equals("Debit Card")){
            pnl_cheaque.setVisible(false);
            pnl_demandDraft.setVisible(false);
            pnl_creditCard.setVisible(false);
            pnl_bankTransfer.setVisible(false);
            pnl_debitCard.setVisible(true);

        }
        else if(paymentMode.equals("Credit Card")){
            pnl_cheaque.setVisible(false);
            pnl_demandDraft.setVisible(false);
            pnl_bankTransfer.setVisible(false);
            pnl_debitCard.setVisible(false);
            pnl_creditCard.setVisible(true);

        }
        else if(paymentMode.equals("Cheaque")){

            pnl_demandDraft.setVisible(false);
            pnl_bankTransfer.setVisible(false);
            pnl_debitCard.setVisible(false);
            pnl_creditCard.setVisible(false);
            pnl_cheaque.setVisible(true);
        }
        else if(paymentMode.equals("Demand Draft")){

            pnl_cheaque.setVisible(false);
            pnl_bankTransfer.setVisible(false);
            pnl_debitCard.setVisible(false);
            pnl_creditCard.setVisible(false);
            pnl_demandDraft.setVisible(true);
        }
        //        else if(paymentMode.equals("Bank Transfer")){
            //
            //            pnl_cheaque.show(false);
            //            pnl_debitCard.show(false);
            //            pnl_creditCard.show(false);
            //            pnl_demandDraft.show(false);
            //            pnl_bankTransfer.show(true);
            //       }
        else{
            System.out.println("Sorry error 404");
        }

    }//GEN-LAST:event_cmb_paymentModeActionPerformed

    private void tf_creditCardNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_creditCardNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_creditCardNoActionPerformed

    private void tf_creditCardNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_creditCardNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_creditCardNameActionPerformed

    private void tf_creditCvvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_creditCvvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_creditCvvActionPerformed

    private void tf_debitCvvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_debitCvvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_debitCvvActionPerformed

    private void tf_creditCvvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_creditCvvKeyReleased
        // TODO add your handling code here:
       CheckCreditCvv();
    }//GEN-LAST:event_tf_creditCvvKeyReleased

    private void tf_creditCvvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_creditCvvKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tf_creditCvvKeyPressed

    private void tf_creditCvvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_creditCvvFocusGained
        // TODO add your handling code here:
      
    }//GEN-LAST:event_tf_creditCvvFocusGained

    private void tf_creditCardNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_creditCardNoKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tf_creditCardNoKeyPressed

    private void tf_creditCardNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_creditCardNoKeyReleased
        // TODO add your handling code here:
                CheckCreditNumber();
    }//GEN-LAST:event_tf_creditCardNoKeyReleased

    private void lbl_back2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back2MouseClicked
        // TODO add your handling code here:
                       new Student_FeesManagementDashboard().setVisible(true);
                       this.dispose();
    }//GEN-LAST:event_lbl_back2MouseClicked

    private void lbl_back2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back2MouseEntered
        // TODO add your handling code here:

        lbl_back2.setBackground(new Color(255,255,255));
        lbl_back2.setLocation(lbl_back2.getLocation().x, lbl_back2.getLocation().y-4);
    }//GEN-LAST:event_lbl_back2MouseEntered

    private void lbl_back2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back2MouseExited
        // TODO add your handling code here:
        lbl_back2.setBackground(new Color(153,153,153));
        lbl_back2.setLocation(lbl_back2.getLocation().x, lbl_back2.getLocation().y+4);
    }//GEN-LAST:event_lbl_back2MouseExited

    private void lbl_back2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back2MousePressed
        // TODO add your handling code here:
        lbl_back2.setLocation(lbl_back2.getLocation().x, lbl_back2.getLocation().y-4);
    }//GEN-LAST:event_lbl_back2MousePressed

    private void lbl_back2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back2MouseReleased
        // TODO add your handling code here:
        lbl_back2.setLocation(lbl_back2.getLocation().x, lbl_back2.getLocation().y+4);

    }//GEN-LAST:event_lbl_back2MouseReleased

    private void btn_makePaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makePaymentMouseEntered
        // TODO add your handling code here:
        btn_makePayment.setBackground(new Color(255,255,255));
        btn_makePayment.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btn_makePaymentMouseEntered

    private void btn_makePaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_makePaymentMouseExited
        // TODO add your handling code here:
        
        btn_makePayment.setBackground(new Color(0,0,0));
        btn_makePayment.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_btn_makePaymentMouseExited

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
            java.util.logging.Logger.getLogger(Student_FeesPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_FeesPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_FeesPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_FeesPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_FeesPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_makePayment;
    private javax.swing.JComboBox<String> cmb_cheaque_bank;
    private javax.swing.JComboBox<String> cmb_creditBank;
    private javax.swing.JComboBox<String> cmb_dd_bank;
    private javax.swing.JComboBox<String> cmb_debitBank;
    private javax.swing.JComboBox<String> cmb_paymentMode;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JLabel lbl_back2;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_no_error;
    private javax.swing.JLabel lbl_paymentamount;
    private javax.swing.JPanel pnl_Payment;
    private javax.swing.JPanel pnl_bankTransfer;
    private javax.swing.JPanel pnl_cheaque;
    private javax.swing.JPanel pnl_creditCard;
    private javax.swing.JPanel pnl_debitCard;
    private javax.swing.JPanel pnl_demandDraft;
    private javax.swing.JTextField tf__debit_nameOnCard;
    private javax.swing.JTextField tf_bank_transfer;
    private javax.swing.JTextField tf_cheaqueNo;
    private javax.swing.JTextField tf_cheaque_AccNo;
    private javax.swing.JTextField tf_cheaque_IFSC;
    private javax.swing.JTextField tf_creditCardName;
    private javax.swing.JTextField tf_creditCardNo;
    private javax.swing.JPasswordField tf_creditCvv;
    private javax.swing.JTextField tf_dd_AccNo;
    private javax.swing.JTextField tf_dd_IFSC;
    private javax.swing.JTextField tf_dd_draft;
    private javax.swing.JTextField tf_debitCardNo;
    private javax.swing.JPasswordField tf_debitCvv;
    // End of variables declaration//GEN-END:variables
}
