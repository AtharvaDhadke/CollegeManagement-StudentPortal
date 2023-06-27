/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static university.portal.Student_Profile.ret_fname;
import static university.portal.Student_Profile.ret_lname;
import static university.portal.Student_Profile.ret_dept;
import static university.portal.Student_Profile.ret_year;

/**
 *
 * @author Atharva Dhadke
 */
public class Student_FeesRelatedQuerry extends javax.swing.JFrame {

    /**
     * Creates new form Admin_FeesNotice
     */
    String name = Student_Dashboard.ret_fname +" " +Student_Dashboard.ret_lname;
    String dept = Student_Dashboard.ret_dept;
    String year_dept = Student_Dashboard.ret_dept +" " +Student_Dashboard.ret_year; 
            
    DefaultTableModel tblModel;
    PreparedStatement ps;
    Connection con ;
    ResultSet rs; 
    private int mouseX;
    private int mouseY;
    private Color redColor = new Color(204,51,0); 

    String ret_name, ret_dept , ret_query; 
    public Student_FeesRelatedQuerry() {
        initComponents();
        
             JTableHeader Theader = table.getTableHeader();
        Theader.setFont(new Font("Tahome " ,Font.BOLD, 20));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
          table.getTableHeader().setOpaque(false);
          table.getTableHeader().setBackground(new Color(58, 63, 67));
          table.getTableHeader().setForeground(new Color(255,255,255));
          try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM  feesrelatedquerry ";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             tblModel = (DefaultTableModel)table.getModel();
             tblModel.setRowCount(0);
            while(rs.next())
            {
                
                ret_name  = rs.getString("student_name");
                ret_dept= rs.getString("dept");
                ret_query= rs.getString("querry");
                        
                String tbdata[] ={ret_name , ret_dept , ret_query};
                tblModel.addRow(tbdata);
                
                
            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
          lbl_username.setText(FirstPage.username);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        lbl_exam = new javax.swing.JLabel();
        lbl_others = new javax.swing.JLabel();
        lbl_all = new javax.swing.JLabel();
        lbl_back3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_querry = new javax.swing.JTextArea();
        lbl_add = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(58, 63, 67));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 850));

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\final admin .png")); // NOI18N
        jLabel19.setText("jLabel19");

        lbl_username.setBackground(new java.awt.Color(0, 0, 0));
        lbl_username.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_username.setOpaque(true);

        lbl_exam.setBackground(new java.awt.Color(58, 63, 67));
        lbl_exam.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_exam.setForeground(new java.awt.Color(255, 255, 255));
        lbl_exam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_exam.setText("Exam Related Queries");
        lbl_exam.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_exam.setOpaque(true);
        lbl_exam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_examMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_examMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_examMouseExited(evt);
            }
        });

        lbl_others.setBackground(new java.awt.Color(58, 63, 67));
        lbl_others.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_others.setForeground(new java.awt.Color(255, 255, 255));
        lbl_others.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_others.setText("Other Queries");
        lbl_others.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_others.setOpaque(true);
        lbl_others.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_othersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_othersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_othersMouseExited(evt);
            }
        });

        lbl_all.setBackground(new java.awt.Color(58, 63, 67));
        lbl_all.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_all.setForeground(new java.awt.Color(255, 255, 255));
        lbl_all.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_all.setText("View All Queries & Reply");
        lbl_all.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(74, 81, 86)));
        lbl_all.setOpaque(true);
        lbl_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_allMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_allMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_allMouseExited(evt);
            }
        });

        lbl_back3.setBackground(new java.awt.Color(153, 153, 153));
        lbl_back3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbl_back3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_back3.setText("BACK");
        lbl_back3.setOpaque(true);
        lbl_back3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_back3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_back3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_back3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_back3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_back3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_exam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_others, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_all, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(lbl_back3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(lbl_exam, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lbl_others, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lbl_all, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(lbl_back3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 900));

        jPanel1.setBackground(new java.awt.Color(122, 125, 128));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ask Fees Related Querry ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1228, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 1240, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ask Question :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 730, 210, -1));

        tf_querry.setColumns(20);
        tf_querry.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_querry.setLineWrap(true);
        tf_querry.setRows(5);
        tf_querry.setWrapStyleWord(true);
        jScrollPane1.setViewportView(tf_querry);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 730, 990, 91));

        lbl_add.setBackground(new java.awt.Color(153, 153, 153));
        lbl_add.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_add.setText("Send");
        lbl_add.setOpaque(true);
        lbl_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_addMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_addMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_addMouseReleased(evt);
            }
        });
        getContentPane().add(lbl_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 840, 113, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 501, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 50));

        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("All CopyRights Reserved /University");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 870, 290, -1));

        jScrollPane2.setBorder(null);

        table.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student / Proff. Name", "Department", "Queries / Replies"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(35);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(200);
            table.getColumnModel().getColumn(0).setPreferredWidth(200);
            table.getColumnModel().getColumn(0).setMaxWidth(200);
            table.getColumnModel().getColumn(1).setMinWidth(200);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 1200, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_addMouseEntered
        // TODO add your handling code here:
        lbl_add.setBackground(new Color(255,255,255));
        lbl_add.setLocation(lbl_add.getLocation().x, lbl_add.getLocation().y-4);
    }//GEN-LAST:event_lbl_addMouseEntered

    private void lbl_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_addMouseExited
        // TODO add your handling code here:
           lbl_add.setBackground(new Color(153,153,153));
        lbl_add.setLocation(lbl_add.getLocation().x, lbl_add.getLocation().y+4);
    }//GEN-LAST:event_lbl_addMouseExited

    private void lbl_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_addMouseClicked
        // TODO add your handling code here:
        System.out.println(name);
        System.out.println(dept);
        System.out.println(year_dept);
        
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
                String sql =  "INSERT INTO `feesrelatedquerry`(`student_name`, `dept`, `year_dept`, `querry`) VALUES (?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                             
                st.setString(1, name);
                st.setString(2, dept);
                st.setString(3, year_dept);
                st.setString(4, tf_querry.getText());
             
                int rs = st.executeUpdate();
                if (rs > 0)
                   JOptionPane.showMessageDialog(null,"Querry Sent Successfully" );
 
                con.close();
        }catch(Exception e){
            
        }
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
                String sql =  "INSERT INTO `commonquerries`(`student_name`, `dept`, `year_dept`, `querry`) VALUES (?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                             
                st.setString(1, name);
                st.setString(2, dept);
                st.setString(3, year_dept);
                st.setString(4, tf_querry.getText());
             
                int rs = st.executeUpdate();
                if (rs > 0)
                   
 
                con.close();
        }catch(Exception e){
            
        }
        
        
         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM  feesrelatedquerry ";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
             tblModel = (DefaultTableModel)table.getModel();
             tblModel.setRowCount(0);
            while(rs.next())
            {
                
                ret_name  = rs.getString("student_name");
                ret_dept= rs.getString("dept");
                ret_query= rs.getString("querry");
                        
                String tbdata[] ={ret_name , ret_dept , ret_query};
                tblModel.addRow(tbdata);
                
                
            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
        
        tf_querry.setText("");
        
        
    }//GEN-LAST:event_lbl_addMouseClicked

    private void lbl_addMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_addMousePressed
        // TODO add your handling code here:
        lbl_add.setLocation(lbl_add.getLocation().x, lbl_add.getLocation().y-4);
    }//GEN-LAST:event_lbl_addMousePressed

    private void lbl_addMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_addMouseReleased
        // TODO add your handling code here:
        lbl_add.setLocation(lbl_add.getLocation().x, lbl_add.getLocation().y+4);
    }//GEN-LAST:event_lbl_addMouseReleased

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

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - mouseX,y - mouseY);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:

        this.mouseX = evt.getX();
        this.mouseY = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void lbl_examMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_examMouseClicked
        // TODO add your handling code here:
        new Student_ExamRelatedQuerry().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_examMouseClicked

    private void lbl_examMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_examMouseEntered
        // TODO add your handling code here:
        lbl_exam.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_examMouseEntered

    private void lbl_examMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_examMouseExited
        // TODO add your handling code here:
        lbl_exam.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_examMouseExited

    private void lbl_othersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_othersMouseClicked
        // TODO add your handling code here:
        new Student_OtherQuerry().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_othersMouseClicked

    private void lbl_othersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_othersMouseEntered
        // TODO add your handling code here:
        lbl_others.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_othersMouseEntered

    private void lbl_othersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_othersMouseExited
        // TODO add your handling code here:
        lbl_others.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_othersMouseExited

    private void lbl_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_allMouseClicked
        // TODO add your handling code here:
        new Student_CommonQuerry().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_allMouseClicked

    private void lbl_allMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_allMouseEntered
        // TODO add your handling code here:
        lbl_all.setBackground(new Color(78, 85, 90));
    }//GEN-LAST:event_lbl_allMouseEntered

    private void lbl_allMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_allMouseExited
        // TODO add your handling code here:
        lbl_all.setBackground(new Color(58,63,67));
    }//GEN-LAST:event_lbl_allMouseExited

    private void lbl_back3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back3MouseClicked
        // TODO add your handling code here:
        new Student_CollegeForumDashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_back3MouseClicked

    private void lbl_back3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back3MouseEntered
        // TODO add your handling code here:

        lbl_back3.setBackground(new Color(255,255,255));
        lbl_back3.setLocation(lbl_back3.getLocation().x, lbl_back3.getLocation().y-4);
    }//GEN-LAST:event_lbl_back3MouseEntered

    private void lbl_back3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back3MouseExited
        // TODO add your handling code here:
        lbl_back3.setBackground(new Color(153,153,153));
        lbl_back3.setLocation(lbl_back3.getLocation().x, lbl_back3.getLocation().y+4);
    }//GEN-LAST:event_lbl_back3MouseExited

    private void lbl_back3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back3MousePressed
        // TODO add your handling code here:
        lbl_back3.setLocation(lbl_back3.getLocation().x, lbl_back3.getLocation().y-4);
    }//GEN-LAST:event_lbl_back3MousePressed

    private void lbl_back3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_back3MouseReleased
        // TODO add your handling code here:
        lbl_back3.setLocation(lbl_back3.getLocation().x, lbl_back3.getLocation().y+4);

    }//GEN-LAST:event_lbl_back3MouseReleased

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
            java.util.logging.Logger.getLogger(Student_FeesRelatedQuerry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_FeesRelatedQuerry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_FeesRelatedQuerry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_FeesRelatedQuerry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_FeesRelatedQuerry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_add;
    private javax.swing.JLabel lbl_all;
    private javax.swing.JLabel lbl_back3;
    private javax.swing.JLabel lbl_exam;
    private javax.swing.JLabel lbl_others;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JTable table;
    private javax.swing.JTextArea tf_querry;
    // End of variables declaration//GEN-END:variables
}