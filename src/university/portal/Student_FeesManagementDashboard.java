/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author Atharva Dhadke
 */
public class Student_FeesManagementDashboard extends javax.swing.JFrame {

    /**
     * Creates new form Admin_DashBoard
     */
 
    
     
    
    String ret_fname, ret_lname, ret_email, ret_phoneNo, ret_gender, ret_bloodGroup, ret_address ;
    String ret_fatherName, ret_motherName, ret_fatherNO,ret_motherNo, ret_fatherOcc, ret_motherOcc;
    String ret_dept,ret_year, ret_enroll, ret_percentage, ret_username,trc_id;
    String Notice;
    
    int transactionId;
    int x=370;
    int y=150;
    int a=1600;
    int b=140;
    
    
    //    *****************************************//
    
    String FYCO_tution = "80,357";
    String FYCO_development = "9,643";
    String FYCO_insurance = "454";
    String FYCO_icard = "175";
    String FYCO_cautionMoneyDeposit = "2,000";
    String FYCO_exam = "2,500";
    String FYCO_form = "500";
    String FYCO_total = "95,629";
    
    String SYCO_tution = "65,179";
    String SYCO_development = "7,821";
    String SYCO_insurance = "200";
    String SYCO_icard = "0";
    String SYCO_cautionMoneyDeposit = "2,000";
    String SYCO_exam = "2,500";
    String SYCO_form = "500";
    String SYCO_total = "78,200";
    
    String TYCO_tution = "63,179";
    String TYCO_development = "7,821";
    String TYCO_insurance = "200";
    String TYCO_icard = "0";
    String TYCO_cautionMoneyDeposit = "2,000";
    String TYCO_exam = "2,500";
    String TYCO_form = "500";
    String TYCO_total = "76,200";
   
//    *****************************************//
    
    String FYCE_tution = "80,357";
    String FYCE_development = "9,643";
    String FYCE_insurance = "454";
    String FYCE_icard = "175";
    String FYCE_cautionMoneyDeposit = "2,000";
    String FYCE_exam = "2,500";
    String FYCE_form = "500";
    String FYCE_total = "95,629";
    
    String SYCE_tution = "65,179";
    String SYCE_development = "7,821";
    String SYCE_insurance = "200";
    String SYCE_icard = "0";
    String SYCE_cautionMoneyDeposit = "2,000";
    String SYCE_exam = "2,500";
    String SYCE_form = "500";
    String SYCE_total = "78,200";
    
    String TYCE_tution = "63,179";
    String TYCE_development = "7,821";
    String TYCE_insurance = "200";
    String TYCE_icard = "0";
    String TYCE_cautionMoneyDeposit = "2,000";
    String TYCE_exam = "2,500";
    String TYCE_form = "500";
    String TYCE_total = "76,200";
    
 //    *****************************************//
    
    String FYME_tution = "80,357";
    String FYME_development = "9,643";
    String FYME_insurance = "454";
    String FYME_icard = "175";
    String FYME_cautionMoneyDeposit = "2,000";
    String FYME_exam = "2,500";
    String FYME_form = "500";
    String FYME_total = "95,629";
    
    String SYME_tution = "65,179";
    String SYME_development = "7,821";
    String SYME_insurance = "200";
    String SYME_icard = "0";
    String SYME_cautionMoneyDeposit = "2,000";
    String SYME_exam = "2,500";
    String SYME_form = "500";
    String SYME_total = "78,200";
    
    String TYME_tution = "63,179";
    String TYME_development = "7,821";
    String TYME_insurance = "200";
    String TYME_icard = "0";
    String TYME_cautionMoneyDeposit = "2,000";
    String TYME_exam = "2,500";
    String TYME_form = "500";
    String TYME_total = "76,200";
    
    
    //    *****************************************//
    String FYEE_tution = "80,357";
    String FYEE_development = "9,643";
    String FYEE_insurance = "454";
    String FYEE_icard = "175";
    String FYEE_cautionMoneyDeposit = "2,000";
    String FYEE_exam = "2,500";
    String FYEE_form = "500";
    String FYEE_total = "95,629";
    
