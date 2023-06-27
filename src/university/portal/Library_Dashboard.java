/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.portal;

import java.awt.Color;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static university.portal.Student_Profile.byteImage;

/**
 *
 * @author Atharva Dhadke
 */
public class Library_Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Library_Dashboard
     */
      private int mouseX;
    private int mouseY;
    
    String b_id,b_name,b_author,b_publication,b_edition;
 
     private Color redColor = new Color(204,51,0);
     
       DefaultTableModel viewBook;
     DefaultTableModel issuedBook;
     
     PreparedStatement ps;
     Connection con ;
     ResultSet rs;
     
     int count = 0;
     
    
    public Library_Dashboard() {
        initComponents();
        
        
        
        lbl_username.setText(FirstPage.username);
        
                  try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM tp ";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();

            while(rs.next())
            {
                b_id  = rs.getString("book_id");
                b_name = rs.getString("name");
                b_author = rs.getString("author_name");
                b_edition = rs.getString("edition");
                b_publication =  rs.getString("publisher");     
                
                count ++;
            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
           String SCount = String.valueOf(count);       
         lbl_bookCount.setText(SCount);
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        lbl_leftStudent = new javax.swing.JLabel();
        lbl_back = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnl_viewBooks = new javax.swing.JPanel();
        lbl_bookCount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pnl_issuedbook = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnl_aboutlibrary = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(lbl_back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 900));

        jPanel3.setBackground(new java.awt.Color(122, 125, 128));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Library Management");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 1240, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 1240, 70));

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

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("—");
        jLabel8.setOpaque(true);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
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

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("University Portal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 517, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 50));

        pnl_viewBooks.setBackground(new java.awt.Color(255, 255, 255));
        pnl_viewBooks.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_viewBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_viewBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_viewBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_viewBooksMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_viewBooksMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_viewBooksMouseReleased(evt);
            }
        });

        lbl_bookCount.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbl_bookCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bookCount.setText("1");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("View Books");

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Library Section\\books.png")); // NOI18N
        jLabel21.setText(".");

        javax.swing.GroupLayout pnl_viewBooksLayout = new javax.swing.GroupLayout(pnl_viewBooks);
        pnl_viewBooks.setLayout(pnl_viewBooksLayout);
        pnl_viewBooksLayout.setHorizontalGroup(
            pnl_viewBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_viewBooksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_bookCount, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_viewBooksLayout.setVerticalGroup(
            pnl_viewBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_viewBooksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_viewBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_bookCount, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnl_viewBooksLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        getContentPane().add(pnl_viewBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 390, 240));

        pnl_issuedbook.setBackground(new java.awt.Color(255, 255, 255));
        pnl_issuedbook.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_issuedbook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_issuedbookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_issuedbookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_issuedbookMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_issuedbookMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_issuedbookMouseReleased(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Library Section\\View Book.png")); // NOI18N
        jLabel5.setText(".");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Issue A Book");

        javax.swing.GroupLayout pnl_issuedbookLayout = new javax.swing.GroupLayout(pnl_issuedbook);
        pnl_issuedbook.setLayout(pnl_issuedbookLayout);
        pnl_issuedbookLayout.setHorizontalGroup(
            pnl_issuedbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_issuedbookLayout.createSequentialGroup()
                .addGroup(pnl_issuedbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addGroup(pnl_issuedbookLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_issuedbookLayout.setVerticalGroup(
            pnl_issuedbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_issuedbookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        getContentPane().add(pnl_issuedbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 372, 240));

        pnl_aboutlibrary.setBackground(new java.awt.Color(255, 255, 255));
        pnl_aboutlibrary.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_aboutlibrary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_aboutlibraryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_aboutlibraryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_aboutlibraryMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_aboutlibraryMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_aboutlibraryMouseReleased(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Library Section\\reading_book.png")); // NOI18N
        jLabel24.setText(".");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Return Issued Book");

        javax.swing.GroupLayout pnl_aboutlibraryLayout = new javax.swing.GroupLayout(pnl_aboutlibrary);
        pnl_aboutlibrary.setLayout(pnl_aboutlibraryLayout);
        pnl_aboutlibraryLayout.setHorizontalGroup(
            pnl_aboutlibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_aboutlibraryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        pnl_aboutlibraryLayout.setVerticalGroup(
            pnl_aboutlibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_aboutlibraryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(27, 27, 27))
        );

        getContentPane().add(pnl_aboutlibrary, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 156, 360, 240));

        jLabel22.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("All CopyRights Reserved /University");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 870, 290, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(18);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(153, 153, 153));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(8);
        jTextArea1.setText("\n               Library Management Software is a comprehensive library management solution that \n                     is suitable for both large and small libraries this software is suitable for all type \n                Institutional,  public and digital  libraries  for  managing their circulation and stocks. \n                   Library Management Software has been designed to automate, manage and look \n                      after the over-all processing of even very large-scale  libraries. This software\n                      is capable of managing Book Issues, Returns, generating various Reports for\n                                       Record-Keeping and Review purposes, according to \n                                                              end user requirements.\n ");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAlignmentX(5.0F);
        jTextArea1.setAlignmentY(5.0F);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel28.setBackground(new java.awt.Color(153, 153, 153));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("About Us");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1196, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, -1, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:

        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        jLabel8.setBackground(new Color(229,229,229));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:

        jLabel8.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jLabel8MouseExited

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

    private void pnl_viewBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewBooksMouseClicked
        // TODO add your handling code here:
               new Student_ViewBook().setVisible(true);
                this.dispose();

    }//GEN-LAST:event_pnl_viewBooksMouseClicked

    private void pnl_viewBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewBooksMouseEntered
        // TODO add your handling code here:

        pnl_viewBooks.setBackground(new Color(212, 225, 238));
        // jPanel2.setBackground(new Color(255,255,255));
        pnl_viewBooks.setLocation(pnl_viewBooks.getLocation().x, pnl_viewBooks.getLocation().y-7);

    }//GEN-LAST:event_pnl_viewBooksMouseEntered

    private void pnl_viewBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewBooksMouseExited
        // TODO add your handling code here:
        pnl_viewBooks.setBackground(new Color(255,255,255));
        //  jPanel2.setBackground(new Color(239,239,239));
        pnl_viewBooks.setLocation(pnl_viewBooks.getLocation().x, pnl_viewBooks.getLocation().y+7);

    }//GEN-LAST:event_pnl_viewBooksMouseExited

    private void pnl_viewBooksMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewBooksMousePressed
        // TODO add your handling code here:
        pnl_viewBooks.setLocation(pnl_viewBooks.getLocation().x, pnl_viewBooks.getLocation().y-7);
    }//GEN-LAST:event_pnl_viewBooksMousePressed

    private void pnl_viewBooksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewBooksMouseReleased
        // TODO add your handling code here:
        pnl_viewBooks.setLocation(pnl_viewBooks.getLocation().x, pnl_viewBooks.getLocation().y+7);
    }//GEN-LAST:event_pnl_viewBooksMouseReleased

    private void pnl_issuedbookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_issuedbookMouseClicked
        // TODO add your handling code here:
       new Student_IssueBook().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_pnl_issuedbookMouseClicked

    private void pnl_issuedbookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_issuedbookMouseEntered
        // TODO add your handling code here:
        pnl_issuedbook.setBackground(new Color(208, 238, 222));
        pnl_issuedbook.setLocation(pnl_issuedbook.getLocation().x, pnl_issuedbook.getLocation().y-7);
    }//GEN-LAST:event_pnl_issuedbookMouseEntered

    private void pnl_issuedbookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_issuedbookMouseExited
        // TODO add your handling code here:
        pnl_issuedbook.setBackground(new Color(255,255,255));
        pnl_issuedbook.setLocation(pnl_issuedbook.getLocation().x, pnl_issuedbook.getLocation().y+7);
    }//GEN-LAST:event_pnl_issuedbookMouseExited

    private void pnl_issuedbookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_issuedbookMousePressed
        // TODO add your handling code here:
        pnl_issuedbook.setLocation(pnl_issuedbook.getLocation().x, pnl_issuedbook.getLocation().y-7);
    }//GEN-LAST:event_pnl_issuedbookMousePressed

    private void pnl_issuedbookMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_issuedbookMouseReleased
        // TODO add your handling code here:
        pnl_issuedbook.setLocation(pnl_issuedbook.getLocation().x, pnl_issuedbook.getLocation().y+7);
    }//GEN-LAST:event_pnl_issuedbookMouseReleased

    private void pnl_aboutlibraryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_aboutlibraryMouseClicked
        // TODO add your handling code here:
        new Student_ReturnBook().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_pnl_aboutlibraryMouseClicked

    private void pnl_aboutlibraryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_aboutlibraryMouseEntered
        // TODO add your handling code here:
        pnl_aboutlibrary.setBackground(new Color(242, 241, 189));
        pnl_aboutlibrary.setLocation(pnl_aboutlibrary.getLocation().x, pnl_aboutlibrary.getLocation().y-7);
    }//GEN-LAST:event_pnl_aboutlibraryMouseEntered

    private void pnl_aboutlibraryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_aboutlibraryMouseExited
        // TODO add your handling code here:
        pnl_aboutlibrary.setBackground(new Color(255, 255, 255));
        pnl_aboutlibrary.setLocation(pnl_aboutlibrary.getLocation().x, pnl_aboutlibrary.getLocation().y+7);
    }//GEN-LAST:event_pnl_aboutlibraryMouseExited

    private void pnl_aboutlibraryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_aboutlibraryMousePressed
        // TODO add your handling code here:
        pnl_aboutlibrary.setLocation(pnl_aboutlibrary.getLocation().x, pnl_aboutlibrary.getLocation().y-7);
    }//GEN-LAST:event_pnl_aboutlibraryMousePressed

    private void pnl_aboutlibraryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_aboutlibraryMouseReleased
        // TODO add your handling code here:
        pnl_aboutlibrary.setLocation(pnl_aboutlibrary.getLocation().x, pnl_aboutlibrary.getLocation().y+7);
    }//GEN-LAST:event_pnl_aboutlibraryMouseReleased

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
            java.util.logging.Logger.getLogger(Library_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Library_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Library_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Library_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Library_Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JLabel lbl_bookCount;
    private javax.swing.JLabel lbl_leftStudent;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel pnl_aboutlibrary;
    private javax.swing.JPanel pnl_issuedbook;
    private javax.swing.JPanel pnl_viewBooks;
    // End of variables declaration//GEN-END:variables
}
