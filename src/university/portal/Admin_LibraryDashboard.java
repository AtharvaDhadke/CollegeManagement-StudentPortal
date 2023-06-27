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

/**
 *
 * @author Atharva Dhadke
 */
public class Admin_LibraryDashboard extends javax.swing.JFrame {

    /**
     * Creates new form Admin_DashBoard
     */
    String b_id,b_name,b_author,b_publication,b_edition, student_name , issuedate;
        String bookid1, bookname1,studentname1,enroll1,idate1,rdate1,fine1;
    
    
     static String ret_fname, ret_lname, ret_email, ret_phoneNo, ret_gender, ret_bloodGroup, ret_address , ret_password;
   static String ret_fatherName, ret_motherName, ret_fatherNO,ret_motherNo, ret_fatherOcc, ret_motherOcc;
   static String ret_dept,ret_year, ret_enroll, ret_percentage, ret_username ,dob ;
   
   String name = ret_fname +" " +ret_lname;
   String dept , year , enroll;
   
   private int mouseX;
    private int mouseY;
    private Color redColor = new Color(204,51,0); 
  
    static byte byteImage[];
    
         PreparedStatement ps;
     Connection con ;
     ResultSet rs;
     DefaultTableModel tblModel;
     
     int booksCount= 0 , usersCount=0 , issuedCount=0 , returnedBook=0;
    
    public Admin_LibraryDashboard() {
        initComponents();
         
        String username = FirstPage.adusername;
        
//    **************************************View Books Count*************************************

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
               
                booksCount ++;
                      
            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
         
          String strbooksCount = String.valueOf(booksCount);       
         lbl_booksCount.setText(strbooksCount);
        
//     *****************************************View Users ************************************
    
          try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM studentdb ";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
           
            while(rs.next())
            {
                 dept    =rs.getString("Department");
            year    =rs.getString("Year");
            enroll  =rs.getString("EnrollmentNo");
            name=rs.getString("FIRST_NAME");
            
            usersCount++;
            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        }   
        String strusersCount = String.valueOf(usersCount);       
         lbl_usersCount.setText(strusersCount);
         
//    **************************************View Issued Books ***********************

         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM issuedetails ";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
           
            while(rs.next())
            {
                
                   b_id = rs.getString("book_id");
                    b_name = rs.getString("name");
                     b_author = rs.getString("author_name"); 
                       b_edition = rs.getString("edition");
                        student_name = rs.getString("student_name");
                            issuedate = rs.getString("issuedate");
                     
                      issuedCount++;   
            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        }  
         String strissuedCount = String.valueOf( issuedCount);       
         lbl_issuedBook.setText(strissuedCount);
         
//     ******************************View Returned Books*********************************

         try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitydb","AtharvaDhadke","Atharva");
            
            String sql = "SELECT * FROM returnedbooks ";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery ();
          
            while(rs.next())
            {
                bookid1=rs.getString("book_id");
                bookname1=rs.getString("book_name");
                studentname1=rs.getString("student_name");
                enroll1=rs.getString("enroll");
                idate1=rs.getString("issue");
                rdate1=rs.getString("return");
                fine1=rs.getString("fine");
                
                returnedBook++;
                   
            } 
        }
        catch(Exception e)
        {
                e.getMessage();
        } 
         