    String SYEE_tution = "65,179";
    String SYEE_development = "7,821";
    String SYEE_insurance = "200";
    String SYEE_icard = "0";
    String SYEE_cautionMoneyDeposit = "2,000";
    String SYEE_exam = "2,500";
    String SYEE_form = "500";
    String SYEE_total = "78,200";
    
    String TYEE_tution = "63,179";
    String TYEE_development = "7,821";
    String TYEE_insurance = "200";
    String TYEE_icard = "0";
    String TYEE_cautionMoneyDeposit = "2,000";
    String TYEE_exam = "2,500";
    String TYEE_form = "500";
    String TYEE_total = "76,200";
 
    private int mouseX;
    private int mouseY;
    private Color redColor = new Color(204,51,0); 

    
    
     
    public Student_FeesManagementDashboard() {
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
            
          }
        }
        catch(Exception e)
        {
            System.out.println("Caught Exception");
            e.getMessage();
        }
                 
        
       
 
                 
         try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
                String sql =  "INSERT INTO `feestructure`(`StudentName`, `EnrollmentNo`, `Department`, `Year`, `Username`, `YearDepartment`, `TutionFees`, `DevelopmentFees`, `InsuranceFees`, `ExamFees`, `ICard`, `CMD`, `FormFee`, `Total`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement st = con.prepareStatement(sql);
                              // st.setInt(1, Integer.parseInt(textField.getText()));
                st.setString(1,ret_fname+" "+ret_lname );
                st.setString(2,ret_enroll );
                st.setString(3,ret_dept );
                st.setString(4,ret_year);
                st.setString(5,ret_username);
                st.setString(6,ret_dept+"-"+ret_year );
                
                 if(ret_dept.equals("Computer") && ret_year.equals("First Year")){
                    System.out.println("First Year Computer");
                    
                        st.setString(7,FYCO_tution );
                        st.setString(8,FYCO_development );
                        st.setString(9,FYCO_insurance );
                        st.setString(10,FYCO_exam);
                        st.setString(11,FYCO_icard);
                        st.setString(12,FYCO_cautionMoneyDeposit );
                        st.setString(13,FYCO_form);
                        st.setString(14,FYCO_total );


                    }


                    else if(ret_dept.equals("Computer") && ret_year.equals("Second Year")){
                    
                        System.out.println("Second Year Computer");
                    
                        st.setString(7,SYCO_tution );
                        st.setString(8,SYCO_development );
                        st.setString(9,SYCO_insurance );
                        st.setString(10,SYCO_exam);
                        st.setString(11,SYCO_icard);
                        st.setString(12,SYCO_cautionMoneyDeposit );
                        st.setString(13,SYCO_form);
                        st.setString(14,SYCO_total );
                    

                    }

                    else if(ret_dept.equals("Computer") && ret_year.equals("Third Year")){
                    System.out.println("Third Year Computer");
                    
                        st.setString(7,TYCO_tution );
                        st.setString(8,TYCO_development );
                        st.setString(9,TYCO_insurance );
                        st.setString(10,TYCO_exam);
                        st.setString(11,TYCO_icard);
                        st.setString(12,TYCO_cautionMoneyDeposit );
                        st.setString(13,TYCO_form);
                        st.setString(14,TYCO_total );
                        

                    }

                   // ****************Civil*********************
                    else if(ret_dept.equals("Civil") && ret_year.equals("First Year")){
                    System.out.println("First Year Civil");
                    
                        st.setString(7,FYCE_tution );
                        st.setString(8,FYCE_development );
                        st.setString(9,FYCE_insurance );
                        st.setString(10,FYCE_exam);
                        st.setString(11,FYCE_icard);
                        st.setString(12,FYCE_cautionMoneyDeposit );
                        st.setString(13,FYCE_form);
                        st.setString(14,FYCE_total );
                
                    }


                    else if(ret_dept.equals("Civil") && ret_year.equals("Second Year")){
                    System.out.println("Second Year Civil");
                    
                        st.setString(7,SYCE_tution );
                        st.setString(8,SYCE_development );
                        st.setString(9,SYCE_insurance );
                        st.setString(10,SYCE_exam);
                        st.setString(11,SYCE_icard);
                        st.setString(12,SYCE_cautionMoneyDeposit );
                        st.setString(13,SYCE_form);
                        st.setString(14,SYCE_total );
              
                    }

                    else if(ret_dept.equals("Civil") && ret_year.equals("Third Year")){
                    System.out.println("Third Year Civil");
                    
                        st.setString(7,TYCE_tution );
                        st.setString(8,TYCE_development );
                        st.setString(9,TYCE_insurance );
                        st.setString(10,TYCE_exam);
                        st.setString(11,TYCE_icard);
                        st.setString(12,TYCE_cautionMoneyDeposit );
                        st.setString(13,TYCE_form);
                        st.setString(14,TYCE_total );                       

                    }

                   // ******************Mechanical*****************************

                    else if(ret_dept.equals("Mechanical") && ret_year.equals("First Year")){
                     System.out.println("First Year Mech");
                    
                        st.setString(7,FYME_tution );
                        st.setString(8,FYME_development );
                        st.setString(9,FYME_insurance );
                        st.setString(10,FYME_exam);
                        st.setString(11,FYME_icard);
                        st.setString(12,FYME_cautionMoneyDeposit );
                        st.setString(13,FYME_form);
                        st.setString(14,FYME_total );
                     
                    }


                    else if(ret_dept.equals("Mechanical") && ret_year.equals("Second Year")){
                    System.out.println("second Year Mech");
                    
                        st.setString(7,SYME_tution );
                        st.setString(8,SYME_development );
                        st.setString(9,SYME_insurance );
                        st.setString(10,SYME_exam);
                        st.setString(11,SYME_icard);
                        st.setString(12,SYME_cautionMoneyDeposit );
                        st.setString(13,SYME_form);
                        st.setString(14,SYME_total );
                   
                    }

                    else if(ret_dept.equals("Mechanical") && ret_year.equals("Third Year")){
                    System.out.println("Third Year Mech");
                    
                        st.setString(7,TYME_tution );
                        st.setString(8,TYME_development );
                        st.setString(9,TYME_insurance );
                        st.setString(10,TYME_exam);
                        st.setString(11,TYME_icard);
                        st.setString(12,TYME_cautionMoneyDeposit );
                        st.setString(13,TYME_form);
                        st.setString(14,TYME_total );

                    }
                     //*****************Electrical*****************************
                    else if(ret_dept.equals("Electrical") && ret_year.equals("First Year")){
                    System.out.println("Third Year Mech");
                    
                        st.setString(7,FYEE_tution );
                        st.setString(8,FYEE_development );
                        st.setString(9,FYEE_insurance );
                        st.setString(10,FYEE_exam);
                        st.setString(11,FYEE_icard);
                        st.setString(12,FYEE_cautionMoneyDeposit );
                        st.setString(13,FYEE_form);
                        st.setString(14,FYEE_total );
                        
                  
                    }


                    else if(ret_dept.equals("Electrical") && ret_year.equals("Second Year")){
                     System.out.println("Third Year Mech");
                    
                        st.setString(7,SYEE_tution );
                        st.setString(8,SYEE_development );
                        st.setString(9,SYEE_insurance );
                        st.setString(10,SYEE_exam);
                        st.setString(11,SYEE_icard);
                        st.setString(12,SYEE_cautionMoneyDeposit );
                        st.setString(13,SYEE_form);
                        st.setString(14,SYEE_total );
                        
                 
                    }

                    else if(ret_dept.equals("Electrical") && ret_year.equals("Third Year")){
                    System.out.println("Third Year Mech");
                    
                        st.setString(7,TYEE_tution );
                        st.setString(8,TYEE_development );
                        st.setString(9,TYEE_insurance );
                        st.setString(10,TYEE_exam);
                        st.setString(11,TYEE_icard);
                        st.setString(12,TYEE_cautionMoneyDeposit );
                        st.setString(13,TYEE_form);
                        st.setString(14,TYEE_total );
                    
                    }

                    else{
                       System.out.println("Invalid");
                    
                        st.setString(7,"Invalid" );
                        st.setString(8,"Invalid" );
                        st.setString(9,"Invalid" );
                        st.setString(10,"Invalid");
                        st.setString(11,"Invalid");
                        st.setString(12,"Invalid" );
                        st.setString(13,"Invalid");
                        st.setString(14,"Invalid" );
                    }
                

                int rs = st.executeUpdate();
                if (rs > 0)
                 
 
                con.close();
        }catch(Exception e){
            
        }         
//         ***************************************Notice**************************************************

             try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            PreparedStatement ps;
            
            String sql = "SELECT * FROM feesnotice";
            ps = con.prepareStatement(sql);
            
          
            ResultSet rs = ps.executeQuery ();
            while(rs.next())
            {
          
            Notice=rs.getString("Notice");
            
          }
        }
        catch(Exception e)
        {
            System.out.println("Caught Exception");
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
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        lbl_leftStudent = new javax.swing.JLabel();
        lbl_mech = new javax.swing.JLabel();
        lbl_leftLibrary = new javax.swing.JLabel();
        lbl_back = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnl_Computer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnl_mechanical = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnl_Civil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_gym = new javax.swing.JLabel();
        lbl_sports = new javax.swing.JLabel();
        lbl_swimming = new javax.swing.JLabel();
        lbl_yoga = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

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
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                formAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(58, 63, 67));
        jPanel7.setPreferredSize(new java.awt.Dimension(400, 850));

        jLabel25.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\final admin .png")); // NOI18N
        jLabel25.setText("jLabel19");

        lbl_username.setBackground(new java.awt.Color(0, 0, 0));
        lbl_username.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_username.setOpaque(true);

        lbl_leftStudent.setBackground(new java.awt.Color(58, 63, 67));
        lbl_leftStudent.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_leftStudent.setForeground(new java.awt.Color(255, 255, 255));
        lbl_leftStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_leftStudent.setText("Student Profile");
        lbl_leftStudent.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_leftStudent.setOpaque(true);
        lbl_leftStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_leftStudentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_leftStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_leftStudentMouseExited(evt);
            }
        });

        lbl_mech.setBackground(new java.awt.Color(58, 63, 67));
        lbl_mech.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_mech.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mech.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mech.setText("College Forum");
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
            .addComponent(lbl_leftStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
            .addComponent(lbl_leftLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_mech, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(lbl_leftStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_leftLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_mech, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(lbl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 900));

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
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Fees Management\\feesStructure.png")); // NOI18N
        jLabel1.setText(".");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fees Structure");

        javax.swing.GroupLayout pnl_ComputerLayout = new javax.swing.GroupLayout(pnl_Computer);
        pnl_Computer.setLayout(pnl_ComputerLayout);
        pnl_ComputerLayout.setHorizontalGroup(
            pnl_ComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
            .addGroup(pnl_ComputerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_ComputerLayout.setVerticalGroup(
            pnl_ComputerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ComputerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
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
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Fees Management\\paymentMode.png")); // NOI18N
        jLabel3.setText(".");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Payment Mode");

        javax.swing.GroupLayout pnl_mechanicalLayout = new javax.swing.GroupLayout(pnl_mechanical);
        pnl_mechanical.setLayout(pnl_mechanicalLayout);
        pnl_mechanicalLayout.setHorizontalGroup(
            pnl_mechanicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addGroup(pnl_mechanicalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_mechanicalLayout.setVerticalGroup(
            pnl_mechanicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mechanicalLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
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
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Fees Management\\feeReceipt.png")); // NOI18N
        jLabel4.setText(".");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Fee Receipt");

        javax.swing.GroupLayout pnl_CivilLayout = new javax.swing.GroupLayout(pnl_Civil);
        pnl_Civil.setLayout(pnl_CivilLayout);
        pnl_CivilLayout.setHorizontalGroup(
            pnl_CivilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_CivilLayout.setVerticalGroup(
            pnl_CivilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CivilLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("All CopyRights Reserved /University");

        lbl_gym.setBackground(new java.awt.Color(254, 101, 107));
        lbl_gym.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_gym.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gym.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_gym.setText("Gym Fees");
        lbl_gym.setOpaque(true);
        lbl_gym.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_gymMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_gymMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_gymMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_gymMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_gymMouseReleased(evt);
            }
        });

        lbl_sports.setBackground(new java.awt.Color(133, 194, 73));
        lbl_sports.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_sports.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sports.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sports.setText("Sports Club Fees");
        lbl_sports.setOpaque(true);
        lbl_sports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_sportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_sportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_sportsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_sportsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_sportsMouseReleased(evt);
            }
        });

        lbl_swimming.setBackground(new java.awt.Color(0, 202, 210));
        lbl_swimming.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_swimming.setForeground(new java.awt.Color(255, 255, 255));
        lbl_swimming.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_swimming.setText("Swimming Club Fees");
        lbl_swimming.setOpaque(true);
        lbl_swimming.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_swimmingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_swimmingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_swimmingMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_swimmingMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_swimmingMouseReleased(evt);
            }
        });

        lbl_yoga.setBackground(new java.awt.Color(30, 156, 229));
        lbl_yoga.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl_yoga.setForeground(new java.awt.Color(255, 255, 255));
        lbl_yoga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_yoga.setText("Yoga Fees");
        lbl_yoga.setOpaque(true);
        lbl_yoga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_yogaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_yogaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_yogaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_yogaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_yogaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_gym, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(lbl_sports, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_yoga, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_swimming, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(pnl_Computer, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(pnl_mechanical, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnl_Civil, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_Computer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_mechanical, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_Civil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_gym, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sports, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_swimming, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_yoga, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel18)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 1200, 760));

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
                .addGap(0, 473, Short.MAX_VALUE)
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1560, 50));

        jPanel5.setBackground(new java.awt.Color(122, 125, 128));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fees Management Dashboard");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 1200, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void paint(Graphics gp)
    {
        super.paint(gp);
        Graphics2D g2d= (Graphics2D) gp;
        g2d.setColor(Color.red);
        g2d.setFont(new Font("BOLD", BOLD, 24));
             
       
        g2d.drawString(Notice,a,b);
       
        try {
            Thread.sleep(500);
            a-= 25;
            
       
        if(a<370)
        {
        
            a=1600;
        }
        repaint();
                      
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        
        
        lbl_username.setText(ret_username);
        
    }
    
    
    
    private void pnl_ComputerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ComputerMouseClicked
        // TODO add your handling code here:
       new Student_FeesStructure().setVisible(true);
       
        
        
       
        
    }//GEN-LAST:event_pnl_ComputerMouseClicked

    private void pnl_ComputerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_ComputerMouseEntered
        // TODO add your handling code here:
        
        pnl_Computer.setBackground(new Color(226, 243, 185));
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
        new Student_FeesPayment().setVisible(true);
        
        
        
    }//GEN-LAST:event_pnl_mechanicalMouseClicked

    private void pnl_mechanicalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_mechanicalMouseEntered
        // TODO add your handling code here:
         pnl_mechanical.setBackground(new Color(219, 239, 250));
          pnl_mechanical.setLocation(pnl_mechanical.getLocation().x, pnl_mechanical.getLocation().y-7);
        
    }//GEN-LAST:event_pnl_mechanicalMouseEntered

    private void pnl_mechanicalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_mechanicalMouseExited
        // TODO add your handling code here:
         pnl_mechanical.setBackground(new Color(255,255,255));
         pnl_mechanical.setLocation(pnl_mechanical.getLocation().x, pnl_mechanical.getLocation().y+7);
    }//GEN-LAST:event_pnl_mechanicalMouseExited

    private void pnl_CivilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_CivilMouseClicked
        // TODO add your handling code here:
      System.out.println(Student_FeesPayment.flag);
        if(Student_FeesPayment.flag == true)
        {
            new Student_FeeReceipt().setVisible(true); 
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Please Pay Your Fees", "Error", JOptionPane.ERROR_MESSAGE);                   
        }

        
     
         
    }//GEN-LAST:event_pnl_CivilMouseClicked

    private void pnl_CivilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_CivilMouseEntered
        // TODO add your handling code here:
         pnl_Civil.setBackground(new Color(252, 225, 225));
         pnl_Civil.setLocation(pnl_Civil.getLocation().x, pnl_Civil.getLocation().y-7);
    }//GEN-LAST:event_pnl_CivilMouseEntered

    private void pnl_CivilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_CivilMouseExited
        // TODO add your handling code here:
         pnl_Civil.setBackground(new Color(255,255,255));
         pnl_Civil.setLocation(pnl_Civil.getLocation().x, pnl_Civil.getLocation().y+7);
    }//GEN-LAST:event_pnl_CivilMouseExited

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

    private void formAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorMoved

    private void lbl_gymMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gymMouseEntered
        // TODO add your handling code here:
            lbl_gym.setBackground(new Color(254, 196, 199));
            lbl_gym.setLocation(lbl_gym.getLocation().x, lbl_gym.getLocation().y-5);
    }//GEN-LAST:event_lbl_gymMouseEntered

    private void lbl_gymMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gymMouseExited
        // TODO add your handling code here:
         lbl_gym.setBackground(new Color(254,101,107));
         lbl_gym.setLocation(lbl_gym.getLocation().x, lbl_gym.getLocation().y+5);
    }//GEN-LAST:event_lbl_gymMouseExited

    private void lbl_gymMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gymMousePressed
        // TODO add your handling code here:
         lbl_gym.setLocation(lbl_gym.getLocation().x, lbl_gym.getLocation().y-5);
    }//GEN-LAST:event_lbl_gymMousePressed

    private void lbl_gymMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gymMouseReleased
        // TODO add your handling code here:
         lbl_gym.setLocation(lbl_gym.getLocation().x, lbl_gym.getLocation().y+5);
    }//GEN-LAST:event_lbl_gymMouseReleased

    private void lbl_sportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sportsMouseEntered
        // TODO add your handling code here:
        lbl_sports.setBackground(new Color(214, 234, 194));
         lbl_sports.setLocation(lbl_sports.getLocation().x, lbl_sports.getLocation().y-5);
    }//GEN-LAST:event_lbl_sportsMouseEntered

    private void lbl_sportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sportsMouseExited
        // TODO add your handling code here:
        lbl_sports.setBackground(new Color(133, 194, 73));
        lbl_sports.setLocation(lbl_sports.getLocation().x, lbl_sports.getLocation().y+5);
    }//GEN-LAST:event_lbl_sportsMouseExited

    private void lbl_sportsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sportsMousePressed
        // TODO add your handling code here:
        lbl_sports.setLocation(lbl_sports.getLocation().x, lbl_sports.getLocation().y-5);
    }//GEN-LAST:event_lbl_sportsMousePressed

    private void lbl_sportsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sportsMouseReleased
        // TODO add your handling code here:
        lbl_sports.setLocation(lbl_sports.getLocation().x, lbl_sports.getLocation().y+5);
    }//GEN-LAST:event_lbl_sportsMouseReleased

    private void lbl_yogaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_yogaMouseEntered
        // TODO add your handling code here:
        lbl_yoga.setBackground(new Color(180, 222, 246));
          lbl_yoga.setLocation(lbl_yoga.getLocation().x, lbl_yoga.getLocation().y-5);
    }//GEN-LAST:event_lbl_yogaMouseEntered

    private void lbl_yogaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_yogaMouseExited
        // TODO add your handling code here:
        lbl_yoga.setBackground(new Color(30, 156, 229));
       lbl_yoga.setLocation(lbl_yoga.getLocation().x, lbl_yoga.getLocation().y+5);
    }//GEN-LAST:event_lbl_yogaMouseExited

    private void lbl_yogaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_yogaMousePressed
        // TODO add your handling code here:
     lbl_yoga.setLocation(lbl_yoga.getLocation().x, lbl_yoga.getLocation().y-5);
    }//GEN-LAST:event_lbl_yogaMousePressed

    private void lbl_yogaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_yogaMouseReleased
        // TODO add your handling code here:
      lbl_yoga.setLocation(lbl_yoga.getLocation().x, lbl_yoga.getLocation().y+5);
    }//GEN-LAST:event_lbl_yogaMouseReleased

    private void lbl_swimmingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_swimmingMouseEntered
        // TODO add your handling code here:
        lbl_swimming.setBackground(new Color(170, 237, 240));
        lbl_swimming.setLocation( lbl_swimming.getLocation().x,  lbl_swimming.getLocation().y-5);
    }//GEN-LAST:event_lbl_swimmingMouseEntered

    private void lbl_swimmingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_swimmingMouseExited
        // TODO add your handling code here:
        lbl_swimming.setBackground(new Color(0, 202, 210));
         lbl_swimming.setLocation( lbl_swimming.getLocation().x,  lbl_swimming.getLocation().y+5);
    }//GEN-LAST:event_lbl_swimmingMouseExited

    private void lbl_swimmingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_swimmingMousePressed
        // TODO add your handling code here:
         lbl_swimming.setLocation( lbl_swimming.getLocation().x,  lbl_swimming.getLocation().y-5);
    }//GEN-LAST:event_lbl_swimmingMousePressed

    private void lbl_swimmingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_swimmingMouseReleased
        // TODO add your handling code here:
         lbl_swimming.setLocation( lbl_swimming.getLocation().x,  lbl_swimming.getLocation().y+5);
    }//GEN-LAST:event_lbl_swimmingMouseReleased

    private void lbl_gymMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gymMouseClicked
        // TODO add your handling code here:
        new Student_FeeGym().setVisible(true);
    }//GEN-LAST:event_lbl_gymMouseClicked

    private void lbl_yogaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_yogaMouseClicked
        // TODO add your handling code here:
        new Student_FeeYoga().setVisible(true);
    }//GEN-LAST:event_lbl_yogaMouseClicked

    private void lbl_sportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sportsMouseClicked
        // TODO add your handling code here:
        new Student_feesports().setVisible(true);
    }//GEN-LAST:event_lbl_sportsMouseClicked

    private void lbl_swimmingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_swimmingMouseClicked
        // TODO add your handling code here:
        new Student_FeeSwimming().setVisible(true);
    }//GEN-LAST:event_lbl_swimmingMouseClicked

    private void lbl_leftStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_leftStudentMouseClicked
        // TODO add your handling code here:
        new Student_Profile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_leftStudentMouseClicked

    private void lbl_leftStudentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_leftStudentMouseEntered
        // TODO add your handling code here:
        lbl_leftStudent.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_leftStudentMouseEntered

    private void lbl_leftStudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_leftStudentMouseExited
        // TODO add your handling code here:
        lbl_leftStudent.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_leftStudentMouseExited

    private void lbl_mechMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mechMouseClicked
        // TODO add your handling code here:
        new Student_CollegeForumDashboard().setVisible(true);
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
                new Student_FeesManagementDashboard().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JLabel lbl_gym;
    private javax.swing.JLabel lbl_leftLibrary;
    private javax.swing.JLabel lbl_leftStudent;
    private javax.swing.JLabel lbl_mech;
    private javax.swing.JLabel lbl_sports;
    private javax.swing.JLabel lbl_swimming;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel lbl_yoga;
    private javax.swing.JPanel pnl_Civil;
    private javax.swing.JPanel pnl_Computer;
    private javax.swing.JPanel pnl_mechanical;
    // End of variables declaration//GEN-END:variables
}