          String strreturnedBook = String.valueOf( returnedBook);       
         lbl_returnBook.setText(strreturnedBook);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pnl_viewBooks = new javax.swing.JPanel();
        lbl_booksCount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pnl_viewusers = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_usersCount = new javax.swing.JLabel();
        pnl_deletebook = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_deleteBook = new javax.swing.JLabel();
        pnl_issuedbook = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_issuedBook = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnl_addbook = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_addBook = new javax.swing.JLabel();
        pnl_aboutlibrary = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbl_returnBook = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_home = new javax.swing.JLabel();
        lbl_library = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(239, 239, 239));

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

        lbl_booksCount.setFont(new java.awt.Font("Tahoma", 1, 71)); // NOI18N
        lbl_booksCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_booksCount.setText("1");

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
                .addComponent(lbl_booksCount, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_viewBooksLayout.setVerticalGroup(
            pnl_viewBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_viewBooksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_viewBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_booksCount, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnl_viewBooksLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pnl_viewusers.setBackground(new java.awt.Color(255, 255, 255));
        pnl_viewusers.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_viewusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_viewusersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_viewusersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_viewusersMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_viewusersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_viewusersMouseReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Library Section\\Users.png")); // NOI18N
        jLabel3.setText(".");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("View Users");

        lbl_usersCount.setFont(new java.awt.Font("Tahoma", 1, 71)); // NOI18N
        lbl_usersCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usersCount.setText("1");

        javax.swing.GroupLayout pnl_viewusersLayout = new javax.swing.GroupLayout(pnl_viewusers);
        pnl_viewusers.setLayout(pnl_viewusersLayout);
        pnl_viewusersLayout.setHorizontalGroup(
            pnl_viewusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_viewusersLayout.createSequentialGroup()
                .addGroup(pnl_viewusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_viewusersLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_usersCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );
        pnl_viewusersLayout.setVerticalGroup(
            pnl_viewusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_viewusersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_viewusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_usersCount))
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnl_deletebook.setBackground(new java.awt.Color(255, 255, 255));
        pnl_deletebook.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_deletebook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_deletebookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_deletebookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_deletebookMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_deletebookMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_deletebookMouseReleased(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Library Section\\bookdelete2.png")); // NOI18N
        jLabel5.setText(".");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Delete Book");

        lbl_deleteBook.setFont(new java.awt.Font("Tahoma", 1, 71)); // NOI18N
        lbl_deleteBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_deleteBook.setText("-1");

        javax.swing.GroupLayout pnl_deletebookLayout = new javax.swing.GroupLayout(pnl_deletebook);
        pnl_deletebook.setLayout(pnl_deletebookLayout);
        pnl_deletebookLayout.setHorizontalGroup(
            pnl_deletebookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
            .addGroup(pnl_deletebookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_deleteBook, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        pnl_deletebookLayout.setVerticalGroup(
            pnl_deletebookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_deletebookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_deletebookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_deleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

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

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Library Section\\View Book.png")); // NOI18N
        jLabel4.setText(".");

        lbl_issuedBook.setFont(new java.awt.Font("Tahoma", 1, 71)); // NOI18N
        lbl_issuedBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_issuedBook.setText("00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("View Issued Books");

        javax.swing.GroupLayout pnl_issuedbookLayout = new javax.swing.GroupLayout(pnl_issuedbook);
        pnl_issuedbook.setLayout(pnl_issuedbookLayout);
        pnl_issuedbookLayout.setHorizontalGroup(
            pnl_issuedbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_issuedbookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_issuedBook, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(pnl_issuedbookLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_issuedbookLayout.setVerticalGroup(
            pnl_issuedbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_issuedbookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_issuedbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbl_issuedBook))
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_addbook.setBackground(new java.awt.Color(255, 255, 255));
        pnl_addbook.setPreferredSize(new java.awt.Dimension(250, 300));
        pnl_addbook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_addbookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnl_addbookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_addbookMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_addbookMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnl_addbookMouseReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Add Book");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atharva Dhadke\\Desktop\\Java Project Images\\Library Section\\addbook.png")); // NOI18N
        jLabel1.setText(".");

        lbl_addBook.setFont(new java.awt.Font("Tahoma", 1, 71)); // NOI18N
        lbl_addBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_addBook.setText("+1");

        javax.swing.GroupLayout pnl_addbookLayout = new javax.swing.GroupLayout(pnl_addbook);
        pnl_addbook.setLayout(pnl_addbookLayout);
        pnl_addbookLayout.setHorizontalGroup(
            pnl_addbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addbookLayout.createSequentialGroup()
                .addGroup(pnl_addbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addGroup(pnl_addbookLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(lbl_addBook, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_addbookLayout.setVerticalGroup(
            pnl_addbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addbookLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_addbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbl_addBook, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

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
        jLabel26.setText("View Returned Books");

        lbl_returnBook.setFont(new java.awt.Font("Tahoma", 1, 71)); // NOI18N
        lbl_returnBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_returnBook.setText("00");

        javax.swing.GroupLayout pnl_aboutlibraryLayout = new javax.swing.GroupLayout(pnl_aboutlibrary);
        pnl_aboutlibrary.setLayout(pnl_aboutlibraryLayout);
        pnl_aboutlibraryLayout.setHorizontalGroup(
            pnl_aboutlibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_aboutlibraryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_returnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_aboutlibraryLayout.setVerticalGroup(
            pnl_aboutlibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_aboutlibraryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_aboutlibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(lbl_returnBook))
                .addGap(14, 14, 14)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("All CopyRights Reserved /University");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1231, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_viewBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_addbook, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_viewusers, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(pnl_deletebook, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_aboutlibrary, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addComponent(pnl_issuedbook, javax.swing.GroupLayout.PREFERRED_SIZE, 373, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_viewBooks, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(pnl_viewusers, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(pnl_issuedbook, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_addbook, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_deletebook, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_aboutlibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 1230, 770));

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
        lbl_library.setText("Student Management");
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

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("University Portal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 507, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 50));

        jPanel6.setBackground(new java.awt.Color(122, 125, 128));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Library Dashboard");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 1230, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnl_viewBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewBooksMouseClicked
        // TODO add your handling code here:
        new Admin_viewBook().setVisible(true);
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

    private void pnl_viewusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewusersMouseClicked
        // TODO add your handling code here:
        
        new Admin_LibraryViewUsers().setVisible(true);
         this.dispose();
        
    }//GEN-LAST:event_pnl_viewusersMouseClicked

    private void pnl_viewusersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewusersMouseEntered
        // TODO add your handling code here:
         pnl_viewusers.setBackground(new Color(205, 230, 248));
         pnl_viewusers.setLocation(pnl_viewusers.getLocation().x, pnl_viewusers.getLocation().y-7);
        
    }//GEN-LAST:event_pnl_viewusersMouseEntered

    private void pnl_viewusersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewusersMouseExited
        // TODO add your handling code here:
         pnl_viewusers.setBackground(new Color(255,255,255));
         pnl_viewusers.setLocation(pnl_viewusers.getLocation().x, pnl_viewusers.getLocation().y+7);
    }//GEN-LAST:event_pnl_viewusersMouseExited

    private void pnl_issuedbookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_issuedbookMouseClicked
        // TODO add your handling code here:
        new Admin_LibraryIssuedBooks().setVisible(true);
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

    private void pnl_deletebookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deletebookMouseClicked
        // TODO add your handling code here:
        
        new DeleteBook().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pnl_deletebookMouseClicked

    private void pnl_deletebookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deletebookMouseEntered
        // TODO add your handling code here:
        pnl_deletebook.setBackground(new Color(247, 205, 206));
         pnl_deletebook.setLocation(pnl_deletebook.getLocation().x, pnl_deletebook.getLocation().y-7);
    }//GEN-LAST:event_pnl_deletebookMouseEntered

    private void pnl_deletebookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deletebookMouseExited
        // TODO add your handling code here:
        
          pnl_deletebook.setBackground(new Color(255, 255, 255));
           pnl_deletebook.setLocation(pnl_deletebook.getLocation().x, pnl_deletebook.getLocation().y+7);
    }//GEN-LAST:event_pnl_deletebookMouseExited

    private void pnl_addbookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addbookMouseClicked
        // TODO add your handling code here:
        
        new AddBook().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_pnl_addbookMouseClicked

    private void pnl_addbookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addbookMouseEntered
        // TODO add your handling code here:
         pnl_addbook.setBackground(new Color(197, 201, 211));
         pnl_addbook.setLocation(pnl_addbook.getLocation().x, pnl_addbook.getLocation().y-7);
         
    }//GEN-LAST:event_pnl_addbookMouseEntered

    private void pnl_addbookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addbookMouseExited
        // TODO add your handling code here:
        pnl_addbook.setBackground(new Color(255, 255, 255));
         pnl_addbook.setLocation(pnl_addbook.getLocation().x, pnl_addbook.getLocation().y+7);
    }//GEN-LAST:event_pnl_addbookMouseExited

    private void pnl_aboutlibraryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_aboutlibraryMouseClicked
        // TODO add your handling code here:
        new Admin_LibraryReturnBook().setVisible(true);
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
        new Admin_StudentProfile().setVisible(true);
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

    private void pnl_viewBooksMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewBooksMousePressed
        // TODO add your handling code here:
        pnl_viewBooks.setLocation(pnl_viewBooks.getLocation().x, pnl_viewBooks.getLocation().y-7);
    }//GEN-LAST:event_pnl_viewBooksMousePressed

    private void pnl_viewBooksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewBooksMouseReleased
        // TODO add your handling code here:
        pnl_viewBooks.setLocation(pnl_viewBooks.getLocation().x, pnl_viewBooks.getLocation().y+7);
    }//GEN-LAST:event_pnl_viewBooksMouseReleased

    private void pnl_viewusersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewusersMousePressed
        // TODO add your handling code here:
        pnl_viewusers.setLocation(pnl_viewusers.getLocation().x, pnl_viewusers.getLocation().y-7);
    }//GEN-LAST:event_pnl_viewusersMousePressed

    private void pnl_viewusersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_viewusersMouseReleased
        // TODO add your handling code here:
        pnl_viewusers.setLocation(pnl_viewusers.getLocation().x, pnl_viewusers.getLocation().y+7);
    }//GEN-LAST:event_pnl_viewusersMouseReleased

    private void pnl_issuedbookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_issuedbookMousePressed
        // TODO add your handling code here:
         pnl_issuedbook.setLocation(pnl_issuedbook.getLocation().x, pnl_issuedbook.getLocation().y-7);
    }//GEN-LAST:event_pnl_issuedbookMousePressed

    private void pnl_issuedbookMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_issuedbookMouseReleased
        // TODO add your handling code here:
         pnl_issuedbook.setLocation(pnl_issuedbook.getLocation().x, pnl_issuedbook.getLocation().y+7);
    }//GEN-LAST:event_pnl_issuedbookMouseReleased

    private void pnl_addbookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addbookMousePressed
        // TODO add your handling code here:
         pnl_addbook.setLocation(pnl_addbook.getLocation().x, pnl_addbook.getLocation().y-7);
    }//GEN-LAST:event_pnl_addbookMousePressed

    private void pnl_addbookMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_addbookMouseReleased
        // TODO add your handling code here:
         pnl_addbook.setLocation(pnl_addbook.getLocation().x, pnl_addbook.getLocation().y+7);
    }//GEN-LAST:event_pnl_addbookMouseReleased

    private void pnl_deletebookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deletebookMousePressed
        // TODO add your handling code here:
         pnl_deletebook.setLocation(pnl_deletebook.getLocation().x, pnl_deletebook.getLocation().y-7);
    }//GEN-LAST:event_pnl_deletebookMousePressed

    private void pnl_deletebookMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deletebookMouseReleased
        // TODO add your handling code here:
         pnl_deletebook.setLocation(pnl_deletebook.getLocation().x, pnl_deletebook.getLocation().y+7);
    }//GEN-LAST:event_pnl_deletebookMouseReleased

    private void pnl_aboutlibraryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_aboutlibraryMousePressed
        // TODO add your handling code here:
         pnl_aboutlibrary.setLocation(pnl_aboutlibrary.getLocation().x, pnl_aboutlibrary.getLocation().y-7);
    }//GEN-LAST:event_pnl_aboutlibraryMousePressed

    private void pnl_aboutlibraryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_aboutlibraryMouseReleased
        // TODO add your handling code here:
         pnl_aboutlibrary.setLocation(pnl_aboutlibrary.getLocation().x, pnl_aboutlibrary.getLocation().y+7);
    }//GEN-LAST:event_pnl_aboutlibraryMouseReleased

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
            java.util.logging.Logger.getLogger(Admin_LibraryDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_LibraryDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_LibraryDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_LibraryDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_LibraryDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lbl_addBook;
    private javax.swing.JLabel lbl_booksCount;
    private javax.swing.JLabel lbl_deleteBook;
    private javax.swing.JLabel lbl_home;
    private javax.swing.JLabel lbl_issuedBook;
    private javax.swing.JLabel lbl_library;
    private javax.swing.JLabel lbl_returnBook;
    private javax.swing.JLabel lbl_usersCount;
    private javax.swing.JPanel pnl_aboutlibrary;
    private javax.swing.JPanel pnl_addbook;
    private javax.swing.JPanel pnl_deletebook;
    private javax.swing.JPanel pnl_issuedbook;
    private javax.swing.JPanel pnl_viewBooks;
    private javax.swing.JPanel pnl_viewusers;
    // End of variables declaration//GEN-END:variables
}
